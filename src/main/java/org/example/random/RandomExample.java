package org.example.random;

import java.util.Random;

public class RandomExample {
    public static void main(String args[]){
        Random random = new Random();

        // Random integer
        int randomInt = random.nextInt();
        System.out.println("Random Integer: " + randomInt);

        // Random integer in a range (0 to 9)
        int boundedInt = random.nextInt(10);
        System.out.println("Random Integer (0-9): " + boundedInt);
    }

}
