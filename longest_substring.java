import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> hash = new HashMap<>();
        ArrayList<Integer> count_list = new ArrayList<>();
        
        char[] arr = s.toCharArray();
        int i=0, j=0, count = 0;

        while(i<s.length()&&j<s.length()){

            if(hash.containsKey(arr[j])){
                count_list.add(count);
                count = 0;
                hash.clear();

                i++;
                j=i;
            }else{
                hash.put(arr[j], 1);
                count++;
                j++;
            }
            
        }

        count_list.add(count);

        int max = 0;
        if(count_list.size()>0){
            max  = Collections.max(count_list);
        }else{
            max= 0;
        }

        return max;
    }
}