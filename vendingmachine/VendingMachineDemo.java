package vendingmachine;

public class VendingMachineDemo {
    public static void run() {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = new Product("Coke", 12);
        Product pepsi = new Product("Pepsi", 10);
        Product water = new Product("Water", 55);

        vendingMachine.inventory.addProduct(coke, 5);
        vendingMachine.inventory.addProduct(pepsi, 3);
        vendingMachine.inventory.addProduct(water, 2);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coin
        vendingMachine.insertCoin(Coin.TWO);

        // Insert a note
        vendingMachine.insertNote(Note.TEN);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(water);

        // Insert insufficient payment
        vendingMachine.insertNote(Note.TEN);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more note
        vendingMachine.insertNote(Note.FIFTY);
    
        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();
    }

    public static void main(String[] args) {
        run();
    }
}