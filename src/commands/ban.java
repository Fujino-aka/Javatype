/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.lambdaworks.redis.api.sync.RedisCommands;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import local.Govern;
import main.bot;
import models.BanList;

/**
 *
 * @author danie
 */
public class ban 
{
    private final Message msg;
    private final RedisCommands db;
    private final Locale lang;
    private final bot api;
    private final String part2;
    private final Long chatId;
    private final int userId; 
    
    public ban(Message msg, Locale lang, RedisCommands db, bot api, String part2)
    {
        this.msg = msg;
        this.db = db;
        this.lang = lang;
        this.api = api;
        this.part2 = part2;
        this.chatId = this.msg.chat().id();
        this.userId = this.msg.replyToMessage().from().id();
    }
    
    public void banUser()
    {
        
    }
    
    public void tempBan(int time)
    {
        if(checkTime(time) == false)
        {
            String text = Govern.getLang(lang, "tempban_invalid");
            api.sendMsgReply(chatId, userId, text);
            return;
        }
        String value = chatId + ":" + userId;
        Calendar unBanTime = Calendar.getInstance(); 
        unBanTime.add(Calendar.MINUTE, time);
        kickUser();
        db.hset("tempbanned", unBanTime, value);
        String hash = "chat:"+chatId+":tempbanned";
        db.set(hash, userId);
        String name = msg.replyToMessage().from().firstName();
        boolean isAlreadyBanned = db.sismember(hash, userId);
        if(isAlreadyBanned)
        {
            String text = Govern.getLang(lang, "tempban_updated", unBanTime.toString(), name);
            api.sendMsg(chatId, text);
        }
        else
        {
            String text = Govern.getLang(lang, "tempban_banned", unBanTime.toString(), name);
            api.sendMsg(chatId, text);
            db.sadd(hash, userId);
        }
        
        
    }
    
    private boolean checkTime(int time)
    {
        if (time == 0)
        {
            return false;
        }
        else if (time > 10080) //one week
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public void kickMe()
    {
        String text = Govern.getLang(lang, "kick_errors");
        api.sendMsg(chatId, text, true);
        api.kick(chatId, userId);
    }
    
    public void banList()
    {
        ArrayList<String> text = new ArrayList<>();
        String header = "";
        ArrayList<BanList> banList = genBanList(header);
        if (banList.isEmpty())
        {
            String empty = Govern.getLang(lang, "ban_listEmpty");
            api.sendMsgReply(chatId, userId, empty);
            return;
        }
        int listSize = banList.size();
        String temp = header;
        while(listSize > 100)
        {
            
            for (int i = 0; i < 100; i++) 
            {
                temp = temp + banList.get(i).getNickName() + "\t" + banList.get(i).getId() + "\n";
            }
            listSize = listSize - 100;
            text.add(temp);
            temp = "";
        }
        for (int i = 0; i < banList.size(); i++) 
        {
            temp = temp + banList.get(i).getNickName() + "\t" + banList.get(i).getId() + "\n";
        }
        text.add(temp);
       
        for (int i = 0; i < text.size(); i++) 
        {
                 api.sendMsgReply(chatId, userId, text.get(i));
        }
    }

    private ArrayList<BanList> genBanList(String text) {
        text = Govern.getLang(lang, "ban_banlist_header");
        String hash = "chat:"+chatId+":bannedlist";
        ArrayList<String> keys = (ArrayList<String>) db.get(hash);
        ArrayList<BanList> bans = new ArrayList<>();
        BanList temp;
        String id; 
        String name;
        String why;
        for (int i = 0; i < keys.size(); i++) 
        {
            id = keys.get(i);
            hash = "chat:"+chatId+":bannedlist"+id;
            name = (String) db.hget(hash, "nick");
            why = (String) db.hget(hash, "why");
            temp = new BanList(name, why);
            bans.add(temp);
        }
        return bans;
    }

    private void kickUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
