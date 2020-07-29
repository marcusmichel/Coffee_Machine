package machine;
import java.util.Scanner;

public class OldCoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = null;
        boolean machineOn = true;
        int money = 550;
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int dispCups = 9;



        while (machineOn) {
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
                    display(money, water, milk, coffee, dispCups);
                    break;

                case "exit":
                    machineOn = false;
                    break;
            }
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
        System.out.println("Coffee is ready!"); */
    }
    private static void display(int money, int water, int milk, int coffee, int dispCups) {
        System.out.println("The coffee machine has: " + water + " of water");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(dispCups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }
}
