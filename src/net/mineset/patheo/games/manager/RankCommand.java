package net.mineset.patheo.games.manager;

import net.mineset.patheo.games.RiseCore;
import net.mineset.patheo.games.util.DefaultFontInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {
    private RiseCore plugin;

    public RankCommand(RiseCore plugin) {
        this.plugin = plugin;
        plugin.getCommand("user").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("RANK_ADMIN")) {
            if (args.length == 0) {
                sendCenteredMessage(player, "§e&lUser & Rank Commands");
                player.sendMessage("§7/user list §eList all current in game ranks");
                player.sendMessage("§7/user add <user> <rank> §eAdds a rank to a player");
                player.sendMessage("§7/user remove <user> <rank> §eRemove a rank from a player");
                return true;
            } else {
                if (args[0].equalsIgnoreCase("list")) {

                    sendCenteredMessage(player, "§e§lRank List §7Currently in game");
                    player.sendMessage("§7- §e§lOWNER§7, §e§lMANAGER§7, §c§lADMIN");
                    player.sendMessage("§7- §c§lSRMOD§7, §c§lMOD§7, §9§lBUILDER");
                    player.sendMessage("§7- §d§lHIPSTER§7, §9§lVIBE§7, §a§lPRO§7, §7Regular");
                    sendCenteredMessage(player, "§e/user add §7- §e/user remove");
                } else {
                    if (args[0].equalsIgnoreCase("add")) {
                        if (args.length > 1) {
                            if (args.length > 2) {
                                if (args[2].equalsIgnoreCase("regular")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add regular");
                                    sender.sendMessage("§aRank §7Regular §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("pro")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add pro");
                                    sender.sendMessage("§aRank §a§lPRO §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("vibe")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add vibe");
                                    sender.sendMessage("§aRank §9§lVIBE §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("hipster")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add hipster");
                                    sender.sendMessage("§aRank §d§lHIPSTER §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("builder")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add builder");
                                    sender.sendMessage("§aRank §9§lBUILDER §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("mod")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add mod");
                                    sender.sendMessage("§aRank §c§lMOD §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("seniormod")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add seniormod");
                                    sender.sendMessage("§aRank §c§lSENIORMOD §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("admin")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add admin");
                                    sender.sendMessage("§aRank §c§lADMIN §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("manager")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add owner");
                                    sender.sendMessage("§aRank §e§lMANAGER §awas applied to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("owner")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group add owner");
                                    sender.sendMessage("§aRank §e§lOWNER §awas applied to the player!");
                                    return true;
                                }


                                sender.sendMessage("§cInvalid rank!");
                                return true;
                            }

                            sender.sendMessage("§cYou must provide a rank to add!");
                            return true;
                        }

                        sender.sendMessage("§cYou must provide a player name!");
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("remove")) {
                        if (args.length > 1) {
                            if (args.length > 2) {
                                if (args[2].equalsIgnoreCase("regular")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove regular");
                                    sender.sendMessage("§aRank §7Regular §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("pro")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove pro");
                                    sender.sendMessage("§aRank §a§lPRO §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("vibe")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove vibe");
                                    sender.sendMessage("§aRank §9§lVIBE §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("hipster")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove hipster");
                                    sender.sendMessage("§aRank §d§lHIPSTER §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("builder")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove builder");
                                    sender.sendMessage("§aRank §9§lBUILDER §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("mod")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove mod");
                                    sender.sendMessage("§aRank §c§lMOD §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("seniormod")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove seniormod");
                                    sender.sendMessage("§aRank §c§lSENIORMOD §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("admin")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove admin");
                                    sender.sendMessage("§aRank §c§lADMIN §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("manager")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove owner");
                                    sender.sendMessage("§aRank §e§lMANAGER §awas removed to the player!");
                                    return true;
                                }

                                if (args[2].equalsIgnoreCase("owner")) {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + args[1] + " group remove owner");
                                    sender.sendMessage("§aRank §e§lOWNER §awas removed to the player!");
                                    return true;
                                }

                                sender.sendMessage("§cInvalid rank!");
                                return true;
                            }

                            sender.sendMessage("§cYou must provide a rank to add!");
                            return true;
                        }

                        sender.sendMessage("§cYou must provide a player name!");
                        return true;
                    }

                    sendCenteredMessage(player, "§e&lUser & Rank Commands");
                    player.sendMessage("§7/user list §eList all current in game ranks");
                    player.sendMessage("§7/user add <user> <rank> §eAdds a rank to a player");
                    player.sendMessage("§7/user remove <user> <rank> §eRemove a rank from a player");
                    return true;
                }
            }

            return false;
        } else {
            player.sendMessage("§cNo permission!");
            return true;
        }
    }

    private final static int CENTER_PX = 154;

    public static void sendCenteredMessage(Player player, String message) {
        if (message == null || message.equals("")) player.sendMessage("");
        message = ChatColor.translateAlternateColorCodes('&', message);

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for(char c : message.toCharArray()) {
            if (c == '§'){
                previousCode = true;
                continue;
            } else if(previousCode == true) {
                previousCode = false;
                if(c == 'l' || c == 'L') {
                    isBold = true;
                    continue;
                } else isBold = false;
            } else {
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while (compensated < toCompensate){
            sb.append(" ");
            compensated += spaceLength;
        }
        player.sendMessage(sb.toString() + message);
    }
}
