public class Order {
    private Item[] order;

    /**
     * @param order amount of items inside the order
     */
    public Order(Item[] order){
        this.order = order;
    }

    /**
     * @return totalPrice
     */
    public float getTotalPrice(){
        float totalPrice = 0;
        for(Item item : order){
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }

    /**
     * Iterator for printItems
     */
    public void printItems(){
        System.out.println("\nOrder:");
        for(Item item : order){
            item.print();
        }

    }
}
