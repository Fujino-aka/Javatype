/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.lambdaworks.redis.api.sync.RedisCommands;
import com.pengrad.telegrambot.model.ChatMember;
import com.pengrad.telegrambot.model.Message;
import java.util.ArrayList;
import java.util.Locale;
import local.Govern;
import main.bot;

/**
 *
 * @author danie
 */
public class Group 
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
    public Group(Message msg, Locale lang, RedisCommands db, bot api, String part2)
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
        if(msg.replyToMessage() != null)
        {
            return msg.replyToMessage().from().id();
        }
        else if(msg.forwardFrom() != null)
        {
            return msg.forwardFrom().id();
           
        }
        else if (part2.contains("@"))
        {
            int temp = userNameToId(part2, chatId);
            if (temp == -1)
            {
                return -1; //TODO Added failure 
            }
        }
        else
        {
            api.sendMsgReply(chatId, sendId, "Please reply or tag someone");
            return -1; //TODO Added failure 
        }
        return -1;
    }
    
    private String setName()
    {
        if(msg.replyToMessage() != null)
        {
            return msg.replyToMessage().from().firstName();
        }
        else if(msg.forwardFrom() != null)
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
    
    public void adminList()
    {
        ArrayList<ChatMember> mods = api.getModList(chatId, userId);
        String creator = mods.get(0).user().firstName() + " " + mods.get(0).user().lastName();
        String admins = "";
        int count = 1;
        for (int i = 1; i < mods.size(); i++) 
        {
            admins = admins + count + ": " + mods.get(i).user().firstName() + " " + mods.get(i).user().lastName() + "\n";
            count++;
        }
        String text = Govern.getLang(lang, "modlist", creator, admins);
        api.sendMsgReply(chatId, userId, text);
    }

    private boolean isLocked(String setting) 
    {
        String hash = "chat:"+chatId+":settings";
        String adminMode = (String) db.hget(hash,"Admin_mode");
        if(adminMode.equalsIgnoreCase("no") && (setting.equalsIgnoreCase("rules") || setting.equalsIgnoreCase("about") || setting.equalsIgnoreCase("modlist") || setting.equalsIgnoreCase("extra")))
        {
            return true;
        }
        String current = (String) db.hget(hash, setting);
        if(current.equalsIgnoreCase("yes"))
        {
            return true;
        }
        return false;
    }
}
