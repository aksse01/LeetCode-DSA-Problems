class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans=0;
        boolean m[]=new boolean[intervals.length];
for(int i=0; i<intervals.length; i++){
    m[i]= true;
}
for(int i=0; i<intervals.length; i++){
    for(int j=0; j<intervals.length; j++){
        if(i==j) continue;
        if(m[j]==true){
            if(intervals[i][0]>=intervals[j][0] && intervals[i][1]<=intervals[j][1]) {
                ans++;
                m[i]=false;
                break;
            }
        } 
    }  
}
return intervals.length-ans;
    }
}