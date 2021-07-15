package leetcode;

public class WC14P1 {
    
    public static int findComplement(int num) {



        int numberOfBits = (int) (Math.floor(Math.log(num) / Math.log(2))) + 1;

        //int allOnesNumber = (int)Math.pow(2,numberOfBits-1) ;

        return ((1 << numberOfBits) - 1) ^ num;

    }

    public static void main(String[] args) {
        System.out.println(findComplement(0));
    }


}
