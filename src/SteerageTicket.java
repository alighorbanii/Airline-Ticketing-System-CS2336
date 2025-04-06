/**
 * This class is a child class of Ticket and extends.
 * This class represents the lowest tier of ticket class. Passengers in this class will be sitting comfortably in the cargo hold!
 * It also allows the user to choose if they want to sit on the cargo for an additional fee, if not, they can sit nicely on the floor!
 */

import java.util.Arrays;
import java.util.List;

// Extends the abstract Ticket class and fills in the methods
public class SteerageTicket extends Ticket {
    //Constructor for Steerage. Uses boolean, true if user wants to sit on the cargo
    public SteerageTicket(boolean sitOnDaCargo) {
        if (sitOnDaCargo) {
            choices.add("Sit on cargo (additional fee)"); // Using .add so its added into their ticket choices
        }
    }

    // Method to sort ticket by class. Telling system that this ticket class is Steerage
    @Override
    public String getUserClass() {
        return "Steerage Class";
    }

    // Steerage doesn't have any complimentary perks (cheap airline) so it returns an empty list.
    @Override
    public List<String> getCompPerks() {
        return Arrays.asList();
    }
}
