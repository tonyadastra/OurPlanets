public class Planet {
    // 9 - Class Design (The "Big 3")
    private String name;
    private String type;
    // 3 - primitive data types: double, int, boolean
    private double rotationCycle;
    private double mass;
//    private double revolutionCycle;
    private int moons;
    private boolean canSupportLife;

    public Planet() {
        name = "Earth";
        type = "terrestrial";
        rotationCycle = 1;
        mass = 1;
//        revolutionCycle = 365.25;
        moons = 1;
        canSupportLife = true;
    }

    public Planet(String name, String type, double rotationCycle, double mass, int moons, boolean canSupportLife) {
        this.name = name;
        this.type = type;
        this.rotationCycle = rotationCycle;
        this.mass = mass;
//        this.revolutionCycle = revolutionCycle;
        this.moons = moons;
        this.canSupportLife = canSupportLife;
    }

    // 9 - Class Design (The "Dynamic Duo")
    // 10a - accessor method
    public String getName() {
        return name;
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
        return mass;
    }

    // 9 - Class Design (The "Big Brain")
    public double getMassInKG() {
        // 6 - call to Math.pow()
        return this.mass * 5.972 * Math.pow(10, 24);
    }

    public double getSolarMass() {
        // 6 - call to Math.pow()
        return getMassInKG() / (1.989 * Math.pow(10, 30));
    }

    public String toString() {
        return "Planet name: " + name + '\n' +
                "Planet Type: " + type + '\n' +
                "Rotation Cycle: " + rotationCycle + " day(s)\n" +
//                ", Revolution Cycle: " + revolutionCycle +
                "Mass: " + mass + " Earth(s), " + getSolarMass() + " Sun(s), or " + getMassInKG() + " kg\n" +
                "Moons: " + moons + "\n" +
                "canSupportLife: " + canSupportLife;
    }


}
