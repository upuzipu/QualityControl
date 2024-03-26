package org.example.first;

import org.example.first.math.Tangents;

public class FirstTask {
    public static void main(String[] args) {
        double x = Math.PI / 4;
        int n = 5;
        Tangents tangents = new Tangents();
        System.out.println(tangents.calculate(x, n));
    }
}
