class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int currLength;
        int maxLength=0;
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
            currLength=0;
            if(!set.contains(i-1)){
                int j=i;
                while(set.contains(j)){
                    j++;
                    currLength++;
                }
            }
            maxLength=Math.max(maxLength,currLength);
        }
        return maxLength;
    }
}