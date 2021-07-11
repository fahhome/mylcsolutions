package leetcode;

public class NumberOfTeams {
    public int numTeams(int[] rating) {
       int ans = 0 ;
       int len = rating.length;
       int pivotindex = 1; 
       int pivotrating = rating[pivotindex];
        
       while(pivotindex < len-1){
           
           
         for(int i = 0 ; i < pivotindex; i++){
               for(int j= pivotindex+1 ; j<len; j++ ){
                   if( (rating[i] > rating[pivotindex] &&  rating[pivotindex] > rating[j]) || (rating[i] < rating[pivotindex] && rating[pivotindex] < rating[j])  ){
                     ans++;
                   }
               }
           }
          
           pivotindex++;
           
       }
        
        return ans ;
      
    }
}
