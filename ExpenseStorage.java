import java.util.*;
import java.io.*;

public class ExpenseStorage {
    private static final String FILE_NAME = "expenses.txt";

    public static List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(SimpleExpense.fromString(line));
            }
        } catch (IOException e) {
            // File might not exist on first run
        }
        return expenses;
    }

    public static void saveExpenses(List<Expense> expenses) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                bw.write(e.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }
}
