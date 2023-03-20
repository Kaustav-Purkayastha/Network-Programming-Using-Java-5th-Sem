// By - Kaustav Purkayastha ( Gurucharan University, Silchar - @ Department of Computer Science )

// 7. Write a program that prints the address of www.youtube.com


import java.net.*;
import java.util.Scanner;

public class GetIPAddress {
    public static void main(String[] args) throws UnknownHostException{

        // Creating a Scanner object to read the input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a valid URL of Website:  ");

        // Reading the input URL from the user
        String web_url = sc.next();          // https://www.youtube.com/

        // Trying to get the IP address of the input URL
        try {
            InetAddress address = InetAddress.getByName(new URL(web_url).getHost());
            String ip = address.getHostAddress();

            // Printing the IP address of the given URL
            System.out.println("The Address of the given URL is:   " + address);
            System.out.println("Raw IP of the given URL:  " + ip);
            
        }

        // Handling the MalformedURLException if the given URL is not valid
        catch(MalformedURLException me) {
            System.out.println("Not a Valid URL of Website!!");
        }

        // Handling any other exception that might occur
        catch(Exception e) {
            System.out.println("Unknown Error Occurred!");
        }   
    }    
}