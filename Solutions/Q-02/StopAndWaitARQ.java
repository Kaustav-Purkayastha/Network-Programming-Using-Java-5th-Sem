// By - Kaustav Purkayastha ( Gurucharan University, Silchar - @ Department of Computer Science )

// 2. Simulate and implement Stop And Wait ARQ protocol for noisy channel.


import java.util.Random;

public class StopAndWaitARQ {
    private static final int TIMEOUT = 500;  // timeout in milliseconds
    private static final double ERROR_PROBABILITY = 0.1;  // probability of error in transmission
    private static final Random random = new Random();  // random number generator

    public static void main(String[] args) {
        int sequenceNumber = 0;
        boolean ackReceived = true;

        while (sequenceNumber < 10) {  // send 10 frames
            if (ackReceived) {
                // send frame
                System.out.println("Sending frame " + sequenceNumber);
                ackReceived = false;

                // simulate transmission errors
                if (random.nextDouble() < ERROR_PROBABILITY) {
                    System.out.println("Error in transmission of frame " + sequenceNumber);
                } else {
                    // simulate successful transmission
                    // wait for ACK
                    try {
                        Thread.sleep(TIMEOUT);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // simulate ACK loss
                    if (random.nextDouble() < ERROR_PROBABILITY) {
                        System.out.println("ACK lost for frame " + sequenceNumber);
                    } else {
                        // ACK received
                        System.out.println("ACK received for frame " + sequenceNumber);
                        ackReceived = true;
                        sequenceNumber++;
                    }
                }
            } else {
                // retransmit frame
                System.out.println("Retransmitting frame " + sequenceNumber);

                // simulate transmission errors
                if (random.nextDouble() < ERROR_PROBABILITY) {
                    System.out.println("Error in retransmission of frame " + sequenceNumber);
                } else {
                    // simulate successful retransmission
                    // wait for ACK
                    try {
                        Thread.sleep(TIMEOUT);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // simulate ACK loss
                    if (random.nextDouble() < ERROR_PROBABILITY) {
                        System.out.println("ACK lost for retransmitted frame " + sequenceNumber);
                    } else {
                        // ACK received
                        System.out.println("ACK received for retransmitted frame " + sequenceNumber);
                        ackReceived = true;
                    }
                }
            }
        }
    }
}
