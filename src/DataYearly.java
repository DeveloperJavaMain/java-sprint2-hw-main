//Информация по месяцу из годового отчета
public class DataYearly {
    int amountIncome, amountOutcome; // доход / расход
    int total;  // суммарная прибыль

    // get / set

    public int getAmountIncome() {
        return amountIncome;
    }

    public void setAmountIncome(int amountIncome) {
        this.amountIncome = amountIncome;
        total = this.amountIncome-this.amountOutcome;
    }

    public int getAmountOutcome() {
        return amountOutcome;
    }

    public void setAmountOutcome(int amountOutcome) {
        this.amountOutcome = amountOutcome;
        total = this.amountIncome-this.amountOutcome;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DataYearly{" +
                "amountIncome=" + amountIncome +
                ", amountOutcome=" + amountOutcome +
                ", total=" + total +
                '}';
    }
}
