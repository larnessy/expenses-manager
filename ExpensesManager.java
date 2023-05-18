package expensesManager;

import java.util.ArrayList;
import java.util.HashMap;

// менеджер расходов
public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }


    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary -= expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) { // Проверьте наличие категории
            ArrayList<Double> spending = expensesByCategories.get(category); // Получите список трат в этой категории
            spending.add(expense); // Добавьте трату
            expensesByCategories.put(category, spending);
            if (expensesByCategories.containsKey(category)) {
                ArrayList<Double> expenses = expensesByCategories.get(category);
                expenses.add(expense);
            } else {
                spending = new ArrayList<>(); // Создайте новый список трат и добавьте в него сумму
                spending.add(expense);
                expensesByCategories.put(category, spending); // Сохраните категорию и новый список трат в хеш-таблицу
                ArrayList<Double> expenses = new ArrayList<>();
                expenses.add(expense);
                expensesByCategories.put(category, expenses);
            }
            if (moneyBeforeSalary < 1000) {
                System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
            }
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        if (expensesByCategories.containsKey(category)) {
            for (ArrayList<Double> expenses : expensesByCategories.values()) {
                for (Double exp : expenses) {
                    if (exp > maxExpense) {
                        maxExpense = exp;
                    }
                    expenses = expensesByCategories.get(category);
                    for (Double expense : expenses) {
                        if (expense > maxExpense) {
                            maxExpense = expense;
                        }
                    }
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }


    // Напишите метод для удаления категории
    public void removeCategory(String category) {
//        if (expensesByCategories.containsKey(category)) {
        expensesByCategories.remove(category);
//        } else {
//            System.out.println("Категории " + category + " нет в списке");
//        }
    }

    // Напишите метод для получения суммы всех трат
    public Double getExpensesSum() {
        Double sum = 0d;
        for (String expense : expensesByCategories.keySet()) {
            for (Double spend : expensesByCategories.get(expense)) {
                sum += spend;
            }
        }
        return sum;
    }

    // Напишите метод для получения категории, где размер трат больше всего
    public String getMaxCategoryName() {
        double maxCategorySum = 0;
        String maxCategoryName = "";
        for (String caregory : expensesByCategories.keySet()) {
            Double sum = 0d;
            for (Double expense : expensesByCategories.get(caregory)) {
                sum += expense;
                if (sum > maxCategorySum) {
                    maxCategorySum = sum;
                    maxCategoryName = caregory;
                }
            }
        }
        return maxCategoryName;
    }

}

