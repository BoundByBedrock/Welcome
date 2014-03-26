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
        getConfig().options().copyDefaults(true);
        saveConfig();
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
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    formatMessage(getConfig().getString("MESSAGE"), player)));
            return true;
        }
        return false;
    }

    private String formatMessage(String string, Player player)
    {
        return string.replace("%p", player.getDisplayName());
    }
}