package cl.alonso.sovereignsupremacy.utils;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.sovereignsupremacy.core.Army;

public class battleUtils {

    public static void biAttack(Army army1, Army army2) {
        int attack1 = ThreadLocalRandom.current().nextInt(army1.minDamage(), army1.damage() + 1);
        int attack2 = ThreadLocalRandom.current().nextInt(army2.minDamage(), army2.damage() + 1);

        army1.setCurrentSoldiers(army1.getCurrentSoldiers() - attack2);
        army2.setCurrentSoldiers(army2.getCurrentSoldiers() - attack1);

        System.out.println(army1.getName() + " Ataca a " + army2.getName() + " Causando " + attack1 + " bajas! ");
        System.out.println(army2.getName() + " Ataca a " + army1.getName() + " Causando " + attack2 + " bajas! ");

        army1.printState();
        army2.printState();

        for (int i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println();

        if (army1.getCurrentSoldiers() == 0 || army2.getCurrentSoldiers() == 0) { System.exit(0); }

    }

}
