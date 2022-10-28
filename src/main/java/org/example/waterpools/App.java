package org.example.waterpools;

import java.util.Arrays;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Landscape water amount calculator.");
            System.out.println("Usage: java -jar waterpools-1.0 [whitespace separated hills heights].");
            System.exit(0);
        }
        try {
            LandscapeValidator v = new LandscapeValidator() {};

            int[] landscape = Arrays.stream(args)
                    .flatMapToInt(num -> IntStream.of(toInt(num)))
                    .toArray();
            long waterAmount = new WaterCalculator().calculateWaterAmount(landscape);
            System.out.println(String.format("Landscape: %s", Arrays.toString(landscape)));
            System.out.println(String.format("Water amount: %d", waterAmount));
        } catch (IllegalArgumentException e) {
            System.out.println("Error while reading landscape. "+e.getMessage());
        } catch (ValidationException e) {
            System.out.println("Error while validating landscape. "+e.getMessage());
        }
    }

    private static int toInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Value '" + s + "' is not a number.");
        }
    }
}
