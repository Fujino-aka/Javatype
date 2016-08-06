/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local;

import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;


/**
 *
 * @author danie
 */
public class Main_en extends ListResourceBundle {    
    public static Object[][] contents = 
    {
        {"kicked", "&&&1 is banned from this group"},
        {"left", "&&&1 left the group or has been kicked and unbanned"},
        {"administrator","&&&1 is an Admin"},
        {"creator", "&&&1 is the group creator"},
        {"unknown","This user has nothing to do with this chat"},
        {"member","&&&1 is a chat member"},  

        {"header_1", "*Ban info (globals)*:\n"},
        {"header_2", "*General info*:\n"},
        {"warns", "`Warns`: "},
        {"media_warns", "`Media warns`: "},
        {"group_msgs", "`Messages in the group`: "},
        {"group_media", "`Media sent in the group`: "},
        {"last_msg", "`Last message here`: "},
        {"global_msgs", "`Total number of messages`: "},
        {"global_media", "`Total number of media`: "},
        {"remwarns_kb", "Remove warns"}

        {"header", "*Global stats* for "},
        {"nothing", "`Nothing to display`"},
        {"kick", "Kick: "},
        {"ban", "Ban: "},
        {"tempban", "Tempban: "},
        {"flood", "Removed for flood: "},
        {"warn", "Removed for warns: "},
        {"media", "Removed for forbidden media: "},
        {"arab", "Removed for arab chars: "},
        {"rtl", "Removed for RTL char: "},
        {"kicked", "_Kicked!_"},
        {"banned", "_Banned!_"}

        {"general_pm", "_I\'ve sent you the message in private_"},
        {"no_user", "I\'ve never seen this user before.\nIf you want to teach me who they are, forward me a message from them"},
        {"the_group", "the group"},
        {"adminlist_admin_required", "I\'m not a group Admin.\n*Only an Admin can see the administrators list*"},
        {"settings_header", "Current settings for *the group*:\n\n*Language*: `&&&1`\n"},
        {"reply", "*Reply to someone* to use this command, or write a *username*"},
        {"too_long", "This text is too long, I can\'t send it"},
        {"msg_me", "_Message me first so I can message you_"},
        {"menu_cb_settings", "Tap on an icon!"},
        {"menu_cb_warns", "Use the row below to change the warns settings!"},
        {"menu_cb_media", "Tap on a switch!"},
        {"tell", "*Group ID*: &&&1"},

        {"not_mod", "You are *not* an admin"}
        {"breaks_markdown", "This text breaks the markdown.\nMore info about a proper use of markdown [here](https://telegram.me/GroupButler_ch/46)."}
        {"credits", "*Some useful links:*"}
        {"setted", "&&&1 command saved!"}
        {"no_commands", "No commands set!"}
        {"commands_list", "List of *custom commands*:\n&&&1"}
        {"command_deleted", "&&&1 command have been deleted"}
        {"command_empty", "&&&1 command does not exist"}
  
        {"banhammer", "*Admins: banhammer powers*\n\n"
                         +"`/kick [by reply|username]` = kick a user from the group (they can be added again).\n"
                         +"`/ban [by reply|username]` = ban a user from the group (also from normal groups).\n"
                         +"`/tempban [minutes]` = ban an user for a specific amount of minutes (minutes must be < 10.080, one week). For now, only by reply.\n"
                         +"`/unban [by reply|username]` = unban the user from the group.\n"
                         +"`/user [by reply|username|id]` = returns a two pages messages: the first shows how many times the user has been banned *in all the groups* (divided in sections), "
                         +"the second page shows some general stats about the user: messages/media in the group, warns received and so on.\n"
                         +"`/status [username|id]` = show the current status of the user `(member|kicked/left the chat|banned|admin/creator|never seen)`.\n"
                         +"`/banlist` = show a list of banned users. Includes the motivations (if given during the ban)\n"
                         +"`/banlist` = clean the banlist.\n"
                         +"\n*Note*: you can write something after `/ban` command (or after the username, if you are banning by username)."
                         +" This comment will be used as the motivation of the ban."},
        {"info", "*Admins info about the group*\n\n"
                     +"`/setrules [group rules]` = set the new rules for the group (the old ones will be overwritten).\n"
                     +"`/addrules [text]` = add some text at the end of the existing rules.\n"
                     +"`/setabout [group description]` = set a new description for the group (the old one will be overwritten).\n"
                     +"`/addabout [text]` = add some text at the end of the existing description.\n"
                     +"\n*Note:* the markdown is supported. If the text sent breaks the markdown, the bot will notify that something is wrong.\n"
                     +"For a correct use of the markdown, check [this post](https://telegram.me/GroupButler_ch/46) in the GroupButler channel"},         
        {"flood", "*Admins: flood settings*\n\n"
                     +"`/antiflood` = manage the flood settings in private, with an inline keyboard. You can change the sensitivity, the action (kick/ban), and even set some exceptions.\n"
                     +"`/antiflood [number]` = set how many messages a user can write in 5 seconds.\n"
                     +"_Note_ : the number must be higher than 3 and lower than 26.\n"},         
        {"media", "*Admins: media settings*\n\n"
                     +"`/media` = receive in PM an inline keyboard to change all the media settings.\n"
                     +"`/warnmax media [number]` = set the max number of warnings before be kicked/banned for have sent a forbidden media.\n"
                     +"`/media list` = show the current settings for all the media.\n"
                     +"\n*List of supported media*: _image, audio, video, sticker, gif, voice, contact, file, link_\n"},         
        {"welcome", "*Admins: welcome settings*\n\n"
                         +"`/menu` = receive in private the menu keyboard. You will find an option to enable/disable the welcome message.\n"
                         +"\n*Custom welcome message:*\n"
                         +"`/welcome Welcome $name, enjoy the group!`\n"
                         +"Write after \"/welcome\" your welcome message. You can use some placeholders to include the name/username/id of the new member of the group\n"
                         +"Placeholders: _$username_ (will be replaced with the username); _$name_ (will be replaced with the name); _$id_ (will be replaced with the id); _$title_ (will be replaced with the group title).\n"
                         +"\n*GIF/sticker as welcome message*\n"
                         +"You can use a particular gif/sticker as welcome message. To set it, reply to a gif/sticker with \'/welcome\'\n"
                         +"\n*Composed welcome message*\n"
                         +"You can compose your welcome message with the rules, the description and the admin list.\n"
                         +"You can compose it by writing `/welcome` followed by the codes of what the welcome message has to include.\n"
                         +"_Codes_ : *r* = rules; *a* = description (about); *m* = adminlist.\n"
                         +"For example, with \"`/welcome rm`\", the welcome message will show rules and admin list"},         
        {"extra", "*Admins: extra commands*\n\n"
                     +"`/extra [#trigger] [reply]` = set a reply to be sent when someone writes the trigger.\n"
                     +"_Example_ : with \"`/extra #hello Good morning!`\", the bot will reply \"Good morning!\" each time someone writes #hello.\n"
                     +"You can reply to a media (_photo, file, vocal, video, gif, audio_) with `/extra #yourtrigger` to save the #extra and receive that media each time you use # command\n"
                     +"`/extra list` = get the list of your custom commands.\n"
                     +"`/extra del [#trigger]` = delete the trigger and its message.\n"
                     +"\n*Note:* the markdown is supported. If the text sent breaks the markdown, the bot will notify that something is wrong.\n"
                     +"For a correct use of the markdown, check [this post](https://telegram.me/GroupButler_ch/46) in the GroupButler channel"},         
        {"warns", "*Admins: warns*\n\n"
                     +"`/warn [by reply]` = warn a user. Once the max number is reached, he will be kicked/banned.\n"
                     +"`/warnmax` = set the max number of the warns before the kick/ban.\n"
                     +"\nHow to see how many warns a user has received: the number is showed in the second page of the `/user` command. In this page, you will see a button to reset this number."},         
        {"char", "*Admins: special characters*\n\n"
                     +"`/menu` = you will receive in private the menu keyboard.\n"
                     +"Here you will find two particular options: _Arab and RTL_.\n"
                     +"\n*Arab*: when Arab it's not allowed (🚫), everyone who will write an arab character will be kicked from the group.\n"
                     +"*RTL*: it stands for 'Right To Left' character, and it's the responsible of the weird service messages that are written in the opposite sense.\n"
                     +"When RTL is not allowed (🚫), everyone that writes this character (or that has it in his name) will be kicked."},         
        {"links", "*Admins: links*\n\n"
                     +"`/setlink [link|'no']` = set the group link, so it can be recalled by other admins, or unset it.\n"
                     +"`/link` = get the group link, if set by the owner.\n"
                     +"\n*Note*: the bot can recognize valid group links. If a link is not valid, you won\'t receive a reply."},         
        {"lang", "*Admins: group language*\n\n"
                     +"`/lang` = choose the group language (can be changed in private too).\n"},         
        {"settings", "*Admins: group settings*\n\n"
                         +"`/menu` = manage the group settings in private with an handy inline keyboard.\n"
                         +"`/report [on/off]` (by reply) = the user won\'t be able (_off_) or will be able (_on_) to use \"@admin\" command.\n"},

        //link
        {"no_link", "*No link* for this group. Ask the owner to generate one"},
        {"link", "[&&&1](&&&2)"},
        {"link_no_input", "This is not a *public supergroup*, so you need to write the link near /setlink"},
        {"link_invalid", "This link is *not valid!*"},
        {"link_updated", "The link has been updated.\n*Here\'s the new link*: [&&&1](&&&2)"},
        {"link_setted", "The link has been set.\n*Here\'s the link*: [&&&1](&&&2)"},
        {"link_unsetted", "Link *unset*"},

        //adminlist
        {"modlist", "*Creator*:\n&&&1\n\n*Admins*:\n&&&2"},
     
        {"no_input", "Write your suggestions/bugs/doubt near the !"},
        {"sent", "Feedback sent!"},
        {"feedback_reply", "*Hello, this is a reply from the bot owner*:\n&&&1"},

        //welcome
        {"welcome", "Hi &&&1, and welcome to *&&&2*!"},
        {"welcome_rls", "Total anarchy!"},
        {"welcome_abt", "No description for this group."},
        {"welcome_modlist", "\n\n*Creator*:\n&&&1\n*Admins*:\n&&&2"},
        {"abt", "\n\n*Description*:\n"},
        {"rls", "\n\n*Rules*:\n"},

        //about
        {"no_bio", "*No description* for this group."},
        {"no_bio_add", "*No description for this group*.\nUse /setabout [description] to set-up a new description"},
        {"no_input_add", "Please write something next /addabout"},
        {"added", "*Description added:*\n&&&1"},
        {"no_input_set", "Please write something next /setabout"},
        {"clean", "The description has been cleaned."},
        {"new", "*New description:*\n&&&1"},
        {"about_setted", "New description *saved successfully*!"}

        //setrules
        {"no_rules", "*Total anarchy*!"},
        {"no_rules_add", "*No rules* for this group.\nUse /setrules [rules] to set the rules"},
        {"no_input_add", "Please write something next /addrules"},
        {"added", "*Rules added:*\n&&&1"},
        {"no_input_set", "Please write something next /setrules"},
        {"clean", "Rules have been cleaned."},
        {"new", "*New rules:*\n&&&1"},
        {"rules_setted", "New rules *saved successfully*!"}

        //settings
        {"rules_locked", "/rules command is now available only for admins"},
        {"about_locked", "/about command is now available only for admins"},
        {"welcome_locked", "Welcome message won\'t be displayed from now"},
        {"modlist_locked", "/adminlist command is now available only for admins"},
        {"flag_locked", "/flag command won\'t be available from now"},
        {"extra_locked", "#extra commands are now available only for admins"},
        {"flood_locked", "Anti-flood is now off"},
        {"report_locked", "@admin command won\'t be available from now"},
        {"admin_mode_locked", "Admin mode off"},

        {"rules_unlocked", "/rules command is now available for everyone"},
        {"about_unlocked", "/about command is now available for everyone"},
        {"welcome_unlocked", "Welcome message will be displayed"},
        {"modlist_unlocked", "/adminlist command is now available for everyone"},
        {"flag_unlocked", "/flag command is now available"},
        {"extra_unlocked", "Extra # commands are now available for everyone"},
        {"flood_unlocked", "Anti-flood is now on"},
        {"report_unlocked", "@admin command is now available"},
        {"admin_mode_unlocked", "Admin mode on"},

        {"no_input", "Welcome and+.?"},
        {"media_setted", "New media set as welcome message: "},
        {"reply_media", "Reply to a `sticker` or a `gif` to set them as *welcome message*"},
        {"a", "New settings for the welcome message:\nRules\n*About*\nAdmins list"},
        {"r", "New settings for the welcome message:\n*Rules*\nAbout\nAdmins list"},
        {"m", "New settings for the welcome message:\nRules\nAbout\n*Admins list*"},
        {"ra", "New settings for the welcome message:\n*Rules*\n*About*\nAdmins list"},
        {"rm", "New settings for the welcome message:\n*Rules*\nAbout\n*Admins list*"},
        {"am", "New settings for the welcome message:\nRules\n*About*\n*Admins list*"},
        {"ram", "New settings for the welcome message:\n*Rules*\n*About*\n*Admins list*"},
        {"no", "New settings for the welcome message:\nRules\nAbout\nAdmins list"},
        {"wrong_input", "Argument unavailable.\nUse _/welcome [no|r|a|m|ra|rm|am|ram]_ instead"},
        {"custom", "*Custom welcome message* set!\n\n&&&1"},
        {"custom_setted", "*Custom welcome message saved!*"},
        {"wrong_markdown", "_Not set_ : I can\'t send you back this message, probably the markdown is *wrong*.\nPlease check the text sent"},

        {"header", "Current settings for *&&&1*:\n\n*Language*: `&&&2`\n"},
        {"w_a", "*Welcome type*: `welcome + about`\n"},
        {"w_r", "*Welcome type*: `welcome + rules`\n"},
        {"w_m", "*Welcome type*: `welcome + adminlist`\n"},
        {"w_ra", "*Welcome type*: `welcome + rules + about`\n"},
        {"w_rm", "*Welcome type*: `welcome + rules + adminlist`\n"},
        {"w_am", "*Welcome type*: `welcome + about + adminlist`\n"},
        {"w_ram", "*Welcome type*: `welcome + rules + about + adminlist`\n"},
        {"w_no", "*Welcome type*: `welcome only`\n"},
        {"w_media", "*Welcome type*: `gif/sticker`\n"},
        {"w_custom", "*Welcome type*: `custom message`\n"},
        {"legenda", "✅ = _enabled/allowed_\n🚫 = _disabled/not allowed_\n👥 = _sent in group (always for admins)_\n👤 = _sent in private_"}

        {"arab_kick", "Users that type arab characters will be kicked"},
        {"arab_ban", "Users that type arab characters will be banned"},
        {"arab_allow", "Arab language allowed"},
        {"rtl_kick", "Users that type the RTL character will be kicked"},
        {"rtl_ban", "Users that type RTL character will be banned"},
        {"rtl_allow", "RTL character allowed"},

        //menu
        {"broken_group", "There are no settings saved for this group.\nPlease run /initgroup to solve the problem :)"},
        {"Rules", "/rules"},
        {"About", "/about"},
        {"Welcome", "Welcome message"},
        {"Modlist", "/adminlist"},
        {"Flag", "Flag"},
        {"Extra", "Extra"},
        {"Flood", "Anti-flood"},
        {"Rtl", "RTL"},
        {"Arab", "Arab"},
        {"Report", "Report"},
        {"Admin_mode", "Admin mode"},

        {"all", "*Commands for all*:\n"
                 +"`/dashboard` : see all the group info from private\n"
                 +"`/rules` (if unlocked) : show the group rules\n"
                 +"`/about` (if unlocked) : show the group description\n"
                 +"`/adminlist` (if unlocked) : show the admins of the group\n"
                 +"`@admin` (if unlocked) : by reply = report the message replied to all the admins; no reply (with text) = send a feedback to all the admins\n"
                 +"`/kickme` : get kicked by the bot\n"
                 +"`/faq` : some useful answers to frequent quetions\n"
                 +"`/id` : get the chat id, or the user id if by reply\n"
                 +"`/echo [text]` : the bot will send the text back (with markdown, available only in private for non-admin users)\n"
                 +"`/info` : show some useful informations about the bot\n"
                 +"`/group` or `/support` : get the support group link (if you reply a user with `/support`, I will reply to them)\n"
                 +"`!`<feedback> : send a feedback/report a bug/ask a question to my creator. (Example: !Your bot is awesome)\n"
                 +"`/help` : show this message."
                 +"I\'m a bot created to help manage Werewolf groups which use @werewolfbot.\n"
                 +"\n*What can I do for you?*\n"}
                 +"Wew, I have a lot of useful tools!\n"
                 +"• You can *kick or ban* users (even in normal groups) by reply/username\n"
                 +"• Set rules and a description\n"
                 +"• Turn on a configurable *anti-flood* system\n"
                 +"• Customize the *welcome message*, also with gif and stickers\n"
                 +"• Warn users, and kick/ban them if they reach a max number of warns\n"
                 +"• Warn or kick users if they send a specific media\n"
                 +"+.and more, below you can find the "all commands" button to get the whole list!\n"
                 +"\nTo use me, *you need to add me as administrator of the group*, or Telegram won\"}t let me work properly! (if you have some doubts about this, check [this post](https://telegram.me/GroupButler_ch/63))"
                 +"\nYou can report bugs/send feedbacks/ask a question to my creator just using "`!<feedback>`"."},
         {"group_success", "_I\'ve sent you the help message in PM_"},
         {"group_not_success", "_Please PM me first so I can PM you_"},
         {"initial", "Choose the *role* to see the available commands:"},
         {"kb_header", "Tap on a button to see the *related commands*"}


