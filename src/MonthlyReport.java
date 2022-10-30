import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public static HashMap<Integer, ArrayList<DataMonth>> dataMap = new HashMap<>();
    public static ArrayList<DataMonth> dataList = new ArrayList<>();

    public static void addMapMonth(){
        for(int i = 1; i<4; i++){
            String content = readFileContents.readFileContentsOrNull("resources/m.202102.csv");
            String[] lines = content.split("\n");
            for (int j = 1; j< lines.length; j++){
                String[] parts = lines[j].split(",");
                String itemName = parts[0];
                Boolean isExpense = Boolean.parseBoolean(parts[1]);
                Integer quantity = Integer.parseInt(parts[2]);
                Integer sumOfOne = Integer.parseInt(parts[3]);
                DataMonth dataMonth = new DataMonth(itemName, isExpense, quantity, sumOfOne);
                dataList.add(dataMonth);
                for (int g=0; g<3; g++) {
                    dataMap.put(g, dataList);
                }
            }
        }
        System.out.println("Списки за 3 месяца считаны!");
        System.out.println(" ");
    }

    static void maxExseption(){
        int expends = 0; // расход
        int maxExpends = 0; // max
        String name = " "; // name

        for (Integer expend : dataMap.keySet()){
            for(DataMonth names : dataMap.get(expend)){
                if (!names.is_Expense){
                   expends += names.quantity * names.sum_Of_One;
                   if(maxExpends < expends){
                       maxExpends = expends;
                       name = names.item_Name;
                   }
                }
            }
            System.out.println("Месяц - "+(expend+1));
            System.out.println("Самый большой расход "+ name);
            System.out.println("Общая сумма расхода - "+ maxExpends);
            System.out.println(" ");
        }
    }

    static void maxIncome(){
        int maxIncome = 0; //max
        int income = 0; // доход
        String itemName =" "; //name

        for(Integer incomeMax: dataMap.keySet()){
            for(DataMonth name:  dataMap.get(incomeMax)){
                if(name.is_Expense){
                    income += name.quantity * name.sum_Of_One;
                    if(maxIncome<income){
                        maxIncome = income;
                        itemName = name.item_Name;
                    }
                }
            }
            System.out.println("Месяц - "+(incomeMax+1));
            System.out.println("Самый прибыльный товар "+ itemName);
            System.out.println("Общая сумма - "+ maxIncome);
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    static void reconciliation(){
        int sumInC0ome = 0;
        int income = 0;
        int wrong = 0;

        for(Integer ignored : dataMap.keySet()){
            for(DataMonth summ: dataMap.get(ignored)){
            if(summ.is_Expense){
                income += summ.quantity*summ.sum_Of_One;
            }else{
                sumInC0ome += summ.quantity*summ.sum_Of_One;
            }
            }
            for (DataYearly incom : YearlyReport.incomeList){
                if((incom.month == ignored)&&(incom.amount != sumInC0ome)){
                    wrong++;
                    System.out.println("За "+ignored+" месяц обнаружено несоответствие по доходу");
                }
            }
            for (DataYearly expend : YearlyReport.expendList){
                if((expend.month == ignored)&&(expend.amount != income)){
                    wrong++;
                    System.out.println("За "+ignored+" месяц обнаружено несоответствие по расходу");
                }
            }
        }
        if (wrong ==0){
            System.out.println("Несоответствий не обноружено");
            System.out.println("");
        }
        System.out.println("");
    }

    static void printCheck(){
        if (dataMap == null){
            System.out.println("Сначала считайте отчеты");
            System.out.println("");
        }else{
            maxIncome();
            maxExseption();
        }
    }
}