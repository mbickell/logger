public class ConsoleLogger implements Logger {
  @Override
  public void log(String message) {
    System.out.println("[INFO] " + message);
  }

  @Override
  public void logError(String message) {
    System.out.println("[ERROR] " + message);
  }
}
