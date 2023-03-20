// By - Kaustav Purkayastha ( Gurucharan University, Silchar - @ Department of Computer Science )

// 9. Write a program to implement following methods:
//  -  public String getHostName()
//  -  public byte[] getAddress()
//  -  public String getHostAddress()


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

class InetMethodsDemonstration {
    public static void main(String[] args) throws UnknownHostException {
        // Creating a Scanner object to read the input from user
        Scanner sc = new Scanner(System.in);

        // Getting the local host InetAddress object
        InetAddress local = InetAddress.getLocalHost();

        // Printing the Host Name and Host Address of the local host
        System.out.println("Host Name: "+local.getHostName());
        System.out.println("Host Address: "+local.getHostAddress());

        // Asking the user to enter a valid URL and reading the input
        System.out.print("\nEnter a valid URL:  ");
        String url = sc.next();

        // Getting the InetAddress object for the given URL
        InetAddress host = InetAddress.getByName(url);

        // Getting the byte array of the IP address of the given URL
        byte []addressBytes = host.getAddress();

        // Printing the byte array of the IP address of the given URL
        System.out.println(Arrays.toString(addressBytes));
    }    
}