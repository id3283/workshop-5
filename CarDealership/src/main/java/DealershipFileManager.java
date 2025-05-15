
import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {
    private final String fileName;

    public DealershipFileManager(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads inventory.csv -> fully-populated Dealership
     */
    public Dealership getDealership() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Empty file");
            }
            // ---------- first line: dealership info ----------
            String[] info = scanner.nextLine().split("\\|");
            Dealership dealer = new Dealership(info[0], info[1], info[2]);

            // ---------- remaining lines: vehicles ----------
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\\|");
                if (parts.length < 8) {
                    continue;
                } // skip malformed
                Vehicle v = new Vehicle(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2], parts[3], parts[4], parts[5],
                        Integer.parseInt(parts[6]),
                        Double.parseDouble(parts[7]));
                dealer.addVehicle(v);
            }
            return dealer;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read " + fileName, e);
        }
    }

    /**
     * Overwrites inventory.csv with current dealership state
     */
    public void saveDealership(Dealership dealer) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println(dealer.getName() + "|" + dealer.getAddress() + "|" + dealer.getPhone());
            for (Vehicle v : dealer.getAllVehicles()) {
                out.println(v.toFileString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to write " + fileName, e);
        }
    }
}
