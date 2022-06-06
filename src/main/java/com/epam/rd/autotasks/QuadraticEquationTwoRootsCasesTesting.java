package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @Parameterized.Parameters
    public static Collection<Object[]> quadraticEquation(){
        return Arrays.asList(new Object[][]{
                {1,5,6,-2.0+" "+-3.0},
                {2,-7,0,3.5+" "+0.0},
                {1,0,-64,8.0+" "+-8.0},
                {1,-1,0,1.0+" "+0.0}
        });
    }

    private final double a;
    private final double b;
    private final double c;
    private final String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    List<String> findDecimalNums(String stringToSearch) {
        Pattern decimalNumPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = decimalNumPattern.matcher(stringToSearch);

        List<String> decimalNumList = new ArrayList<>();
        while (matcher.find()) {
            decimalNumList.add(matcher.group());
        }

        return decimalNumList;
    }

    @Test
    public void testTwoRootsCase() {
        DoubleStream decimalNumValuesFound = findDecimalNums(quadraticEquation.solve(a,b,c))
                .stream()
                .mapToDouble(Double::valueOf);

        double[] roots = decimalNumValuesFound.toArray();
        Arrays.sort(roots);
        String rootString = "";

        if (roots.length==2){ rootString = roots[1]+" "+roots[0]; }

        assertEquals(expected, rootString);
    }

}