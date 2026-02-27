class Solution {
    public int numSteps(String s) {
         int steps = 0;
        int carry = 0;
        
        // Right se left (last bit se start)
        for(int i = s.length() - 1; i > 0; i--) {
            
            int bit = s.charAt(i) - '0';
            
            if(bit + carry == 1) {
                // odd case
                steps += 2;   // add 1 + divide
                carry = 1;
            } else {
                // even case
                steps += 1;   // only divide
            }
        }
        
        // Agar last me carry bach gaya
        return steps + carry;
    }
}