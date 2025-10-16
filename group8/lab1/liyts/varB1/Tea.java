package lab1.liyts.varB1;

public class Tea extends Food implements Nutritious {
    private String color;

    public Tea(String color) {
        super("Чай");
        this.color = color;
    }

    public void consume() {
        System.out.println(this + " выпит");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Tea)) return false;
            return color.equals(((Tea) arg0).color);
        } else return false;
    }

    public String toString() {
        return super.toString() + " цвета '" + color.toUpperCase() + "'";
    }

    public int calculateCalories() {
        if (color.equalsIgnoreCase("черный")) return 2;
        if (color.equalsIgnoreCase("зеленый")) return 0;
        return 1;
    }
}
