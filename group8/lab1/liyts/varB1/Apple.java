package lab1.liyts.varB1;

public class Apple extends Food implements Nutritious {
    private String size;

    public Apple(String size) {
        super("Яблоко");
        this.size = size;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple) arg0).size);
        } else return false;
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    public int calculateCalories() {
        if (size.equalsIgnoreCase("большое")) return 100;
        if (size.equalsIgnoreCase("маленькое")) return 60;
        return 80;
    }
}

