package leetcode;

public class AmazonPS1P2 {

    public static String reverseStr(String s, int k) {

        StringBuilder ans = new StringBuilder();
        int len = s.length();

        int i = 0;

        while(i < len){

            String firstk = s.substring(i, Math.min(i+k,len));
            StringBuilder reversefirstk = new StringBuilder(firstk).reverse();
            ans.append(new String(reversefirstk));

            int j = i + k;

            if(j > len)
                break;
            
            String remainingafterkto2k = s.substring(j, Math.min(len, j+k));
            ans.append(new String(remainingafterkto2k));
            
            i += 2*k;

        }


        return new String(ans);

    }

    public static void main(String[] args) {
        String s = "abasdwqdasowhdjasdwdasdcd";
        System.out.println(reverseStr(s, 4));
        
    }
    
}
