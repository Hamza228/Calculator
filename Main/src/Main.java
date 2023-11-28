import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static final Map<String, Integer> ROMAN_NUMERALS = new HashMap<>();
    private static final Map<Integer, String> ARABIC_TO_ROMAN = new HashMap<>();

    static {
        ROMAN_NUMERALS.put("I", 1);
        ROMAN_NUMERALS.put("II", 2);
        ROMAN_NUMERALS.put("III", 3);
        ROMAN_NUMERALS.put("IV", 4);
        ROMAN_NUMERALS.put("V", 5);
        ROMAN_NUMERALS.put("VI", 6);
        ROMAN_NUMERALS.put("VII", 7);
        ROMAN_NUMERALS.put("VIII", 8);
        ROMAN_NUMERALS.put("IX", 9);
        ROMAN_NUMERALS.put("X", 10);
        ROMAN_NUMERALS.put("XI", 11);
        ROMAN_NUMERALS.put("XII", 12);
        ROMAN_NUMERALS.put("XIII", 13);
        ROMAN_NUMERALS.put("XIV", 14);
        ROMAN_NUMERALS.put("XV", 15);
        ROMAN_NUMERALS.put("XVI", 16);
        ROMAN_NUMERALS.put("XVII", 17);
        ROMAN_NUMERALS.put("XVIII", 18);
        ROMAN_NUMERALS.put("XIX", 19);
        ROMAN_NUMERALS.put("XX", 20);
        ROMAN_NUMERALS.put("XXI", 21);
        ROMAN_NUMERALS.put("XXII", 22);
        ROMAN_NUMERALS.put("XXIII", 23);
        ROMAN_NUMERALS.put("XXIV", 24);
        ROMAN_NUMERALS.put("XXV", 25);
        ROMAN_NUMERALS.put("XXVI", 26);
        ROMAN_NUMERALS.put("XXVII", 27);
        ROMAN_NUMERALS.put("XXVIII", 28);
        ROMAN_NUMERALS.put("XXIX", 29);
        ROMAN_NUMERALS.put("XXX", 30);
        ROMAN_NUMERALS.put("XXXI", 31);
        ROMAN_NUMERALS.put("XXXII", 32);
        ROMAN_NUMERALS.put("XXXIII", 33);
        ROMAN_NUMERALS.put("XXXIV", 34);
        ROMAN_NUMERALS.put("XXXV", 35);
        ROMAN_NUMERALS.put("XXXVI", 36);
        ROMAN_NUMERALS.put("XXXVII", 37);
        ROMAN_NUMERALS.put("XXXVIII", 38);
        ROMAN_NUMERALS.put("XXXIX", 39);
        ROMAN_NUMERALS.put("XL", 40);
        ROMAN_NUMERALS.put("XLI", 41);
        ROMAN_NUMERALS.put("XLII", 42);
        ROMAN_NUMERALS.put("XLIII", 43);
        ROMAN_NUMERALS.put("XLIV", 44);
        ROMAN_NUMERALS.put("XLV", 45);
        ROMAN_NUMERALS.put("XLVI", 46);
        ROMAN_NUMERALS.put("XLVII", 47);
        ROMAN_NUMERALS.put("XLVIII", 48);
        ROMAN_NUMERALS.put("XLIX", 49);
        ROMAN_NUMERALS.put("L", 50);
        ROMAN_NUMERALS.put("LI", 51);
        ROMAN_NUMERALS.put("LII", 52);
        ROMAN_NUMERALS.put("LIII", 53);
        ROMAN_NUMERALS.put("LIV", 54);
        ROMAN_NUMERALS.put("LV", 55);
        ROMAN_NUMERALS.put("LVI", 56);
        ROMAN_NUMERALS.put("LVII", 57);
        ROMAN_NUMERALS.put("LVIII", 58);
        ROMAN_NUMERALS.put("LIX", 59);
        ROMAN_NUMERALS.put("LX", 60);
        ROMAN_NUMERALS.put("LXI", 61);
        ROMAN_NUMERALS.put("LXII", 62);
        ROMAN_NUMERALS.put("LXIII", 63);
        ROMAN_NUMERALS.put("LXIV", 64);
        ROMAN_NUMERALS.put("LXV", 65);
        ROMAN_NUMERALS.put("LXVI", 66);
        ROMAN_NUMERALS.put("LXVII", 67);
        ROMAN_NUMERALS.put("LXVIII", 68);
        ROMAN_NUMERALS.put("LXIX", 69);
        ROMAN_NUMERALS.put("LXX", 70);
        ROMAN_NUMERALS.put("LXXI", 71);
        ROMAN_NUMERALS.put("LXXII", 72);
        ROMAN_NUMERALS.put("LXXIII", 73);
        ROMAN_NUMERALS.put("LXXIV", 74);
        ROMAN_NUMERALS.put("LXXV", 75);
        ROMAN_NUMERALS.put("LXXVI", 76);
        ROMAN_NUMERALS.put("LXXVII", 77);
        ROMAN_NUMERALS.put("LXXVIII", 78);
        ROMAN_NUMERALS.put("LXXIX", 79);
        ROMAN_NUMERALS.put("LXXX", 80);
        ROMAN_NUMERALS.put("LXXXI", 81);
        ROMAN_NUMERALS.put("LXXXII", 82);
        ROMAN_NUMERALS.put("LXXXIII", 83);
        ROMAN_NUMERALS.put("LXXXIV", 84);
        ROMAN_NUMERALS.put("LXXXV", 85);
        ROMAN_NUMERALS.put("LXXXVI", 86);
        ROMAN_NUMERALS.put("LXXXVII", 87);
        ROMAN_NUMERALS.put("LXXXVIII", 88);
        ROMAN_NUMERALS.put("LXXXIX", 89);
        ROMAN_NUMERALS.put("XC", 90);
        ROMAN_NUMERALS.put("XCI", 91);
        ROMAN_NUMERALS.put("XCII", 92);
        ROMAN_NUMERALS.put("XCIII", 93);
        ROMAN_NUMERALS.put("XCIV", 94);
        ROMAN_NUMERALS.put("XCV", 95);
        ROMAN_NUMERALS.put("XCVI", 96);
        ROMAN_NUMERALS.put("XCVII", 97);
        ROMAN_NUMERALS.put("XCVIII", 98);
        ROMAN_NUMERALS.put("XCIX", 99);
        ROMAN_NUMERALS.put("C", 100);




        for (Map.Entry<String, Integer> entry : ROMAN_NUMERALS.entrySet()) {
            ARABIC_TO_ROMAN.put(entry.getValue(), entry.getKey());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            try {
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static String calc(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Неверный формат выражения");
        }

        String firstToken = tokens[0];
        String operator = tokens[1];
        String secondToken = tokens[2];

        boolean isRoman = isRomanNumeral(firstToken) && isRomanNumeral(secondToken);

        int num1;
        int num2;

        try {
            num1 = isRoman ? parseRomanNumeral(firstToken) : Integer.parseInt(firstToken);
            num2 = isRoman ? parseRomanNumeral(secondToken) : Integer.parseInt(secondToken);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка в формате чисел");
        }

        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
        }

        String result;
        switch (operator) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = String.valueOf(num1 / num2);
                break;
            default:
                throw new IllegalArgumentException("Неверная арифметическая операция");
        }

        return isRoman ? convertToRoman(Integer.parseInt(result)) : result;
    }

    private static boolean isRomanNumeral(String token) {
        return ROMAN_NUMERALS.containsKey(token);
    }

    private static int parseRomanNumeral(String token) {
        if (ROMAN_NUMERALS.containsKey(token)) {
            return ROMAN_NUMERALS.get(token);
        }
        throw new IllegalArgumentException("Неверный формат числа");
    }

    private static String convertToRoman(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Римские числа могут быть только от 1 до 10 включительно");
        }
        return ARABIC_TO_ROMAN.get(number);
    }
}

