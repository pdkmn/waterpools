package org.example.waterpools;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WaterCalculatorTest {
    private WaterCalculator calculator;

    @BeforeAll
    void setUp() {
        calculator = new WaterCalculator();
    }

    @Test
    void smallDesertAlwaysDry() {
        assertEquals(0, calculator.calculateWaterAmount(new int[]{0}));
    }

    @Test
    void singleHillAlwaysDry() {
        assertEquals(0, calculator.calculateWaterAmount(new int[]{1}));
    }

    @Test
    void desertAndHillAlwaysDry() {
        assertEquals(0, calculator.calculateWaterAmount(new int[]{1, 0}));
        assertEquals(0, calculator.calculateWaterAmount(new int[]{0, 1}));
        assertEquals(0, calculator.calculateWaterAmount(new int[]{0, 0, 1}));
        assertEquals(0, calculator.calculateWaterAmount(new int[]{0, 1, 0}));
        assertEquals(0, calculator.calculateWaterAmount(new int[]{1, 0, 0}));
    }

    @Test
    void evenTwoHillsAlwaysDry() {
        assertEquals(0, calculator.calculateWaterAmount(new int[]{1,2}));
        assertEquals(0, calculator.calculateWaterAmount(new int[]{2,1}));
    }

    @Test
    void highPlateauAlwaysDry() {
        assertEquals(0, calculator.calculateWaterAmount(new int[]{8849, 8849, 8849}));
    }

    @Test
    void waterOnTheLevelOfSmallestHill() {
        assertEquals(3, calculator.calculateWaterAmount(new int[]{5, 1, 4}));
        assertEquals(2, calculator.calculateWaterAmount(new int[]{3, 1, 5}));
    }

    @Test
    void testExerciseSample() {
        assertEquals(9, calculator.calculateWaterAmount(new int[]{5,2,3,4,5,4,0,3,1}));
    }



}