package me.godmodz115.welcome;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Welcome extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Enabled!");
    }

    @Override
    public void onDisable()
    {
        saveConfig();
        getLogger().info("Disabled!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player) sender;
        if (commandLabel.equalsIgnoreCase("hi"))
        {
            if (args.length != 1)
            {
                return false;
            }
            else if (args.length == 1)
            {
                player.chat(ChatColor.translateAlternateColorCodes('&',
                        formatMessage(getConfig().getString("MESSAGE"), args[0])));
                return true;
            }
        }
        return false;
    }

    private String formatMessage(String string, String recipient)
    {
        return string.replace("%p", recipient);
    }
}