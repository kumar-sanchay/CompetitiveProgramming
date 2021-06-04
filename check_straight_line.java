class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int y = coordinates[1][1]-coordinates[0][1];
        
        int x = coordinates[1][0]-coordinates[0][0];
        float m;
        if(x==0){
            m=0;
        }else{
            m=(float)(y)/(x);
        }
        for(int i=1; i<coordinates.length-1; i++){
            
            int x1 = (coordinates[i+1][0]-coordinates[i][0]);
            float m1;
            
            if(x1==0)
                m1 = 0;
            else
                m1 = (float)(coordinates[i+1][1]-coordinates[i][1])/x1;
            
            if(m!=m1)
                return false;
            
        }
        
        return true;
    }
}