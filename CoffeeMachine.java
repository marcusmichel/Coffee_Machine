package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        
        // Creates an enumerator variable that will be modified by the buy action, depending on which drink is chosen
        Buy purchase = Buy.ESPRESSO;
        
        // Initial resources
        int money = 550;
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int dispCups = 9;

        // Creates an array to store all these resource values
        int[] resources = new int[5];
        resources[0] = water;
        resources[1] = milk;
        resources[2] = coffee;
        resources[3] = money;
        resources[4] = dispCups;

        // Takes user input
        Scanner scanner = new Scanner(System.in);

        String input;
        
        // Turns the machine on--will only turn off once the user choses to exit
        boolean machineOn = true;

        // The initial state of the machine is on the menu, and will be changed with different "button" presses
        State currentState = State.MENU;

        // Main loop
        while (machineOn) {
            // Checks which state the machine is in, decides what action corresponds to user input
            switch (currentState) {
                // Main menu for the machine, changes the state to whichever button is pressed
                case MENU:
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    input = scanner.next();
                    switch (input) {
                        case "buy":
                            currentState = State.BUY;
                            break;
                        case "fill":
                            currentState = State.FILL;
                            break;
                        case "take":
                            currentState = State.TAKE;
                            break;
                        case "remaining":
                            currentState = State.REMAINING;
                            break;
                        case "exit":
                            currentState = State.EXIT;
                            break;
                        default:
                            System.out.println("Not Valid");
                            break;
                    }
                    break;

                // Buy state allows you to attempt to buy a drink, and takes you back to the main menu regardless of whether you're able to successfully buy one
                case BUY:
                    System.out.println("What do you want to buy? " +
                            "1 - espresso, 2 - latte, 3 - cappuccino, " +
                            "back - to main menu: ");
                    input = scanner.next();
                    switch (input) {
                        case "back":
                            currentState = State.MENU;
                            break;
                        case "1":
                            purchase = Buy.ESPRESSO;
                            break;
                        case "2":
                            purchase = Buy.LATTE;
                            break;
                        case "3":
                            purchase = Buy.CAPPUCCINO;
                            break;
                    }
                    // Checks to make sure the command was not to go back to the main menu
                    if (currentState != State.MENU) {
                        resources = buyDrink(purchase, resources);
                    }
                    currentState = State.MENU;
                    break;
                    
                // Allows a user to add resources to the machine
                case FILL:
                    System.out.println("Write how many ml of water do you want to add:");
                    resources[0] += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    resources[1] += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    resources[2] += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    resources[4] += scanner.nextInt();
                    currentState = State.MENU;
                    break;

                // User can take all of the money out of the machine
                case TAKE:
                    System.out.println("I gave you $" + resources[3]);
                    resources[3] = 0;
                    currentState = State.MENU;
                    break;

                // Displays what resources are in the machine
                case REMAINING:
                    display(resources);
                    currentState = State.MENU;
                    break;
                    
                // Turns off the machine, ends program    
                case EXIT:
                    machineOn = false;
                    break;
                default:
                    break;
            }
        }

    }

    // Displays what resources are in the machine
    private static void display(int[] resources) {
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(resources[0] + " of water");
        System.out.println(resources[1] + " of milk");
        System.out.println(resources[2] + " of coffee beans");
        System.out.println(resources[4] + " of disposable cups");
        System.out.println("$" + resources[3] + " of money");
        System.out.println();
    }
    
    // Buys a drink, or gives an error message identifying the first undersupplied resource
    public static int[] buyDrink(Buy purchase, int[] resources) {
        String enough = "I have enough resources, making you a coffee!";
        String needWater = "Sorry, not enough water!";
        String needMilk = "Sorry, not enough milk!";
        String needCoffee = "Sorry, not enough coffee!";
        String needMoney = "Sorry, not enough money!";
        String needCups = "Sorry, not enough cups!";

        int[] output = new int[5];
        int[] reqResource = new int[5];
        reqResource[0] = purchase.water;
        reqResource[1] = purchase.milk;
        reqResource[2] = purchase.coffee;
        reqResource[3] = purchase.money;
        reqResource[4] = purchase.cups;


        if (resources[4] == 0) {
            System.out.println(needCups);
        } else if (purchase.water > resources[0]) {
            System.out.println(needWater);
        } else if (purchase.milk > resources[1]) {
            System.out.println(needMilk);
        } else if (purchase.coffee > resources[2]) {
            System.out.println(needCoffee);
        } else if (purchase.money > resources[3]) {
            System.out.println(needMoney);
        } else {
            System.out.println(enough);
            for (int i = 0; i < 5; i++) {
                resources[i] -= reqResource[i];
            }
        }
        System.out.println();
        return resources;
    }
}
