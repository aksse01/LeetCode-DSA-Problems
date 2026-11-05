class Solution {
    public int nextGreaterElement(int n) {
        String numStr = String.valueOf(n);
        int[] digits = new int[numStr.length()];

        int len = numStr.length();
        for (int i = 0; i < len; i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        int found = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            return -1;
        } else {
            for (int i = len - 1; i >= 0; i--) {
                if (digits[i] > digits[found]) {
                    int temp = digits[i];
                    digits[i] = digits[found];
                    digits[found] = temp;
                    break;
                }
            }
            int start = found + 1;
            int end = len - 1;
            while (start < end) {
                int temp = digits[start];
                digits[start] = digits[end];
                digits[end] = temp;
                start++;
                end--;
            }
            int newNum = 0;
            for (int digit : digits) {
                if (newNum > (Integer.MAX_VALUE - digit) / 10) {
                    return -1; // overflow will occur
                }
                newNum = newNum * 10 + digit;
            }

            return newNum;
        }
    }
}