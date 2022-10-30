public class DataMonth {
    String item_Name;
    boolean is_Expense;
    Integer quantity;
    Integer sum_Of_One;

    public DataMonth (String itemName, boolean isExpense, Integer quantity, Integer sumOfOne){
        this.item_Name = itemName;
        this.is_Expense = isExpense;
        this.quantity = quantity;
        this.sum_Of_One = sumOfOne;
    }
}