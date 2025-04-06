/**
 * This class is a child class of Ticket and extends.
 * This class represents the highest tier ticket. This tier includes beverages to share with the pilot, a copilot seat, access to flight
 * instruments, and 2 bathroom passes. Passengers can also opt to choose if they want to have access to yoke and pedals to help the pilot!!
 */

import java.util.Arrays;
import java.util.List;

// Extends the abstract base class Ticket and fills in methods
public class FirstTicket extends Ticket {

    // Constructor with one boolean method
    // flightInstruments: whether the user wants to become a pilot without training or a license!! I ♡ Safety!!
    public FirstTicket(boolean flightInstruments) {
        if (flightInstruments) {
            choices.add("The passenger will pretend that he's a pilot (yoke and pedal access)"); //.add to be added to their ticket
        }
    }

    // Returns the type of ticket class the user chose (first in this case)
    @Override
    public String getUserClass() {
        return "First Class";
    }

    // Returns the complimentary perks that come with the first class ticket
    // These features come with the ticket without additional costs (surprisingly)
    @Override
    public List<String> getCompPerks() {
        return Arrays.asList(
                "Copilot seat",
                "Access to flight instruments",
                "Rootbeer and non-alcoholic wine",
                "2 bathroom passes"
        );
    }
}
