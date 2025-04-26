class Solution {
    public String multiply(String num1, String num2) {
        //normal our school multiplication but initution to find the destination index using input index is difficult to identify
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String n1=new StringBuilder(num1).reverse().toString();
        String n2=new StringBuilder(num2).reverse().toString();
        int[] result=new int[n1.length()+n2.length()];
        for(int i=0;i<n1.length();i++){
            for(int j=0;j<n2.length();j++){
                int digit=(n1.charAt(i)-'0')*(n2.charAt(j)-'0');
                result[i+j]+=digit;
                result[i+j+1]+=result[i+j]/10;
                result[i+j]=result[i+j]%10;
            }
        }
        StringBuilder res=new StringBuilder();
        int end=result.length-1;
        while(end>=0 && result[end]==0){
            end--;
        }
        while(end>=0){
            res.append(String.valueOf(result[end]));
            end--;
        }
        return res.toString();
    }
}