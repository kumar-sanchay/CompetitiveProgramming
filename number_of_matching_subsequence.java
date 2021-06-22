import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int ans = 0;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            
            if(map.containsKey(s.charAt(i))){
                List<Integer> l = map.get(s.charAt(i));
                l.add(i);
                map.put(s.charAt(i), l);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(s.charAt(i), l);
            }
        }
        
        for(String str: words){
            int low = -1;
            int count = 0;
            for(int i=0; i<str.length(); i++){
                
                if(map.containsKey(str.charAt(i))){
                    List<Integer> myList = map.get(str.charAt(i));
                    ListIterator<Integer> iter = myList.listIterator();
                    
                    while(iter.hasNext()){
                        int a = iter.next();
                        if(a>low){
                            low = a;
                            count++;
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
            
            if(str.length()==count){
                ans++;
            }
        }
        return ans;
    }
}