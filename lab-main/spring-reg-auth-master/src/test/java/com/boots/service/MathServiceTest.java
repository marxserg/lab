package com.boots.service;

import com.boots.entity.MathFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MathServiceTest {

    private MathFunctions mathFunctionsMock;
    private MathService mathService;

    @BeforeEach
    public void setUp() {
        mathFunctionsMock = Mockito.mock(MathFunctions.class);
        mathService = new MathService(mathFunctionsMock);
    }

    // Проверяет корректное умножение двух матриц одинакового размера.
    @Test
    public void testPerformMatrixMultiplication() {
        int[][] a = {
                {1, 2},
                {3, 4}
        };
        int[][] b = {
                {2, 0},
                {1, 2}
        };
        int[][] expected = {
                {4, 4},
                {10, 8}
        };

        when(mathFunctionsMock.multiplyMatrices(a, b)).thenReturn(expected);

        int[][] result = mathService.performMatrixMultiplication(a, b);
        assertArrayEquals(expected, result);

        verify(mathFunctionsMock, times(1)).multiplyMatrices(a, b);
    }

    //Проверяет корректное умножение матриц разных размеров,
    // где число столбцов первой матрицы равно числу строк второй матрицы.
    @Test
    public void testPerformMatrixMultiplicationDifferentSize() {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        int[][] expected = {
                {58, 64},
                {139, 154}
        };

        when(mathFunctionsMock.multiplyMatrices(a, b)).thenReturn(expected);

        int[][] result = mathService.performMatrixMultiplication(a, b);
        assertArrayEquals(expected, result);

        verify(mathFunctionsMock, times(1)).multiplyMatrices(a, b);
    }

    //Проверяет умножение матриц, содержащих только нули.
    @Test
    public void testPerformMatrixMultiplicationWithZero() {
        int[][] a = {
                {0, 0},
                {0, 0}
        };
        int[][] b = {
                {0, 0},
                {0, 0}
        };
        int[][] expected = {
                {0, 0},
                {0, 0}
        };

        when(mathFunctionsMock.multiplyMatrices(a, b)).thenReturn(expected);

        int[][] result = mathService.performMatrixMultiplication(a, b);
        assertArrayEquals(expected, result);

        verify(mathFunctionsMock, times(1)).multiplyMatrices(a, b);
    }

    //Проверяет значение квадратичной функции для положительных коэффициентов.
    @Test
    public void testEvaluateQuadraticFunctionPositiveCoefficients() {
        double a = 1.0;
        double b = -3.0;
        double c = 2.0;
        double x = 2.0;
        double expected = 0.0;

        when(mathFunctionsMock.quadraticFunction(a, b, c, x)).thenReturn(expected);

        double result = mathService.evaluateQuadraticFunction(a, b, c, x);
        assertEquals(expected, result, 1e-9);

        verify(mathFunctionsMock, times(1)).quadraticFunction(a, b, c, x);
    }

    //Проверяет значение квадратичной функции для отрицательных коэффициентов.
    @Test
    public void testEvaluateQuadraticFunctionNegativeCoefficients() {
        double a = -1.0;
        double b = 4.0;
        double c = -4.0;
        double x = -2.0;
        double expected = -4.0;

        when(mathFunctionsMock.quadraticFunction(a, b, c, x)).thenReturn(expected);

        double result = mathService.evaluateQuadraticFunction(a, b, c, x);
        assertEquals(expected, result, 1e-9);

        verify(mathFunctionsMock, times(1)).quadraticFunction(a, b, c, x);
    }

    //Проверяет значение квадратичной функции, когда все коэффициенты равны нулю.
    @Test
    public void testEvaluateQuadraticFunctionZeroCoefficients() {
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double x = 2.0;
        double expected = 0.0;

        when(mathFunctionsMock.quadraticFunction(a, b, c, x)).thenReturn(expected);

        double result = mathService.evaluateQuadraticFunction(a, b, c, x);
        assertEquals(expected, result, 1e-9);

        verify(mathFunctionsMock, times(1)).quadraticFunction(a, b, c, x);
    }
}