        {"no_input", "Reply to a message to report it to an admin, or write something next \'@admin\' to send a feedback to them"}
        {"reported", "Reported!"}
        {"no_reply", "Reply to a user!"}
        {"blocked", "From now, this user can\'t use \'@admin\'"}
        {"already_blocked", "This user is already unable to use \'@admin\'"}
        {"unblocked", "This user now can use \'@admin\'"}
        {"already_unblocked", "This user is already able to use \'@admin\'"}

        {"flood_ban", "&&&1 *banned* for flood!"}
        {"flood_kick", "&&&1 *kicked* for flood!"}
        {"media_kick", "&&&1 *kicked*: media sent not allowed!"}
        {"media_ban", "&&&1 *banned*: media sent not allowed!"}
        {"rtl_kicked", "&&&1 *kicked*: RTL character in names/messages not allowed!"}
        {"arab_kicked", "&&&1 *kicked*: arab messages not allowed!"}
        {"rtl_banned", "&&&1 *banned*: RTL character in names/messages not allowed!"}
        {"arab_banned", "&&&1 *banned*: arab messages not allowed!"}
        {"flood_motivation", "Banned for flood"}
        {"media_motivation", "Sent a forbidden media"}
        {"first_warn", "This type of media is *not allowed* in this chat."}
 
