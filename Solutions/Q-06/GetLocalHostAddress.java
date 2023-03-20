// By - Kaustav Purkayastha ( Gurucharan University, Silchar - @ Department of Computer Science )

// 6. Write a program to find the address of the local machine.


import java.net.*;

public class GetLocalHostAddress {
    public static void main(String[] args) throws UnknownHostException {

        // Getting the InetAddress of the local machine
        InetAddress localhost = InetAddress.getLocalHost();

        // Printing the IP address of the local machine
        System.out.println("Address of the local machine: " + localhost.getHostAddress());
    }
}