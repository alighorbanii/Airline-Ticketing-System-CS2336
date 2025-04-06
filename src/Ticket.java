/**
 * This is the abstract base class that defines the structure of the other 4 child ticket classes. It includes lists for choices
 * and upgrades, and subclasses methods for getting the ticket clas and complimentary perks.
 */


import java.util.ArrayList; // Used for dynamic arrays
import java.util.List;      // For list structure

// This is the abstract class for all other ticket types (Steerage, Coach, Business, and First)
// It also implements Comparable<Ticket> to sort tickets using Collections.sort()
public abstract class Ticket implements Comparable<Ticket> {

    protected List<String> choices = new ArrayList<>(); // This list stores any optional features the user chooses for their ticket

    protected List<String> upgrades = new ArrayList<>(); // This list stores the upgrades the user might choose

    public abstract String getUserClass(); // Abstract method every child class will use, that returns the class name of the ticket

    public abstract List<String> getCompPerks(); // Abstract method every child class will use, returns what complimentary perks the ticket comes with

    // Returns the list of optional choices the user chose
    public List<String> getChoices() {
        return choices;
    }

    // Returns the list of upgrades the user chose
    public List<String> getUpgrades() {
        return upgrades;
    }

    // Calculates how many total extras the ticket has (choices + upgrades)
    // Tickets are sorted by passenger class (Steerage < Coach < Business < First), and then by the number of extras chosen
    public int getChoiceCount() {
        return choices.size() + upgrades.size();
    }

    // This method assigns a numeric rank to each class so they can be compared in the compareTo() method
    // to determine which ticket is "higher"
    public int getClassRank() {
        if (getUserClass().equalsIgnoreCase("Steerage")) return 0;
        if (getUserClass().equalsIgnoreCase("Coach")) return 1;
        if (getUserClass().equalsIgnoreCase("Business")) return 2;
        if (getUserClass().equalsIgnoreCase("First")) return 3;
        return 99; // This acts as a fallback in case an unknown class is used
    }

    // This method compares the current ticket with another ticket
    // Allows Collections.sort() to sort Ticket objects
    @Override
    public int compareTo(Ticket other) {
        // Comparing by class rank
        int rank1 = this.getClassRank();
        int rank2 = other.getClassRank();

        if (rank1 != rank2) {
            // If the classes are different, sort by class rank
            return Integer.compare(rank1, rank2);
        } else {
            // If class is the same, sort by number of extras
            return Integer.compare(this.getChoiceCount(), other.getChoiceCount());
        }
    }
}

