class Solution {
    public long sumAndMultiply(int n) {
        String gd = String.valueOf(n);
        StringBuilder non = new StringBuilder();
        for(char y : gd.toCharArray()){
            if(y != '0'){
                non.append(y);
            }
        }
        if(non.length() ==0){
            return 0;
        }
        long po = Integer.parseInt(non.toString());
        long m = 0;
        long l = po;
        while(l>0){
            m+=l%10;
            l/=10;
        }
        return po * m;
    }
}