        {"warn", "This kind of media is *not allowed* in this group.\n_Next time_ you will be kicked or banned"}
        {"settings_header", "*Current settings for media*:\n\n"}
        {"changed", "New status for [&&&1] = &&&2"}

        {"number_invalid", "`&&&1` is not a valid value!\nThe value should be *higher* than `3` and *lower* then `26`"}
        {"not_changed", "The max number of messages is already &&&1"}
        {"changed_plug", "The *max number* of messages (in *5 seconds*) changed _from_  &&&1 _to_  &&&2"}
        {"kick", "From now, flooders will be kicked"}
        {"ban", "From now, flooders will be banned"}
        {"changed_cross", "&&&1 -> &&&2"}
        {"text", "Texts"}
        {"image", "Images"}
        {"sticker", "Stickers"}
        {"gif", "Gif"}
        {"video", "Videos"}
        {"sent", "_I\'ve sent you the anti-flood menu in private_"}
        {"ignored", "[&&&1] will be ignored by the anti-flood"}
        {"not_ignored", "[&&&1] won\'t be ignored by the anti-flood"}
        {"number_cb", "Current sensitivity. Tap on the + or the -"}

        {"broken_group", "There are no settings saved for this group.\nPlease run /initgroup to solve the problem :)"}
        {"Rules", "/rules"}
        {"About", "/about"}
        {"Welcome", "Welcome message"}
        {"Modlist", "/adminlist"}
        {"Flag", "Flag"}
        {"Extra", "Extra"}
        {"Flood", "Anti-flood"}
        {"Rtl", "RTL"}
        {"Arab", "Arab"}
        {"Report", "Report"}
        {"Admin_mode", "Admin mode"}

