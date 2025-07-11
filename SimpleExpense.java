public class SimpleExpense implements Expense {
    private String date;
    private String description;
    private double amount;

    public SimpleExpense(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public String getDate() { return date; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return date + "," + description + "," + amount;
    }

    public static SimpleExpense fromString(String line) {
        String[] parts = line.split(",");
        return new SimpleExpense(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
}
