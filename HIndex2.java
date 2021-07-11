package leetcode;

public class HIndex2 {

    public static int hIndex(int[] citations) {
        int len = citations.length;
        int ans = 1;
        int i = len / 2;

        int itemsLeft = i;
        int itemsRight = len - i;

        while (i > 0 && itemsRight < citations[i]) {
            i = i / 2;
            itemsRight = len - i;
        }
        
        if( itemsRight >= citations[i] && citations[i] != 0){
            System.out.println("block 1");
            if(i > 0)
                {
                    ans = citations[i];
                    int upperlimit = i*2;
                    // For the missed citations in between 
                    for(int k = i; k<=upperlimit && k < len; k++ ){
                        itemsRight = len - k ;
                        if(citations[k] <= itemsRight && citations[k] >= ans)
                            ans = citations[k];
                        if(itemsRight < citations[k] && itemsRight >= ans) // {1,1,7,10,10}
                            ans = itemsRight;
                    }
                }
            else if(i<=0 && len > 1){
                ans = len - 1; 
            }
            else{

            }

        }
        else if(citations[i] == 0){
            // cases like [0,0,4,4 ] where in between you get array with 0 index
            System.out.println("block 2");
            int k = i;
            while (k < len && citations[k] == 0) {
                k++;
            }
            ans = len -k ;

        }
        else if(itemsRight <  citations[i]){
            // case when i = 0 and itemsRight < citations[i] --> [100]
            System.out.println("block 3");
            ans = len - i ;
        }
        else {
            System.out.println("Inside unexpected block");
        }

        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {0,0,4,4};
        System.out.println(hIndex(arr));
    }
}
