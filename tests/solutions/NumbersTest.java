package solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersTest {

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(1, Numbers.factorial(0));
        assertEquals(1, Numbers.factorial(1));
        assertEquals(2, Numbers.factorial(2));
        assertEquals(24, Numbers.factorial(4));
        assertEquals(120, Numbers.factorial(5));
        assertEquals(2432902008176640000L, Numbers.factorial(20));
        assertThrows(IllegalArgumentException.class, () -> {
            Numbers.factorial(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Numbers.factorial(26);
        });
    }

    @Test
    public void testIsArmstrongNumber() {
        assertTrue(Numbers.isArmstrongNumber(0));
        assertTrue(Numbers.isArmstrongNumber(1));
        assertTrue(Numbers.isArmstrongNumber(153));
        assertTrue(Numbers.isArmstrongNumber(9474));
        assertFalse(Numbers.isArmstrongNumber(-153));
        assertFalse(Numbers.isArmstrongNumber(10));
        assertFalse(Numbers.isArmstrongNumber(123));
        assertFalse(Numbers.isArmstrongNumber(1632));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(Numbers.isPalindrome(0)); 
        assertTrue(Numbers.isPalindrome(121));
        assertTrue(Numbers.isPalindrome(12321)); 
        assertTrue(Numbers.isPalindrome(823328)); 
        assertFalse(Numbers.isPalindrome(123));
        assertFalse(Numbers.isPalindrome(-121));
        assertFalse(Numbers.isPalindrome(12345));
        assertFalse(Numbers.isPalindrome(123456));
        assertFalse(Numbers.isPalindrome(-30085));
    }

    @Test
    public void testReverseDigitsInNumber() {
        assertEquals(54321, Numbers.reverseDigitsInNumber(12345));
        assertEquals(0, Numbers.reverseDigitsInNumber(0));
        assertEquals(1, Numbers.reverseDigitsInNumber(1));
        assertEquals(987654321, Numbers.reverseDigitsInNumber(123456789));
        assertEquals(3652, Numbers.reverseDigitsInNumber(-2563));
    }

    @Test
    public void testSumOfDigitsInNumber() {
        assertEquals(15, Numbers.sumOfDigitsInNumber(12345));
        assertEquals(0, Numbers.sumOfDigitsInNumber(0));
        assertEquals(1, Numbers.sumOfDigitsInNumber(1));
        assertEquals(45, Numbers.sumOfDigitsInNumber(123456789));
        assertEquals(16, Numbers.sumOfDigitsInNumber(-2563));
    }

    @Test
    public void testDigitsInNumber() {
        assertEquals(5, Numbers.digitsInNumber(12345));
        assertEquals(1, Numbers.digitsInNumber(0));
        assertEquals(1, Numbers.digitsInNumber(1));
        assertEquals(9, Numbers.digitsInNumber(123456789));
        assertEquals(4, Numbers.digitsInNumber(-2563));
    }

    @Test
    public void testGetLastDigit() {
        assertEquals(5, Numbers.getLastDigit(12345));
        assertEquals(0, Numbers.getLastDigit(0));
        assertEquals(1, Numbers.getLastDigit(1));
        assertEquals(9, Numbers.getLastDigit(123456789));
        assertEquals(2, Numbers.getLastDigit(-12662));
    }

    @Test
    public void testGetAbsoluteValue() {
        assertEquals(124, Numbers.getAbsoluteValue(124));
        assertEquals(0, Numbers.getAbsoluteValue(0));
        assertEquals(124, Numbers.getAbsoluteValue(-124));
        assertEquals(12345, Numbers.getAbsoluteValue(12345));
        assertEquals(2563, Numbers.getAbsoluteValue(-2563));
    }

    @Test
    public void testToPowerOf() {
        assertEquals(1, Numbers.toPowerOf(5, 0));
        assertEquals(8, Numbers.toPowerOf(2, 3));
        assertEquals(16, Numbers.toPowerOf(4, 2));
        assertEquals(1024, Numbers.toPowerOf(2, 10));
        assertEquals(1, Numbers.toPowerOf(10, 0));
        assertThrows(IllegalArgumentException.class, () -> {
            Numbers.toPowerOf(2, -3);
        });
    }
}
