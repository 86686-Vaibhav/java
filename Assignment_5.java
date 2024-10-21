package com.app.fruits;
import java.util.Scanner; 
abstract class Fruit{
    private String color;
    private double weight;
    private String name;
    private boolean isFresh;

    public Fruit(String name, double weight, String color, boolean isFresh) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.isFresh = isFresh;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setFresh(boolean isFresh) {
        this.isFresh = isFresh;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", isFresh=" + isFresh +
                '}';
    }

    public abstract String taste();
}

class Apple extends Fruit {
    public Apple(String name, double weight, String color, boolean isFresh) {
        super(name, weight, color, isFresh);
    }

    @Override
    public String taste() {
        return "sweet n sour";
    }
}

class Mango extends Fruit {
    public Mango(String name, double weight, String color, boolean isFresh) {
        super(name, weight, color, isFresh);
    }

    @Override
    public String taste() {
        return "sweet";
    }
}

class Orange extends Fruit {
    public Orange(String name, double weight, String color, boolean isFresh) {
        super(name, weight, color, isFresh);
    }

    @Override
    public String taste() {
        return "sour";
    }
}
public class Assignment_5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the basket: ");
        int basketSize = sc.nextInt();
        Fruit[] basket = new Fruit[basketSize];
        int counter = 0;
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("0. Exit");
            System.out.println("1. Add Mango");
            System.out.println("2. Add Orange");
            System.out.println("3. Add Apple");
            System.out.println("4. Display names of all fruits in the basket");
            System.out.println("5. Display details of all fresh fruits in the basket");
            System.out.println("6. Display tastes of all stale fruits");
            System.out.println("7. Mark a fruit as stale");
            System.out.println("8. Mark all sour fruits stale (optional)");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (counter < basket.length) {
                        System.out.println("Enter Mango details: name, weight, color");
                        basket[counter++] = new Mango(sc.next(), sc.nextDouble(), sc.next(), true);
                    } else {
                        System.out.println("Basket is full!");
                    }
                    break;

                case 2:
                    if (counter < basket.length) {
                        System.out.println("Enter Orange details: name, weight, color");
                        basket[counter++] = new Orange(sc.next(), sc.nextDouble(), sc.next(), true);
                    } else {
                        System.out.println("Basket is full!");
                    }
                    break;

                case 3:
                    if (counter < basket.length) {
                        System.out.println("Enter Apple details: name, weight, color");
                        basket[counter++] = new Apple(sc.next(), sc.nextDouble(), sc.next(), true);
                    } else {
                        System.out.println("Basket is full!");
                    }
                    break;

                case 4:
                    System.out.println("Fruits in the basket:");
                    for (Fruit fruit : basket) {
                        if (fruit != null) {
                            System.out.println(fruit.getName());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Fresh fruits:");
                    for (Fruit fruit : basket) {
                        if (fruit != null && fruit.isFresh()) {
                            System.out.println(fruit + ", Taste: " + fruit.taste());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Tastes of stale fruits:");
                    for (Fruit fruit : basket) {
                        if (fruit != null && !fruit.isFresh()) {
                            System.out.println(fruit.getName() + ": " + fruit.taste());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Enter index to mark fruit as stale:");
                    int index = sc.nextInt();
                    if (index >= 0 && index < counter && basket[index] != null) {
                        basket[index].setFresh(false);
                        System.out.println(basket[index].getName() + " is now stale.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 8:
                    System.out.println("Marking all sour fruits as stale.");
                    for (Fruit fruit : basket) {
                        if (fruit != null && "sour".equals(fruit.taste())) {
                            fruit.setFresh(false);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}