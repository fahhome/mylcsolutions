package leetcode;

import java.math.BigInteger;

//This is the correct solution but it may lead to integer overflow and hence wrong result for some cases
// Thats why used BigInteger to avoid integer overflow
public class JuneTwelveTwo {
    
    public static int chalkReplacer(int[] chalk, int k) {
        int ans  = 0;
        int len = chalk.length;
        // int remainingChalks = k;
        // while(remainingChalks >= chalk[ans]){
        //     remainingChalks -= chalk[ans];
        //     ans = (ans + 1) % (chalk.length);
        // }
        int [] prefixarr  = new int[chalk.length];
        prefixarr[0] = chalk[0];
        for(int i = 1 ; i < chalk.length ; i++)
            prefixarr[i] = prefixarr[i-1] + chalk[i];

        int loop = 0 ;

        int first = 0;
        int last = len - 1;
        BigInteger kBig = BigInteger.valueOf(k);

        while (last >= first) {

            int mid = first + (last - first) / 2;
            BigInteger chalksUsed = BigInteger.valueOf(loop*prefixarr[len-1] + prefixarr[mid]);
            BigInteger chalksUsedPrev = BigInteger.valueOf(0);
            if(mid > 0)
                chalksUsedPrev =   BigInteger.valueOf(loop * prefixarr[len - 1] + prefixarr[mid - 1]) ;
            
            if( mid == 0 ? (chalksUsed.compareTo(kBig) > 0) : (chalksUsed.compareTo(kBig) > 0 &&  chalksUsedPrev.compareTo(kBig) <=0) ){
                ans = mid;
                break;
            }

            if(last == first){
                first = 0;
                last = len -1 ;
                loop++;
            }else{
                if (chalksUsed.compareTo(kBig)>0) {
                    last = (mid - 1) % len;
                } else {
                    first = (mid + 1) % len;
                }
            }

        }
        

        return ans;
    
    }
    public static void main(String[] args) {
        // int [] chalk = {22,25,39,3,45,45,12,17,32,9};
        // int k = 835;

        // int[] chalk = { 5,1,5 };
        // int k = 22;

        int[] chalk = { 3, 4, 1, 2};
        int k = 25;

        System.out.println(chalkReplacer(chalk, k));

    }
}
