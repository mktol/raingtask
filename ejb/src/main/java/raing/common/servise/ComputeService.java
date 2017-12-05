package raing.common.servise;



import javax.ejb.Stateless;

@Stateless
public class ComputeService {

    /**
     * Method calculate volume of water that fills the hollows on the surface.
     * @param arr array that equivalent  one-dimensional surface, each element is height. These heights form the surface.
     * @return count of units witch filled by water
     */
    public  int computeVolumeOfWater(int[] arr){
        if(arr==null){
            throw new IllegalArgumentException("input array can not be null");
        }
        if(arr.length<3){
            return 0;
        }
        int sumOfFilledUnits = 0;
        int maxElementIndex = findMaxElementIndex(arr, 0, arr.length-1);
        sumOfFilledUnits += computeLeftSide(arr, 0, maxElementIndex);
        sumOfFilledUnits += computeRightSide(arr, maxElementIndex, arr.length-1);
        return sumOfFilledUnits;
    }

    /***
     * Methods find and return index of max element in array
     * @param arr array
     * @param from start index
     * @param to enindex
     * @return the index of max element in array, if array contains more then one max element, that are equal, method will return the last max element
     */
    private int findMaxElementIndex(int[] arr, int from, int to) {
        int elementIndex = 0;
        int maxElement = 0;
        for (int i = from; i <= to; i++) {
            if (arr[i] >= maxElement) {
                maxElement = arr[i];
                elementIndex = i;
            }
        }
        return elementIndex;
    }

    private int computeLeftSide(int[] arr, int leftB, int rightB) {
        if ((rightB - leftB) < 2) {
            return 0;
        }
        int maxElemInd = findMaxElementIndex(arr, leftB, rightB);
        int secondMaxId = findMaxElementIndex(arr, leftB, rightB - 1); // rightB-1 avoid counting rightB because it max value
        int sumOfFilledUnits = countVolume(arr, secondMaxId, maxElemInd);
        sumOfFilledUnits += computeLeftSide(arr, leftB, secondMaxId);
        return sumOfFilledUnits;
    }


    private int computeRightSide(int[] arr, int leftB, int rightB){
        if ((rightB - leftB) < 2) {
            return 0;
        }
        int maxElementIndex = findMaxElementIndex(arr, leftB+1, rightB);
        int sum = countVolume(arr, leftB, maxElementIndex);
        sum += computeRightSide(arr, maxElementIndex, rightB);
        return sum;

    }

    private  int countVolume(int[] arr, int leftBorder, int rightBorder) {
        if (Math.abs(rightBorder - leftBorder) < 2) {
            return 0;
        }
        int sum = 0;
        int baseHigh = arr[leftBorder] <= arr[rightBorder] ?  arr[leftBorder] : arr[rightBorder];
        for (int i = leftBorder + 1; i < rightBorder; i++) {
            sum += baseHigh - arr[i] >= 0 ? baseHigh - arr[i] : 0;
        }
        return sum;
    }
}
