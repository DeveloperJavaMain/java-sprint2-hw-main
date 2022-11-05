import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Стартовый класс
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int command;

        ReportsByYear reportsByYear = new ReportsByYear(2021);
        YearlyReport  yearlyReport  = new YearlyReport(2021);

        // меню пользователя
        while (true) {
            printMenu();
            System.out.println();
            System.out.print("Введите команду:");
            try {
                command = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Введите число от 0 до 5");
                scanner.next();
                continue;
            }

            if (command == 0) {
                System.out.println("До свидания - ждем вас снова!");
                break;
            }

            switch (command){
                case 1: reportsByYear.loadReports(); break;
                case 2: yearlyReport.addMapYearly(); break;
                case 3: Checkup.checkup(yearlyReport, reportsByYear); break;
                case 4: reportsByYear.print(); break;
                case 5: yearlyReport.print(); break;
                default: {
                    System.out.println("Введенные данные не корректны!");
                    System.out.println("-Выберите корректный пункт меню-");
                    System.out.println(" ");
                }
            }
        }
    }
    public static void printMenu() {
        System.out.println();
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Завершить работу");
    }
}

