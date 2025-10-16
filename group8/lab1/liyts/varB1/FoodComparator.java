package lab1.liyts.varB1;

import java.util.Comparator;

public class FoodComparator implements Comparator<Food> {
    public int compare(Food arg0, Food arg1) {
        if (arg0 == null && arg1 == null) return 0;
        if (arg0 == null) return 1;
        if (arg1 == null) return -1;
        return Integer.compare(arg0.toString().length(), arg1.toString().length());
    }
}
