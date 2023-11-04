package solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersTest {

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
}
