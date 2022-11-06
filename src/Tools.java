import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

//Вспомогательные методы
public class Tools {
    private static String[] names = {"Январь","Февраль","Март","Апрель","Май","Июнь",
            "Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

    // Наименование месяца
    // num от 0 до 11
    public static String monthName(int num) {
        if(num<0 || num>11) return "error";
        return names[num];
    }

    // считывание файла
    public static List<String> readFileContentsOrNull(String path)
    {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл '"+path+"'. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}
