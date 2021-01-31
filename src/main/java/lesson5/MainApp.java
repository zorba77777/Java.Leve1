package lesson5;

public class MainApp {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Сидоров Алексей", "Юрист", "sidr@mail.ru",
                "89217676767", 100000, 43);
        employees[1] = new Employee("Иванов Иван", "Продавец", "ivanov@mail.ru",
                "89215555565", 55000, 30);
        employees[2] = new Employee("Петров Евгений", "Инженер", "petrove@mail.ru",
                "89215585565", 77000, 46);
        employees[3] = new Employee("Белов Александр", "Программист", "belov@mail.ru",
                "89215587565", 25000, 52);
        employees[4] = new Employee("Дегтерев Антон", "Сисадмин", "degt@mail.ru",
                "89218987565", 84000, 22);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].printInfo();
            }
        }
    }
}
