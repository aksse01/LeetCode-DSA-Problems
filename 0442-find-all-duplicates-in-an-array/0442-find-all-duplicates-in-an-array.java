class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> ans = new ArrayList<>();
       
        int n = arr.length;
        int i = 0;
        while(i<n){
            int rightidx = arr[i] - 1;
            if(arr[i] == i +1 || arr[i] == arr[rightidx]){
                i++;
            }else {
                swap(arr, i, rightidx);
            }
        }
        for(i = 0; i< n ; i++){
            if(arr[i] != i + 1){
                ans.add(arr[i]);
            }
        }return ans;

        
    }
    public static void swap(int arr[], int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}