        {"warn_reply", "Reply to a message to warn the user"}
        {"changed_type", "New action on max number of warns received: *&&&1*"}
        {"mod", "An admin can\'t be warned"}
        {"warned_max_kick", "User &&&1 *kicked*: reached the max number of warns"}
        {"warned_max_ban", "User &&&1 *banned*: reached the max number of warns"}
        {"warned", "&&&1 *has been warned.*\n_Number of warns_   *&&&2*\n_Max allowed_   *&&&3*"}
        {"warnmax", "Max number of warns changed&&&3.\n*Old* value: &&&1\n*New* value: &&&2"}
        {"getwarns_reply", "Reply to a user to check his number of warns"}
        {"getwarns", "&&&1 (*&&&2/&&&3*)\nMedia: (*&&&4/&&&5*)"}
        {"nowarn_reply", "Reply to a user to remove his warns"}
        {"warn_removed", "*Warn removed!*\n_Number of warns_   *&&&1*\n_Max allowed_   *&&&2*"}
        {"ban_motivation", "Too many warns"}
        {"inline_high", "The new value is too high (>12)"}
        {"inline_low", "The new value is too low (<1)"}
        {"zero", "The number of warns received by this user is already _zero_"}
        {"nowarn", "The number of warns received by this user has been *reset*"}

