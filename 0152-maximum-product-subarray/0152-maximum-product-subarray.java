class Solution {
    public int maxProduct(int[] nums) {
     int currmax = nums[0];
     int currmin = nums[0];
     int maxnum = nums[0];
     for(int i=1;i<nums .length;i++)
     {
        int tempmax = currmax;
        currmax = Math.max(nums[i],Math.max(currmax*nums[i],currmin*nums[i]));
        currmin = Math.min(nums[i],Math.min(tempmax*nums[i],currmin*nums[i]));
        maxnum = Math.max(maxnum,currmax);

     }
     return maxnum;
    }
}