package expensesManager;

// советчик
public class Advisor {
    public void getAdvice(double moneyBeforeSalary, int daysBeforeSalary) {
        System.out.printf("Постарайтесь тратить в среднем не больше %.2f RUB в день, " +
                "чтобы дотянуть до зарплаты.\n", moneyBeforeSalary/daysBeforeSalary);
    }
}
