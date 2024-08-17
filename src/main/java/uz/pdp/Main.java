package uz.pdp;
import java.math.BigInteger;

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

    //13. Roman to Integer
    public static final int[] table = new int[256];
    static {
        table['I'] = 1;
        table['V'] = 5;
        table['X'] = 10;
        table['L'] = 50;
        table['C'] = 100;
        table['D'] = 500;
        table['M'] = 1000;
    }
    public static int romanToInt(String s) {
        int value = 0;
        int prev = 0;
        int current;
        for (char c : s.toCharArray()) {
            current = table[c];
            if (prev < current) {
                value -= prev + prev;
            }
            value += current;
            prev = current;
        }
        return value;
    }
    //

    //14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }

        String prefix = strs[0];
        int length = prefix.length();

        for(int i = 1; i<strs.length; i++){
            while(strs[i].indexOf(prefix) !=0){
                prefix = prefix.substring(0, --length);
                if(length==0){
                    return "";
                }
            }
        }
        return prefix;
    }

    //26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int j=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    //27. Remove Element
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }

    //28. Find the Index of the First Occurrence in a String
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        int nLength = needle.length();
        if(nLength==1){
            for(int i=0; i<haystack.length(); i++){
                if(haystack.charAt(i)==needle.charAt(0)){
                    return i;
                }
            }
        }
        for(int i=0; i<haystack.length()-nLength+1; i++){
            if(haystack.substring(i,i+nLength).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //58. Length of Last Word
    public int lengthOfLastWord(String s) {
        int index=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)!=' '){
                index++;
            }
            if(index>0 && s.charAt(i)==' '){
                return index;
            }
        }
        return index;

    }
    //66. Plus One
    public int[] plusOne(int[] digits) {
        StringBuilder str = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        for(int digit : digits){
            str.append(digit);
        }
        BigInteger value= new BigInteger(str.toString());
        value = value.add(BigInteger.ONE);
        String resultStr = value.toString();
        int[] result = new int[resultStr.length()];
        for(int i =0; i<resultStr.length(); i++){
            result[i]=Character.getNumericValue(resultStr.charAt(i));
        }
        return result;

    }

    //69. Sqrt(x)
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}