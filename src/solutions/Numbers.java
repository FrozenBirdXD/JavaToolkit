package solutions;

public class Numbers {

    // Main method for testing
    public static void main(String[] args) {
        // System.out.println(getAbsoluteValue(-124));
        // System.out.println(digitsInNumber(0));
        // System.out.println(sumOfDigitsInNumber(-12345));
        // System.out.println(getLastDigit(124));
        // System.out.println(reverseDigitsInNumber(1));
        // System.out.println(isPalindrome(233332));
        // System.out.println(isArmstrongNumber(1634));
        // System.out.println(toPowerOf(3, 3));
    }

    public static boolean isArmstrongNumber(int number) {
        if (number < 0) {
            return false;
        }
        int numOfDigits = digitsInNumber(number);
        int sum = 0;
        for (int num = number; num > 0; num /= 10) {
            int lastDigit = num % 10;
            sum = sum + toPowerOf(lastDigit, numOfDigits);
        }
        return sum == number;
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        int reversedNum = reverseDigitsInNumber(number);
        return reversedNum == number;
    }

    public static int reverseDigitsInNumber(int number) {
        number = getAbsoluteValue(number);
        int reversedNumber = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number /= 10;
        }
        return reversedNumber;
    }

    public static int sumOfDigitsInNumber(int number) {
        number = getAbsoluteValue(number);
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        return sum;
    }

    public static int digitsInNumber(int number) {
        if (number == 0) {
            return 1;
        }
        number = getAbsoluteValue(number);
        int numDigits = 0;
        for (int num = number; num > 0; num /= 10) {
            numDigits++;
        }
        return numDigits;
    }

    public static int toPowerOf(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static int getLastDigit(int number) {
        number = getAbsoluteValue(number);
        return number % 10;
    }

    public static int getAbsoluteValue(int number) {
        if (number >= 0) {
            return number;
        }
        return number * -1;
    }
}
