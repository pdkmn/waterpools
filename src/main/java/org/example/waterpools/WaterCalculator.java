package org.example.waterpools;

import static java.lang.Math.max;

public class WaterCalculator {

    /**
     * The basic idea is that to calculate water amount in particular point one ought to do the following: <br/>
     * <ol>
     *      <li>Find minimum of maximum point height around (left and right) this point </li>
     *      <li>Subtract this point height from the value found above</li>*
     * </ol>
     * This idea can be developed to iterating simultaneously from both left and right sides of height array, <br/>
     * determining left and right maximum values. Then we need update result depending on what 'maximum' is greater and<br/>
     * move the pointer in direction of greater maximum.<br/>
     * In human terms - if the right hill is bigger the water level will not be higher than the left hill.
     *
     * @param landscape array of hills heights.
     * @return water amount collected between hills after the hard rain.
     */
    public long calculateWaterAmount(int[] landscape, LandscapeValidator validator) {
        validator.validateLandscape(landscape);
        int leftIndex = 0;
        int rightIndex = landscape.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        int res = 0;
        while (leftIndex < rightIndex) {

            leftMax = max(leftMax, landscape[leftIndex]);
            rightMax = max(rightMax, landscape[rightIndex]);

            if (leftMax < rightMax) {
                res += leftMax - landscape[leftIndex++];
            } else {
                res += rightMax - landscape[rightIndex--];
            }
        }
        return res;
    }

    public long  calculateWaterAmount(int[] landscape){
        return calculateWaterAmount(landscape, new LandscapeValidator() {});
    }
}




