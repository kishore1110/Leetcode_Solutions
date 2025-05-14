class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> result=new HashSet<>();
        backtrack(digits,set,1,result,0,0);
        int[] resultArray=new int[result.size()];
        int index=0;
        for(int num:result){
            resultArray[index++]=num;
        }
        Arrays.sort(resultArray);
        return resultArray;
    }
    public void backtrack(int[] digits,HashSet<Integer> set,int first,HashSet<Integer> result,int num,int len){
        if(len>=3){
            if(num%2==0)result.add(num);
            return;
        }
        for(int i=0;i<digits.length;i++){
            if(!set.contains(i)){
                if(digits[i]==0 && first==1)continue;
                set.add(i);
                backtrack(digits,set,0,result,num*10+digits[i],len+1);
                set.remove(i);
            }
        }
    }
}