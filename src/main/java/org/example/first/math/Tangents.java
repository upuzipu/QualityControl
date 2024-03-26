package org.example.first.math;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Tangents {
    public double calculate(double x, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            double term = Math.pow(-1, i) * (Math.pow(x, 2*i + 1) / factorial(2*i + 1));
            result += term;
        }
        return result;
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
