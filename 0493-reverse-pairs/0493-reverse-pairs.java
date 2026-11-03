class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = low + (high - low)/2;
        cnt += mergeSort(nums,low,mid);
        cnt += mergeSort(nums,mid+1,high);
        cnt += countingPairs(nums, low, mid, high);
        merge(nums,low,mid,high);
        return cnt;
    }
    private int countingPairs(int[] nums, int low, int mid, int high){
        int right = mid +1;
        int cnt = 0;
        for(int left = low; left <= mid; left++){
            while(right <= high && (long)nums[left] > (long)2 * nums[right])right++;
            cnt += (right - (mid+1));
        }
        return cnt;
    }
    private void merge(int[] nums, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                list.add(nums[left++]);
            }else{
                list.add(nums[right++]);
            }
        }
        while(left <= mid){
            list.add(nums[left++]);
        }
        while(right <= high){
            list.add(nums[right++]);
        }
        for(int i = low; i <= high ; i++){
            nums[i] = list.get(i-low);
        }
    }
}