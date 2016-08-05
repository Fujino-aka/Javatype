/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.lambdaworks.redis.api.sync.RedisCommands;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.response.BaseResponse;
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
public class Removal 
{
    private final Message msg;
    private final RedisCommands db;
    private final Locale lang;
    private final bot api;
    private final String part2;
    private final Long chatId;
    private final int userId; 
    private final String name;
    private final int sendId;
    
    public Removal(Message msg, Locale lang, RedisCommands db, bot api, String part2)
    {
        this.msg = msg;
        this.db = db;
        this.lang = lang;
        this.api = api;
        this.part2 = part2;
        this.chatId = this.msg.chat().id();
        this.userId = setId();
        this.sendId = this.msg.from().id();
        this.name = setName();
    }
    
    private int setId() {
        if(msg.replyToMessage()) //TODO Resolve test
        {
            return msg.replyToMessage().from().id();
        }
        else if(msg.forwardFrom())
        {
            return msg.forwardFrom().id();
           
        }
        else if (part2.contains("@"))
        {
            int temp = userNameToId(part2);
            if (temp == -1)
            {
                return null; //TODO Added failure 
            }
        }
        else
        {
            api.sendMsgReply(chatId, sendId, "Please reply or tag someone");
            return null; //TODO Added failure 
        }
    }
    
    private String setName()
    {
        if(msg.replyToMessage()) //TODO Resolve Test
        {
            return msg.replyToMessage().from().firstName();
        }
        else if(msg.forwardFrom())
        {
            return msg.forwardFrom().firstName();
           
        }
        else if (part2.contains("@"))
        {
            return part2;
        }
        else
        {
            api.sendMsgReply(chatId, sendId, "Please reply or tag someone");
            return null;
        }
    }
    
    private int userNameToId(String username, Long chatId)
    {
        int userID;
        if (username.isEmpty())
        {
            return -1;
        }
        username = username.toLowerCase();
        String hash = "bot:usernames:" + chatId;
        String id = (String) db.hget(hash, username);
        if(!id.isEmpty())
        {
            userID = Integer.parseInt(id);
        }
        else
        {
            userID = userNameToId(username);
        }
        return userID;
    }

    private int userNameToId(String username) 
    {
        if (username.isEmpty())
        {
            return -1;
        }
        username = username.toLowerCase();
        String hash = "bot:usernames:";
        String id = (String) db.hget(hash, username);
        if(!id.isEmpty())
        {
            return Integer.parseInt(id);
        }
        else
        {
            return -1;
        }
    }
    
    public void banUser()
    {
        BaseResponse res = api.ban(chatId, userId);
        if (!res.isOk())
        {
            String error;
            if(res.description().isEmpty())
            {
                error = Govern.getLang(lang, "ban_general_motivation");    
            }
            else
            {
                error = res.description();
            }
            api.sendMsg(chatId, error);
        }
        else
        {
            String hash = "ban:"+userId;
            db.hincrby(hash, "ban", 1);
            String why;
            if(msg.replyToMessage()) //TODO Resolve test 
            {
               why = part2; 
            }
            else
            {
                why = "No Reason given";
            }
            hash = "chat:" + chatId + ":bannedlist";
            db.set(hash, userId);
            hash = hash + ":" + userId;
            db.hset(hash, "nick", name + " (" + userId + ")");
            db.hset(hash, "why", why);
        }
    }
    
    public void tempBan(int time)
    {
        if(checkTime(time) == false)
        {
            String text = Govern.getLang(lang, "tempban_invalid");
            api.sendMsgReply(chatId, sendId, text);
            return;
        }
        String value = chatId + ":" + userId;
        Calendar unBanTime = Calendar.getInstance(); 
        unBanTime.add(Calendar.MINUTE, time);
        api.ban(chatId, userId);
        db.hset("tempbanned", unBanTime, value);
        String hash = "chat:"+chatId+":tempbanned";
        db.set(hash, userId);
        String name = msg.replyToMessage().from().firstName();
        boolean isAlreadyBanned = db.sismember(hash, userId);
        if(isAlreadyBanned)
        {
            String text = Govern.getLang(lang, "tempban_updated", unBanTime.toString(), name);
            api.sendMsgReply(chatId, sendId, text);
        }
        else
        {
            String text = Govern.getLang(lang, "tempban_banned", unBanTime.toString(), name);
            api.sendMsgReply(chatId, sendId, text);
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
            api.sendMsgReply(chatId, sendId, empty);
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
                 api.sendMsgReply(chatId, sendId, text.get(i));
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

    public void kickUser() {
        BaseResponse res = api.kick(chatId, userId);
        if(!res.isOk())
        {
            String error;
            if(res.description().isEmpty())
            {
                error = Govern.getLang(lang, "ban_general_motivation");    
            }
            else
            {
                error = res.description();
            }
            api.sendMsg(chatId, error);
        }
        else
        {
            String hash = "ban:"+userId;
            db.hincrby(hash, "kick", 1);
            String text = Govern.getLang(lang, "ban_kicked", msg.from().firstName(),  name);
            api.sendMsg(chatId, text, true);
        }
        
    }
}
