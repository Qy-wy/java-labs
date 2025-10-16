package lab1.liyts.varB1;

public class MainApplication {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;

        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
            } else if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);
            } else if (parts[0].equals("Tea")) {
                breakfast[itemsSoFar] = new Tea(parts[1]);
            }
            itemsSoFar++;
        }

        for (Food item : breakfast) {
            if (item != null)
                item.consume();
            else
                break;
        }

        Apple targetApple1 = new Apple("большое");
        Apple targetApple2 = new Apple("маленькое");
        Tea targetTea1 = new Tea("черный");
        Tea targetTea2 = new Tea("зеленый");
        Cheese targetCheese = new Cheese();

        int appleCount1 = countEqualFoods(breakfast, targetApple1);
        int appleCount2 = countEqualFoods(breakfast, targetApple2);
        int teaCount1 = countEqualFoods(breakfast, targetTea1);
        int teaCount2 = countEqualFoods(breakfast, targetTea2);
        int cheeseCount = countEqualFoods(breakfast, targetCheese);

        System.out.println("Яблок размера большое: " + appleCount1);
        System.out.println("Яблок размера маленькое: " + appleCount2);
        System.out.println("Чая цвета черный: " + teaCount1);
        System.out.println("Чая цвета зеленый: " + teaCount2);
        System.out.println("Сыра: " + cheeseCount);

        System.out.println("Всего хорошего!");
    }

    public static int countEqualFoods(Food[] breakfast, Food target) {
        int count = 0;
        for (Food item : breakfast) {
            if (item != null && item.equals(target)) {
                count++;
            }
        }
        return count;
    }
}

