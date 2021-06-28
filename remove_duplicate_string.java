class Solution {
    public String removeDuplicates(String s) {
        
        return remove(s, 0);
    }
    
    public String remove(String s,int idx){
        
        if(idx==s.length()-1)
            return s;
        
        
        for(int i=idx; i<s.length()-1; i++){
            
            if(s.charAt(i)==s.charAt(i+1)){
                String str = s.substring(0, i) + s.substring(i+2, s.length());
                s = remove(str, 0);
                i = idx;
            }
                
            
        }
        
        return s;
    }
}