public class BundleItem extends Item {
    private float discount;
    private String description;
    private Item[] bundle;

    /**
     * @param bundle items in the bundle
     * @param description specification of the bundleItem
     * @param discount reduction per bundle
     */
    public BundleItem(Item[] bundle, String description, float discount){
        super(description);
        this.bundle = bundle;
        this.description = description;
        this.discount = discount;
    }

    public void printItems(){

        for(Item item : bundle){
            item.print();
        }
    }

    /**
     * Print BundleItem
     */
    public void print(){
        System.out.print("\nBundle: " + description + ", Rabatt: " + discount + "\n");
        printItems();
        System.out.println("Price without Discount: " + getPrice() + "\tRabatt: " + discount);
        System.out.println("Discountprice: " + getTotalPrice());
    }

    /**
     * getPrice for Discount
     * @return getTotalPrice
     */
    public float getTotalPrice(){
        return getPrice() * ((100 - discount) / 100);

    }

    /**
     * getPrice without Discount
     * @return getPrice
     */
    public float getPrice(){
        float totalPrice = 0;
        for(Item item : bundle){
            totalPrice += item.getTotalPrice();
        }
        return Math.round(totalPrice);
    }
}

