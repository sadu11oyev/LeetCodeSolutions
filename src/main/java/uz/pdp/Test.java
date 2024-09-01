package uz.pdp;

public class Test {
    public static void main(String[] args) {
        System.out.println(addDigits(19));
    }
    public static int addDigits(int num) {
        int res= sumNumbers(num);
        while(res>9){
            res =sumNumbers(res);
        }
        return res;
    }
    public static int sumNumbers(int num){
        int sum = 0;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
}
