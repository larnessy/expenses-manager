package expensesManager;

// базовый ввод
public class BasicInput {
    private double moneyBeforeSalary = 0.0;
    private int daysBeforeSalary = 0;

    public double getMoneyBeforeSalary() {
        return moneyBeforeSalary;
    }

    public void setMoneyBeforeSalary(double moneyBeforeSalary) {
        this.moneyBeforeSalary = moneyBeforeSalary;
    }

    public int getDaysBeforeSalary() {
        return daysBeforeSalary;
    }

    public void setDaysBeforeSalary(int daysBeforeSalary) {
        this.daysBeforeSalary = daysBeforeSalary;
    }
}
