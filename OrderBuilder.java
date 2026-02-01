package jmockitunexpectedinvocation;

public class OrderBuilder {

    public OrderBuilder selectItem(String item) {
        System.out.println("Item selected: " + item);
        return this;
    }

    public OrderBuilder applyDiscount(int percent) {
        System.out.println("Discount applied: " + percent);
        return this;
    }

    public Order build() {
        return new Order();
    }
}
