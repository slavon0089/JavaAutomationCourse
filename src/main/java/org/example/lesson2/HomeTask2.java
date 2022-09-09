package org.example.lesson2;

public class HomeTask2 {
    public static void main(String[] args) {
        int palidromNumber = 454;
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        String input = "Geeks For Geeks";
        int sqrtNumber = 81;
        int fibonacciNumber = 11;
        int fizzBuzzNumber=50;

        palidrome(palidromNumber);
        twoSum(nums, target);
        lengthOfLastWord(input);
        mySqrt(sqrtNumber);
        fibonacci(fibonacciNumber);
        fizzbizz(fizzBuzzNumber);
    }

    public static void palidrome(int number) {
        int r, sum = 0, temp;
        temp = number;
        while (number > 0) {
            r = number % 10;
            sum = (sum * 10) + r;
            number = number / 10;
        }
        if (temp == sum)
            System.out.println("true");
        else
            System.out.println("false");

    }

    public static void twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.printf("[%d,%d] \n", i, j);
                }
            }
            break;
        }
    }

    public static int lengthOfLastWord(String a) {
        int len = 0;
        String x = a.trim();
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                len = 0;
            else
                len++;
        }
        System.out.println("lenght of the last world: " + len);
        return len;
    }

    public static int mySqrt(int x) {
        x = (int) Math.sqrt(x);
        System.out.println(x);
        return x;
    }

    public static void fibonacci(int n){
        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0+" "+n1+" ");
        for(int i = 3; i <= n; i++){
            n2=n0+n1;
            System.out.print(n2+" ");
            n0=n1;
            n1=n2;
        }
        System.out.println();

    }

    public static void fizzbizz(int n)
    {
        for (int i=1; i<=n; i++)
        {
            if (i%15==0)
                System.out.print(" FizzBuzz ");
            else if (i%5==0)
                System.out.print(" Buzz ");
            else if (i%3==0)
                System.out.print(" Fizz ");
            else
                System.out.print(i+" ");
        }
    }

}
