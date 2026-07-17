class Solution {
    private void helper(int i, int nums[], List<Integer> subset, List<List<Integer>> result) {
        if(i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        helper(i + 1, nums, subset, result);
        subset.remove(subset.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        helper(i + 1, nums, subset, result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, subset, result);
        return result;
    }
}