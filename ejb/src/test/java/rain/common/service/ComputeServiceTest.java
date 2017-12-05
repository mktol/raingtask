package rain.common.service;

import org.junit.Test;
import raing.common.servise.ComputeService;

import static org.junit.Assert.assertEquals;

public class ComputeServiceTest {


    private int[] arr1 = new int[]{3, 2, 1, 4, 3, 2, 3, 4, 5, 4}; // volume of water 7
    private int[] arr2 = new int[]{4, 5, 4, 3, 3, 4, 4, 0, 4, 0, 2, 3, 4, 3, 2, 2}; // volume of water 13
    private int[] arr3 = new int[]{3, 2, 1, 6, 3, 2, 3, 4, 5, 4, 2, 4}; // 13
    private int[] plate = new int[]{7, 3, 2, 1, 6, 3, 2, 3, 4, 5, 4, 2, 4, 7}; // 45
    private int[] arr6 = new int[]{4, 3, 2, 90, 1, 2, 1, 3, 1, 4}; // 15
    private int[] pyramid = new int[]{1, 2, 3, 4, 3, 2, 1}; // 0
    private int[] arr8 = new int[]{1, 2, 3, 4, 3, 2, 1, 2}; // 1
    private int[] miniPlate = new int[]{2, 1, 2}; // 1

    private ComputeService testedClass = new ComputeService();

    @Test
    public void testComputeVolumeOfWater(){
        assertEquals(7, testedClass.computeVolumeOfWater(arr1));
        assertEquals(13, testedClass.computeVolumeOfWater(arr2));
        assertEquals(13, testedClass.computeVolumeOfWater(arr3));
        assertEquals(45, testedClass.computeVolumeOfWater(plate));
        assertEquals(15, testedClass.computeVolumeOfWater(arr6));
        assertEquals(0, testedClass.computeVolumeOfWater(pyramid));
        assertEquals(1, testedClass.computeVolumeOfWater(arr8));
        assertEquals(1, testedClass.computeVolumeOfWater(miniPlate));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeVolumeOfWater_null(){
        testedClass.computeVolumeOfWater(null);
    }

    @Test
    public void testComputeVolumeOfWater_emptyArray(){
        assertEquals(0 , testedClass.computeVolumeOfWater(new int[]{}));
        assertEquals(0 , testedClass.computeVolumeOfWater(new int[]{2, 3}));
    }
}
