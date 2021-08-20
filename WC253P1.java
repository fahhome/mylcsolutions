package leetcode;

public class WC253P1 {

    public boolean isPrefixString(String s, String[] words) {
        int len = words.length;

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < len; i++){

            if(s.equals(new String(sb)))
                return true;
            
            sb.append(words[i]);

        }

        if(s.equals(new String(sb)))
            return true;

        return false;

    }

    public static void main(String[] args) {
        
    }


}
