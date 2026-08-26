class NumArray {

    int[] tree;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums.clone();
        n = nums.length;
        tree = new int[n + 1];

        // Build Fenwick Tree
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    // Add value to Fenwick Tree
    private void add(int index, int value) {
        while (index <= n) {
            tree[index] += value;
            index += index & -index;
        }
    }

    // Update nums[index]
    public void update(int index, int val) {
        int difference = val - nums[index];

        nums[index] = val;

        add(index + 1, difference);
    }

    // Prefix sum from 0 to index
    private int prefixSum(int index) {
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }

        return sum;
    }

    // Sum from left to right
    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }
}