import java.util.*;
import java.util.concurrent.TimeUnit;

// 11 - Class Composition - Driver
public class OurPlanetsDriver {
    public static void main(String[] args) {
        // 17 - Scanner User Input
        Scanner input = new Scanner(System.in);

        // create object
        OurPlanets universe = new OurPlanets();

        System.out.println("Welcome to OurPlanets!");
        System.out.println("You will be given three explorations. In each exploration, you can try out different modes. To select a mode, type the integer before the mode and then hit [Enter].\n");
        // Set Timeout - provide the user some time to look at my response
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }

        int count = 0;
        while (count < 3) {
            System.out.println("Exploration #" + (count + 1));
            System.out.println("1: Explore the universe\n2: Find Planets of a certain type\n3: Find planets that support life\n4: Create your own exoplanets\n5: Find the planets of the largest and smallest mass in OurUniverse\n6: Experience a Rare Space Event\n7: Visit an Exoplanet\n8: Why Pick one myself? You pick one for me!");
            int modeSelected = input.nextInt();
            System.out.println("You selected option " + modeSelected + "\n");
            // 2 - "if-then-else" statement with "throw" error
            if (modeSelected > 8 || modeSelected < 1){
                // throw IllegalArgumentException
                throw new IllegalArgumentException("Please enter a valid number.");
            }
            else {
                if (modeSelected == 8) {
                    // 6 - call to Math.random(); 8 - use of casting
                    int randomMode = (int) (Math.random() * 6 + 1);
                    System.out.println("We helped you select mode " + randomMode + "\n");
                    modeSelected = randomMode;
                }
                if (modeSelected == 1) {
                    System.out.println(universe);
                }
                if (modeSelected == 2) {
                    System.out.print("Type in the planet type that you would like to search for: ");
                    String typeInput = input.next(); // Not using nextLine because of the first-three-letter filter
                    // 7 - String method (substring)  (As you can see, I'm trying really hard to use the substring method :) )
                    // Fix user's small typos by selected first three letters and use a switch to match corresponding type
                    String typeFirstThreeChars = typeInput.substring(0, 3);

                    // Enhanced switch - learned from my IDE's recommendation
                    String type = switch (typeFirstThreeChars) {
                        case "Ter" -> "Terrestrial";
                        case "Gas" -> "Gas Giant";
                        case "Ice" -> "Ice Giant";
                        default -> typeInput;
                    };

                    // 20 - interactions
                    System.out.println(universe.findPlanets(type));
                }
                if (modeSelected == 3) {
                    // 20 - interactions
                    System.out.println(universe.findPlanets(true));
                }
                if (modeSelected == 4) {
                    System.out.println("How many exoplanets would you like to add?");
                    int inputAddCount = input.nextInt();
                    int addCount = 0;
                    ArrayList<Planet> customPlanets = new ArrayList<Planet>();
                    while (addCount < inputAddCount) {
                        input.nextLine();
                        System.out.println("What would you like to call your custom planet? ");
                        String customPlanetName = input.nextLine();
                        System.out.println("What type is this planet? ");
                        String customPlanetType = input.nextLine();
                        System.out.println("How many inhabitants are on this planet? ");
                        int customPlanetInhabitants = input.nextInt();
                        System.out.println("How long is a day on your custom planet (in days)? ");
                        double customPlanetRotationCycle = input.nextDouble();
                        System.out.println("How many times is its mass compared to Earth? ");
                        double customPlanetMass = input.nextDouble();
                        System.out.println("How many moons does it have? ");
                        int customPlanetMoons = input.nextInt();
                        System.out.println("Can this planet support life? (Enter true or false)");
                        boolean customPlanetCanSupportLife = input.nextBoolean();

                        Planet newPlanet = new Planet(customPlanetName, customPlanetType, customPlanetInhabitants, customPlanetRotationCycle, customPlanetMass, customPlanetMoons, customPlanetCanSupportLife);
                        customPlanets.add(newPlanet);
                        System.out.println("New planet created successfully!");
                        System.out.println("This is your new planet: \n" + newPlanet + "\n");
                        addCount++;
                    }
                    // 20 - interactions
                    universe.addCustomPlanets(customPlanets);
                }
                if (modeSelected == 5) {
                    // 20 - interactions
                    System.out.println(universe.findMinMaxMass());
                }
                if (modeSelected == 6) {
                    System.out.println("A SuperNova is coming!");
                    // 6 - call to Math.random(); 8 - use of casting
                    int SuperNovaSolarMass = (int) (Math.random() * 60);
                    System.out.println("We detected that the mass of the SuperNova is approximately " + SuperNovaSolarMass + " Sun(s)");
                    System.out.println("Type 1 to stay on Earth, 2 to escape to an exoplanet(you can escape to a planet you created!), 3 to counter the SuperNova");
                    int userInput = input.nextInt();

                    // 20 - interactions
                    String superNovaOutput = universe.SuperNova(SuperNovaSolarMass, userInput);
                    System.out.println(superNovaOutput);

                }
                if (modeSelected == 7) {
                    System.out.println("Here are all the exoplanets, type in the number that you would like to visit");
                    // 20 - interactions
                    for (int i = 0; i < universe.getExoplanets().size(); i++) {
                        System.out.println(i + ": " + universe.getExoplanets().get(i).getName());
                    }
                    Planet selectedPlanet = universe.getExoplanets().get(input.nextInt());
                    if (selectedPlanet.getCanSupportLife()) {
                        selectedPlanet.spaceshipLanding();
                        System.out.println("Woo-hoo! You landed on this exoplanet. You are this planet's " + selectedPlanet.getInhabitants() + " resident.");
                    }
                    else {
                        System.out.println("Since this planet cannot support life, you cannot safely land on this planet.");
                        System.out.println("Here are the details about this planet: ");
                        System.out.println(selectedPlanet);
                    }
                    System.out.println();

                }

                // Set Timeout - provide the user some time to look at my response
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }

                count++;
            }

        }

        System.out.println("Thank you for your interest in OurPlanets!");

        System.out.println("Enter 1 to view Developer's Profile; type any other number to quit.");
        String endProgramInput = input.next();
        if (endProgramInput.equals("1"))
            System.out.println("\n\n\nDeveloper: @tonyliunyc\nGitHub Repository for this project: https://github.com/tonyliunyc/OurPlanets\nProfile: Web Developer: Python, HTML, CSS, Javascript, D3JS, Flask, PostgreSQL; High school junior at Burlingame High School\nOur website: Global COVID-19 Vaccine Frontline: https://www.panelixir.com");

    }

}
