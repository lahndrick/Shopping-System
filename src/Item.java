
import java.util.Objects;

/**
 *
 * @author Lahndrick Hendricks
 */
public class Item implements Comparable<Item> {

    private String name;
    private double cost;

    //constructor
    public Item(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    //toString for simple format of "name, $cost"
    @Override
    public String toString() {
        return name + ", $" + cost;
    }

    //overriding hashcode, equals and compareTo methods, to order the set by to name
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Item o) {
        return this.getName().compareTo(o.getName());
    }

}
