package test_data.computer;

public class ComputerData {
    private final String processorType;
    private final String ram;
    private final String hdd;
    private final String software;
    private final String os;

    public ComputerData(String processorType, String ram, String hdd, String os, String software) {
        this.processorType = processorType;
        this.ram = ram;
        this.hdd = hdd;
        this.software = software;
        this.os = os;
    }

    public String getSoftware() {
        return software;
    }

    public String getHdd() {
        return hdd;
    }

    public String getRam() {
        return ram;
    }

    public String getProcessorType() {
        return processorType;
    }

    public String getOS() {
        return os;
    }

    @Override
    public String toString() {
        return "ComputerData{" +
                "processorType='" + processorType + '\'' +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", os='" + os + '\'' +
                ", software='" + software + '\'' +
                '}';
    }

}
