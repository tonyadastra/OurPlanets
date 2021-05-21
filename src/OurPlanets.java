import java.util.ArrayList;

public class OurPlanets {
    private Planet[] SolarSystem = new Planet[8];
    private ArrayList<Planet> Exoplanets = new ArrayList<Planet>();

    public OurPlanets() {
        SolarSystem[0] = new Planet("Mercury", "Terrestrial", 0, 59, 0.0553, 0, false);
        SolarSystem[1] = new Planet("Venus", "Terrestrial", 0, 243, 0.815, 0, false);
        SolarSystem[2] = new Planet();
        SolarSystem[3] = new Planet("Mars", "Terrestrial", 0, 1.025, 0.107, 2, true);
        SolarSystem[4] = new Planet("Jupiter", "Gas Giant", 0, 0.408, 317.8, 79, false);
        SolarSystem[5] = new Planet("Saturn", "Gas Giant", 0, 0.446, 95.2, 82, false);
        SolarSystem[6] = new Planet("Uranus", "Ice Giant", 0, 0.708, 14.5, 27, false);
        SolarSystem[7] = new Planet("Neptune", "Ice Giant", 0, 0.667, 17.1, 14, false);

        Exoplanets.add(new Planet("Proxima Centauri b", "Terrestrial", 0, 1, 3.0, 0, false));
        Exoplanets.add(new Planet("Proxima Centauri c", "Terrestrial", 0, 1.2, 7, 0, false));
    }

    // 10d - 3 other methods #1
    public void addCustomPlanets(ArrayList<Planet> customPlanets){
        Exoplanets.addAll(customPlanets);
    }

    // 10c - A pair of overloaded methods: findPlanets(String type) and findPlanets(boolean canSupportLife)
    public String findPlanets(String type) {
        int i = 0;
        String output = "";
        String planetOutput = "";
        // 4 - do-while loop
        do {
            if (SolarSystem[i].getType().equalsIgnoreCase(type)) {
                planetOutput += SolarSystem[i] + "\n";
            }
            i++;
        } while (i < SolarSystem.length);

        // 4 - for loop
        for (int j = 0; j < Exoplanets.size(); j++) {
            if (Exoplanets.get(j).getType().equalsIgnoreCase(type)) {
                planetOutput += Exoplanets.get(j) + "\n";
            }
        }

        // 7 - String method (isEmpty)
        if (planetOutput.isEmpty()) {
            output = "Unfortunately, we did not find any planets of type '" + type + "'.";
        }
        else {
            output = "Here are the planets we found! \n" + planetOutput;
        }
        return output;
    }

    // 23 - Polymorphism
    public String findPlanets(boolean canSupportLife) {
        int i = 0;
        String output = "";
        String planetOutput = "";
        // 4 - while loop
        while (i < SolarSystem.length) {
            if (SolarSystem[i].getCanSupportLife() == canSupportLife) {
                planetOutput += SolarSystem[i] + "\n\n";
            }
            i++;
        }

        // 4 - for loop
        // 13 - traverse ArrayList of Exoplanets
        for (int j = 0; j < Exoplanets.size(); j++) {
            if (Exoplanets.get(j).getCanSupportLife() == canSupportLife) {
                planetOutput += Exoplanets.get(j) + "\n\n";
            }
        }

        if (planetOutput.isEmpty()) {
            output = "Unfortunately, we did not find any planets of canSupportLife '" + canSupportLife + "'.";
        }
        else {
            output = "Here are the planets we found! \n" + planetOutput;
        }
        return output;
    }

    // 10d - 3 other methods #2
    public String findMinMaxMass() {
        double minValue = SolarSystem[0].getMass(),  maxValue = SolarSystem[0].getMass();
        Planet minPlanet, maxPlanet;

        // Find values and corresponding Planet for Min/Max in SolarSystem + Exoplanets
        // 24 - Insertion Sort
        for (int i = 1; i < SolarSystem.length; i++) {
            Planet keyPlanet = SolarSystem[i];
            int j = i - 1;

            while (j >= 0 && SolarSystem[j].getMass() > keyPlanet.getMass()) {
                SolarSystem[j + 1]= SolarSystem[j];
                j--;
            }
            SolarSystem[j + 1] = keyPlanet;
        }

        for (int i = 1; i < Exoplanets.size(); i++) {
            Planet keyPlanet = Exoplanets.get(i);
            int j = i - 1;

            while (j >= 0 && Exoplanets.get(j).getMass() > keyPlanet.getMass()) {
                Exoplanets.set(j + 1, Exoplanets.get(j));
                j--;
            }
            Exoplanets.set(j + 1, keyPlanet);
        }

        if (Exoplanets.get(0).getMass() < SolarSystem[0].getMass()) {
            minPlanet = Exoplanets.get(0);
        }
        else {
            minPlanet = SolarSystem[0];
        }

        if (Exoplanets.get(Exoplanets.size() - 1).getMass() > SolarSystem[SolarSystem.length - 1].getMass()) {
            maxPlanet = Exoplanets.get(Exoplanets.size() - 1);
        }
        else {
            maxPlanet = SolarSystem[SolarSystem.length - 1];
        }

//        for (Planet planet : SolarSystem) {
//            for (Planet exoplanet : Exoplanets) {
//                if (minValue > planet.getMass() && planet.getMass() < exoplanet.getMass()) {
//                    minValue = planet.getMass();
//                    minPlanet = planet;
//                } else if (minValue > exoplanet.getMass() && planet.getMass() > exoplanet.getMass()) {
//                    minValue = exoplanet.getMass();
//                    minPlanet = exoplanet;
//                } else if (maxValue < planet.getMass() && planet.getMass() > exoplanet.getMass()) {
//                    maxValue = planet.getMass();
//                    maxPlanet = planet;
//                } else if (maxValue < exoplanet.getMass() && exoplanet.getMass() < planet.getMass()) {
//                    maxValue = exoplanet.getMass();
//                    maxPlanet = exoplanet;
//                }
//            }
//        }

        String output = "Planet of the smallest mass in OurPlanets: " + minPlanet.getName() + ", mass: " + minPlanet.getMass() + " Earth(s)\n";
        output += "Planet of the largest mass in OurPlanets: " + maxPlanet.getName() + ", mass: " + maxPlanet.getMass() + " Earth(s)";

        return output;
    }

