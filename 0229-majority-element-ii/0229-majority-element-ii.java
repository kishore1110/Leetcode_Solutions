class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int canditate1=0;
        int count1=0;
        int canditate2=0;
        int count2=0;
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            if(count1==0 && i!=canditate2){
                canditate1=i;
                count1=1;
            }
            else if(count2==0 && i!=canditate1){
                canditate2=i;
                count2=1;
            }
            else if(i==canditate1){
                count1++;
            }
            else if(i==canditate2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
            }
            int condition=nums.length/3;
            count1=0;
            count2=0;
            for(int ii:nums){
                if(ii==canditate1){
                    count1++;
                }
                else if(ii==canditate2){
                    count2++;
                }
            }
            if(count1>condition){
                list.add(canditate1);
            }
            if(count2>condition){
                list.add(canditate2);
            }
    return list;
    }
} 