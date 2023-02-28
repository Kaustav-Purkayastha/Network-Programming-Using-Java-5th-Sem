
// 6. Write a program to find the address of the local machine.


import java.net.*;

public class GetLocalHostAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("Address of the local machine: " + localhost.getHostAddress());
    }
}