public class Planet {
    private String name;
    private String type;
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMoons() {
        return moons;
    }

    public void setMoons(int moons) {
        this.moons = moons;
    }


    public boolean getCanSupportLife() {
        return canSupportLife;
    }


    public void setCanSupportLife(boolean canSupportLife) {
        this.canSupportLife = canSupportLife;
    }

    public void newMoonDiscovered() {
        this.moons += 1;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getMassInKG() {
        return this.mass * 5.972 * Math.pow(10, 24);
    }

    public double getSolarMass() {
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
