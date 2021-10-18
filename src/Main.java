// 1. Приветствовать любого пользователя при вводе его имени через командную строку.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String answer = scanner.nextLine();
        System.out.println("Hello, " + answer + "!");

    }
}
