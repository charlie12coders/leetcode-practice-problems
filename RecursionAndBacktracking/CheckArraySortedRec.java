package RecursionAndBacktracking;

public class CheckArraySortedRec {
    public static boolean checkSorted(int[] arr,int n){
        if(n==0 || n==1){
            return true;
        }
        return arr[n-1]>=arr[n-2] && checkSorted(arr, n-1);
    }
    public static void main(String[] args) {
       System.out.println(checkSorted(new int[]{1,2,3,4,5}, 5));
    }
}
