class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                sum = sum - 1;

            }else{
                sum = sum + 1;
            }

        
        if(map.containsKey(sum)){
            int previdx = map.get(sum);
            int curridx = i - previdx;
            maxLen = Math.max(curridx, maxLen);
        }else{
            map.put(sum, i);
        }
        }
        return maxLen;
        
    }
}