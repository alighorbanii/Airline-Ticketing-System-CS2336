/**
 *This class is a child class of Ticket and extends.
 * This class comes with perks including 1 bathroom pass, 1 held carry-on, and a middle seat. Passengers can also opt to choose if
 * they want a window or aisle seat, and if they want overhead bin storage (comes with a very modest additional fee!)
 */

import java.util.Arrays;
import java.util.List;

// Extends the ticket abstract base class and fills in methods
public class BusinessTicket extends Ticket {

    //Constructor that takes in two boolean values
    // windowSeat: If the user would like a window or aisle seat
    // overheadStorage: whether the user wants to have access to overhead bin storage
    // all for an additional fee :P
    public BusinessTicket(boolean windowSeat, boolean overheadStorage) {
        if (windowSeat) {
            choices.add("Window / aisle seat"); //.add to add the option to the ticket
        }
        if (overheadStorage) {
            choices.add("Overhead bin storage");
        }
    }

    // Returns the type of ticket class
    @Override
    public String getUserClass() {
        return "Business Class";
    }

    // Returns complimentary perks if the user chooses Business as their ticket. These perks come with the ticket, without
    // the very ethical and moral additional fees
    @Override
    public List<String> getCompPerks() {
        return Arrays.asList(
                "Middle seat",
                "1 held carry-on",
                "1 bathroom pass"
        );
    }
}
