/*
 * Copyright (C) 2014 by maciekmm <m.mionskowski@maciekmm.tk>
 * This file is part of AntiAutoSoup project.
 * AntiAutoSoup can not be copied and/or distributed without the express permission of maciekmm
 */

package tk.maciekmm.antiautosoup.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tk.maciekmm.antiautosoup.AntiAutoSoup;
import tk.maciekmm.antiautosoup.BanInfo;

public class AsBan implements CommandExecutor {
    private final AntiAutoSoup plugin;

    public AsBan(AntiAutoSoup plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length<1) {
            return false;
        }
        BanInfo ban = BanInfo.getByName(args[0],plugin.getBans());
        ban.ban(plugin);
        sender.sendMessage(AntiAutoSoup.getString("ban.ban",args[0]));
        return true;
    }
}
