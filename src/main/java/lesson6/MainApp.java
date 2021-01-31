package lesson6;

public class MainApp {

    public static void main(String[] args) {

        Animals animal = new Animals();
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();

        animal.run();
        animal.swim();
        animal.jump();

        dog1.run();
        dog1.swim();
        dog1.jump();

        cat1.run();
        cat1.swim();
        cat1.jump();

        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.run();
        dog.swim();
        cat.run();
        cat.swim();
        dog.run(200);
        dog.swim(23);
        cat.run(900);
        cat.swim(2);

        Dog rax = new Dog("Rax");
        Cat catBarsik = new Cat("Barsik");

        rax.swim(5);
        rax.swim();
        rax.run(5);
        rax.run();
        rax.jump(5);
        rax.jump();


        catBarsik.swim(4);
        catBarsik.swim();
        catBarsik.run(5);
        catBarsik.run();
        catBarsik.jump(1);
        catBarsik.jump();

        animal.printAnimalsQuantity();
        dog.printDogsQuantity();
        cat.printCatsQuantity();

        Cat catBarton = new Cat("Barton", 30, 1);
        Dog dogArchi = new Dog("Archi", 500, 30, 2);

        Cat catSteven = new Cat("Steven", true);
        Dog dogHenry = new Dog("Henry", true);

        catBarton.jump(0.9);
        dogArchi.swim(120);

        catSteven.run(1);
        dogHenry.jump(5);
    }
}
