public class Q10ValidateIPAddress {
    public static void main(String[] args) {
        String[] ipAddresses = {"192.168.1.1", "255.255.255.255", "256.100.10.10", "192.168.1"};
        String regex = "^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$";

        for (String ip : ipAddresses) {
            boolean isValid = ip.matches(regex);
            System.out.println(ip + " -> " + (isValid ? "Valid" : "Invalid"));
        }
    }
}