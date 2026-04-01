class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int firstoccur = findFirst(nums, target);
        int lastoccur = findLast(nums, target);
        return new int []{firstoccur, lastoccur};
    }
        public int findFirst(int nums [], int target){
            int start = 0;
            int end = nums.length -1;
            int ans = -1;
            while(start <= end){
                int mid = start + (end - start)/ 2;
                if(nums[mid] == target){
                    ans = mid;
                    end = mid - 1;

                }else if(nums[mid] < target){
                    start = mid + 1;
                }else{

                    end = mid-1;
                }
            }
            return ans;
        }
        public int findLast(int nums [], int target){
            int start = 0;
            int end = nums.length-1;
            int ans = -1;
            while(start <= end){
                int mid = start + (end - start)/ 2;
                if(nums[mid] == target){
                    ans = mid;
                    start = mid + 1;

                }else if(nums[mid] < target){
                    start = mid + 1;
                }else{

                    end = mid-1;
                }
            }
            return ans;
        }
    }
