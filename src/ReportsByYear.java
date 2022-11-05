import java.nio.file.Files;
import java.nio.file.Path;

/*
    Набор месячных отчетов за год
 */
public class ReportsByYear {
    private MonthlyReport[] reports = new MonthlyReport[12];
    private int totalIncome = 0 , totalOutcome = 0;
    private int count = 0;
    private boolean ready = false;
    private int year;

    public ReportsByYear(int year) {
        this.year = year;
    }

    // get / set

    public MonthlyReport[] getReports() {
        return reports;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public int getTotalOutcome() {
        return totalOutcome;
    }

    public int getCount() {
        return count;
    }

    public boolean isReady() {
        return ready;
    }

    public int getYear() {
        return year;
    }

    // methods

    // загрузка отчетов
    public void loadReports(){

        for(int i=0; i<12; i++){
            String fname = String.format("resources/m.%d%02d.csv", year, (i+1));

            Path path = Path.of(fname);
            if(!Files.exists(path)) {
                reports[i] = null;
                continue;
            }

            MonthlyReport rpt = new MonthlyReport();
            rpt.addMapMonth(fname);
            if(rpt.isReady()) {
                reports[i] = rpt;
                totalIncome += rpt.getTotalIncome();
                totalOutcome+= rpt.getTotalOutcome();
                count++;
            } else {
                System.out.println("Возникли проблемы при загрузке '"+fname+"'");
            }
        }
        ready = true;
        System.out.println("Загружено месячных отчетов: "+count);
    }

    // вывод на печать
    public void print(){
        if(!isReady()){
            System.out.println("Отчеты не загружены");
            return;
        }
        for(int i=0; i<12; i++){
            MonthlyReport report = reports[i];
            if(report==null) continue;
            // печать отчета
            System.out.println(Tools.monthName(i));
            report.print();
        }
    }

}
