/**
 * This java project simulates a ticket purchasing system for an airline called Ghost Airways. Users will have the option
 * to select from 4 passenger classes (steerage, coach, business, and first class). Each class will have optional features that
 * users can select if they want to add to their flight experience, but for an additional fee. There are also two additional flight upgrades
 * that users can choose (Thrill Seeker or Wingman tickets). These upgrades are QUITE the experience.This project also includes methods
 * that store each ticket using a menu and displays the selected tickets of the user in an organized way.
 */

//This class simply creates an instance of the TicketMenu class and starts the menu code by calling the StartDaCode() method
public class Main {
    public static void main(String[] args) {
        TicketMenu menu = new TicketMenu();
        menu.startDaCode();
    }
}