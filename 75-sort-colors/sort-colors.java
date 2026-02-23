// class Solution {
//     public void sortColors(int[] nums) {
//         int largest = Integer.MIN_VALUE;
//         for(int i=0; i<nums.length; i++){
//             largest = Math.max(largest,nums[i]);
//         }
//         int count[] = new int[largest+1];
//         for(int i=0; i<nums.length; i++){
//             count[nums[i]]++;
//         }
//         int j=0;
//         for(int i=0; i<count.length; i++){
//             while(count[i]>0){
//                 nums[j] = i;
//                 j++;
//                 count[i]--;
//             }
//         }
        
//     }
// }

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                mid++;
            } 
            else { // nums[mid] == 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}