
public class Vehicle {
    private final int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;   // car, truck, suv, van
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin,
                   int year,
                   String make,
                   String model,
                   String vehicleType,
                   String color,
                   int odometer,
                   double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // -------- getters & setters --------
    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int y) {
        year = y;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String m) {
        make = m;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String m) {
        model = m;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String t) {
        vehicleType = t;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        color = c;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int o) {
        odometer = o;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }

    @Override
    public String toString() {
        return String.format("%5d | %-4d | %-10s | %-10s | %-5s | %-6s | %7d | $%,8.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }

    /**
     * Pipe-delimited serialization used by DealershipFileManager
     */
    public String toFileString() {
        return vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" +
                color + "|" + odometer + "|" + price;
    }
}
