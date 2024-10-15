package vendingmachine;

public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addTotalPrice(coin.getValue());
        checkPayment();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addTotalPrice(note.getValue());
        checkPayment();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return.");
    }

    public void checkPayment() {
        if(vendingMachine.getTotalPrice() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
}
