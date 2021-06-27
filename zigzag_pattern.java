class Solution {
    public static String convert(String s, int numRows) {
        

        char[][] matrix = new char[numRows][1000];

        int idx, jdx;
        char[] arr = s.toCharArray();

        idx = 0; 
        jdx = 0;

        boolean latch = true;
        int count = 1;
        for(char c: arr){
            
            matrix[idx][jdx] = c;

            System.out.println(idx+","+jdx+"|"+matrix[idx][jdx]);
            if(idx<numRows-1 && latch){
                idx++;
            }else if(idx>=numRows-1){
                jdx++;
                idx = (numRows-1) - count;

                if (idx<0) idx=0;
                count++;
                latch = false;
            }else if(idx==0 && !latch){
                latch=true;
                idx++;
                count = 1;
            }else if(idx<numRows-1){
                jdx++;
                idx = (numRows-1) - count;
                count++;
            }


        }

        String result = "";

        for(int i=0; i<numRows; i++){
            for(int j=0; j<1000; j++){

                if(matrix[i][j]!='\u0000')
                    result += String.valueOf(matrix[i][j]);

            }
        }

        return result;
    }

    public static void main(String args[]){

        String s = "PAYPALISHIRING";

        String r = convert(s, 3);
        System.out.println(r);
        
    }
}
