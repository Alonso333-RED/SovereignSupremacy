package cl.alonso.sovereignsupremacy.core;

public class Sector {
    
    private String name;
    
    private int xLocation;
    private int yLocation;
    private Sector north;
    private Sector east;
    private Sector west;
    private Sector south;
    
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
}