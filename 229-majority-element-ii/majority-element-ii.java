class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }if(nums[i] == candidate2){
                count2++;
            }
        }
        int n = nums.length;
        if(count1 > n/3){
            ans.add(candidate1);
        }
        if(count2 > n/3 && candidate2 != candidate1){
            ans.add(candidate2);
        }
        return ans;
    }
}