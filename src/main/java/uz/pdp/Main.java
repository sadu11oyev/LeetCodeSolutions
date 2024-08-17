package uz.pdp;

public class Main {
    public static void main(String[] args) {


    }
    //1. Two Sum
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            for(int i=0; i<nums.length; i++){
                for(int j=0; j<nums.length; j++){
                    if(nums[i]+nums[j]==target && i!=j){
                        res[0]=i;
                        res[1]=j;
                        break;
                    }
                }
            }
            return res;
        }

    //9.Palindrome Number
        public boolean isPalindrome(int x) {
            boolean palindrome = false;
            String s1 = Integer.toString(x);
            String s2 = "";

            for (int i = s1.length() - 1; i >= 0; i--) {
                s2 += s1.charAt(i);
            }

            if (s1.equals(s2)) {
                palindrome = true;
            }

            return palindrome;
        }

}