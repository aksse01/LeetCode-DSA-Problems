class Solution {
    public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int count = Integer.bitCount(xor);
    return count;
    }
}