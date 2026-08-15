class Solution {
        /*
        #########################################################################
        #                                                                       #
        #  =============================================                        #
        #                  SIDDARDHA CHILUVERU                                  #
        #  =============================================                        #
        #                                                                       #
        #  Author      : Siddardha Chiluveru                                    #
        #  Description : Solution / Code / Project                              #
        #  Date        : 2026-08-10                                             #
        #                                                                       #
        #########################################################################
        */
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int[] ans = new int[nums.length - k + 1];
        ans[0] = map.lastKey();
        int l = 0;
        int r = k;
        while (r != nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (map.get(nums[l]) > 1)
                map.put(nums[l], map.get(nums[l]) - 1);
            else
                map.remove(nums[l]);
            ans[l + 1] = map.lastKey();
            l += 1;
            r += 1;
        }
        return ans;
    }
}