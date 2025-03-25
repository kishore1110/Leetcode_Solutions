class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        int[] tFreq=new int[52];
        int[] sFreq=new int[52];
        int match=0;
        for(int i=0;i<t.length();i++){
            if(Character.isLowerCase(t.charAt(i))){
                tFreq[t.charAt(i)-'a']++;
            }
            else if(Character.isUpperCase(t.charAt(i))){
                tFreq[t.charAt(i)-'A'+26]++;
            }
            if(Character.isLowerCase(s.charAt(i))){
                sFreq[s.charAt(i)-'a']++;
            }
            else if(Character.isUpperCase(s.charAt(i))){
                sFreq[s.charAt(i)-'A'+26]++;
            }
        }
        for(int i=0;i<52;i++){
            if(sFreq[i]>=tFreq[i]){
                match++;
            }
        }
        int left=0;
        int right;
        int minLength=Integer.MAX_VALUE;
        int resultLeft=-1;
        int resultRight=-1;
        for(right=t.length();right<s.length();right++){
            while(match==52){
                if(right-left<minLength){
                    resultLeft=left;
                    resultRight=right;
                    minLength=resultRight-resultLeft;
                }
                if(Character.isLowerCase(s.charAt(left))){
                    int index=s.charAt(left)-'a';
                    sFreq[index]--;
                    if(sFreq[index]+1>=tFreq[index] && sFreq[index]<tFreq[index]){
                        match--;
                    }
                }
                else if(Character.isUpperCase(s.charAt(left))){
                    int index=s.charAt(left)-'A'+26;
                    sFreq[index]--;
                    if(sFreq[index]+1>=tFreq[index] && sFreq[index]<tFreq[index]){
                        match--;
                    }
                }
                left++;
            }
            if(Character.isLowerCase(s.charAt(right))){
                int index=s.charAt(right)-'a';
                sFreq[index]++;
                if(sFreq[index]-1<tFreq[index] && sFreq[index]>=tFreq[index]){
                    match++;
                }
            }
            else if(Character.isUpperCase(s.charAt(right))){
                int index=s.charAt(right)-'A'+26;
                sFreq[index]++;
                if(sFreq[index]-1<tFreq[index] && sFreq[index]>=tFreq[index]){
                    match++;
                }
            }
        }
        while(match==52){
            if(right-left<minLength){
                resultLeft=left;
                resultRight=right;
                minLength=resultRight-resultLeft;
            }
            if(Character.isLowerCase(s.charAt(left))){
                int index=s.charAt(left)-'a';
                sFreq[index]--;
                if(sFreq[index]+1>=tFreq[index] && sFreq[index]<tFreq[index]){
                    match--;
                }
            }
            else if(Character.isUpperCase(s.charAt(left))){
                int index=s.charAt(left)-'A'+26;
                sFreq[index]--;
                if(sFreq[index]+1>=tFreq[index] && sFreq[index]<tFreq[index]){
                    match--;
                }
            }
            left++;
        }
        if(resultLeft==-1)return "";
        return s.substring(resultLeft,resultRight);
    }
}