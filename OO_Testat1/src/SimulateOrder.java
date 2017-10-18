public class SimulateOrder {
    public static void main(String[] args) {
        //Create new ProductItems
        ProductItem book = new ProductItem(5, 35.50f, "Book");
        ProductItem calculator = new ProductItem(7, 45.50f, "Calculator");

        //Create new ServiceItems
        ServiceItem roomDecoration = new ServiceItem("Roomdecoration", 750);
        ServiceItem installNetwork = new ServiceItem("Networkinstallation", 320);

        //Print ProductItems
        System.out.println("\nProductItems:");
        book.print();
        calculator.print();

        //Print ServiceItems
        System.out.println("\nServiceItems:");
        roomDecoration.print();
        installNetwork.print();

        //Create new Order and Print OrderPrice
        Order order1 = new Order(new Item[]{roomDecoration, book});
        Order order2 = new Order(new Item[]{installNetwork, calculator });

        //Print Order and OrderPrice
        order1.printItems();
        System.out.println("Total: " + order1.getTotalPrice());
        order2.printItems();
        System.out.println("Total: " + order2.getTotalPrice());

        //Create BundleItem
        BundleItem bundleItem1 = new BundleItem(new Item[]{roomDecoration, calculator}, "Rabattbundle", 40);
        BundleItem bundleItem2 = new BundleItem(new Item[]{installNetwork, book}, "Rabattbundle 2", 30);

        //Print BundleItem
        bundleItem1.print();
        bundleItem2.print();

    }
}
