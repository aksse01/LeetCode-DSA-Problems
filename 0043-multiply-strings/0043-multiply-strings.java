class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int arr[] = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int p1 = i + j; // // index where the carry digit would go
                int p2 = i + j + 1;// // index where the digit after multiplying & addition would go
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mult + arr[p2]; // number after multiplying and adding
                arr[p1] += sum / 10; // // carry, placed just to the left and added to its curr number
                arr[p2] = sum % 10; // // remainder from carry placed at right first
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(!(arr[i] == 0 && sb.length() == 0)) sb.append(arr[i]);
        }
        if(sb.length() == 0) sb.append(arr[0]); // // every digit in the array is zero, so we need to append it only once
        return sb.toString();
    }
}