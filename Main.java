package expensesManager;

import java.util.Scanner;

// бизнес-логика
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicInput basicInput = new BasicInput();

        if (View.enterBasicInput(scanner, basicInput)) {

            Converter converter = new Converter(78.5, 88.7, 0.75);
            Advisor advisor = new Advisor();
            ExpensesManager expensesManager = new ExpensesManager(); // НЕ ОК ТОЛЬКО ЗДЕСЬ

            OUTER:
            while (true) {
                View.printMenu();
                int command;

                for (int i = 0; ; i++) {
                    try {
                        command = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        if(i == 2){
                            System.out.println("Вы не готовы к работе с такой сложной компьютерной программой. " +
                                    "Наберитесь опыта и попробуйте свои силы в другой раз.");
                            break OUTER;
                        }
                        System.out.println("Некорректный ввод, попробуйте ещё раз…");
                    }
                }

                switch (command) {
                    case 1 -> { // всё ок
                        System.out.printf("Ваши сбережения: %.0f RUB\n", basicInput.getMoneyBeforeSalary());
                        System.out.println("В какую валюту хотите конвертировать?\nДоступные варианты: 1 - USD, 2 - EUR, 3 - JPY.");
                        int currency = scanner.nextInt();
                        converter.convert(basicInput.getMoneyBeforeSalary(), currency);
                    }
                    case 2 -> {
                        advisor.getAdvice(basicInput.getMoneyBeforeSalary(), basicInput.getDaysBeforeSalary());
                    }
                    case 3 -> { // ДАЛЕЕ ФУНКЦИОНАЛ НЕ РЕАЛИЗОВАН
                        System.out.println("Введите размер траты:");
                        double expense = scanner.nextDouble();
                        System.out.println("К какой категории относится трата?");
                        String category = scanner.next();
                        basicInput.setMoneyBeforeSalary(expensesManager.saveExpense(basicInput.getMoneyBeforeSalary(), category, expense));
                    }
                    case 4 -> {
                        expensesManager.printAllExpensesByCategories();
                    }
                    case 5 -> {
                        System.out.println("В какой категории искать?");
                        String category = scanner.next();
                        System.out.println("Самая большая трата в категории " + category + " составила "
                                + expensesManager.findMaxExpenseInCategory(category) + " руб.");
                    }
                    case 6 -> {
                        expensesManager.removeAllExpenses();
                    }
                    case 7 -> {
                        System.out.println("Всего потрачено: " + expensesManager.getExpensesSum());
                    }
                    case 8 -> {
                        System.out.println("Какую категорию вы хотите удалить?");
                        String category = scanner.next();
                        expensesManager.removeCategory(category);
                    }
                    case 9 -> {
                        System.out.println("В категории " + expensesManager.getMaxCategoryName() + " вы потратили больше всего.");
                    }
                    case 0 -> { // всё ок
                        System.out.println("Выход");
                        break OUTER;
                    }
                    default -> {
                        System.out.println("Извините, такой команды пока нет.");
                    }
                }

            }

            scanner.close();
        }

    }

}
