package com.example.serverSwitcher;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerSwitcherPlugin extends JavaPlugin implements PluginMessageListener {

    @Override
    public void onEnable() {
        // Register the BungeeCord plugin messaging channel
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        // Register the command executor
        this.getCommand("sendto").setExecutor(new SendToCommand());
    }

    @Override
    public void onDisable() {
        // Unregister the plugin messaging channels
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }

    // Command executor for /sendto
    private class SendToCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length < 2) {
                sender.sendMessage("§cUsage: /sendto <player> <server>");
                return false;
            }

            // Get the target player and server name
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            String serverName = args[1];

            // Check if the target player is online
            if (targetPlayer == null) {
                sender.sendMessage("§cPlayer '" + args[0] + "' is not online.");
                return false;
            }

            // Send the player to the specified server
            if (sendPlayerToServer(targetPlayer, serverName)) {
                sender.sendMessage("§aSent " + targetPlayer.getName() + " to server '" + serverName + "'.");
            } else {
                sender.sendMessage("§cFailed to send " + targetPlayer.getName() + " to server '" + serverName + "'.");
            }

            return true;
        }
    }

    // Method to send a player to another server
    private boolean sendPlayerToServer(Player player, String serverName) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("Connect"); // BungeeCord subchannel
            out.writeUTF(serverName); // Target server name
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Send the plugin message
        player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
        return true;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        // Handle incoming plugin messages if needed
    }
}