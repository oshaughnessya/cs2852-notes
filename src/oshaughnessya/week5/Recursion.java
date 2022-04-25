package oshaughnessya.week5;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    private static int fact(int number) {
        return number < 2 ? 1 : number * fact(number - 1);
    }
}
