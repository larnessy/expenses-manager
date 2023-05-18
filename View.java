package expensesManager;

import java.util.Scanner;

// ориентация на View
public class View {
    public static boolean enterBasicInput(Scanner scanner, BasicInput basicInput) {
        boolean isReady = true;
        OUTER:
        for (int i = 0; i < 3; i++) {

            System.out.println("Сколько рублей (RUB) у вас осталось до зарплаты? // Округлите до целых…");
            for (int j = 0; ; j++) {
                try {
                    basicInput.setMoneyBeforeSalary(scanner.nextDouble());
                    if (basicInput.getMoneyBeforeSalary() < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    if (j == 2) {
                        System.out.println("Вы не готовы к работе с такой сложной компьютерной программой. " +
                                "Наберитесь опыта и попробуйте свои силы в другой раз.");
                        isReady = false;
                        break OUTER;
                    }
                    System.out.println("Некорректный ввод, попробуйте ещё раз…");
                }
            }

            System.out.println("Сколько дней до вашей следующей зарплаты?");
            for (int j = 0; ; j++) {
                try {
                    basicInput.setDaysBeforeSalary(scanner.nextInt());
                    if (basicInput.getDaysBeforeSalary() < 0 || basicInput.getDaysBeforeSalary() > 31) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    if (j == 2) {
                        System.out.println("Вы не готовы к работе с такой сложной компьютерной программой. " +
                                "Наберитесь опыта и попробуйте свои силы в другой раз.");
                        isReady = false;
                        break OUTER;
                    }
                    System.out.println("Некорректный ввод, попробуйте ещё раз…");
                }
            }

            System.out.printf("Ваши сбережения: %.0f RUB. Дней до зарплаты: %d.\n", basicInput.getMoneyBeforeSalary(), basicInput.getDaysBeforeSalary());

            System.out.println("Всё верно?\nДоступные варианты: 0 - Нет, 1 - Да.");
            int yesOrNo;
            for (int j = 0; ; j++) {
                try {
                    yesOrNo = scanner.nextInt();
                    if (yesOrNo == 0) {
                        System.out.println("Хорошо, попробуйте заново…");
                        continue OUTER;
                    } else if (yesOrNo != 1) {
                        throw new Exception();
                    }
                    break OUTER;
                } catch (Exception e) {
                    if (j == 2) {
                        System.out.println("Вы не готовы к работе с такой сложной компьютерной программой. " +
                                "Наберитесь опыта и попробуйте свои силы в другой раз.");
                        isReady = false;
                        break OUTER;
                    }
                    System.out.println("Некорректный ввод, попробуйте ещё раз…");
                }
            }
        }
        return isReady;
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?"); // реализовано
        System.out.println("1 - Конвертировать валюту"); // реализовано
        System.out.println("2 - Получить совет"); // реализовано
        System.out.println("3 - Ввести трату"); //
        System.out.println("4 - Показать траты по категориям");
        System.out.println("5 - Показать самую большую трату в выбранной категории");
        System.out.println("6 - Очистить таблицу трат");
        System.out.println("7 - Вернуть сумму всех трат");
        System.out.println("8 - Удалить категорию");
        System.out.println("9 - Получить имя самой дорогой категории");
        System.out.println("0 - Выход");
    }

}