package test_data.computer;

public class ComputerData {
    private String processorType;
    private String ram;
    private String hdd;
    private String software;
    private String os;


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
