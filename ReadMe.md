## OurPlanets
> Object containing Solar System planets and two exoplanets, with methods for users to try out

### Synopsis
+ Difficulty Level: moderately difficult
  - This object includes several methods that require traversing through an array and an ArrayList at the same time, to find the minimum and maximum value. The SuperNova method also includes some complicated calculations and choices that synthesizes the knowledge of several topics together.
+ Fun Level: very fun
  - For those who are interested in astronomy and science fiction, it should be very fun. There are lots of interactions with the user, including different prompts for them to enter a number for different choices when a SuperNova is approaching. The user also has the option to create their own planets.
+ Self-Evaluation: interactive, user-friendly, and intriguing
  - This program includes several interactive features for the user to explore. The user will always have an option to choose from until the exploration ends. When the user enters a choice, the program would also return their choice, letting the user know what they have picked. For science fiction fans, this product should be very intriguing, including data for many different planets in the universe.
+ What I learned: Timeout function, enhanced switch, passing one case in a switch to another, ArrayList addAll method, astronomical knowledge
  - I learned the timeout function so that when there’s a long response from the program, the user would have several seconds to read the program before the next loop begins. Also, I learned to use an enhanced switch to replace a switch statement to simplify the code. In the method SuperNova, the user has the option to counter the SuperNova(using a special force)  if they don’t know whether to stay on Earth or escape to an exoplanet. Therefore, if the “special force” failed to counter the SuperNova, I need to redirect this case to stay on Earth. Moreover, with the option for the user to create their own planets, I learned the addAll method for adding a new ArrayList to an existing one. Finally, through finding information about exoplanets’ data, I acquired new knowledge about celestial objects outside of the Solar System.
### Updates and Releases
+ v1.1 - Optimize Timeout, add useful comments, remove unnecessary methods
  + Released: January 17, 2021
+ v1.0 - Initial Release
    + Released: January 17, 2021
+ v0.2 - Create OurPlanetsDriver, Test Different User Inputs
    + Updated: January 15, 2021
+ v0.1 - Create Planet and OurPlanets object, add OurPlanets data
    + Updated: January 13, 2021
  
### Detailed Program Description
OurPlanets is an object with a zero-arg constructor that creates 8 planets in the Solar System of object Planet and 2 exoplanets, Proxima Centauri b and Proxima Centauri c. The Planet[] array SolarSystem stores 8 Planet objects(planets in the Solar System), and the ArrayList<Planet> Exoplanets stores 2 Planet objects(two exoplanets). The Planet object includes the name, type, rotationCycle, mass, moons, and canSupportLife of a planet, as well as several accessor, mutator, and processor methods to get, set, or calculate values of instance variables. OurPlanets includes a pair of overloaded methods to find planets of a certain type or planets that can support life, a method that finds planets that have the maximum and minimum mass in the both SolarSystem and Exoplanets, a method that allows users to add Planet objects to the Exoplanets ArrayList, a method SuperNova that is a rare space event and can possibly cause damage to planets based on its mass, a randomly generated number. The toString method of OurPlanets returns the data in the universe, printing the information of SolarSystem planets and Exoplanets(call toString of Planet objects). In OurPlanetsDriver, the program prompts the user to enter numbers to select game modes that correspond to different methods in OurPlanets, with an option for the user to let the program randomly generate a mode. The user will have three explorations, each having the same modes to choose from. After three explorations, a “thank you for your interest” note would appear and the user has the option to view the developer’s profile.


