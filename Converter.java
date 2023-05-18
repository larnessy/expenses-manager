package expensesManager;

// конвертер
public class Converter {
    private double USD;
    private double EUR;
    private double JPY;

    public Converter(double USD, double EUR, double JPY) {
        this.USD = USD;
        this.EUR = EUR;
        this.JPY = JPY;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getJPY() {
        return JPY;
    }

    public void setJPY(double JPY) {
        this.JPY = JPY;
    }

    public void convert(double moneyBeforeSalary, int currency) {
        switch (currency) {
            case 1 -> {
                moneyBeforeSalary /= USD;
                System.out.printf("USD/RUB = %.2f. У вас %.2f USD.\n", USD, moneyBeforeSalary);
            }
            case 2 -> {
                moneyBeforeSalary /= EUR;
                System.out.printf("EUR/RUB = %.2f. У вас %.2f EUR.\n", EUR, moneyBeforeSalary);
            }
            case 3 -> {
                moneyBeforeSalary /= JPY;
                System.out.printf("JPY/RUB = %.2f. У вас %.2f JPY.\n", JPY, moneyBeforeSalary);
            }
        }
    }

}
