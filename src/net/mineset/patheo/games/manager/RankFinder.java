package net.mineset.patheo.games.manager;

import org.bukkit.entity.Player;

public class RankFinder {
    protected static InternalServerRank RankList[] = {
            new InternalServerRank("Owner", "RANK_OWNER", "§e", "§e§lOWNER§7 ", "§f", 900),
            new InternalServerRank("Manager", "RANK_MANAGER", "§e", "§e§lMANAGER§7 ", "§f", 800),
            new InternalServerRank("Admin", "RANK_ADMIN", "§c", "§c§lADMIN§7 ", "§f", 800),
            new InternalServerRank("SeniorMod", "RANK_SRMOD", "§c", "§c§lSRMOD§7 ", "§f", 700),
            new InternalServerRank("Mod", "RANK_MOD", "§c", "§c§lMOD§7 ", "§f", 600),
            new InternalServerRank("Builder", "RANK_BUILDER", "§9", "§9§lBUILDER§7 ", "§f", 500),
            new InternalServerRank("Hipster", "RANK_HIPSTER", "§d", "§d§lHIPSTER§7 ", "§f", 75),
            new InternalServerRank("Vibe", "RANK_VIBE", "§9", "§9§lVIBE§7 ", "§f", 50),
            new InternalServerRank("Pro", "RANK_PRO", "§a", "§a§lPRO§7 ", "§f", 25),
            new InternalServerRank("Regular", "RANK_REGULAR", "§7", "§7", "§f")
    };

    public static InternalServerRank GetRank(Player player) {
        InternalServerRank highestRank = new InternalServerRank();

        for (InternalServerRank rank : RankList) {
            if (rank.Weight > highestRank.Weight && (rank.Permission == "RANK_REGULAR" || player.hasPermission(rank.Permission))) {
                highestRank = rank;
            }
        }

        return highestRank;
    }
}
