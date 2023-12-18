public class HelperClass {
    // helper class for my coding exam
    public static boolean isPowerOfN(int number, int power) {
        if (number <= 0) {
            return false;
        }

        while (number % power == 0) {
            number /= power;
        }

        return number == 1;
    }

    public static boolean isPowerOfNRecursive(int number, int power) {
        if (number <= 0) {
            return false;
        }

        return isPower(number, power);
    }

    private static boolean isPower(int base, int n) {
        if (base == 1) {
            return true;
        } else if (base % n != 0 || base == 0) {
            return false;
        } else {
            return isPower(base / n, n);
        }
    }

    public static long factorialRecursive(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * factorialRecursive(number - 1);
        }
    }

    public static long factorial(int number) {
        long result = 1;
        for (int i = number; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String str) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        String cleanedStr = str.replaceAll("\\s", "").toLowerCase();
        return isPalindromeRecursive(cleanedStr, 0, cleanedStr.length() - 1);
    }

    private static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base case: if the start index crosses the end index
        if (start >= end) {
            return true;
        }

        // if the characters at start and end indices are same
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static int sumOfDigitsRecursive(int num) {
        if (num <= 0) {
            return 0;
        }
        return (num % 10) + sumOfDigitsRecursive(num / 10);
    }

    public static void main(String[] args) {
        System.out.println(HelperClass.isPowerOfN(16, 2));
        System.out.println(HelperClass.isPowerOfNRecursive(16, 2));

        System.out.println(HelperClass.factorialRecursive(30));
        System.out.println(HelperClass.factorial(30));
        int[] arr = new int[] { 3, 4, 1, -4, -2, 52 };

        System.out.println(HelperClass.isPalindromeRecursive(" Lsl"));
        System.out.println(sumOfDigitsRecursive(0));

    }
}