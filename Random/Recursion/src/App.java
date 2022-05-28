package Random.Recursion.src;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        numberSeries(10);
        
        System.out.println(sumToN(10));
        
        System.out.println(factorial(10));
        
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(Arrays.toString(reverseArray(arr)));

        String s = "aabbaacgacaabbaa";
        System.out.println(checkPalindrome(s)); 

        System.out.println(fibonacci(6));

    }

    private static int fibonacci(int i) {
        if(i == 0){
            return 0;
        }
        if(i == 1){
            return 1;
        }
        System.out.println(i);
        return fibonacci(i-1) + fibonacci(i-2);
    }

    private static boolean checkPalindrome(String s) {
        int i = 0;
        return checkSim(i,s);
    }

    private static boolean checkSim(int i, String s) {
        if(i==s.length()/2){
            return true;
        }
        if(s.charAt(i) == s.charAt(s.length()-i-1)){
            System.out.println(s.charAt(i) + " == " + s.charAt(s.length()-i-1));
            return checkSim(++i,s);
        }
        System.out.println(s.charAt(i) + " ! " + s.charAt(s.length()-i-1));
        return false;
    }

    private static int[] reverseArray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        swap(arr,l,r);
        return arr;
    }

    private static int[] swap(int[] arr, int l, int r) {
        if(l == r){
            return arr;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return swap(arr,++l,--r);
    }

    private static int sumToN(int i) {
        if(i==0){
            return 0;
        }
        return i+sumToN(--i);
    } 

    private static int factorial(int i) {
        if(i==0){
            return 1;
        }
        return i*factorial(--i);
    }

    private static void numberSeries(int n) {
        if(n<0){
            return;
        }
        System.out.println(n--);
        numberSeries(n);
    }
}
