package lesson7;

public class MainApp {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 50),
                new Cat("Leo", 30),
                new Cat("Simba", 25),
        };

        Plate plate = new Plate(100);

        for (Cat i : cats) {
            i.eat(plate);
            i.info();
        }
    }
}
