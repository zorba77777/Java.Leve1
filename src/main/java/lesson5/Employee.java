package lesson5;

public class Employee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;


    public Employee (String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void printInfo () {
        System.out.println("ФИО: " + name + "; Должность: " + position + "; Почта: " + email + "; Телефон: " + phone +
                "; Зарплата: " + salary + "; Возраст: " + age);
    }
    public int getAge () {
        return age;
    }
}
