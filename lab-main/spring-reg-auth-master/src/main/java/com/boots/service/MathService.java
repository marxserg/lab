package com.boots.service;

import com.boots.entity.MathFunctions;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private final MathFunctions mathFunctions;

    public MathService(MathFunctions mathFunctions) {
        this.mathFunctions = mathFunctions;
    }

    public int[][] performMatrixMultiplication(int[][] a, int[][] b) {
        return mathFunctions.multiplyMatrices(a, b);
    }

    public double evaluateQuadraticFunction(double a, double b, double c, double x) {
        return mathFunctions.quadraticFunction(a, b, c, x);
    }
}

