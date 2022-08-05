import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPFinder {

    public static String getIP() {
        try {
            Enumeration<NetworkInterface> NICs = NetworkInterface.getNetworkInterfaces();
            while (NICs.hasMoreElements()) {
                NetworkInterface NIC = NICs.nextElement();
                Enumeration<InetAddress> IPs = NIC.getInetAddresses();
                while (IPs.hasMoreElements()) {
                    InetAddress IP = IPs.nextElement();
                    if (IP instanceof java.net.Inet4Address) {
                        if (IP.toString().startsWith("/192")) {
                            return IP.toString();
                        }
                    }
                }
            }
        } catch (SocketException e4) {
            System.err.println("Error: getNetworkInterfaces() failed: " + e4);
        }
        System.out.println("IP is not found.");
        return null;
    }
}
