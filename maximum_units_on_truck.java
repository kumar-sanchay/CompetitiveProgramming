class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        for(int i=0; i<boxTypes.length; i++){
            
            for(int j=0; j<boxTypes.length-i-1; j++){
                
                if(boxTypes[j][1]<boxTypes[j+1][1]){
                    int tem[] = boxTypes[j];
                    boxTypes[j] = boxTypes[j+1];
                    boxTypes[j+1] = tem;
                }
            }
        }
        int rem = truckSize;
        int result = 0;
        for(int i=0; i<boxTypes.length; i++){
            if(boxTypes[i][0]<=rem){
                result += boxTypes[i][0] * boxTypes[i][1];
                rem -= boxTypes[i][0];
            }else if(rem>0){
                int r = boxTypes[i][0] - rem;
                result += (rem*boxTypes[i][1]);
                rem = 0;
            }else{
                break;
            }
        }
        return result;
    }
}