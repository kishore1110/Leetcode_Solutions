class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int start=meetings[0][0];
        int end=meetings[0][1];
        int count=0;
        for(int i=1;i<meetings.length;i++){
            if(meetings[i][0]<=end){
                end=end>meetings[i][1]?end:meetings[i][1];
            }
            else{
                count+=end-start+1;
                start=meetings[i][0];
                end=meetings[i][1];
            }
        }
        count+=end-start+1;
        return days-count;
    }
}