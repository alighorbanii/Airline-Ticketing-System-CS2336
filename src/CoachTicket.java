/**
 * This class is a child class of Ticket and extends.
 * This class offers passengers to choose to stand comfortably by holding onto the handrail, and if they want to bring only
 * 1 carry-on bag (all with an additional fee)
 */

import java.util.Arrays;
import java.util.List;

// Extends the ticket abstract base clas and includes methods
public class CoachTicket extends Ticket {

    // Constructor that takes two boolean values
    // handrail: if the user wants to hold onto the handrail, true if they do
    // CarryOn: If the user wants to bring a carry-on, true if they do
    public CoachTicket(boolean handrail, boolean carryOn) {
        if (handrail) {
            choices.add("Passenger will hold onto the handrail!"); // Using .add so its added into their ticket choices
        }
        if (carryOn) {
            choices.add ("Passenger will bring 1 carry-on!");
        }
    }

    // returns the class name of ticket
    @Override
    public String getUserClass() {
        return "Coach Class";
    }

    // Coach class does not include any perks (Ghost is a cheap airline) so return an empty list
    @Override
    public List<String> getCompPerks() {
        return Arrays.asList();
    }
}
