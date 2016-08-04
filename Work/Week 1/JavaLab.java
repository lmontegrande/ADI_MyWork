package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(
          "Test 1: " + getDifference(1,2) + "\n" +
          "Test 2: " + divide152By(3) + "\n" +
          "Test 3: " + isLetter3EqualLetter1("Hat", "The") + "\n" +
          "Test 4: " + transmogrifier(1, 2, 3) + "\n" +
          "Test 5: " + reverseString("Doggy")
        );
    }

    public static int getDifference(int a, int b) {
        return a - b;
    }

    public static float divide152By(float a) {
        return 152/a;
    }

    public static boolean isLetter3EqualLetter1(String a, String b) {
        return (Character.toLowerCase(a.charAt(2)) == Character.toLowerCase(b.charAt(0)));
    }

    public static double transmogrifier(double a, double b, double c) {
        return Math.pow(a*b, c);
    }

    public static String reverseString(String a) {
        String reverseString = "";
        char[] charArray = a.toCharArray();
        for(int x=charArray.length; x != 0; x--) {
            reverseString += Character.toString(charArray[x-1]);
        }

        // return System.out.println(new StringBuilder("Doggy").reverse().toString());
        return reverseString;
    }

}
