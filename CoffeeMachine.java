package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Buy purchase = Buy.ESPRESSO;

        int money = 550;
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int dispCups = 9;


        int[] resources = new int[5];
        resources[0] = water;
        resources[1] = milk;
        resources[2] = coffee;
        resources[3] = money;
        resources[4] = dispCups;

        Scanner scanner = new Scanner(System.in);

        String input;
        boolean machineOn = true;

        State currentState = State.MENU;

        while (machineOn) {
            switch (currentState) {
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
                    if (currentState != State.MENU) {
                        resources = buyDrink(purchase, resources);
                    }
                    currentState = State.MENU;
                    break;
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

                case TAKE:
                    System.out.println("I gave you $" + resources[3]);
                    resources[3] = 0;
                    currentState = State.MENU;
                    break;

                case REMAINING:
                    display(resources);
                    currentState = State.MENU;
                    break;
                case EXIT:
                    machineOn = false;
                    break;
                default:
                    break;
            }
        }

        /* while (machineOn) {
            System.out.println("Write action (buy, fill, take, remaining, exit) :");
            input = scanner.next();
            switch(input) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    switch(scanner.next()) {
                        case "1":
                            if (water < 250) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            } else {
                                water -= 250;
                            }

                            if (coffee < 16) {
                                System.out.println("Sorry, not enough coffee!");
                                break;
                            } else {
                                coffee -= 16;
                            }

                            if (dispCups == 0) {
                                System.out.println("Sorry, not enough cups!");
                                break;
                            } else {
                                dispCups--;
                            }

                            System.out.println("I have enough resources, making you a coffee!");
                            money += 4;
                            break;

                        case "2":

                            if (water < 350) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            } else {
                                water -= 350;
                            }

                            if (milk < 75) {
                                System.out.println("Sorry, not enough milk!");
                                break;
                            } else {
                                milk -= 75;
                            }

                            if (coffee < 20) {
                                System.out.println("Sorry, not enough coffee!");
                                break;
                            } else {
                                coffee -= 20;
                            }

                            if (dispCups == 0) {
                                System.out.println("Sorry, not enough cups!");
                                break;
                            } else {
                                dispCups--;
                            }

                            System.out.println("I have enough resources, making you a coffee!");
                            money += 7;
                            break;

                        case "3":

                            if (water < 200) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            } else {
                                water -= 200;
                            }

                            if (milk < 100) {
                                System.out.println("Sorry, not enough milk!");
                                break;
                            } else {
                                milk -= 100;
                            }

                            if (coffee < 12) {
                                System.out.println("Sorry, not enough coffee!");
                                break;
                            } else {
                                coffee -= 12;
                            }

                            if (dispCups == 0) {
                                System.out.println("Sorry, not enough cups!");
                                break;
                            } else {
                                dispCups--;
                            }

                            System.out.println("I have enough resources, making you a coffee!");
                            money += 6;
                            break;

                        case "back":
                            continue;

                        default:
                            System.out.println("Something went wrong!");
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    water += scanner.nextInt();

                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();

                    System.out.println("Write how many ml of water do you want to add:");
                    coffee += scanner.nextInt();

                    System.out.println("Write how many ml of water do you want to add:");
                    dispCups += scanner.nextInt();
                    break;

                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;

                case "remaining":
                    display(resources);
                    break;

                case "exit":
                    machineOn = false;
                    break;
            } */
//            display(money, water, milk, coffee, dispCups);

        }




        /* System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int maxCups = 0;

        maxCups = water / 200;
        if (maxCups > milk / 50) {
            maxCups = milk / 50;
        } else if (maxCups > coffee / 15){
            maxCups = coffee / 15;
        }

        if (cups > maxCups) {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        } else if (cups == maxCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            int dif = maxCups - cups;
            System.out.println("Yes, I can make that amount of coffee (and even " + dif + " more than that)" );
        }*/





       /* int cups = scanner.nextInt();
        int water = 200 * cups;
        int milk = 50 * cups;
        int coffee = 15 * cups;

        System.out.println("For" + cups + " of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");




        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    } */
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
//    private static void display(int money, int water, int milk, int coffee, int dispCups) {
//        System.out.println("The coffee machine has: " + water + " of water");
//        System.out.println(water + " of water");
//        System.out.println(milk + " of milk");
//        System.out.println(coffee + " of coffee beans");
//        System.out.println(dispCups + " of disposable cups");
//        System.out.println("$" + money + " of money");
//    }

//    void expand(int[] buyOutput) {
//        water = buyOutput[0];
//        milk = buyOutput[1];
//        coffee = buyOutput[2];
//        money = buyOutput[3];
//        dispCups = buyOutput[4];
//    }

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
