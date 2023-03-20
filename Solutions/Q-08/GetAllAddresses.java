// By - Kaustav Purkayastha ( Gurucharan University, Silchar - @ Department of Computer Science )

// 8. Write a program that prints all the addresses of www.youtube.com


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GetAllAddresses {
    public static void main(String args[]){

    // Creating a Scanner object to read the input from user
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a valid URL:  ");

    // Reading the input URL from the user
    String web_url = sc.next();             //  www.youtube.com

        // Trying to get all the IP addresses associated with the input URL
        try {
            InetAddress[] myHost = InetAddress.getAllByName(web_url);

            // Printing all the IP addresses associated with the input URL
            System.out.println("\nAll Addresses of "+ web_url +" :");
            for(InetAddress host:myHost) {
            System.out.println(host.getHostAddress());
            }
        } 
        
        // Handling the UnknownHostException if the given URL is invalid
        catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}