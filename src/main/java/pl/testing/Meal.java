package pl.testing;

import java.util.Objects;

public class Meal {

    private String name;
    private Double price;

    public Meal(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getDiscountPrice(Double discount) {

        if (discount > this.price) {
            throw new IllegalArgumentException("Discount canot be higher than the price");
        }

        return this.price - discount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(name, meal.name) &&
                Objects.equals(price, meal.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
