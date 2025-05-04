class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<ArrayList<Integer>,Integer> map=new HashMap<>();
        int count=0;
        for(int[] dom:dominoes){
            int a=dom[0]>dom[1]?dom[1]:dom[0]; 
            int b=dom[0]<dom[1]?dom[1]:dom[0];
            ArrayList<Integer> pair=new ArrayList<>(Arrays.asList(a,b));
            count+=map.getOrDefault(pair,0);
            map.put(pair,map.getOrDefault(pair,0)+1);
        }
        return count;
    }
}