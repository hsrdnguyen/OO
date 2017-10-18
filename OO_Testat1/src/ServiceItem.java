public class ServiceItem extends Item{
    private float price;

    /**
     * @param description specification of the serviceItem
     * @param price costs per serviceItem
     */
    public ServiceItem(String description, float price){
        super(description);
        this.price = price;
    }

    /**
     * @return price
     */
    public float getTotalPrice(){
        return price;
    }

    /**
     * Print ServiceItem
     */
    public void print(){
        super.print();
        System.out.println("");
    }
}
