import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aquarium {
    public static void createAquarium(ArrayList<Fish> fishList){
        Guppy guppy1 = new Guppy("Гуппи 1", 1, 3, "Красный");
        fishList.add(guppy1);

        Guppy guppy2 = new Guppy("Гуппи 2", 3, 6,"Голубой");
        fishList.add(guppy2);

        Neon neon1 = new Neon("Неон 1", 1, 2, "Умеренно яркая");
        fishList.add(neon1);

        Neon neon2 = new Neon("Неон 2", 5, 4, "Яркая");
        fishList.add(neon2);

        Swordtail swordtail1 = new Swordtail("Меченосец 1", 4, 10,"Мечевидный");
        fishList.add(swordtail1);

        Swordtail swordtail2 = new Swordtail("Меченосец 2", 5, 8,"Мечевидный");
        fishList.add(swordtail2);

        Goldfish goldfish1 = new Goldfish("Золотая рыбка 1", 10, 15, "Оранжевый");
        fishList.add(goldfish1);

        Goldfish goldfish2 = new Goldfish("Золотая рыбка 2", 30, 30, "Оранжевый");
        fishList.add(goldfish2);

        Gourami gourami1 = new Gourami("Гурами 1", 4, 10,"Обычный");
        fishList.add(gourami1);

        Gourami gourami2 = new Gourami("Гурами 2", 5, 8,"Мраморный");
        fishList.add(gourami2);
    }

    public static void showAquarium(ArrayList<Fish> fishList){
        System.out.println("\nСписок рыбок в аквариуме: \n");
        System.out.println("-----------------------");
        for (Fish fish : fishList) {
            System.out.println(fish.toString());
            System.out.println("-----------------------");
        }
    }

    public static void text(String text, List<Fish> list ){
        System.out.println(text);
        for (int i = 0; i < list.size(); i++) {
            Fish fish = list.get(i);
            int age = fish.getLengthOfLife();
            String ageString = CheckValue.getAge(age);

            if (i == list.size() - 1) {
                System.out.println("\n" + fish.getName() + " : " + ageString + " - " +
                        fish.getSize() + " (см) - " + fish.getCost() + " р.");
            } else {
                System.out.print("\n" + fish.getName() + " : " + ageString + " - " +
                        fish.getSize() + " (см) - " + fish.getCost() + " р,");
            }
        }
    }

    public static void sortByLengthOfLifeUp(ArrayList<Fish> fishList){
        Collections.sort(fishList);
        text("\nСортировка рыбок в порядке возрастания: ", fishList);
    }

    public static void sortByLengthOfLifeDown(ArrayList<Fish> fishList){
        Comparator<Fish> lengthOfLifeComparator = new ReserveComparator();
        fishList.sort(lengthOfLifeComparator);
        text("\nСортировка рыбок в порядке убывания: ", fishList);
    }

    public static double calculateTotalCost(ArrayList<Fish> fishList) {
        double totalCost = 0.0;
        for (Fish fish : fishList) {
            totalCost += fish.getCost();
        }
        return totalCost;
    }

    public static void searchInRange(ArrayList<Fish> fishList) {
        int minSize, maxSize;
        System.out.println("\nВведите минимальный размер рыбки: ");
        minSize = CheckValue.readIntegerInRange(0, 30);
        System.out.println("Введите максимальный размер рыбки: ");
        maxSize = CheckValue.readIntegerInRange(1, 50);

        while (minSize == maxSize) {
            System.out.println("\nЗначения не могут быть одинаковыми! Введите разные значения.");
            System.out.println("Введите минимальный размер рыбки: ");
            minSize = CheckValue.readIntegerInRange(0, 30);

            System.out.println("Введите максимальный размер рыбки: ");
            maxSize = CheckValue.readIntegerInRange(1, 50);
        }

        List<Fish> fishInRange = new ArrayList<>();
        for (Fish fish : fishList) {
            if (fish.getSize() >= minSize && fish.getSize() <= maxSize) {
                fishInRange.add(fish);
            }
        }

        System.out.println("\nРыбки в заданном диапазоне размеров (" + minSize + " - " + maxSize + "):\n");
        for (Fish fish : fishInRange) {
            System.out.println(fish.getName() + ": " + fish.getSize() + " (см)");
        }
    }

    public static Guppy addGuppy() {
        Guppy guppy = new Guppy("", 0, 0, "");

        System.out.println("\nВведите имя гуппи: ");
        String name = CheckValue.readNonEmptyString();
        guppy.setName(name);

        System.out.println("Введите продолжительность жизни гуппи (до 3 лет): ");
        int lengthOfLife = CheckValue.readIntegerInRange(1, 3);
        guppy.setLengthOfLife(lengthOfLife);

        System.out.println("Введите размер гуппи (до 6 см): ");
        int size = CheckValue.readIntegerInRange(1, 6);
        guppy.setSize(size);

        System.out.println("Введите цвет гуппи: ");
        String color = CheckValue.readNonEmptyString();
        guppy.setColor(color);

        return guppy;
    }

    public static Neon addNeon() {
        Neon neon = new Neon("", 0, 0, "");

        System.out.println("\nВведите имя неона: ");
        String name = CheckValue.readNonEmptyString();
        neon.setName(name);

        System.out.println("Введите продолжительность жизни неона (до 5 лет): ");
        int lengthOfLife = CheckValue.readIntegerInRange(1, 5);
        neon.setLengthOfLife(lengthOfLife);

        System.out.println("Введите размер неона (до 4 см): ");
        int size = CheckValue.readIntegerInRange(1, 4);
        neon.setSize(size);

        System.out.println("Введите яркость неона: ");
        String brightness = CheckValue.readNonEmptyString();
        neon.setBrightness(brightness);

        return neon;
    }

    public static Swordtail addSwordtail() {
        Swordtail swordtail = new Swordtail("", 0, 0, "");

        System.out.println("\nВведите имя меченосца: ");
        String name = CheckValue.readNonEmptyString();
        swordtail.setName(name);

        System.out.println("Введите продолжительность жизни меченосца (до 5 лет): ");
        int lengthOfLife = CheckValue.readIntegerInRange(1, 5);
        swordtail.setLengthOfLife(lengthOfLife);

        System.out.println("Введите размер меченосца (до 15 см): ");
        int size = CheckValue.readIntegerInRange(1, 15);
        swordtail.setSize(size);

        System.out.println("Введите форму хвоста меченосца: ");
        String tailShape = CheckValue.readNonEmptyString();
        swordtail.setTailShape(tailShape);

        return swordtail;
    }

    public static Goldfish addGoldfish() {
        Goldfish goldfish = new Goldfish("", 0, 0, "");

        System.out.println("\nВведите имя золотой рыбки: ");
        String name = CheckValue.readNonEmptyString();
        goldfish.setName(name);

        System.out.println("Введите продолжительность жизни золотой рыбки (до 30 лет): ");
        int lengthOfLife = CheckValue.readIntegerInRange(1, 30);
        goldfish.setLengthOfLife(lengthOfLife);

        System.out.println("Введите размер золотой рыбки (до 30 см): ");
        int size = CheckValue.readIntegerInRange(1, 30);
        goldfish.setSize(size);

        System.out.println("Введите цвет золотой рыбки: ");
        String color = CheckValue.readNonEmptyString();
        goldfish.setColor(color);

        return goldfish;
    }

    public static Gourami addGourami() {
        Gourami gourami = new Gourami("", 0, 0, "");

        System.out.println("\nВведите имя гурами: ");
        String name = CheckValue.readNonEmptyString();
        gourami.setName(name);

        System.out.println("Введите продолжительность жизни гурами (до 6 лет): ");
        int lengthOfLife = CheckValue.readIntegerInRange(1, 6);
        gourami.setLengthOfLife(lengthOfLife);

        System.out.println("Введите размер гурами (до 12 см): ");
        int size = CheckValue.readIntegerInRange(1, 12);
        gourami.setSize(size);

        System.out.println("Введите вид гурами: ");
        String species = CheckValue.readNonEmptyString();
        gourami.setSpecies(species);

        return gourami;
    }
}
