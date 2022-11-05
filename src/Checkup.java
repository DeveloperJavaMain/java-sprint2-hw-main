//Сверка отчетов

public class Checkup {
    public static boolean checkup(YearlyReport yearly, ReportsByYear monthly){

        if(!yearly.isReady() || !monthly.isReady()){
            System.out.println("Сначала загрузите отчеты.");
            return false;
        }

        // сверка отчетов
        boolean result = true;

        for(int i=0; i<12; i++){
            DataYearly yearRec = yearly.getData()[i];
            MonthlyReport  monthRec= monthly.getReports()[i];

            if(yearRec==null && monthRec==null) continue; // нет записей для этого месяца

            if(yearRec==null) { // нет записи в годовом отчете
                System.out.println("месяц "+(i+1)+" : отсутствует запись в годовом отчете");
                result = false;
                continue;
            }
            if(monthRec==null) { // нет месячного отчета
                System.out.println("месяц "+(i+1)+" : отсутствует запись в месячном отчете");
                result = false;
                continue;
            }

            // не совпадает доход
            if(yearRec.getAmountIncome()!= monthRec.getTotalIncome()){
                System.out.println("месяц "+(i+1)+" : несовпадает сумма дохода "+yearRec.getAmountIncome()+"!="+monthRec.getTotalIncome());
                result = false;
            }
            // не совпадает расход
            if(yearRec.getAmountOutcome()!= monthRec.getTotalOutcome()){
                System.out.println("месяц "+(i+1)+" : несовпадает сумма расхода "+yearRec.getAmountOutcome()+"!="+monthRec.getTotalOutcome());
                result = false;
            }
        }
        System.out.println("Сверка отчетов завершена "+((result)?"успешно":"с ошибками"));
        return result;
    }
}

