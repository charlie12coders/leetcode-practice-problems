package RecursionAndBacktracking;

public class Fibonacci{
    public static int fibonacciReturn(int n){
        if(n==0){
            return n;
        }else if(n==1 || n==2){
            return 1;
        }
        return fibonacciReturn(n-1)+fibonacciReturn(n-2);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacciReturn(i));
        }
        
    }
}