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
import com.pengrad.telegrambot.response.BaseResponse;
import java.util.Locale;
import local.Govern;
import main.bot;

/**
 *
 * @author danie
 */
public class Warn 
{
    private final Message msg;
    private final RedisCommands db;
    private final Locale lang;
    private final bot api;
    private final String part2;
    
    public Warn(Message msg, Locale lang, RedisCommands db, bot api, String part2)
    {
        this.msg = msg;
        this.db = db;
        this.lang = lang;
        this.api = api;
        this.part2 = part2;
    }
    
    public void WarnUsr()
    {
        if(msg.replyToMessage() != null)
        {
            String name = msg.replyToMessage().from().firstName();
            Long chatId = msg.chat().id();
            int userId = msg.replyToMessage().from().id();
            String hash = "chat:" + chatId + ":warns";
            Long num = db.hincrby(hash, userId, 1);
            Long maxWarn = (Long) db.hget("chat:" + chatId + ":warnsettings", "max");
            BaseResponse res;
            if(num >= maxWarn)
            {
                String text;
                String type = (String) db.hget("chat:" + chatId + ":warnsettings", "type");
                if (type.equalsIgnoreCase("ban"))
                {
                    text = Govern.getLang(lang, "warned_max_ban", name);
                    res = api.ban(chatId, userId);
                }
                else
                {
                    text = Govern.getLang(lang, "warned_max_kick", name);
                    res = api.kick(chatId, userId);
                }
                if(!res.isOk())
                {
                    if(res.description().equals(""))
                    {
                        text = Govern.getLang(lang, "ban_general_motivation");
                    }
                    else
                    {
                        text = res.description();
                    }
                }
                else
                {
                    String banH = "chat:" + chatId + ":bans";
                    db.hset(banH, userId, "warn");
                    String why;
                    if (type.equalsIgnoreCase("ban"))
                    {
                        why = Govern.getLang(lang, "warn_ban_motivation");
                        if (!part2.equalsIgnoreCase("")) text = part2;
                        db.hset(banH, userId, name + " " + why);
                    }
                    db.hdel(hash, userId);
                    db.hdel("chat:"+chatId+":mediawarn", userId);
                }
                api.sendMsgReply(chatId,userId, text);  
            }
            else
            {   
                String text = Govern.getLang(lang, "warn_warned");
                InlineKeyboardMarkup keys = doKeyboardWarn(userId);
                api.sendKeys(chatId, text, keys, true, msg.messageId());
            }
        }
    }
    
    private InlineKeyboardMarkup doKeyboardWarn(int userId)
    {
        InlineKeyboardMarkup keys = new InlineKeyboardMarkup(
        new InlineKeyboardButton[]{
                new InlineKeyboardButton("Reset Warns").callbackData("resetwarns:" + userId),
                new InlineKeyboardButton("Remove Warn").callbackData("removewarn:" + userId)
        });
        return keys;
    }
}
