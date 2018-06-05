package popova.collection.sort.Bank;

import java.util.Scanner;

public class PercentOf {

    private static double returnPercents(int value, double percent, int month, double result) {
        if (month == 0) {
            return result;
        } else {
            double per = (result + value) * (percent/100.0);
            System.out.println(String.format("add percent in %d, percents = %.1f, общее = %.1f", month, per, per + result + value));
            return returnPercents(value, percent, month - 1, per + result + value);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите сумму пополнения: ");
        int value = in.nextInt();
        System.out.print("Введите проценты: ");
        double percent = in.nextDouble();
        System.out.print("Введите количество месяцев: ");
        int month = in.nextInt();
        System.out.print(String.format("Сумма через %d месяцев будет равна %.1f: ", month, returnPercents(value, percent, month,0 )));


    }
}
