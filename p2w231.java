package leetcode;

public class p2w231 {

    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder(num);

        for(int i = 0; i < num.length(); i++){
            if( change[sb.charAt(i) - '0'] > (sb.charAt(i) - '0') ){

                int j = i;

                while(j < num.length() &&  (change[sb.charAt(j) - '0'] > (sb.charAt(j) - '0'))){
                    sb.setCharAt(j, (char)(change[sb.charAt(j) - '0'] + '0')  );
                    j++;
                }

                break;
            }
        }


        return new String(sb);
    }
    public static void main(String[] args) {
        
    }
}
