// 21 - is-a relationship
// 22 - Implement Interface
public class Planet extends Star implements Utilities {
    // 9 - Class Design (The "Big 3")
    private String type;
    // 3 - primitive data types: double, int, boolean
    private double rotationCycle;
    private double mass;
    private int moons;
    private boolean canSupportLife;

    public Planet() {
        super("Earth", 7874965825L);
        type = "terrestrial";
        rotationCycle = 1;
        mass = 1;
        moons = 1;
        canSupportLife = true;
    }

    public Planet(String name, String type, int inhabitants, double rotationCycle, double mass, int moons, boolean canSupportLife) {
        super(name, inhabitants);
        this.type = type;
        this.mass = mass;
        this.rotationCycle = rotationCycle;
        this.moons = moons;
        this.canSupportLife = canSupportLife;
    }

    // 9 - Class Design (The "Dynamic Duo")
    // 10a - accessor method
    public String getName() {
        return super.getName();
    }

    // 10a - accessor method
    public String getType() {
        return type;
    }

    // 10b - mutator method
    public void setMoons(int moons) {
        this.moons = moons;
    }

    // 10a - accessor method
    public boolean getCanSupportLife() {
        return canSupportLife;
    }

    // 10b - mutator method
    public void setCanSupportLife(boolean canSupportLife) {
        this.canSupportLife = canSupportLife;
    }

    // 10a - accessor method
    public double getMass() {
        return mass * 5.972 * Math.pow(10, 24);
    }

    // 9 - Class Design (The "Big Brain")
//    public double getMassInKG() {
//        // 6 - call to Math.pow()
//        return super.getMassInKG();
//    }
//
    public double getSolarMass() {
        // 6 - call to Math.pow()
        return getMass() / (1.989 * Math.pow(10, 30));
    }


//    public double getSolarMass() {
//        // 6 - call to Math.pow()
//        return super.getSolarMass();
//    }

    public void spaceshipLanding() {
        super.setInhabitants(30);
    }


    public String toString() {
        return "Planet name: " + getName() + '\n' +
                "Inhabitants: " + getInhabitants() + '\n' +
                "Planet Type: " + type + '\n' +
                "Rotation Cycle: " + rotationCycle + " day(s)\n" +
                "Mass: " + mass + " Earth(s), " + getMass() + " kg\n" +
                "Moons: " + moons + "\n" +
                "canSupportLife: " + canSupportLife;
    }


}
