import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> basket = new ArrayList<>();
        while (true) {
            System.out.println("Выберите номер операции путем ввода его номера. Для завершения введите end\n 1 Добавить  2 Показать  3 Удалить");
            String inputStr = scanner.nextLine();
            if (inputStr.equals("end")) break;
            else if (inputStr.equals("")) continue;
            int numOperation;
            try {
                numOperation = Integer.parseInt(inputStr);
            } catch (NumberFormatException error) {
                System.out.println("При вводе номера операции допущена ошибка!");
                continue;
            }
            if (numOperation == 1) {
                addBasket(basket, scanner);
            } else if (numOperation == 2) {
                showBasket(basket);
            } else if (numOperation == 3) {

            } else {
                System.out.println("Номер операции выбран неверно, введенного Вами номера " + numOperation + " нет в предложенном списке выбора");
                continue;
            }
        }
    }

    public static void addBasket(ArrayList basket, Scanner scanner) {
        System.out.println("Введите наименование товара который хотите добавить в корзину и нажмите Enter");
        String inputStr = scanner.nextLine();
        if (inputStr.equals("")) {
            System.out.println("Вы оставили пустое наименование, такой товар добавлять в корзину нельзя!");
        } else {
            basket.add(inputStr);
            showBasket(basket);
        }
    }

    public static void showBasket(ArrayList basket) {
        System.out.println("Список покупок");
        for (int i = 0; i < basket.size(); i++) {
            System.out.println((i + 1) + ". " + basket.get(i));
        }
    }
}
