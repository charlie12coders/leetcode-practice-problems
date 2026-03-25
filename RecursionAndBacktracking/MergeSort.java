public class MergeSort {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }

    public static void mergesort(int[] arr , int si , int ei){
        //Base case
        if(si>=ei){
            return;
        }

        int mid = si + (ei-si)/2;

        mergesort(arr,si,mid); //left part
        mergesort(arr,mid+1,ei); //right part

        merge(arr,si,mid,ei); 
    }

    public static void merge(int[] arr , int si , int mid , int ei){

        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i]>=arr[j]){
                temp[k] = arr[j++];
            }else{
                temp[k] = arr[i++];
            }
            k++;
        }

        while(i<=mid){
            temp[k++]= arr[i++];
        }

        while(j<=ei){
            temp[k++] = arr[j++];
        }

        //copying temp array to original array
        for(int x=0,y=si;x<temp.length;x++,y++){
            arr[y]= temp[x];
        }
    }

}
