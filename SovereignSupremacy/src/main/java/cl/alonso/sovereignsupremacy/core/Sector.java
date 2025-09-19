package cl.alonso.sovereignsupremacy.core;

import java.util.HashSet;
import java.util.Set;
public class Sector {
    
    private String name;
    
    private int xLocation;
    private int yLocation;
    private Sector north;
    private Sector east;
    private Sector west;
    private Sector south;

    private Set<Troop> troopsInside = new HashSet<Troop>();
    
    public Sector(String name, int xLocation, int yLocation) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getID() { return xLocation+","+yLocation; }

    public int getXLocation() { return xLocation; }
    public void setXLocation(int xLocation) { this.xLocation = xLocation; }

    public int getYLocation() { return yLocation; }
    public void setYLocation(int yLocation) { this.yLocation = yLocation; }

    public Sector getNorth() { return north; }
    public void setNorth(Sector north) { this.north = north; }

    public Sector getEast() { return east; }
    public void setEast(Sector east) { this.east = east; }

    public Sector getWest() { return west; }
    public void setWest(Sector west) { this.west = west; }

    public Sector getSouth() { return south; }
    public void setSouth(Sector south) { this.south = south; }

    public Set<Troop> getTroopsInside() { return troopsInside; }
    public void receiveTroop(Troop troop) { this.troopsInside.add(troop); }
    public void removeTroop(Troop troop) { this.troopsInside.remove(troop); }

    public void printInfo() {
        System.out.println("Informacion del sector:");
        System.out.println(" --- " + name + " ---");
        System.out.println("Ubicación: (" + xLocation + "," + yLocation + ")");
        System.out.println("ID: " + getID());
        System.out.println("Norte: " + (north != null ? north.getName() + " (" + north.getID() + ")" : "N/A"));
        System.out.println("Sur: " + (south != null ? south.getName() + " (" + south.getID() + ")" : "N/A"));
        System.out.println("Este: " + (east != null ? east.getName() + " (" + east.getID() + ")" : "N/A"));
        System.out.println("Oeste: " + (west != null ? west.getName() + " (" + west.getID() + ")" : "N/A"));
        System.out.println("Tropas dentro del sector: " + troopsInside.size());
        for (Troop troop : troopsInside) {
            System.out.println(" - " + troop.getName() + " de " + troop.getCountryOrigin().getName() + " con " + troop.getCurrentSoldiers() + "/" + troop.getMaxSoldiers() + " soldados.");
        }
    }
}