class Solution {
    public int minPartitions(String n) {
         int maxDigit = 0;
        
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            maxDigit = Math.max(maxDigit, digit);
            
            // Optimization: Agar 9 mil gaya toh directly return kar do
            if (maxDigit == 9) {
                return 9;
            }
        }
        
        return maxDigit;
    }
}