import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Годовой отчет
public class YearlyReport {

    // записи по месяцам
    private DataYearly[] data = new DataYearly[12];
    // количество загруженных месяцев
    private int count = 0;
    // готовность отчета
    private boolean ready = false;
    // год
    private int year;
    // суммарный доход и расход
    private int totalIncome = 0, totalOutcome = 0;

    public YearlyReport(int year) {
        this.year = year;
    }

    // get / set

    public DataYearly[] getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public boolean isReady() {
        return ready;
    }

    // загрузка отчета
    public void addMapYearly() {
        List<String> lines = Tools.readFileContentsOrNull("resources/y." + year + ".csv");
        Arrays.fill(data, null);
        boolean skipHeader = false;

        for (String line : lines) {
            if (!skipHeader) {
                skipHeader = true;
                continue;
            }

            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            DataYearly record = data[month - 1];
            if (record == null) {
                record = new DataYearly();
                data[month - 1] = record;
                count++;
            }
            if (isExpense) {
                record.setAmountOutcome(amount);
            } else {
                record.setAmountIncome(amount);
            }
        }
        for(DataYearly rec: data){
            if(rec==null) continue;
            totalIncome+=rec.getAmountIncome();
            totalOutcome+=rec.getAmountOutcome();
        }
        ready = true;
        System.out.println("Список за год считан! Считано записей: " + count);
    }

    // вывод на печать
    public void print() {
        if(!isReady()){
            System.out.println("Сначала загрузите отчеты");
            return;
        }
        if(count==0){
            System.out.println("Отчет не содержит данных ни за один месяц");
            return;
        }
        System.out.println("год "+year);
        System.out.println("прибыль по месяцам:");
        for(int i=0; i<12; i++){
            DataYearly rec = data[i];
            if(rec==null) continue;
            System.out.printf("%-10s % 12d\n",Tools.monthName(i),rec.getTotal());
        }
        System.out.println();
        System.out.printf("средний расход: % 12.2f\n",((double)totalOutcome/count));
        System.out.printf("средний доход : % 12.2f\n",((double)totalIncome/count));

    }

    @Override
    public String toString() {
        return "YearlyReport{" +
                "data=" + Arrays.toString(data) +
                ", count=" + count +
                ", ready=" + ready +
                ", year=" + year +
                '}';
    }
}
