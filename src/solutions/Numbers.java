package solutions;
public class Numbers {

    // Main method for testing
    public static void main(String[] args) {
        // System.out.println(getAbsoluteValue(-124));
        // System.out.println(digitsInNumber(0));
        // System.out.println(sumOfDigitsInNumber(-12345));
        // System.out.println(getLastDigit(124));
        // System.out.println(reverseDigitsInNumber(1));
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
