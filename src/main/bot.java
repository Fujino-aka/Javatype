/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.ChatMember;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.GetChatAdministrators;
import com.pengrad.telegrambot.request.GetChatMember;
import com.pengrad.telegrambot.request.KickChatMember;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.UrbanChatMember;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetChatAdministratorsResponse;
import com.pengrad.telegrambot.response.GetChatMemberResponse;
import com.pengrad.telegrambot.response.SendResponse;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class bot 
{
    TelegramBot bot = TelegramBotAdapter.build("BOT_TOKEN");
    
    public BaseResponse ban(Long chatId, int userId)
    {
        BaseResponse ban = bot.execute(new KickChatMember(chatId, userId));
        return ban;
    }
    
    public BaseResponse kick(Long chatId, int userId)
    {
        BaseResponse kick = bot.execute(new KickChatMember(chatId, userId));
        if (kick.isOk())
        {
            GetChatMemberResponse check = bot.execute(new GetChatMember(chatId, userId));
            String status = check.chatMember().status().toString();
            int count = 0;
            while ("kicked".equalsIgnoreCase(status))
            {
                BaseResponse unBan = bot.execute(new UrbanChatMember(chatId, userId));
                check = bot.execute(new GetChatMember(chatId, userId));
                status = check.chatMember().status().toString();
                count = count + 1;
            }
            if (count == 0)
            {
                check = bot.execute(new GetChatMember(chatId, userId));
                status = check.chatMember().status().toString();
                while ("kicked".equalsIgnoreCase(status))
                {
                    BaseResponse unBan = bot.execute(new UrbanChatMember(chatId, userId));
                    check = bot.execute(new GetChatMember(chatId, userId));
                    status = check.chatMember().status().toString();
                    count = count + 1;
                }
            }
            return kick;
        }
        else
        {
            System.err.println("Kick Failed: " + kick.toString());
            return kick;
        }
    }
    
    public SendResponse sendMsg(Long chatId, String msg)
    {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, msg));
        return sendResponse;
    }

    public SendResponse sendKeys(Long chatId, String text, InlineKeyboardMarkup keys, boolean b, Integer messageId) {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, text).replyMarkup(keys).parseMode(ParseMode.Markdown).replyToMessageId(messageId));   
        return sendResponse;
    }
    
    public SendResponse sendMsg(Long chatId, String msg, boolean b)
    {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, msg).parseMode(ParseMode.HTML));
        return sendResponse;
    }

    public void sendMsgReply(Long chatId, int sendId, String msg) {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, msg).replyToMessageId(sendId));
    }
    
    public boolean isMod(Long chatId, int sendId)
    {
        GetChatMemberResponse res = bot.execute(new GetChatMember(chatId, sendId));
        if (!res.isOk())
        {
            return false;
        }
        String status = res.chatMember().status().toString();
        if (status.equalsIgnoreCase("creator") || status.equalsIgnoreCase("administrator"))
        {
            return true;
        }
        return false;
    }
    
    public ArrayList<ChatMember> getModList(Long chatId, int sendId)
    {
        ArrayList<ChatMember> mods = new ArrayList<>();
        GetChatAdministratorsResponse res = bot.execute(new GetChatAdministrators(chatId));
        if(!res.isOk())
        {
            
        }
        
        for (int i = 0; i < res.administrators().size(); i++) 
        {
            if(res.administrators().get(i).status().toString().equalsIgnoreCase("creator"))
            {
                mods.add(res.administrators().get(i));
                break;
            }
        }
        if(res.administrators().size() > 0)
        {
            for (int i = 0; i < res.administrators().size(); i++) 
            {
                mods.add(res.administrators().get(i));
            }
        }
        
        return mods;
    }

    public void sendMsgReply(Long chatId, int sendId, String string, boolean b) {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, string).parseMode(ParseMode.Markdown).replyToMessageId(sendId));
    }
}
