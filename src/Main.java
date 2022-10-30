import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int command;

        while (true) {
            printMenu();
            System.out.println(" ");
            System.out.print("Введите команду:");
            command = scanner.nextInt();

            if (command == 1) {
                MonthlyReport.addMapMonth();
            } else if (command == 2) {
                YearlyReport.addMapYearly();
            } else if (command == 3) {
                MonthlyReport.reconciliation();
            } else if (command == 4) {

            } else if (command == 5) {

            } else if (command == 0) {
                System.out.println("? До свидания - ждем вас сново! ?");
                break;
            } else {
                System.out.println("Введенные данные не корректны!");
                System.out.println("-Выберите корректный пункт меню-");
                System.out.println(" ");
            }
        }
    }
    public static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Завершить работу");
    }
}