        {"list", "*List of available languages:*"}
        {"success", "*New language set:* &&&1"}
        {"error", "Language not supported yet"}

        {"kicked", "`&&&1` kicked `&&&2`!"}
        {"banned", "`&&&1` banned `&&&2`!"}
        {"already_banned_normal", "&&&1 is *already banned*!"}
        {"unbanned", "User unbanned!"}
        {"reply", "Reply to someone"}
        {"globally_banned", "&&&1 has been globally banned!"}
        {"not_banned", "The user is not banned"}
        {"banlist_header", "*Banned users*:\n\n"}
        {"banlist_empty", "_The list is empty_"}
        {"banlist_error", "_An error occurred while cleaning the banlist_"}
        {"banlist_cleaned", "_The banlist has been cleaned_"}
        {"tempban_zero", "For this, you can directly use /ban"}
        {"tempban_week", "The time limit is one week (10.080 minutes)"}
        {"tempban_banned", "User &&&1 banned. Ban expiration:"}
        {"tempban_updated", "Ban time updated for &&&1. Ban expiration:"}
        {"general_motivation", "I can\'t kick this user.\nProbably I\'m not an admin, or the user is an admin"}

        {"header". "You can manage the group flood settings from here.\n"
             +"\n*1st row*\n"
             +"• *ON/OFF*: the current status of the anti-flood\n"
             +"• *Kick/Ban*: what to do when someone is flooding\n"
             +"\n*2nd row*\n"
             +"• you can use *+/-* to change the current sensitivity of the anti-flood system\n"
             +"• the number is the max number of messages that can be sent in _5 seconds_\n"
             +"• max value: _25_ - min value: _4_\n"
             +"\n*3rd row* and below\n"
             +"You can set some exceptions for the anti-flood:\n"
             +"• ✅: the media will be ignored by the anti-flood\n"
             +"• ❌: the media won\"t be ignored by the anti-flood\n"
             +"• *Note*: in "_texts_" are included all the other types of media (file, audio, etc)"}
 
