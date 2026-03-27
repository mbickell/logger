import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Logger logger = selectLogger();

        logger.log("Application started");

        logger.logError("Failed to load optional plugin 'analytics.jar' — skipping");

        if (logger instanceof FileLogger) {
            System.out.println("\nDone! Check app.log in the project root for the output.");
        }
    }

    private static Logger selectLogger() {
        System.out.println("Choose a logger:");
        System.out.println("  1 - Console Logger");
        System.out.println("  2 - File Logger  (writes to app.log)");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        // The reference type is the interface — the concrete object is
        // determined at runtime based on the user's choice.
        Logger logger;
        switch (input) {
            case "1" -> {
                logger = new ConsoleLogger();
                System.out.println("Using ConsoleLogger\n");
            }
            case "2" -> {
                logger = new FileLogger();
                System.out.println("Using FileLogger — output goes to app.log\n");
            }
            default -> {
                System.out.println("Invalid choice. Falling back to ConsoleLogger.\n");
                logger = new ConsoleLogger();
            }
        }
        scanner.close();
        return logger;
    }
}