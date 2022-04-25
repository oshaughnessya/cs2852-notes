package oshaughnessya.week5;

import java.util.stream.IntStream;

public class BinarySearcher {

    public static void main(String[] args) {
        System.out.println(contains(IntStream.range(2, 15).toArray(), 15));
    }

    public static boolean contains(int[] data, int target) {
        return contains(data, target, 0, data.length);
    }

    private static boolean contains(int[] data, int target, int begin, int end) {
        int middle = (begin + end) / 2;
        boolean found = false;
        // Base case
        if (data[middle] == target) {
            found = true;
        } else if (begin < end) {
            // recursive step
            if (data[middle] < target) {
                found = contains(data, target, middle + 1, end);
            } else {
                found = contains(data, target, begin, middle);
            }
        }
        return found;
    }
}
