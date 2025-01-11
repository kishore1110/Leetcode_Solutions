class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int corresElement=stack.pop();
                int nse=i;
                int pse=stack.isEmpty()?-1:stack.peek();
                maxArea=Math.max(maxArea,heights[corresElement]*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int corresElement=stack.pop();
            int nse=heights.length;
            int pse=stack.isEmpty()?-1:stack.peek();
            maxArea=Math.max(maxArea,heights[corresElement]*(nse-pse-1));
        } 
        return maxArea;
    }
}