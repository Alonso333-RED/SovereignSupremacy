package cl.alonso.sovereignsupremacy.utils;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.sovereignsupremacy.core.Sector;

public class worldUtils {
    
    private static final String[] nameBank = {
        "Zyron", "Orion", "Nebulon", "Astra", "Vortex",
        "Quasar", "Lunaris", "Galaxia", "Cosmo", "Andromeda",
        "Polaris", "Altair", "Sirius", "Vega", "Rigel",
        "Proxima", "Titan", "Europa", "Callisto", "Ganymede",
        "Phobos", "Deimos", "Io", "Enceladus", "Mimas",
        "Hyperion", "Tethys", "Rhea", "Dione", "Ceres",
        "Sedna", "Makemake", "Haumea", "Eris", "Charon",
        "Aldebaran", "Betelgeuse", "Capella", "Deneb", "Fomalhaut",
        "Altairis", "Lyra", "Cygnus", "Andros", "Nebulus",
        "Xenon", "Zyphor", "Orialis", "Veltor", "Quorax",
        "Lumina", "Stellara", "Cosmion", "Astrolis", "Vortexus",
        "Nebulis", "Galacton", "Exon", "Polaria", "Cryon",
        "Aurelia", "Celestia", "Ecliptor", "Solaris", "Novae",
        "Pulsar", "Quintar", "Vantor", "Oberon", "Titanis",
        "Lunara", "Orbiton", "Astera", "Vireon", "Cosmica",
        "Zorion", "Neptara", "Jovian", "Mercuron", "Saturnis",
        "Uranix", "Plutaris", "Cometis", "Meteoron", "Galactis",
        "Orbis", "Stellaris", "Aether", "Zenith", "Aphelion",
        "Perseon", "Aurora", "Lyricon", "Celara", "Nexon",
        "Virelia", "Astrion", "Cosmara", "Solara", "Nebulix"
    };
    
    public static String getRandomName() {
        int position = ThreadLocalRandom.current().nextInt(0, nameBank.length);
        String selection = nameBank[position];
        return selection;
    }

    public static void setupWorld(Sector[][] world) {
        int number = 1;
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                world[row][col] = new Sector(getRandomName()+" "+number, row, col);
                number++;
            }
        }

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                Sector current = world[row][col];
                current.setNorth(world[(row - 1 + world.length) % world.length][col]);
                current.setSouth(world[(row + 1) % world.length][col]);
                current.setWest(world[row][(col - 1 + world[row].length) % world[row].length]);
                current.setEast(world[row][(col + 1) % world[row].length]);
            }
        }
    }
}
