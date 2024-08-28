package uz.pdp;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //70. Climbing Stairs
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }

    //88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<nums2.length; i++){
            nums1[m]=nums2[i];
            m++;
        }
        Arrays.sort(nums1);
    }
    //1920. Build Array from Permutation
    public int[] buildArray(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i]=nums[nums[i]];
        }
        return ans;
    }

    //1929. Concatenation of Array
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length+nums.length];
        System.arraycopy(nums,0,ans,0,nums.length);
        System.arraycopy(nums,0,ans,nums.length,nums.length);
        return ans;

    }

   //2011. Final Value of Variable After Performing Operations
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("++X") ||operations[i].equals("X++") ){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }


    //1512. Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
        int sout=0;
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i]==nums[j] && i<j){
                    sout++;
                }
            }
        }
        return sout;

    }

    //2942. Find Words Containing Character
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].indexOf(x) != -1){
                res.add(i);
            }
        }
        return res;
    }

    //1470. Shuffle the Array
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[n*2];
        int a=0;
        for(int i=0; i<n*2; i+=2){
            ans[i]=nums[a];
            a++;
        }
        for(int i=1; i<n*2; i+=2){
            ans[i]=nums[a];
            a++;
        }
        return ans;

    }

    //1672. Richest Customer Wealth
    public int maximumWealth(int[][] accounts) {
        int max=0,a=0;
        for(int i=0; i<accounts.length; i++){
            a=0;
            for(int j=0;j<accounts[i].length;j++){
                a+=accounts[i][j];
            }
            if(max<a){
                max=a;
            }
        }
        return max;
    }

    //2373. Largest Local Values in a Matrix
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int maxLocal[][] = new int[n-2][n-2];

        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = findMax(grid, i, j);
            }
        }
        return maxLocal;
    }

    private int findMax(int grid[][], int x, int y) {
        int maxEle = 0;
        for(int i = x; i < x + 3; i++) {
            for(int j = y; j < y + 3; j++) {
                maxEle = Math.max(maxEle, grid[i][j]);
            }
        }
        return maxEle;
    }

    //1863. Sum of All Subset XOR Totals
    public int subsetXORSum(int[] nums) {

        return helper(nums, 0, 0);
    }
    public int helper(int nums[], int level, int currentXOR){

        if(level == nums.length) return currentXOR;

        int include = helper(nums, level + 1, currentXOR^nums[level]);

        int exclude = helper(nums, level + 1, currentXOR);

        return include + exclude;
    }

    //2798. Number of Employees Who Met the Target
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int sum=0;
        for(int i=0;i<hours.length;i++){
            if(target<=hours[i]){
                sum++;
            }
        }
        return sum;
    }

    //1431. Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        for(int kid:candies){
            max=Math.max(max,kid);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<candies.length; i++){
            res.add(max <= extraCandies+candies[i]);
        }
        return res;
    }

    //2824. Count Pairs Whose Sum is Less than Target
    public int countPairs(List<Integer> nums, int target) {
        int result=0;
        for(int i=0; i<nums.size(); i++){
            for(int j=i+1; j<nums.size(); j++){
                if(nums.get(i)+nums.get(j)<target){
                    result++;
                }
            }
        }
        return result;
    }

    //1365. How Many Numbers Are Smaller Than the Current Number
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int num=0;
        int[] res=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i]>nums[j]){
                    num++;
                }
            }
            res[i]=num;
            num=0;
        }
        return res;
    }

    //2574. Left and Right Sum Differences
    public int[] leftRightDifference(int[] nums) {
        int leftSum=0,rightSum=0;
        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            for(int l=0; l<i; l++){
                leftSum=leftSum+nums[l];
            }
            for(int r=i+1; r<nums.length; r++){
                rightSum=rightSum+nums[r];
            }
            res[i]=Math.abs(leftSum-rightSum);
            leftSum=0;
            rightSum=0;
        }
        return res;
    }

    //1480. Running Sum of 1d Array
    public int[] runningSum(int[] nums) {

        for(int i = 1; i<nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }

    //3162. Find the Number of Good Pairs I
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i] % k != 0)
                continue;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] % (nums2[j]*k)==0){
                    ans++;
                }
            }
        }
        return ans;
    }

    //2114. Maximum Number of Words Found in Sentences
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        int max = 0;
        for(int i=0; i<sentences.length; i++){
            res = sentences[i].trim().split("\\s+").length;
            if(max<res){
                max=res;
            }
        }
        return max;
    }

    //3065. Minimum Operations to Exceed Threshold Value I
    public int minOperations(int[] nums, int k) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<k){
                res++;
            }
        }
        return res;

    }

    //2974. Minimum Number Game
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length-1; i+=2){
            arr[i]=nums[i+1];
            arr[i+1]=nums[i];
        }
        return arr;
    }

    //2769. Find the Maximum Achievable Number
    public int theMaximumAchievableX(int num, int t) {
        return (num+2*t);
    }

    //3190. Find Minimum Operations to Make All Elements Divisible by Three
    public int minimumOperations(int[] nums) {
        int result = 0;
        for(Integer num:nums){
            if(num%3!=0){
                result++;
            }
        }
        return result;
    }


    //2469. Convert the Temperature
    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius*1.80 + 32.00;
        double[] res= {kelvin, fahrenheit};
        return res;
    }

    //2894. Divisible and Non-divisible Sums Difference
    public int differenceOfSums(int n, int m) {
        int num1=0, num2=0;
        for(int i=1; i<=n; i++){
            if(i%m!=0){
                num1+=i;
            }else{
                num2+=i;
            }
        }
        return num1-num2;
    }

    //2235. Add Two Integers
    public int sum(int num1, int num2) {
        return num1+num2;
    }

    //2413. Smallest Even Multiple
    public int smallestEvenMultiple(int n) {
        if(n%2==0){
            return n;
        }else{
            return n*2;
        }
    }



}