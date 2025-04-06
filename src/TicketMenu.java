/**
 * This class contains the full menu interface and user interaction methods. It handles tickets, prompting, and storing user
 * options into lists. Also includes methods of sorting results for the display.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections; // For sorting the tickets using compareTo()

// This class handles the entire menu system and user interaction
public class TicketMenu {

    // List that stores all Ticket objects created by the user
    private final List<Ticket> tickets = new ArrayList<>();

    // Scanner to take input from the user in the console
    private final Scanner scanner = new Scanner(System.in);


    // Starts the menu interaction loop for the user. IT STARTS DA CODE!!
    // Displays a menu and reads the user's input
    // Based on the user's choice, it calls different methods or prints different lists
    public void startDaCode() {
        while (true) {
            // Display the main menu options
            System.out.println("\n===============================================");
            System.out.println("|              Ghost Airways Menu             |");
            System.out.println("|=============================================|");
            System.out.println("| 1.  Add a new ticket                        |");
            System.out.println("| 2.  Display all tickets                     |");
            System.out.println("| 3.  Show Thrill Seeker tickets              |");
            System.out.println("| 4.  Show Wingman tickets                    |");
            System.out.println("| 5.  Show basic tickets (no extras)          |");
            System.out.println("| 6.  Exit                                    |");
            System.out.println("===============================================");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine(); // Reads user input

            // If user selects 1, call method to add a new ticket
            if (choice.equals("1")) {
                addTicket();
            }
            // If user selects 2, display all tickets with sorting
            else if (choice.equals("2")) {
                displayAll(); // displays all of the users tickets
            }
            // If user selects 3, show tickets that include the Thrill Seeker upgrade
            else if (choice.equals("3")) {
                System.out.println("Tickets with Thrill Seeker upgrade:");
                for (Ticket t : tickets) { // loop through all tickets
                    if (t.getUpgrades().contains("Thrill Seeker")) { // check if upgrades list includes the Thrill Seeker upgrade
                        OrganizeDisplay.printTicket(t); // displays the ticket by calling the OrganizeDisplay class
                    }
                }
            }
            // If user selects 4, show tickets that include the Wingman upgrade
            else if (choice.equals("4")) {
                System.out.println("Tickets with Wingman upgrade:");
                for (Ticket t : tickets) {
                    if (t.getUpgrades().contains("Wingman")) {
                        OrganizeDisplay.printTicket(t);
                    }
                }
            }
            // If user selects 5, show tickets that have no upgrades and no choices (i.e basic tickets)
            else if (choice.equals("5")) {
                System.out.println("Tickets with no extras:");
                for (Ticket t : tickets) {
                    // Check if this ticket has no choices or upgrades using isEmpty()
                    if (t.getChoices().isEmpty() && t.getUpgrades().isEmpty()) {
                        OrganizeDisplay.printTicket(t);
                    }
                }
            }
            // If user selects 6, exit the loop and end the program
            else if (choice.equals("6")) {
                System.out.println("Thank you for flying with Ghost Airways! Pray you make it alive! :)");
                break;
            }
            // If input is invalid (not 1–6), show error message
            else {
                System.out.println("Invalid input. Please enter 1–6.");
            }
        }
    }

    // Handles creation of a new ticket and Prompts the user to select ticket class and optional features/upgrades
    // Based on user inputs, constructs the proper Ticket object and adds it to the list
    private void addTicket() {
        // Show ticket class options
        System.out.println("\nSelect passenger class:");
        System.out.println("1. Steerage Class");
        System.out.println("2. Coach Class");
        System.out.println("3. Business Class");
        System.out.println("4. First Class");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();

        // This will store the new Ticket object
        Ticket ticket = null;

        // Depending on which class the user chose, ask for the extra options
        if (choice.equals("1")) {
            System.out.print("Would you like to sit on super comfy cargo for an additional fee? (y/n): ");
            boolean sitOnDaCargo = scanner.nextLine().equals("y"); // true if input is "y"
            ticket = new SteerageTicket(sitOnDaCargo); // creates new ticket
        } else if (choice.equals("2")) {
            System.out.print("Would you like to have access to the handrail for an additional fee? (y/n): ");
            boolean handrail = scanner.nextLine().equals("y");
            System.out.print("Will you be bringing only 1 carry-on bag for an additional fee? (y/n): ");
            boolean carryOn = scanner.nextLine().equals("y");
            ticket = new CoachTicket(handrail, carryOn);
        } else if (choice.equals("3")) {
            System.out.print("Would you like a window or aisle seat for an additional fee? (y/n): ");
            boolean window = scanner.nextLine().equals("y");
            System.out.print("Would you like overhead bin storage for an additional fee? (y/n): ");
            boolean overheadStorage = scanner.nextLine().equals("y");
            ticket = new BusinessTicket(window, overheadStorage);
        } else if (choice.equals("4")) {
            System.out.print("Would you like to pretend that you're a pilot and add yoke and rudder pedals for an additional fee? (y/n): ");
            boolean flightInstruments = scanner.nextLine().equals("y");
            ticket = new FirstTicket(flightInstruments);
        } else {
            // Invalid number entered for class selection
            System.out.println("Invalid class.");
            return; // cancel and exit this method
        }

        // Ask if user wants the Thrill Seeker upgrade and add it if yes
        System.out.print("Would you like the super safe Thrill Seeker upgrade for an additional fee? (y/n): ");
        if (scanner.nextLine().equals("y")) {
            ticket.getUpgrades().add("Thrill Seeker");
        }

        // Ask if user wants the Wingman upgrade
        System.out.print("Would you like the very fun and safe Wingman upgrade for an additional fee? (y/n): ");
        if (scanner.nextLine().equals("y")) {
            ticket.getUpgrades().add("Wingman");

            // If Wingman upgrade is added, ask if user wants to select a wing side
            System.out.print("Would you like to choose which wing upon arrival for an additional fee? (y/n): ");
            if (scanner.nextLine().equals("y")) {
                ticket.getChoices().add("Select wing side");
            }
        }

        // Add the completed ticket object to the main ticket list
        tickets.add(ticket);
        System.out.println("Ticket added successfully.");
    }

    // Displays all the tickets currently in the system and sorts the tickets using compareTo() method in the Ticket class
    // Then it loops through the list and prints each ticket
    private void displayAll() {
        // If no tickets exist, notify the user
        if (tickets.isEmpty()) {
            System.out.println("No tickets purchased yet.");
            return;
        }

        // Sort tickets using compareTo() defined in Ticket (by class, then extras)
        Collections.sort(tickets);

        // Loop through each ticket and print it using the OrganizeDisplay class
        for (Ticket t : tickets) {
            OrganizeDisplay.printTicket(t);
        }
    }
}
