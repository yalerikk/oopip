import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*25. Аквариум.
    + Определить иерархию аквариумных рыбок.
    + Составить список рыбок для аквариума.
    + Подсчитать цену за всех рыбок.
    + Провести сортировку рыбок на основе их продолжительности жизни.
    + Найти рыбок, соответствующих заданному диапазону размеров.*/

    static ArrayList<Fish> fishList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\n\n\nДобро пожаловать в Аквариум!");
        functionMenu();
    }

    public static void functionMenu(){
        int choice;
        System.out.println("\n1)Составить список рыбок для аквариума;\n" +
                "2)Подсчитать цену за всех рыбок;\n" +
                "3)Провести сортировку рыбок на основе их продолжительности жизни;\n" +
                "4)Найти рыбок, соответствующих заданному диапазону размеров.\n");
        System.out.println("Выберите действие или нажмите 5 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 5);

        switch (choice) {
            case 1:
                makeList();
            case 2:
                countAquarium();
            case 3:
                sortByLengthOfLife();
            case 4:
                searchFishes();
            case 5:
                System.out.println("\nВыход из программы.");
                functionMenu();
        }
    }

    private static void makeList() {
        int choice;
        System.out.println("\nСоставить список рыбок для аквариума:\n" +
                "1)Автоматически;\n2)Добавить рыбок вручную.\n");
        System.out.println("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);

        switch (choice) {
            case 1:
                Aquarium.createAquarium(fishList);
                System.out.println("\nУспешно создано!");
                functionMenu();
            case 2:
                addFishes();
                functionMenu();
            case 3:
                functionMenu();
        }
    }

    public static void addFishes() {
        int choice;
        System.out.println("\nВыберите тип рыбки:\n" +
                "1)Гуппи;\n2)Неон;\n3)Меченосец;\n4)Золотая рыбка;\n5)Гурами.\n");
        System.out.println("Выберите действие или нажмите 6 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 6);
        switch (choice) {
            case 1:
                Guppy guppy = Aquarium.addGuppy();
                fishList.add(guppy);
                System.out.println("\nРыбка добавлена!");
                addFishes();
            case 2:
                Neon neon = Aquarium.addNeon();
                fishList.add(neon);
                System.out.println("\nРыбка добавлена!");
                addFishes();
            case 3:
                Swordtail swordtail = Aquarium.addSwordtail();
                fishList.add(swordtail);
                System.out.println("\nРыбка добавлена!");
                addFishes();
            case 4:
                Goldfish goldfish = Aquarium.addGoldfish();
                fishList.add(goldfish);
                System.out.println("\nРыбка добавлена!");
                addFishes();
            case 5:
                Gourami gourami = Aquarium.addGourami();
                fishList.add(gourami);
                System.out.println("\nРыбка добавлена!");
                addFishes();
            case 6:
                functionMenu();
        }
    }

    private static void countAquarium() {
        int choice;
        double totalCost = Aquarium.calculateTotalCost(fishList);
        System.out.println("\nВывести список рыбок в аквариуме перед просмотром суммы?:\n" +
                "1)Да;\n2)Нет.\n");
        System.out.print("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);
        switch (choice) {
            case 1:
                Aquarium.showAquarium(fishList);
                System.out.println("\nОбщая стоимость рыбок: " + totalCost + " р.");
                functionMenu();
            case 2:
                System.out.println("\nОбщая стоимость рыбок: " + totalCost + " р.");
                functionMenu();
            case 3:
                functionMenu();
        }
    }

    private static void sortByLengthOfLife() {
        int choice;
        System.out.println("\nПровести сортировку рыбок на основе их продолжительности жизни:\n" +
                "1)В порядке возрастания;\n2)В порядке убывания.\n");
        System.out.println("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);
        switch (choice) {
            case 1:
                Aquarium.sortByLengthOfLifeUp(fishList);
                functionMenu();
            case 2:
                Aquarium.sortByLengthOfLifeDown(fishList);
                functionMenu();
            case 3:
                functionMenu();
        }
    }

    private static void searchFishes() {
        int choice;
        System.out.println("\nНайти рыбок, соответствующих заданному диапазону размеров:\n" +
                "1)Да;\n2)Нет, выйти.\n");
        System.out.println("Выберите действие: ");
        choice = CheckValue.readIntegerInRange(1, 2);
        switch (choice) {
            case 1:
                Aquarium.searchInRange(fishList);
                functionMenu();
            case 2:
                functionMenu();
        }
    }
}