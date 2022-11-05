import java.util.ArrayList;
import java.util.List;

/*
    Отчет за месяц
 */
public class MonthlyReport {

    // список операций
    private ArrayList<DataMonth> dataList = new ArrayList<>();
    // суммарных доход и расход
    private int totalIncome = 0, totalOutcome = 0;
    // максимальная прибыли и трата
    private DataMonth maxIncome, maxOutcome;
    // готовность отчета
    private boolean ready = false;

    // get / set

    public int getTotalIncome() {
        return totalIncome;
    }

    public int getTotalOutcome() {
        return totalOutcome;
    }

    public DataMonth getMaxIncome() {
        return maxIncome;
    }

    public DataMonth getMaxOutcome() {
        return maxOutcome;
    }

    public boolean isReady() {
        return ready;
    }

    // methods

    public void addMapMonth(String source){
        List<String> lines = Tools.readFileContentsOrNull(source);

        boolean skipHeader = false;

        for(String line: lines){
            if(!skipHeader) {
                skipHeader = true;
                continue;
            }

            String[] parts = line.split(",");
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);
            DataMonth dataMonth = new DataMonth(itemName, isExpense, quantity, sumOfOne);
            dataList.add(dataMonth);

            // статистика

            if(isExpense){
                totalOutcome+=dataMonth.getAmount();
                if(maxOutcome==null || dataMonth.getAmount()> maxOutcome.getAmount()){
                    maxOutcome = dataMonth;
                }
            } else {
                totalIncome+=dataMonth.getAmount();
                if(maxIncome==null || dataMonth.getAmount()> maxIncome.getAmount()){
                    maxIncome = dataMonth;
                }
            }
        }
        ready = true;
    }

    //  вывод отчета
    public void print(){
        System.out.printf("самый прибыльный товар : % 9d %s\n",maxIncome.getAmount(),maxIncome.getItemName());
        System.out.printf("самая большая трата    : % 9d %s\n",maxOutcome.getAmount(),maxOutcome.getItemName());
    }

}