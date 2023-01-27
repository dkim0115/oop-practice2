package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {

    public static final List<NewArithmeticOperator> arithmeticOperators =
            List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivitionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        return arithmeticOperators.stream()
                .filter(arithmeticOperator->arithmeticOperator.supports(operator))
                .map(arithmeticOperator->arithmeticOperator.calculate(operand1,operand2))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("not correct"));
    }

    //using Enum
//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
//    }

}
