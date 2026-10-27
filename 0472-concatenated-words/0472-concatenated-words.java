class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set =new HashSet<>();
        for(String s:words) set.add(s);
        int n = words.length;
        List<String> list =new ArrayList<>();
        for(int i=0;i<n;i++){
            int len = words[i].length();
            boolean bool = memo(0,words[i],set,new Boolean[len],len);
            if(bool){
                list.add(words[i]);
            }
        }
        return list;
    }
    public boolean memo(int i,String s,HashSet<String> set,Boolean[] dp,int n){
        if(i==n){
            return true;
        }
        if(dp[i]!=null) return dp[i];
        boolean bool = false;
        int len = n;
        if(i==0) len--;
        for(int j=i+1;j<=len;j++){
            String sub = s.substring(i,j);
            if(set.contains(sub)){
                bool = memo(j,s,set,dp,n);
                if(bool) break;
            }
        }
        return dp[i] = bool;
    }
}