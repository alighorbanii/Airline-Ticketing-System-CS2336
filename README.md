# Airline Passenger Ticketing System – Ghost Airways (CS2336 Project)

This Java-based console program simulates an interactive ticket purchasing system for a fictional airline, Ghost Airways. 
Users can select from four unique (a bit strange) passenger classes, choose optional upgrades (also a bit strange :P ), and view a fully formatted display of their ticket selections. 
The system was designed for a CS2336 (Computer Science II) course project with a strong focus on object-oriented programming, sorting, and user interaction.

---

## Features

- Choose from 4 ticket classes: Steerage, Coach, Business, First
- Optional features with humorous descriptions and additional "fees"
- Thrill Seeker and Wingman upgrades (called wingman because you will be sitting on the wing!!)
- Menu-driven console interface
- Ticket sorting by class and extras (using `compareTo`)
- Display ticket details in a clean, styled format
- Fully object-oriented: abstract base class + 4 child classes
- Uses `Collections.sort()` for sorting tickets

---

## How to Run
- Java 11 or higher

---

## File Overview

| File Name             | Purpose |
|-----------------------|---------|
| `Main.java`           | Entry point of the program — runs the menu |
| `TicketMenu.java`     | Handles menu UI, ticket creation, upgrades, sorting |
| `Ticket.java`         | Abstract base class defining ticket structure |
| `SteerageTicket.java` | Lowest tier ticket class |
| `CoachTicket.java`    | Mid-tier class with basic features |
| `BusinessTicket.java` | Premium class with perks |
| `FirstTicket.java`    | Top-tier ticket class with luxury options |
| `OrganizeDisplay.java`| Formats and prints ticket details nicely |

---

## Concepts Used

- Inheritance & Polymorphism
- Abstract Classes
- Custom `compareTo()` Implementation
- Collections & Lists
- Encapsulation
- Scanner I/O
- Modular Design

---

## Author

**Ali Ghorbani**  
Student – University of Texas at Dallas  
CS2336: Computer Science II – Spring 2025  
GitHub: [@alighorbanii](https://github.com/alighorbanii)

---


