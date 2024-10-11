package bidblitz;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Event {
    private final int id;
    private final String name;
    private int lowestBid;
    private Member lowestBidPlacedMember;
    private final Date dateOfTheEvent;
    private final Map<Member, int[]> membersParticipated;

    public Event(int id, Date dateOfTheEvent, String name) {
        this.id = id;
        this.dateOfTheEvent = dateOfTheEvent;
        this.name = name;
        lowestBid = (int)1e9;
        lowestBidPlacedMember = null;
        membersParticipated = new HashMap<>();
    }

    private boolean isMemberValidToSubmitBid(Member member, int[] bids) {
        // check if member reg for event
        if(!membersParticipated.containsKey(member)) {
            System.out.println("Member did not registered for this event");
            return false;
        }
        // check already submitted
        if(membersParticipated.get(member) != null) {
            System.out.println("You have already submmited your bid. You cannot submit more than once!");
            return false;
        }
        //check unqiue bids
        int bidsSize = bids.length;
        if(bidsSize > 5 && bidsSize < 0) {
            System.out.println("You can only place 1 to 5 bids. Please re-submit it!");
            return false;
        }
        Arrays.sort(bids);
        for(int i = 1; i < bidsSize; i++) {
            if(bids[i - 1] == bids[i]) {
                System.out.println("You bids contains Duplicates. Please submit unique bids!");
                return false;
            }
            if(bids[i - 1] <= 0 || bids[i] <= 0) {
                System.out.println("Please submit bids with value greater than 0");
                return false;
            }
        }
        // check maxBid Value
        if(member.getSuperCoins() < bids[bidsSize - 1]) {
            System.out.println("You don't have enough super coins to bid");
            return false;
        }
        return true;
    }

    public void submitBid(Member member, int[] bids) {
        if(!isMemberValidToSubmitBid(member, bids)) return;
        
        if(bids[0] < lowestBid) {
            lowestBid = bids[0];
            lowestBidPlacedMember = member;
        }

        membersParticipated.put(member, bids);
    }

    public void registerForEvent(Member member) {
        if(membersParticipated.containsKey(member)) {
            System.out.println("Member already registered for this event");
            return;
        }
        membersParticipated.put(member, null);
    }

    public void declareWinner() {
        if(lowestBidPlacedMember == null) {
            System.out.println("No winner! No bids placed by any member");
            return;
        }
        int[] winnerBids = membersParticipated.get(lowestBidPlacedMember);
        lowestBidPlacedMember.setSuperCoins(lowestBidPlacedMember.getSuperCoins() - winnerBids[winnerBids.length - 1]);
        System.out.println("The winner is: "+  lowestBidPlacedMember.getName());
    }

    public String getName() {
        return name;
    }

    public int getLowestBid() {
        return lowestBid;
    }

    public void setLowestBid(int lowestBid) {
        this.lowestBid = lowestBid;
    }

    public Member getLowestBidPlacedMember() {
        return lowestBidPlacedMember;
    }

    public void setLowestBidPlacedMember(Member lowestBidPlacedMember) {
        this.lowestBidPlacedMember = lowestBidPlacedMember;
    }

    public Date getDateOfTheEvent() {
        return dateOfTheEvent;
    }

    public int getId() {
        return id;
    }


}
