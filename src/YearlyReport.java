import java.util.ArrayList;
import java.util.HashMap;

    public class YearlyReport {
        public static HashMap<Integer, ArrayList<DataYearly>> dataMap = new HashMap<>();
        public static ArrayList<DataYearly> incomeList = new ArrayList<>(); //
        public static ArrayList<DataYearly> expendList = new ArrayList<>();
        public static ArrayList<DataYearly> dataList = new ArrayList<>();
        static String path = "resources/y.2021.csv";

        public static void addMapYearly() {
            String content = readFileContents.readFileContentsOrNull(path);
            String[] lines = content.split("\r?\n");
            for (int i = 1; i < lines.length; i++) {
                String[] parts = lines[i].split(",");
                Integer month = Integer.parseInt(parts[0]);
                Integer amount = Integer.parseInt(parts[1]);
                Boolean isExpense = Boolean.parseBoolean(parts[2]);
                DataYearly dataYearly = new DataYearly(month, amount, isExpense);
                dataList.add(dataYearly);
                dataMap.put(i, dataList);

                if(isExpense){
                    expendList.add(dataYearly);
                }else{
                    incomeList.add(dataYearly); //
                }
            }
            System.out.println("Списсок за год считан!");
            System.out.println(" ");
        }

        static void expensesMid(){
            int expense = 0;
            int mid = 0;
            for(DataYearly expens : expendList){
                expense += expens.amount;
            }
            mid = expense/expendList.size();
            System.out.println("Средний расход: "+mid);
        }

        static void incomeMid(){
            int incomes = 0;
            int mid = 0;
            for(DataYearly income : incomeList){
                incomes += income.amount;
            }
            mid = incomes/incomeList.size();
            System.out.println("Средний доход: "+mid);
        }

        static void printYearlyReport(){
            int income = 0;
            int expense = 0;
            int profit = 0;

            for(DataYearly incomes: incomeList){
                income = incomes.amount;
                for (DataYearly expenses: expendList){
                    expense = expenses.amount;
                    if(incomes.month.equals(expenses.month)){
                        profit=income-expense;
                    }
                }
                System.out.println(incomes + " месяц - "+ profit);
            }
            expensesMid();
            incomeMid();
        }
    }
