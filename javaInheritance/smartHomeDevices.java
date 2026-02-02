package inheritance;

/*
 This program demonstrates single inheritance in a smart home system.
 It models a general Device and a specific Thermostat device.
 The subclass extends functionality by adding specialized attributes.
 The example focuses on clarity and basic object-oriented design.
*/

class BaseDevice {
    int deviceId;
    String status;

    BaseDevice(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() { // displays basic device status
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Thermostat subclass with temperature control feature
class ThermostatDevice extends BaseDevice {
    int temperatureSetting;

    ThermostatDevice(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() { // displays thermostat-specific status
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class to test smart home device inheritance
public class SmartHome {

    public static void main(String[] args) { // program execution starts here
        BaseDevice device = new ThermostatDevice(501, "ON", 24);
        device.displayStatus();
    }
}

