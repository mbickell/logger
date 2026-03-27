import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
  String filename = "app.log";

  @Override
  public void log(String message) {
    try (FileWriter fileWriter = new FileWriter(filename, true)) {
      fileWriter.write("[INFO] " + message + "\n");
    } catch (IOException e) {
      logError("An error occurred.");
      e.printStackTrace();
    }
  }

  @Override
  public void logError(String message) {
    try (FileWriter fileWriter = new FileWriter(filename, true)) {
      fileWriter.write("[ERROR] " + message + "\n");
    } catch (IOException e) {
      logError("An error occurred.");
      e.printStackTrace();
    }
  }
}
