class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2) return false;

        int[] s1count = new int[26];
        int[] windowcount = new int[26];

        for(int i=0; i<n1; i++){
            s1count[s1.charAt(i) - 'a']++;
            windowcount[s2.charAt(i) - 'a']++;
        }
         if(isMatch(s1count, windowcount)){
                return true;
         }
         for(int i=n1; i<n2; i++){
            windowcount[s2.charAt(i) - 'a']++;
            windowcount[s2.charAt(i-n1) - 'a']--;
            if(isMatch(s1count, windowcount)){
                return true;
            }
         }
         return false;

        
    }
    private boolean isMatch(int a[], int b[]){
        for(int i=0; i<26; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
         return true;
    }
}