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
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Римские числа могут быть только от 1 до 10 включительно");
        }
        return ARABIC_TO_ROMAN.get(number);
    }
}
