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
