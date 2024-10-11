package bidblitz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BidBlitzSystem {
    private static BidBlitzSystem instance;
    private final List<Member> members;
    private final List<Event> events;
    private int totalEventsConducted;

    private BidBlitzSystem() {
        this.members = new ArrayList<>();
        this.events = new ArrayList<>();
        this.totalEventsConducted = 0;
    }

    public static BidBlitzSystem getInstance() {
        if(instance == null) {
            instance = new BidBlitzSystem();
        }
        return instance;
    }

    private boolean isValidEvent(String name, Date eventDate) {
        for(Event event: events) {
            if(event.getName().equals(name)) {
                System.out.println(name+" event name already exists, please use different name");
                return false;
            }
        }
        int eventsSize = events.size();
        if(eventsSize > 0 && eventDate.compareTo(events.get(eventsSize - 1).getDateOfTheEvent()) == 0) {
            System.out.println("Sorry! there is already ongoing event today, please try tomorrow");
            return false;
        }
        return true;
    }

    public Event addEvent(String name, String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date eventDate = formatter.parse(date);
            System.out.println(eventDate);
            //check unique name and no events present in the day
            if(!isValidEvent(name, eventDate)) return null;
            
            Event newEvent = new Event(totalEventsConducted + 1, eventDate, name);
            events.add(newEvent);
            totalEventsConducted += 1;
            System.out.println(name+" event added successfully");
            return newEvent;
        } catch (ParseException ex) {
            System.out.println("Not a valid date!");
            return null;
        }
    }

    public void registerForEvent(Member member, Event event) {
        event.registerForEvent(member);
    } 

    public Member registerMember(String name, int superCoins) {
        Member member = new Member(members.size() + 1, name, superCoins);
        members.add(member);
        return member;
    }

    public void submitBid(Member member, Event event, int[] bids) {
        event.submitBid(member, bids);
    }

    public void declareWinner(Event event) {
        event.declareWinner();
    }

    public void listPastWinners() {
        int eventsSize = events.size();
        for(int i = eventsSize - 2; i >= 0; i--) {
            Event event = events.get(i);
            System.out.println(event.getId()+ " "+ event.getLowestBidPlacedMember().getName()+" "+event.getLowestBid()+" "+event.getDateOfTheEvent());
        }
    }
}
