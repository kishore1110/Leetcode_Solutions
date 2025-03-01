class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){ 
            List<String> result=new ArrayList<>();
            return result;
        }
        HashMap<Integer,ArrayList<Character>> map=new HashMap<>();
        ArrayList<Character> list2=new ArrayList<>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        map.put(2,list2);
        ArrayList<Character> list3=new ArrayList<>();
        list3.add('d');
        list3.add('e');
        list3.add('f');
        map.put(3,list3);
        ArrayList<Character> list4=new ArrayList<>();
        list4.add('g');
        list4.add('h');
        list4.add('i');
        map.put(4,list4);
        ArrayList<Character> list5=new ArrayList<>();
        list5.add('j');
        list5.add('k');
        list5.add('l');
        map.put(5,list5);
        ArrayList<Character> list6=new ArrayList<>();
        list6.add('m');
        list6.add('n');
        list6.add('o');
        map.put(6,list6);
        ArrayList<Character> list7=new ArrayList<>();
        list7.add('p');
        list7.add('q');
        list7.add('r');
        list7.add('s');
        map.put(7,list7);
        ArrayList<Character> list8=new ArrayList<>();
        list8.add('t');
        list8.add('u');
        list8.add('v');
        map.put(8,list8);
        ArrayList<Character> list9=new ArrayList<>();
        list9.add('w');
        list9.add('x');
        list9.add('y');
        list9.add('z');
        map.put(9,list9);
        List<String> result=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        backtrack(result,temp,map,digits,0);
        return result;
    }
    public void backtrack(List<String> result,StringBuilder temp,HashMap<Integer,ArrayList<Character>> map,String digits,int index){
        if(index>=digits.length()){
            result.add(temp.toString());
            return;
        }
        for(char ch:map.get(digits.charAt(index)-'0')){
            temp.append(ch);
            backtrack(result,temp,map,digits,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}