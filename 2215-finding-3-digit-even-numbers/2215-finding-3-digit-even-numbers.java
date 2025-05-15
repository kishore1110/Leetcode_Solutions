class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> result=new ArrayList<>();
        int index=0;
        while(digits[index]==0){
            index++;
            if(index==digits.length)return new int[]{};
        }
        backtrack(digits,set,index,result,0,0);
        int[] resultArray=new int[result.size()];
        index=0;
        for(int num:result){
            resultArray[index++]=num;
        }
        return resultArray;
    }
    public void backtrack(int[] digits,HashSet<Integer> set,int index,ArrayList<Integer> result,int num,int len){
        if(len>=3){
            if(num%2==0)result.add(num);
            return;
        }
        for(int i=index;i<digits.length;i++){
            if(!set.contains(i)){
                if(!set.contains(i-1) && i!=0 && digits[i]==digits[i-1])continue;
                set.add(i);
                backtrack(digits,set,0,result,num*10+digits[i],len+1);
                set.remove(i);
            }
        }
    }
}