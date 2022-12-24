// https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/partition-an-array-official/ojquestion

// TC - O(n)
// SC - O(1)

class Solution {
    public static void partition(int[] arr, int pivot){
        int i = 0, j = 0;
        while(i <  arr.length) {
            if(arr[i] > pivot) {
                i++;
            } 
            else if(arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } 
        }
        
      }
    
      public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
}