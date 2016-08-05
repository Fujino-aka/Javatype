/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author danie
 */
public class Govern 
{
    public static final Locale[] supportedLocales = {
        new Locale("en", "US")
    };
    public static String getLang(Locale lang, String name)
    {
        Locale local = new Locale("en", "US");
        String text;
        for(Locale i : supportedLocales)
        {
            if(i.equals(lang))
            {
                local = i;
                break;
            }   
        }
        ResourceBundle rb = ResourceBundle.getBundle("local.Main", local);
        text = (String) rb.getObject(name);
        return text;
    }
    
    public static String getLang(Locale lang, String name, Object... params)
    {
        Locale local = new Locale("en", "US");
        String text;
        for(Locale i : supportedLocales)
        {
            if(i.equals(lang))
            {
                local = i;
                break;
            }   
        }
        ResourceBundle rb = ResourceBundle.getBundle("local.Main", local);
        return MessageFormat.format(rb.getString(name), params);
    }
}
