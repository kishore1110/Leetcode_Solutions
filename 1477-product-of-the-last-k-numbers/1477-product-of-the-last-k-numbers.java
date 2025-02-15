class ProductOfNumbers {
    ArrayList<Integer> list;
    int product;
    public ProductOfNumbers() {
        list=new ArrayList<>();
        product=1;
    }
    
    public void add(int num) {
        if(num==0){
            list=new ArrayList<>();
            product=1;
        }
        else{
            product*=num;
            list.add(product);
        }
    }
    
    public int getProduct(int k) {
        if(list.size()<k){
            return 0;
        }
        int answer=list.get(list.size()-1);
        if(list.size()==k){
            return answer;
        }
        return answer/list.get(list.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */