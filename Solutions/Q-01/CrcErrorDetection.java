// By - Kaustav Purkayastha ( Gurucharan University, Silchar - @ Department of Computer Science )

// 1. Simulate Cyclic Redundancy Check (CRC) Error Detection Algorithm for Noisy Channel.


import java.util.zip.CRC32;

public class CrcErrorDetection {
  
  // Generate checksum for the given message using CRC-32 algorithm
  public static long generateChecksum(String message) {
    CRC32 crc = new CRC32();
    crc.update(message.getBytes());
    return crc.getValue();
  }

  // Simulate noisy channel by flipping a random bit in the message
  public static String simulateNoisyChannel(String message) {
    StringBuilder sb = new StringBuilder(message);
    int index = (int)(Math.random() * message.length());
    char c = message.charAt(index);
    char flipped = c == '0' ? '1' : '0';
    sb.setCharAt(index, flipped);
    return sb.toString();
  }

  public static void main(String[] args) {
    // Original message
    String message = "101101";
    System.out.println("Original message: " + message);
    
    // Generate checksum for the message
    long checksum = generateChecksum(message);
    System.out.println("Checksum: " + checksum);
    
    // Simulate noisy channel by flipping a random bit
    String receivedMessage = simulateNoisyChannel(message);
    System.out.println("Received message: " + receivedMessage);
    
    // Verify the checksum of the received message
    long receivedChecksum = generateChecksum(receivedMessage);
    if (receivedChecksum == checksum) {
      System.out.println("Message is error-free");
    } else {
      System.out.println("Message has errors");
    }
  }
}
