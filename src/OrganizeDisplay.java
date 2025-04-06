/**
 * Contains a static method printTicket() that allows the display to be formated cleanly and displays the ticket's classes, perks,
 * choices, upgrades, and total options selected. It's used to consistently show ticket info.
 */

import java.util.List;

// This class is used to neatly organize the display console
// The class doesn't modify or create anything, it's just to make the display console more organized and look cool when user makes a choice
public class OrganizeDisplay {

    // This method takes a ticket object and print all of its info
    // Info includes class, perks, user choices, upgrades, and the total number of extras chosen
    public static void printTicket(Ticket t) {
        System.out.println("\n================ TICKET INFO ================");
        System.out.println("Class: " + t.getUserClass());

        // Gets the list of complimentary perks provided for the ticket class
        List<String> perks = t.getCompPerks();
        // If there are any perks that come with the ticket (without the morally just fees) , print them
        if (!perks.isEmpty()) {
            System.out.println("Complimentary perks:");
            for (String p : perks) {
                System.out.println("  - " + p);
            }
        }

        // Check if the user selected any optional features (with the morally just fees)
        if (!t.getChoices().isEmpty()) {
            System.out.println("Options:");
            for (String o : t.getChoices()) {
                System.out.println("  - " + o);
            }
        }

        // Check if the user selected the upgrades (wingman or thrill seeker)
        if (!t.getUpgrades().isEmpty()) {
            System.out.println("Upgrades:");
            for (String u : t.getUpgrades()) {
                System.out.println("  - " + u);
            }
        }

        // Print the total number of extras (choices + upgrades)
        System.out.println("Total options selected: " + t.getChoiceCount());
        System.out.println("=============================================");
    }
}

