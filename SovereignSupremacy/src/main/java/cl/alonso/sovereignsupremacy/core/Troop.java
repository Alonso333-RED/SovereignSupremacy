package cl.alonso.sovereignsupremacy.core;

import cl.alonso.sovereignsupremacy.utils.troopUtils;

public class Troop {
    private String name;
    private Country countryOrigin;
    private Sector currentSector;

    private final int MAX_SOLDIERS_POSSIBLE_VALUE = 1000000000;
    private int maxSoldiers;
    private int currentSoldiers;
    private double potential;
    private double discipline;

    public Troop(String name, Country countryOrigin, Sector currentSector, int maxSoldiers, double potential, double discipline) {
        this.name = name;
        this.countryOrigin = countryOrigin;
        this.currentSector = currentSector;
        if (maxSoldiers > MAX_SOLDIERS_POSSIBLE_VALUE) { maxSoldiers = MAX_SOLDIERS_POSSIBLE_VALUE; }
        this.maxSoldiers = maxSoldiers;
        this.currentSoldiers = maxSoldiers;
        this.potential = potential;
        this.discipline = discipline;

        troopUtils.spawnTroopInSector(this, currentSector);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Country getCountryOrigin() { return countryOrigin; }
    public void setCountryOrigin(Country countryOrigin) { this.countryOrigin = countryOrigin; }

    public Sector getCurrentSector() { return currentSector; }
    public void setCurrentSector(Sector currentSector) { this.currentSector = currentSector; }

    public int getMaxSoldiers() { return maxSoldiers; }
    public void setMaxSoldiers(int maxSoldiers) { this.maxSoldiers = maxSoldiers; }

    public int getCurrentSoldiers() { return currentSoldiers; }
    public void setCurrentSoldiers(int currentSoldiers) {
        if (currentSoldiers < 0) { currentSoldiers = 0; }
        else if (currentSoldiers > this.maxSoldiers) { currentSoldiers = this.maxSoldiers; }
        this.currentSoldiers = currentSoldiers;
    }

    public double getPotential() { return potential; }
    public void setPotential(double potential) { this.potential = potential; }

    public double getDiscipline() { return discipline; }
    public void setDiscipline(double discipline) { this.discipline = discipline; }

    private int ceilToInt(double value) {
        double rounded = Math.round(value * 1000.0) / 1000.0; 
        int result = (int) Math.ceil(rounded);
        return result > 0 ? result : 1;
    }

    public int maxDamage() {return ceilToInt(this.currentSoldiers * this.potential);}
    public int minDamage() {return ceilToInt(this.currentSoldiers * (this.potential * this.discipline));}

    public void printStats() {
        System.out.println("Informacion de la tropa:");
        System.out.println(" --- " + name + " --- ");
        System.out.println("Pais de Origen: " + countryOrigin.getName());
        System.out.println("Sector Actual: " + currentSector.getName());
        System.out.println("Soldados restantes: " + currentSoldiers + "/" + maxSoldiers);
        System.out.println("Potencial: " + potential);
        System.out.println("Disciplina: " + discipline);
        System.out.println("Daño maximo: " + maxDamage());
        System.out.println("Daño minimo: " + minDamage());
        System.out.println();
    }

    public void printState() {
        System.out.println("Estado de la tropa:");
        System.out.println(" --- " + name + " --- ");
        System.out.println("Pais de Origen: " + countryOrigin.getName());
        System.out.println("Soldados restantes: " + currentSoldiers);
        System.out.println("Daño maximo: " + maxDamage());
        System.out.println("Daño minimo: " + minDamage());
        System.out.println();
    }
}
