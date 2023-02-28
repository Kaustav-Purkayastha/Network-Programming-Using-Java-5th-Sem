
// 7. Write a program that prints the address of www.youtube.com


import java.net.*;
import java.util.Scanner;

public class GetIPAddress {
    public static void main(String[] args) throws UnknownHostException{
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a valid URL of Website:  ");
       String web_url = sc.next();          // https://www.youtube.com/
        try {
            InetAddress address = InetAddress.getByName(new URL(web_url).getHost());
            String ip = address.getHostAddress();
            System.out.println("The Address of the given URL is:   " + address);
            System.out.println("Raw IP of the given URL:  " + ip);
            
        }
        catch(MalformedURLException me) {
            System.out.println("Not a Valid URL of Website!!");
        }
        catch(Exception e) {
            System.out.println("Unknown Error Occurred!");
        }   
    }    
}