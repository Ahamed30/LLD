package bidblitz;

public class BidBlitzSystemDemo {
    // @SuppressWarnings("deprecation")
    public static void run() {
        BidBlitzSystem bidBlitzSystemInstance = BidBlitzSystem.getInstance();

        Member akshay = bidBlitzSystemInstance.registerMember("akshay", 10000);
        Member chris = bidBlitzSystemInstance.registerMember("chris", 5000);
        Member henry = bidBlitzSystemInstance.registerMember("henry", 5000);

        Event event1 = bidBlitzSystemInstance.addEvent("BBD IPHONE-14","2023-06-06");
        // Event event2 = bidBlitzSystemInstance.addEvent("BBD IPHONE-15","2023-06-06");
        Event event3 = bidBlitzSystemInstance.addEvent("BBD IPHONE-16","2023-06-08");

        bidBlitzSystemInstance.registerForEvent(akshay, event1);
        bidBlitzSystemInstance.registerForEvent(chris, event1);
        bidBlitzSystemInstance.registerForEvent(henry, event3);

        bidBlitzSystemInstance.submitBid(akshay, event1, new int[]{200, 400, 500, 600, 100});
        bidBlitzSystemInstance.submitBid(chris, event1, new int[]{200, 400, 50, 500});
        bidBlitzSystemInstance.submitBid(henry, event1, new int[]{200, 400, 100, 500});

        bidBlitzSystemInstance.declareWinner(event1);

        bidBlitzSystemInstance.listPastWinners();
    }
    public static void main(String[] args) {
        run();
    }
}
