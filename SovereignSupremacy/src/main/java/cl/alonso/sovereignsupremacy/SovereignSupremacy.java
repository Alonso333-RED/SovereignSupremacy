package cl.alonso.sovereignsupremacy;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.sovereignsupremacy.core.Country;
import cl.alonso.sovereignsupremacy.core.Sector;
import cl.alonso.sovereignsupremacy.core.Troop;
import cl.alonso.sovereignsupremacy.utils.battleUtils;
import cl.alonso.sovereignsupremacy.utils.worldUtils;

// Currently building the program, so this is just pure testing
public class SovereignSupremacy {
    public static void main( String[] args )
    {
        int xSize = ThreadLocalRandom.current().nextInt(1, 10+1);
        int ySize = ThreadLocalRandom.current().nextInt(1, 10+1);

        //xSize = 10;
        //ySize = 10;

        Sector[][] world = new Sector[xSize][ySize];
        worldUtils.setupWorld(world);

        System.out.println("Tamaño del mundo: "+xSize+","+ySize);

        int inRow = ThreadLocalRandom.current().nextInt(0, world.length);
        int inColumn = ThreadLocalRandom.current().nextInt(0, world[0].length);

        //inRow = 0;
        //inColumn = 0;

        System.out.println("Mapa del Mundo");
        System.out.println();

        Sector mySector = world[inRow][inColumn];

        for (Sector[] world1 : world) {
            for (Sector currentSector : world1) {
                if (currentSector == mySector) {
                    System.out.print("X" + "  |");
                } else if (currentSector == mySector.getNorth()) {
                    System.out.print("^" + "  |");
                } else if (currentSector == mySector.getEast()) {
                    System.out.print(">" + "  |");
                } else if (currentSector == mySector.getWest()) {
                    System.out.print("<" + "  |");
                } else if (currentSector == mySector.getSouth()) {
                    System.out.print("v" + "  |");
                } else {
                    System.out.print(currentSector.getID() + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Ubicación actual: " + mySector.getName() + " (" + mySector.getXLocation()+","+mySector.getYLocation()+")");
        System.out.println("Norte: " + mySector.getNorth().getName()+" ("+mySector.getNorth().getID()+")");
        System.out.println("Sur: " + mySector.getSouth().getName()+" ("+mySector.getSouth().getID()+")");
        System.out.println("Este: " + mySector.getEast().getName()+" ("+mySector.getEast().getID()+")");
        System.out.println("Oeste: " + mySector.getWest().getName()+" ("+mySector.getWest().getID()+")");
        System.out.println();
        mySector.printInfo();
        System.out.println();

        Country alpha = new Country("Alpha");
        Troop alpha0 = new Troop("AlphaZero", alpha, mySector, 1000, 0.1, 0.1);
        alpha0.printStats();

        Country beta = new Country("Beta");
        Troop beta0 = new Troop("BetaZero", beta, mySector, 1000, 0.1, 0.1);
        beta0.printStats();

        System.out.println(alpha0);
        //Sleep for 2.5 seconds
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
        System.out.println();

        int round = 1;

        System.out.println();
        mySector.printInfo();
        System.out.println();

        while (alpha0.getCurrentSoldiers() > 0 && beta0.getCurrentSoldiers() > 0) {
            System.out.println("Ronda " + round + ": ");
            battleUtils.troopFight(alpha0, beta0);
            round++;
        }
        System.out.println();
        mySector.printInfo();
        System.out.println();
    }
}
