public class ProductItem extends Item{
    private int amount;
    private float pricePerUnit;

    /**
     * @param amount the quantity of the product
     * @param pricePerUnit costs per product
     * @param description specification of the productItem
     */
    public ProductItem(int amount, float pricePerUnit, String description){
        super(description);
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    /**
     * @return price
     */
    public float getTotalPrice(){
        return amount * pricePerUnit;
    }

    /**
     * Print ProducItem
     */
    public void print(){
        super.print();
        System.out.println("\tAnzahl: " + amount + "\tStückpreis: " + pricePerUnit);
    }
}
