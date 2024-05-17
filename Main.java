import java.util.Arrays;
import java.util.Scanner;

class Calculator {
    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Number should be in range [1, 3999]");
        }

        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        return M[num / 1000] + C[(num % 1000) / 100]
                + X[(num % 100) / 10] + I[num % 10];
    }

    public static void main(String[] args) {
        int ans;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите пример: ");
        String primer = sc.nextLine();

        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean flag_rim = false;



        try {
            String[] parts = primer.split(" ");
            if ((Arrays.binarySearch(rim, parts[0]) >= 0) && (Arrays.binarySearch(rim, parts[2]) >= 0)) {
                flag_rim = true;
            };
            //Перевод с римских в арабские
            int a = switch (parts[0]) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> Integer.parseInt(parts[0]);
            };

            int b = switch (parts[2]) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> Integer.parseInt(parts[2]);
            };

            // Операции над числами вывод арабским числом
            ans = switch (parts[1]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> throw new Error();
            };

            String a1 = parts[0];
            String b1 = parts[2];

            if ((Arrays.binarySearch(arab, a1) >= 0) && (Arrays.binarySearch(rim, b1) >= 0)) { // Выводит индекс
                throw new Error();
            };
            if ((Arrays.binarySearch(arab, b1) >= 0) && (Arrays.binarySearch(rim, a1) >= 0)) { // Выводит индекс
                throw new Error();
            };



            if ((a < 1) | (a > 10) | (b < 1) | (b > 10)) {
                throw new java.lang.Error();
            }

            if (flag_rim == true) {
                System.out.println((intToRoman(ans)));
            } else {
                System.out.println(ans);
            }



        } catch (Exception e) {
            throw new java.lang.Error();
        }
    }
}
