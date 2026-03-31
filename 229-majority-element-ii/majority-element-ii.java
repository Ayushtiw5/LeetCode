class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int cand1 = Integer.MIN_VALUE;
        int cand2 = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(count1 == 0 && nums[i] != cand2){
                cand1 = nums[i];
                count1 = 1;
            }else if(count2 == 0 && nums[i] != cand1 ){
                cand2 = nums[i];
                count2 = 1;
            }else if(nums[i] == cand1){
                count1++;
            }else if(nums[i] == cand2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
         count1 = 0;
         count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == cand1){
                count1++;
            }else if(nums[i] == cand2){
                count2++;

            }

        }
        if(count1 > nums.length / 3) ans.add(cand1);
        if(count2 > nums.length / 3) ans.add(cand2);
        return ans;
    }
}