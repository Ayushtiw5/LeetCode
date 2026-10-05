class Solution {
    public int maxArea(int[] height) {
        int mostwater = 0;
        int i = 0;
        int j = height.length-1;
        while( i < j){
            int length = Math.min(height[i] , height[j]);
            int width = j - i;
            mostwater = Math.max(mostwater, length*width);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return mostwater;
        
    }
}