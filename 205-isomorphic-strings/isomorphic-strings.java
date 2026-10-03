class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int [] charS = new int[256];
        int [] charT = new int[256];
        for(int i=0; i<s.length(); i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(charS[chs] != charT[cht]){
                return false;
            }
            charS[chs] = i+1;
            charT[cht] = i+1;
        } 
        return true;
    }
}