        {"menu_first". "Manage the settings of the group.\n"
             +"\nSome commands (_/rules, /about, /adminlist, #extra commands_) can be *disabled for non-admin users*\n"
             +"What happens if a command is disabled for non-admins:\n"
             +"• If the command is triggered by an admin, the bot will reply *in the group*\n"
             +"• If the command is triggered by a normal user, the bot will reply *in the private chat with the user* (only if the user has already started the bot)\n"
             +"\nThe icons near the command will show the current status:\n"
             +"• 👥: the bot will reply *in the group*, with everyone\n"
             +"• 👤: the bot will reply *in private* with normal users and in the group with admins\n"
             +"\n*Other settings*: for the other settings, icons are self explanatory\n"},

        {"media_first". "Tap on a voice in the right column to *change the setting*\n"
                +"You can use the last line to change how many warns should the bot give before kick/ban someone for a forbidden media\n"
                +"The number is not related to the normal `/warn` command"},


        {"menu", "_I\''ve sent you the settings menu in private_"},
        {"group_success", "_I\'ve sent you the help message in PM_"},
        {"group_not_success", "_Please PM me first so I can PM you_"},
        {"initial", "Choose the *role* to see the available commands:"},
        {"kb_header", "Tap on a button to see the *related commands*"}
 
        {"private", "_I\'ve sent you the group dashboard in private_"},
        {"first", "Navigate this message to see *all the info* about this group!"},
        {"antiflood", "- *Status*: `&&&1`\n- *Action* when an user floods: `&&&2`\n- Number of messages *every 5 seconds* allowed: `&&&3`\n- *Ignored media*:\n&&&4"},
        {"settings", "Settings"},
        {"admins", "Admins"},
        {"rules", "Rules"},
        {"about", "Description"},
        {"welcome", "Welcome message"},
        {"extra", "Extra commands"},
        {"media", "Media settings"},
        {"flood", "Flood settings"},

        {"[1]", "I\'m not an admin, I can\'t kick people"},
        {"[2]", "I can\'t kick or ban an admin"},
        {"[3]", "There is no need to unban in a normal group"},
        {"[4]", "This user is not a chat member"},
 

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}



