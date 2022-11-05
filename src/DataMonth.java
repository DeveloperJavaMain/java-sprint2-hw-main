//Информация из месячного отчета
public class DataMonth {
    private String itemName;   // item_name
    private boolean expense;    // расход или доход
    private int quantity;       // количестов
    private int sum_Of_One;     // стоимость единицы
    private int amount;         // сумма

    // constructor

    public DataMonth (String itemName, boolean isExpense, int quantity, int sumOfOne){
        this.itemName = itemName;
        this.expense = isExpense;
        this.quantity = quantity;
        this.sum_Of_One = sumOfOne;
        amount = quantity * sumOfOne;
    }

    // get / set

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isExpense() {
        return expense;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum_Of_One() {
        return sum_Of_One;
    }

    public void setSum_Of_One(int sum_Of_One) {
        this.sum_Of_One = sum_Of_One;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}