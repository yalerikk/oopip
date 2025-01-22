import java.util.Scanner;

public class CheckValue {
    static Scanner sca = new Scanner(System.in);
    protected static String readNonEmptyString() {
        String value = sca.nextLine();
        while (value.isEmpty()) {
            System.out.println("\nЗначение не может быть пустым. Пожалуйста, введите значение: ");
            value = sca.nextLine();
        }
        return value;
    }

    protected static int readIntegerInRange(int min, int max) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = sca.nextLine(); // Считываем ввод как строку

            // Проверяем, является ли ввод числом
            if (isInteger(input)) {
                value = Integer.parseInt(input); // Преобразуем строку в число
                if (value >= min && value <= max) {
                    validInput = true; // Ввод корректен
                } else {
                    System.out.println("Некорректное значение! Пожалуйста, введите значение от " + min + " до " + max + ": ");
                }
            } else {
                System.out.println("Некорректное значение! Пожалуйста, введите значение от " + min + " до " + max + ": ");
            }
        }
        return value;
    }

    private static boolean isInteger(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false; // Если встретили нецифровой символ, возвращаем false
            }
        }
        return true; // Если все символы цифры, возвращаем true
    }

    protected static String getAge(int age) {
        if (age % 10 == 1 && age % 100 != 11) {
            return age + " год";
        } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
            return age + " года";
        } else {
            return age + " лет";
        }
    }
}
