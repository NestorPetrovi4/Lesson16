import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> basket = new ArrayList<>();
        while (true) {
            System.out.println("Выберите номер операции путем ввода его номера. Для завершения введите end\n 1 Добавить  2 Показать  3 Удалить 4 Найти");
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
                deleteBasket(basket, scanner);
            } else if (numOperation == 4) {
                findBasket(basket, scanner);
            } else {
                System.out.println("Номер операции выбран неверно, введенного Вами номера " + numOperation + " нет в предложенном списке выбора");
                continue;
            }
        }
    }

    public static void addBasket(ArrayList<String> basket, Scanner scanner) {
        System.out.println("Введите наименование товара который хотите добавить в корзину и нажмите Enter");
        String inputStr = scanner.nextLine();
        if (inputStr.equals("")) {
            System.out.println("Вы оставили пустое наименование, такой товар добавлять в корзину нельзя!");
        } else {
            basket.add(inputStr);
            showBasket(basket);
        }
    }

    public static void showBasket(ArrayList<String> basket) {
        System.out.println("Список покупок" + (basket.isEmpty() ? " пуст" : ""));
        for (int i = 0; i < basket.size(); i++) {
            System.out.println((i + 1) + ". " + basket.get(i));
        }
    }

    public static void deleteBasket(ArrayList<String> basket, Scanner scanner) {
        showBasket(basket);
        System.out.println("Введите номер позиции или название позиции которую хотите удалить");
        String inputStr = scanner.nextLine();
        try {
            int num = Integer.parseInt(inputStr);
            if (num == 0 || basket.size() < num) {
                System.out.println("Такого номера позиции не существует в вашей корзине!!!!");
                return;
            }
            System.out.println("Покупка " + basket.get(num - 1) + " удалена");
            basket.remove(num - 1);
            showBasket(basket);
        } catch (NumberFormatException error) {
            if (basket.remove(inputStr)) {
                System.out.println("Покупка " + inputStr + " удалена");
                showBasket(basket);
            }
        }
    }

    public static void findBasket(ArrayList<String> basket, Scanner scanner) {
        System.out.println("Введите текст для поиска по корзине");
        String inputStr = scanner.nextLine();
        String findString = inputStr.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < basket.size(); i++) {
            String item = basket.get(i);
            String itemLower = item.toLowerCase();
            if (itemLower.contains(findString)) {
                stringBuilder.append((i + 1) + ". " + item + "\n");
            }
        }
        if (stringBuilder.length() > 0) {
            System.out.println("Найдено:");
            System.out.println(stringBuilder.toString());
        }
    }
}
