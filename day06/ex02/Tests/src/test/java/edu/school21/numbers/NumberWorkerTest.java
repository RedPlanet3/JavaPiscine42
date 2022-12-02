package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    NumberWorker numWork;

    @BeforeEach
    void beforeEachMethod() {this.numWork = new NumberWorker();}

    @ParameterizedTest
    @ValueSource(ints = {11,17,113, 2, 3})
     void isPrimeForPrimes(int num)
    {Assertions.assertTrue(numWork.isPrime(num));}

    @ParameterizedTest
    @ValueSource(ints = {10,120,115})
    void isPrimeForNotPrimes(int num)
    {Assertions.assertFalse(numWork.isPrime(num));}

    @ParameterizedTest
    @ValueSource(ints = {1,0,-2})
    void  isPrimeForIncorrectNumbers(int num)
    {
        Assertions.assertThrows(NumberWorker.IllegalNumberException.class, () -> numWork.isPrime(num));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void checkDigitsSum(int num, int sum)
    {Assertions.assertEquals(numWork.digitsSum(num), sum);}
}
