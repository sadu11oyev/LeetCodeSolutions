package uz.pdp;

import java.util.Arrays;
public class Medium {


    //16. 3Sum Closest
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return closest;
    }

    //11. Container With Most Water
    public int maxArea(int[] height) {
        int left = 0;
        int rigth = height.length-1;
        int maxArea = 0;

        while(left < rigth){
            maxArea = Math.max(maxArea,(rigth-left)*Math.min(height[left],height[rigth]));

            if(height[left] < height[rigth]){
                left++;
            }else{
                rigth--;
            }

        }
        return maxArea;
    }

    //29. Divide Two Integers
    public int divide(int dividend, int divisor) {
        long res =  (long)dividend/divisor;
        if(res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(res<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)res;
        }
    }


    //2396. Strictly Palindromic Number
    public boolean isStrictlyPalindromic(int n) {
        boolean isPal = false;
        for(int i=2; i<=n-2; i++){
            isPal = isPalindrom(n,i);
            if(!isPal){
                break;
            }
        }
        return isPal;

    }
    public static boolean isPalindrom(int n, int sis){
        boolean isPalind = false;
        String str1 = "";
        while(n>0){
            if(n%sis==0){
                str1+=""+0;
            }else{
                str1+=""+(n%sis);
            }
            n=n/sis;
        }

        int size = str1.length();
        for(int i=0; i<=size/2; i++){
            if(str1.charAt(i)==str1.charAt(size-i-1)){
                isPalind = true;
            }else{
                isPalind = false;
                break;
            }
        }
        return isPalind;
    }



}
