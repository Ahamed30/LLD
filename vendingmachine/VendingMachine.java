package vendingmachine;

public class VendingMachine {
    private static VendingMachine instance;
    Inventory inventory;
    private final IdleState idleState;
    private final ReadyState readyState;
    private final ReturnChangeState returnChangeState;
    private final DispenseState dispenseState;
    private Product selectedProduct;
    private double totalPrice;
    private VendingMachineState currentState;

    public VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        returnChangeState = new ReturnChangeState(this);
        dispenseState = new DispenseState(this);
        currentState = idleState;
        totalPrice = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if(instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }
    
    public void setState(VendingMachineState vendingMachineState) {
        currentState = vendingMachineState;
    } 

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    public void addTotalPrice(double totalPrice) {
        this.totalPrice += totalPrice;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    } 

    public VendingMachineState getReadyState() {
        return readyState;
    } 

    public VendingMachineState getDispenseState() {
        return dispenseState;
    } 

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    } 

    public void resetPayment() {
        totalPrice = 0.0;
    } 

    public void resetSelectedProduct() {
        selectedProduct = null;
    } 

}