    // 10d - 3 other methods #3
    public String SuperNova(int SuperNovaSolarMass, int userOption) {
        int planetsDamaged = 0;
        boolean solarSystemDamaged = false;
        boolean exoplanetsDamaged = false;

        String output = "";

        // 5 - switch statement
        switch (userOption) {
            case 3:
                // 6 - call to Math.random(); 8 - use of casting
                int counterPower = (int) ((Math.random() + 0.4) * SuperNovaSolarMass);
                // 2 - if-then-else
                if (counterPower >= SuperNovaSolarMass) {
                    output += "Woo-hoo! Your counter power successfully defeated the SuperNova!";
                    break;
                }
                else {
                    output += "Oh no! Counter power has failed to defeat the SuperNova.\n";
                    userOption = 1;
                }

            case 1:
            case 2:
                switch (SuperNovaSolarMass / 10) {
                    case 0:
                        output += "The mass of the SuperNova is too small to cause any damage :)";
                        planetsDamaged = 0;
                        break;
                    case 1:
                    case 2:
                        for (Planet planet : SolarSystem) {
                            // 7 - String method (contains)
                            if (!planet.getType().contains("Giant") || planet.getSolarMass() * Math.pow(10, 7) < SuperNovaSolarMass) {
                                planet.setCanSupportLife(false);
                                planet.setMoons(0);
                                planetsDamaged++;
                            }
                        }

                        solarSystemDamaged = true;
                        exoplanetsDamaged = false;
                        break;
                    case 3:
                    case 4:
                        for (int i = 0; i < Exoplanets.size(); i++) {
                            if (Exoplanets.get(i).getSolarMass() * Math.pow(10, 7) < SuperNovaSolarMass) {
                                Exoplanets.remove(i);
                                i--;
                            }
                        }
                        solarSystemDamaged = false;
                        exoplanetsDamaged = true;
                        break;
                    case 5:
                        // Mass too large --> swallowed into a black hole, no planets damaged
                        output += "This is your lucky day! The mass of the SuperNova is too large, hence swallowed into a black hole. No planets are damaged!\n";
                        planetsDamaged = 0;
                        break;
                    default:
                        planetsDamaged = 0;
                        solarSystemDamaged = false;
                        exoplanetsDamaged = false;

                }
                if (!solarSystemDamaged && !exoplanetsDamaged) {
                    if (userOption == 1)
                        output += "Good call! The SuperNova damage any systems. You survived the SuperNova.";
                    else
                        output += "Escaping to an exoplanet isn't a bad choice! However, the SuperNova did not damage the SolarSystem. You survived the SuperNova.";
                } else if (solarSystemDamaged){
                    if (userOption == 1)
                        output += "Oh no! The Solar System is damaged! You did not survive the SuperNova.";
                    else
                        output += "Nice! The SuperNova damaged the Solar System, and you survived. Now, you need to build a new life on a new planet...";
                } else {
                    if (userOption == 1)
                        output += "Great decision! The SuperNova did not hit the Solar System. You survived the SuperNova.";
                    else {
                        output += "Oops! The Solar System remains intact, but the SuperNova hit Exoplanets. You did not survive the SuperNova.";
                        planetsDamaged++;
                    }
                }
                output += "\nThis SuperNova damaged a total of " + planetsDamaged + " planets. ";
        }
        return output;

    }

    public ArrayList<Planet> getExoplanets() {
        return Exoplanets;
    }

    public String toString() {
        String output = "This is our universe:\nThe Solar System:\n";
        // 13 - traverse array of planets in SolarSystem
        for (Planet planet: SolarSystem)
            output += planet + "\n\n";

        output += "\nExoplanets:\n";
        // 13 - traverse ArrayList of Exoplanets
        for (Planet planet: Exoplanets)
            output += planet + "\n\n";

        return output;
    }

}
