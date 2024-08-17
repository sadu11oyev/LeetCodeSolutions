package uz.pdp;

import java.util.Arrays;

public class Hard {
    //4. Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        int[] array = new int[size];
        System.arraycopy(nums1,0,array,0,nums1.length);
        System.arraycopy(nums2,0,array,nums1.length,nums2.length);
        Arrays.sort(array);
        int medium = size/2;
        if (size%2==0){
            return (array[medium-1]+array[medium])/2.0;
        }else {
            return array[medium];
        }


    }
}
