package org.example;

import org.assertj.core.util.Streams;
import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/* 1.Do a simple quadratic operation.
       2.It can only be calculated in positive numbers.
       3.If you divide 0 in division, you create an IllegalArgumentException.
     */

public class CalculatorTest {


    @DisplayName("Perform addition operations.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) throws Exception {
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);
    }
    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );
    }

}

    // 1  +  2 ----> Calculator
    //    3    <----
//    @DisplayName("Perform addition operations.")
//    @Test
//    void additionTest(){
//        int result = Calculator.calculate(1, "+", 2);
//        assertThat(result).isEqualTo(3);
//    }
//
//    // 1  -  2 ----> Calculator
//    //    3    <----
//    @DisplayName("Perform subtraction operations.")
//    @Test
//    void subtractionTest(){
//        int result = Calculator.calculate(3, "-", 1);
//        assertThat(result).isEqualTo(2);
//    }
//}
