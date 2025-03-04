
---
 <p align="center">
  <img src="https://raw.githubusercontent.com/ItsTNJS/ServerSwitcher/refs/heads/master/icon.jpg?raw=true" alt="Sublime's custom image"/>
</p>

# ServerSwitcher Plugin  

## About  
The **ServerSwitcher Plugin** is a Bukkit/Spigot/Paper plugin that enables server administrators and other plugins to send players to different **BungeeCord** or **Velocity**-connected servers. Since the backend server and plugins on it typically do not have access to the `/server` command , this plugin provides an alternative method for transferring players between servers using a command and the plugin messaging channel.  

## Features  
- Allows players to be sent to another server using the `/sendto <player> <server>` command.  
- Supports both **BungeeCord** and **Velocity** proxy networks.  
- Uses the plugin messaging channel for seamless player transfers.  
- Can be utilized by other plugins to programmatically move players between servers.  

## Use Cases  
- Administrators can move players between servers without needing direct proxy access.  
- Developers can integrate server switching into their own plugins for custom teleportation mechanics.  
- Automated events or minigame servers can send players to different lobbies or game servers dynamically.  

## Command  
- `/sendto <player> <server>` – Moves a player to the specified server.  

## Installation  
1. Install **BungeeCord** or **Velocity** and configure multiple servers.  
2. Place the **ServerSwitcher** plugin `.jar` file into your **Bukkit/Spigot/Paper** (Back end) server’s `plugins` folder.  
3. Restart the server to enable the plugin.  

## Dependencies  
- Requires either a **BungeeCord** or **Velocity** proxy setup.  
- Compatible with **Bukkit/Spigot/Paper** servers.
---

# THIS IS NOT A PROXY PLUGIN, IT IS ONLY TO BE RUN ON THE BACKEND!

