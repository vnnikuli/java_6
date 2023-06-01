package homework6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Модель 1", 8, 500, "Windows", "Черный"));
        laptops.add(new Laptop("Модель 2", 16, 1000, "Linux", "Серый"));
        laptops.add(new Laptop("Модель 3", 8, 1000, "Windows", "Синий"));

        // Запрашиваем критерии фильтрации
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> criteria = new HashMap<>();

        System.out.println("Выберите цифру:");
        System.out.println("1 - amountRAM");
        System.out.println("2 - hardDiskCapacity");
        System.out.println("3 - operatingSystem");
        System.out.println("4 - color");

        int selectedCriteria = scanner.nextInt();
        Object minimumValue;

        switch (selectedCriteria) {
            case 1:
                System.out.println("Минимальный объем ОЗУ:");
                minimumValue = scanner.nextInt();
                criteria.put(selectedCriteria, minimumValue);
                break;
            case 2:
                System.out.println("Минимальный объем ЖД:");
                minimumValue = scanner.nextInt();
                criteria.put(selectedCriteria, minimumValue);
                break;
            case 3:
                System.out.println("Операционная система:");
                minimumValue = scanner.next();
                criteria.put(selectedCriteria, minimumValue);
                break;
            case 4:
                System.out.println("Цвет:");
                minimumValue = scanner.next();
                criteria.put(selectedCriteria, minimumValue);
                break;
            default:
                System.out.println("Неверно");
                return;
        }
        Set<Laptop> filteredLaptops = filterLaptops(laptops, criteria);

        // Вывод отфильтрованных ноутбуков
        System.out.println("Результат ");
        for (Laptop laptop : filteredLaptops) {
            System.out.println("Модель: " + laptop.getModel());
            System.out.println("ОЗУ: " + laptop.getAmountRAM());
            System.out.println("Объем ЖД: " + laptop.getHardDiskCapacity());
            System.out.println("Операционная система: " + laptop.getOperatingSystem());
            System.out.println("Цвет: " + laptop.getColor());
            System.out.println();
        }
    }

    // Метод для фильтрации ноутбуков
    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, Object> criteria) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean matchesFilter = true;

            for (Map.Entry<Integer, Object> entry : criteria.entrySet()) {
                int criteriaKey = entry.getKey();
                Object minimumValue = entry.getValue();

                switch (criteriaKey) {
                    case 1:
                        if (laptop.getAmountRAM() < (int) minimumValue) {
                            matchesFilter = false;
                        }
                        break;
                    case 2:
                        if (laptop.getHardDiskCapacity() < (int) minimumValue) {
                            matchesFilter = false;
                        }
                        break;
                    case 3:
                        if (!laptop.getOperatingSystem().equals(minimumValue)) {
                            matchesFilter = false;
                        }
                        break;
                    case 4:
                        if (!laptop.getColor().equals(minimumValue)) {
                            matchesFilter = false;
                        }
                        break;
                    default:
                        System.out.println("Неверно");
                        return filteredLaptops;
                }
            }

            if (matchesFilter) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

}
