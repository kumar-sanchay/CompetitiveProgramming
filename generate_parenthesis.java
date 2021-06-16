import java.util.*;

class Solution {
   
    public List<String> generateParenthesis(int n) {
        
        char s[] = new char[n];
        List<String> list  = new ArrayList<>();

        list = parenthesis_genrator(s, n, 0, 0, 0, list);
        return list;
    }

    public List<String> parenthesis_genrator(char str[], int n, int open, int close, int pos, List<String> list){

        if(close==n){   
            String s = "";
            for(int i=0; i<n; i++){
                s += String.valueOf(str[i]);
            }
            list.add(s);
        }else{

            if(open>close){
                str[pos] = ')';
                parenthesis_genrator(str, n, open, close+1, pos+1, list);
            }

            if(open<n){
                str[pos] = '(';
                parenthesis_genrator(str, n, open+1, close, pos+1, list);
            }
        }

        return list;
    }

    
}