package org.w3cschool.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.List;
import java.util.Map;

public class DemoSpEL {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        // Literal Expressions
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        Object nullValue = parser.parseExpression("null").getValue();

        //Inline Lists
        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);

        //Inline Maps
        Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(context);
        Map mapOfMaps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context);

        //Array Construction
        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);

        //Methods
        String bc = parser.parseExpression("'abc'.substring(1,3)").getValue(String.class);

        //Operators
        Boolean trueValue1 = parser.parseExpression("2 == 2").getValue(Boolean.class);
        Boolean falseValue1 = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        Boolean trueValue2 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
        boolean falseValue2 = parser.parseExpression("'xyz' instanceof T(Integer)").getValue(Boolean.class);
        boolean trueValue3 = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        boolean falseValue3 = parser.parseExpression("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);

    }
}
