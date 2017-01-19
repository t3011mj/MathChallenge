import java.util.Scanner;

public class Main {

    public static int calculateSum(int inputValue) {

        int sumDigit = 0;
        int i = 0;
        int lengthOfinputInt = 0;
        int stringIndex = 0;
        double resultPow = 0.0;
        String intAsString = " ";
        String [] arrayInatAsString = new String[10];
        int [] arrayInputInt = new int[10];

        // Convert integer to String to count number of digits.
        intAsString  = Integer.toString(inputValue);
        lengthOfinputInt = intAsString.length();

        // If the input value is a negative integer - start analyzing the string at position 1
        if (inputValue < 0) {
            stringIndex = 1;
        }
        else {
            stringIndex = 0;
        }

        // parse input number into separate digits
        for (i=stringIndex; i < lengthOfinputInt; i++) {
            arrayInatAsString[i] = intAsString.substring(i,i + 1);
            arrayInputInt[i] = Integer.parseInt(arrayInatAsString[i]);
            resultPow = Math.pow(arrayInputInt[i], 3.0);
            sumDigit = sumDigit + (int) resultPow;
        }
        if (inputValue < 0) {
            sumDigit = sumDigit * -1;
        }
        return sumDigit;
    }

    public static void main(String[] args) {
        int inputInt = 0;
        long longInt = 0;
        int sumDigitUpdated = 0;
        int stringIndex = 0;
        Boolean isSum = false;
        Boolean validInput = false;

        // Get User Input
        // Max value of int is 2147483647. Min value of int is -2147483657
        while (!validInput) {

            System.out.println("Enter an integer:");
            Scanner scnr = new Scanner(System.in);
            longInt = scnr.nextLong();
            if (longInt >= 2147483647) {
                System.out.println(" Integer is greater than 2147483647 - re-enter value");
            } else if (longInt <= -214783647) {
                System.out.println("Integer is less than -21478364 - re-enter value");
            } else {
                validInput = true;
                inputInt = (int) longInt;
            }
        }

        // Invoke method to parse digits of input value
        sumDigitUpdated = calculateSum(inputInt);

        if ((inputInt == sumDigitUpdated) || (inputInt == (-1 * sumDigitUpdated))) {
           isSum = true;
        }

        System.out.println("The User entered a vlaue of "  + inputInt + " and the sum of the digits is: " + sumDigitUpdated + ".");
        System.out.println("The sum of the cubes of the number's digits being equal to the number itself: " + isSum);
    }
  }
