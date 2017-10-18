public class Item {
    private String description;

    /**
     * @param description specification of the item
     */
    public Item(String description) {
        this.description = description;
    }

    /**
     * @return price
     */
    public float getTotalPrice(){
        return 0;
    }

    /**
     * Print Item
     */
    void print(){
        System.out.print("\tItem: " + description + "\tPrice: " + Math.round(getTotalPrice() * 100f) / 100f);
    }
}
