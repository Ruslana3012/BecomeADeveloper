package org.example;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        MathService math = new MathService(filePath);
        System.out.println("Max value = " + math.findMaxValue());
        System.out.println("Min value = " + math.findMinValue());
        System.out.println("Median = " + math.getMedian());
        System.out.println("Arithmetic mean value = " + math.getArithmeticMeanValue());
        System.out.println("The largest increasing sequence of numbers: " + math.findTheLargestSequenceOfNumbersThatIncreases());
        System.out.println("The largest decreasing sequence of numbers: " + math.findTheLargestSequenceOfNumbersThatDecreases());
    }
}