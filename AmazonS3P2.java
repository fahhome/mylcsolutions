package leetcode;

// Important How to compare Stringbuilder with string
public class AmazonS3P2 {

    public static String gcdOfStrings(String str1, String str2) {
        //String ans ="";
        StringBuilder ans = new StringBuilder("");

        int l1 = str1.length();
        int l2 = str2.length();

        if(l1 < l2){

            int l1t = l1;
            while (l1t > 0) {

                StringBuilder s = new StringBuilder(str2.substring(0, l1t));
                int slen = s.length();

                if (l2 % slen == 0 && l1 % slen == 0) {
                    int f2 = l2 / slen;
                    int f1 = l1 / slen;

                    StringBuilder s1t = new StringBuilder();
                    StringBuilder s2t = new StringBuilder();
                    for (int i = 0; i < f2; i++) {
                        s2t.append(s);
                    }

                    for (int i = 0; i < f1; i++) {
                        s1t.append(s);
                    }

                    if (s1t.toString().equals(str1) && s2t.toString().equals(str2)) {
                        ans.append(s);
                        break;
                    }

                }

                l1t--;
            }
            

        }else if(l2 < l1){

            int l2t = l2;

            while(l2t > 0){

                StringBuilder s = new StringBuilder(str2.substring(0,l2t));
                int slen =s.length();

                if(l2%slen == 0 && l1 %slen == 0){
                    int f2 = l2/slen;
                    int f1 = l1/slen;

                    StringBuilder s1t = new StringBuilder();
                    StringBuilder s2t = new StringBuilder(); 
                    for(int i = 0 ; i < f2 ; i++){
                        s2t.append(s);
                    }

                    for (int i = 0; i < f1; i++) {
                        s1t.append(s);
                    }

                    if(s1t.toString().equals(str1) && s2t.toString().equals(str2)){
                        ans.append(s);
                        break;
                    }
                    
                }

                l2t--;;
            }

        }else{
            if(str1.equals(str2))
                ans.append(str1);
        }

        return new String(ans);
    }
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB", "ABAB"));
    }
}
