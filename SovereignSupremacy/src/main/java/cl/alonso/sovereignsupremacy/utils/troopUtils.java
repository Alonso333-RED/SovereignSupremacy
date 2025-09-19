package cl.alonso.sovereignsupremacy.utils;

import cl.alonso.sovereignsupremacy.core.Troop;
import cl.alonso.sovereignsupremacy.core.Sector;

public class troopUtils {
    public static void spawnTroopInSector(Troop troop, Sector sector) {
        sector.receiveTroop(troop);
    }
}
