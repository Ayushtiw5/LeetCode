class Solution {
    public int minAddToMakeValid(String s) {
        int openend = 0;
        int closeend = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                closeend++;
            }else{
                if(closeend > 0){
                    closeend--;
                }else{
                    openend++;
                }
            }

        }
        return closeend + openend;
        
    }
}