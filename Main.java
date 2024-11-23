import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int bestScore = Integer.MAX_VALUE; // Лучшее количество попыток
        boolean keepPlaying = true;

        while (keepPlaying) {
            int numberToGuess = random.nextInt(100) + 1; // Загадали число от 1 до 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

            while (!guessedCorrectly) {
                System.out.print("Введите число (или тип 'RESULT' для просмотра результатов): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("RESULT")) {
                    System.out.println("Текущие попытки: " + attempts);
                    System.out.println("Лучшее количество попыток: " + (bestScore == Integer.MAX_VALUE ? "Нет игр" : bestScore));
                    continue; // Продолжить цикл, не увеличивая попытки
                }

                int userGuess;
                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введите допустимое число или 'RESULT'.");
                    continue; // Если ввод некорректный, продолжаем цикл
                }

                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат.");
                } else {
                    System.out.println("Поздравляю! Ты угадал число " + numberToGuess + " за " + attempts + " попыток.");
                    guessedCorrectly = true;

                    if (attempts < bestScore) {
                        bestScore = attempts;
                    }
                }
            }

            System.out.print("Хотите сыграть снова? (да/нет): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("да")) {
                keepPlaying = false;
            }
        }

        System.out.println("Спасибо за игру! До новых встреч!");
        scanner.close();
    }
}


