class Solution {
    public boolean isPalindrome(String s) {
        String clean = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                clean = clean + Character.toLowerCase(ch);
            }
        }
        for(int i=0; i<clean.length(); i++){
            if(clean.charAt(i) != clean.charAt(clean.length()-i-1)){
                return false;
            }
        }
        return true;
        
    }
}