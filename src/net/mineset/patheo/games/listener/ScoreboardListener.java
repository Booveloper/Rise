package net.mineset.patheo.games.listener;

import net.mineset.patheo.games.RiseCore;
import net.mineset.patheo.games.manager.InternalServerRank;
import net.mineset.patheo.games.manager.RankFinder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Iterator;

public class ScoreboardListener implements Listener {
    private RiseCore main;
    private int taskID = 7231633;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private HashMap<Player, Integer> task = new HashMap();
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private HashMap<Player, Scoreboard> scoreboard = new HashMap();

    @SuppressWarnings("rawtypes")
    public ScoreboardListener(RiseCore main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
        Iterator var3 = Bukkit.getOnlinePlayers().iterator();

        while(var3.hasNext()) {
            Player ps = (Player)var3.next();
            ps.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
            if (!this.task.containsKey(ps)) {
                this.scoreboard.put(ps, Bukkit.getServer().getScoreboardManager().getNewScoreboard());
                this.boardStart(ps);
            }
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {
        if (!this.task.containsKey(e.getPlayer())) {
            this.scoreboard.put(e.getPlayer(), Bukkit.getServer().getScoreboardManager().getNewScoreboard());
            this.boardStart(e.getPlayer());
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeave(PlayerQuitEvent e) {
        if (this.task.containsKey(e.getPlayer())) {
            this.scoreboard.remove(e.getPlayer());
            Bukkit.getScheduler().cancelTask((Integer)this.task.get(e.getPlayer()));
            this.task.remove(e.getPlayer());
            e.getPlayer().getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        }

    }

    @SuppressWarnings("deprecation")
    public void boardStats(Player p) {
        Scoreboard board = (Scoreboard)this.scoreboard.get(p);
        InternalServerRank playerRank = RankFinder.GetRank(p);
        Objective objectiveSidebar = board.getObjective("sidebar");
        if (objectiveSidebar == null) {
            if (p.getServer().getServerName().equalsIgnoreCase("HUB-1")) {
                objectiveSidebar = board.registerNewObjective("sidebar", "abc");
                objectiveSidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
                objectiveSidebar.setDisplayName("§f§lMINESET");
                objectiveSidebar.getScore("§r").setScore(9);
                objectiveSidebar.getScore("§7Rank: " + playerRank.Prefix).setScore(8);
                objectiveSidebar.getScore("§7Coins: §60").setScore(7);
                objectiveSidebar.getScore("§7Level: §d0").setScore(6);
                objectiveSidebar.getScore("§r§r").setScore(5);
                objectiveSidebar.getScore("§7Server: §3" + Bukkit.getServerName()).setScore(4);
                objectiveSidebar.getScore("§7Online: §9" + Bukkit.getOnlinePlayers().size()).setScore(3);
                objectiveSidebar.getScore("§r§r§r").setScore(2);
                objectiveSidebar.getScore("§e  play.mineset.net").setScore(1);
            }

            if (p.getServer().getServerName().equalsIgnoreCase("PRK-1")) {
                if (p.getServer().getServerName().equalsIgnoreCase("HUB-1")) {
                    objectiveSidebar = board.registerNewObjective("sidebar", "abc");
                    objectiveSidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
                    objectiveSidebar.setDisplayName("§f§lMINESET");
                    objectiveSidebar.getScore("§r").setScore(7);
                    objectiveSidebar.getScore("§7Rank: " + playerRank.Prefix).setScore(6);
                    objectiveSidebar.getScore("§r§r").setScore(5);
                    objectiveSidebar.getScore("§7Score: §30").setScore(4);
                    objectiveSidebar.getScore("§7Checkpoint: §cIsland").setScore(3);
                    objectiveSidebar.getScore("§r§r§r").setScore(2);
                    objectiveSidebar.getScore("§e  play.mineset.net").setScore(1);
                }
            }
        }

        Objective objectiveTablist = board.getObjective("tablist");
        if (objectiveTablist == null) {
            objectiveTablist = board.registerNewObjective("tablist", "def");
        }

        @SuppressWarnings("rawtypes")
        Iterator var7 = Bukkit.getOnlinePlayers().iterator();

        Player all;
        String prefix;
        String height;
        Team team;
        do {
            if (!var7.hasNext()) {
                return;
            }

            all = (Player)var7.next();
            prefix = null;
            height = null;
            if (all.hasPermission("RANK_OWNER")) {
                height = "0001";
                prefix = "§e§lOWNER §7";
            } else if (all.hasPermission("RANK_ADMIN")) {
                height = "0002";
                prefix = "§c§lADMIN §7";
            } else if (all.hasPermission("RANK_SRMOD")) {
                height = "0003";
                prefix = "§c§lSRMOD §7";
            } else if (all.hasPermission("RANK_MOD")) {
                height = "0004";
                prefix = "§c§lMOD §7";
            } else if (all.hasPermission("RANK_BUILDER")) {
                height = "0005";
                prefix = "§9§lBUILDER §7";
            } else if (all.hasPermission("RANK_HIPSTER")) {
                height = "0010";
                prefix = "§d§lHIPSTER §7";
            } else if (all.hasPermission("RANK_VIBE")) {
                height = "0020";
                prefix = "§9§lVIBE §7";
            } else if (all.hasPermission("RANK_PRO")) {
                height = "0030";
                prefix = "§a§lPRO §7";
            } else {
                height = "0100";
                prefix = "§7";
            }

            team = null;
            @SuppressWarnings("rawtypes")
            Iterator var12 = board.getTeams().iterator();

            while(var12.hasNext()) {
                Team team2 = (Team)var12.next();
                if (team2.getName().contains(all.getUniqueId().toString().replace("-", "").substring(0, 10))) {
                    team = team2;
                }
            }
        } while(team != null && team.getPrefix().equalsIgnoreCase(prefix));

        if (team != null) {
            team.unregister();
        }

        team = board.registerNewTeam(height + "-" + all.getUniqueId().toString().replace("-", "").substring(0, 10));
        team.setPrefix(prefix);
        team.addEntry(all.getName());
        team.addPlayer(all);
        all.setScoreboard((Scoreboard)this.scoreboard.get(all));
    }

    public void boardStart(final Player p) {
        this.taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this.main, new Runnable() {
            public void run() {
                if (p.isOnline()) {
                    ScoreboardListener.this.boardStats(p);
                } else {
                    p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
                    ScoreboardListener.this.scoreboard.remove(p);
                    Bukkit.getScheduler().cancelTask((Integer)ScoreboardListener.this.task.get(p));
                }

            }
        }, 0L, 20L);
        this.task.put(p, this.taskID);
    }
}
