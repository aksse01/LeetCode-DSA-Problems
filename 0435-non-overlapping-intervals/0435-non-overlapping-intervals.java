class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));

        int counter=0; //first job with earliest finish time will never overlap other job.
        int endTime=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<endTime) counter++;
            else endTime=intervals[i][1];
        }
        return counter;
    }
}