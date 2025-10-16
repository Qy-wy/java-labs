package lab1.liyts.varB1;

public class Cheese extends Food implements Nutritious {
    public Cheese() {
        super("Сыр");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }
    public int calculateCalories() {
        return 200;
    }
}
