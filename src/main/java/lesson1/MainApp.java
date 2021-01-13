package lesson1;

import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    public static double a, b, c, d;
    public static int e;
    public static String name;

    public static void main(String[] args) {
        System.out.println("Введите номер домашнего задания (3-8), чтобы получить условия - введите 0:");
        int num = scanner.nextInt();
        while (num == 0) {
            task_condition();
            System.out.println("Введите номер домашнего задания (3-8), чтобы получить условия - введите 0:");
            num = scanner.nextInt();
        }
        switch (num) {
            case 3:
                System.out.println("3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;");
                System.out.println("Введите значение a:");
                a = scanner.nextDouble();
                System.out.println("Введите значение b:");
                b = scanner.nextDouble();
                System.out.println("Введите значение c:");
                c = scanner.nextDouble();
                System.out.println("Введите значение d:");
                d = scanner.nextDouble();
                while (d == 0) {
                    System.out.println("Входной параметр d не может быть равен нулю, введите параметр заново:");
                    d = scanner.nextDouble();
                }
                double result = task3(a, b, c, d);
                System.out.println(result);
                break;
            case 4:
                System.out.println("4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;");
                System.out.println("Введите число 1:");
                a = scanner.nextDouble();
                System.out.println("Введите число 2:");
                b = scanner.nextDouble();
                boolean check = task4(a, b);
                System.out.println(check);
                break;
            case 5:
                System.out.println("5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.");
                System.out.println("Введите число:");
                e = scanner.nextInt();
                task5(e);
                break;
            case 6:
                System.out.println("6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;");
                System.out.println("Введите число:");
                e = scanner.nextInt();
                check = task6(e);
                System.out.println(check);
                break;
            case 7:
                System.out.println("7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;");
                System.out.println("Введите имя:");
                name = scanner.next();
                task7(name);
                break;
            case 8:
                System.out.println("8. Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");
                task8();
                break;
            default:
                System.out.println("Вы ввели некорректное значение.");
        }
    }

    private static void task_condition() {
        System.out.println("3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;");
        System.out.println("4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;");
        System.out.println("5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.");
        System.out.println("6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;");
        System.out.println("7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;");
        System.out.println("8. Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");
    }

    private static double task3(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    private static boolean task4(double e, double f) {
        if ((e + f) >= 10 && (e + f) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void task5(int e) {
        if (e >= 0) {
            System.out.println("Переданное число положительное");
        } else {
            System.out.println("Переданное число отрицательное");
        }
    }

    private static boolean task6(int e) {
        if (e < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void task7(String name) {
        System.out.print("Привет, " + name + "!");
    }

    private static void task8() {
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        if (year % 100 == 0 && year % 400 == 0) {
            System.out.println("Год високосный");
        } else if (year % 100 == 0) {
            System.out.println("Год не високосный");
        } else if (year % 4 == 0 && year % 100 > 0) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }

}
