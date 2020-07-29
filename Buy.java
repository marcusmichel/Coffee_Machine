package machine;

public enum Buy {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO( 200, 100, 12, 6);

    int water;
    int milk;
    int coffee;
    int money;
    int cups = 1;

    Buy(int water, int milk, int coffee, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.money = money;
    }

//    public int[] buyDrink(int water, int milk, int coffee, int money, int dispCups) {
//        String enough = "I have enough resources, making you a coffee!";
//        String needWater = "Sorry, not enough water!";
//        String needMilk = "Sorry, not enough milk!";
//        String needCoffee = "Sorry, not enough coffee!";
//        String needMoney = "Sorry, not enough money!";
//        String needCups = "Sorry, not enough cups!"
//
//        int[] output = new int[5];
//        int[] reqResource = new int[5];
//        reqResource[0] = this.water;
//        reqResource[1] = this.milk;
//        reqResource[2] = this.coffee;
//        reqResource[3] = this.money;
//        reqResource[4] = this.cups;
//
//        output[0] = water;
//        output[1] = milk;
//        output[2] = coffee;
//        output[3] = money;
//        output[4] = dispCups;
//
//        if (cups == 0) {
//            System.out.println(needCups);
//        } else if (this.water > water) {
//            System.out.println(needWater);
//        } else if (this.milk > milk) {
//            System.out.println(needMilk);
//        } else if (this.coffee > coffee) {
//            System.out.println(needCoffee);
//        } else if (this.money > money) {
//            System.out.println(needMoney);
//        } else {
//            System.out.println(enough);
//            for (int i = 0; i < 5; i++) {
//                output[i] -= reqResource[i];
//            }
//        }
//    }
}
