package cl.alonso.sovereignsupremacy.utils;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.sovereignsupremacy.core.Troop;

public class battleUtils {

    public static void troopFight(Troop troop1, Troop troop2) {
        int attack1 = ThreadLocalRandom.current().nextInt(troop1.minDamage(), troop1.maxDamage() + 1);
        int attack2 = ThreadLocalRandom.current().nextInt(troop2.minDamage(), troop2.maxDamage() + 1);

        troop1.setCurrentSoldiers(troop1.getCurrentSoldiers() - attack2);
        troop2.setCurrentSoldiers(troop2.getCurrentSoldiers() - attack1);

        System.out.println(troop1.getName() + " Ataca a " + troop2.getName() + " Causando " + attack1 + " bajas! ");
        System.out.println(troop2.getName() + " Ataca a " + troop1.getName() + " Causando " + attack2 + " bajas! ");

        troop1.printState();
        troop2.printState();

        for (int i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println();

        if (troop1.getCurrentSoldiers() == 0 || troop2.getCurrentSoldiers() == 0) { System.exit(0); }

    }

}
