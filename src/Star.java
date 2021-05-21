// 22 - implement interface
public abstract class Star implements Utilities {
    private String name;
    private long inhabitants;
    private double rotationCycle;
    private double mass;

    public Star() {
        name = "The Sun";
        inhabitants = 0;
        rotationCycle = 25;
        mass = 1;
    }

    public Star(String name, long inhabitants) {
        this.name = name;
        this.inhabitants = inhabitants;
    }

    public Star(String name, long inhabitants, double mass) {
        this.name = name;
        this.inhabitants = inhabitants;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass * 1.989 * Math.pow(10, 30);
    }

//    public double getMassInKG() {
//        // 6 - call to Math.pow()
//        return mass * 5.972 * Math.pow(10, 24);
//    }

    public long getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(long inhabitants) {
        this.inhabitants = inhabitants;
    }

    public void addNewInhabitants(int newInhabitants) {
        this.inhabitants += newInhabitants;
    }

    public void spaceshipLanding() {
        this.inhabitants += 10;
    }

    public String toString() {
        return "Star name: " + getName() + '\n' +
                "Inhabitants: " + getInhabitants() + '\n' +
                "Rotation Cycle: " + rotationCycle + " day(s)\n" +
//                ", Revolution Cycle: " + revolutionCycle +
                "Mass: " + mass + " Sun(s), " + getMass() + " kg\n";
    }
}
