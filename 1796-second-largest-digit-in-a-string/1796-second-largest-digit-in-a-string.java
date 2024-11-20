class Solution {
    public int secondHighest(String s) {
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        List<Character> list=new ArrayList<>();
        list.add('0');
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        for(int i=0;i<s.length();i++){
            if(list.contains(s.charAt(i))){
                int num=s.charAt(i)-'0';
                if(num>max){
                    secondMax=max;
                    max=num;
                }
                else if(num>secondMax && num!=max){
                    secondMax=num;
                }
            }
        }
        return secondMax==Integer.MIN_VALUE?-1:secondMax;
    }
}