package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathService implements MathInterface {
    public static List<Integer> numbers;

    public MathService(String filePath) {
        numbers = FileService.readFile(filePath);
    }

    @Override
    public int findMaxValue() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Cannot find maximum value in an empty list");
        }

        int maxValue = numbers.get(0);

        for (int number : numbers) {
            if (number > maxValue) {
                maxValue = number;
            }
        }

        return maxValue;
    }

    @Override
    public int findMinValue() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Cannot find minimum value in an empty list");
        }

        int minValue = numbers.get(0);

        for (int number : numbers) {
            if (number < minValue) {
                minValue = number;
            }
        }

        return minValue;
    }

    @Override
    public double getMedian() {
        Collections.sort(numbers);
        double median;
        int size = numbers.size();
        if (size % 2 == 0) {
            double firstMiddleNumber = numbers.get(size / 2 - 1);
            double secondMiddleNumber = numbers.get(size / 2);
            median = (firstMiddleNumber + secondMiddleNumber) * 0.5;
        } else {
            median = numbers.get(size / 2);
        }
        return median;
    }

    @Override
    public int getArithmeticMeanValue() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    @Override
    public List<Integer> findTheLargestSequenceOfNumbersThatIncreases() {
        if (numbers.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        temp.add(numbers.get(0));

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                temp.add(numbers.get(i));
            } else {
                if (temp.size() > result.size()) {
                    result.clear();
                    result.addAll(temp);
                }
                temp.clear();
                temp.add(numbers.get(i));
            }
        }

        // Check the last sequence
        if (temp.size() > result.size()) {
            result = temp;
        }

        return result;

    }

    @Override
    public List<Integer> findTheLargestSequenceOfNumbersThatDecreases() {
        if (numbers.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        temp.add(numbers.get(0));

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i - 1)) {
                temp.add(numbers.get(i));
            } else {
                if (temp.size() > result.size()) {
                    result.clear();
                    result.addAll(temp);
                }
                temp.clear();
                temp.add(numbers.get(i));
            }
        }

        // Check the last sequence
        if (temp.size() > result.size()) {
            result = temp;
        }

        return result;

    }
}
