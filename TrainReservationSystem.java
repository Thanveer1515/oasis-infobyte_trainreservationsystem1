import java.util.HashMap;
import java.util.Scanner;

public class TrainReservationSystem {
    static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        users.put("user1", "pass1");
        users.put("user2", "pass2");

        Scanner sc = new Scanner(System.in);
        if (login(sc)) {
            while (true) {
                System.out.println("📋 MENU:");
                System.out.println("1. Reserve Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> reserveTicket(sc);
                    case 2 -> cancelTicket(sc);
                    case 3 -> {
                        System.out.println("👋 Thank you for using the reservation system!");
                        return;
                    }
                    default -> System.out.println("⚠️ Invalid option. Try again.");
                }
            }
        } else {
            System.out.println("❌ Access Denied.");
        }
        sc.close();
    }

    public static boolean login(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("✅ Login successful!\n");
            return true;
        }
        return false;
    }

    public static void reserveTicket(Scanner sc) {
        System.out.println("📝 Enter Reservation Details:");

        System.out.print("Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Train Number: ");
        String trainNo = sc.nextLine();
        System.out.print("Class Type (e.g., Sleeper, AC): ");
        String classType = sc.nextLine();
        System.out.print("Journey Date: ");
        String date = sc.nextLine();
        System.out.print("Destination: ");
        String destination = sc.nextLine();

        String trainName = "Express Line"; // Placeholder

        System.out.println("\n🧾 Reservation Summary:");
        System.out.println("Name: " + name);
        System.out.println("Train No: " + trainNo);
        System.out.println("Train Name: " + trainName);
        System.out.println("Class: " + classType);
        System.out.println("Date: " + date);
        System.out.println("Destination: " + destination);
        System.out.println("✅ Reservation successful!\n");
    }

    public static void cancelTicket(Scanner sc) {
        System.out.print("Enter PNR Number: ");
        String pnr = sc.nextLine();
        System.out.println("🔍 Searching for PNR: " + pnr);
        System.out.print("Do you want to cancel? (yes/no): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            System.out.println("❌ Ticket Cancelled Successfully.\n");
        } else {
            System.out.println("ℹ️ Cancellation Aborted.\n");
        }
    }
}
