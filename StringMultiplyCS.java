package leetcode;

//IMPORTANT
//String multiplication without integer overflow
public class StringMultiplyCS {
    
    public String add(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;

        while (i < l1 && j < l2) {

            int sum = (s1.charAt(l1 - i - 1) - '0') +
                    (s2.charAt(l2 - j - 1) - '0') + carry;

            sb.insert(0, sum % 10);
            carry = sum / 10;

            i++;
            j++;

        }

        while (i < l1) {
            int sum = (s1.charAt(l1 - i - 1) - '0') + carry;

            sb.insert(0, sum % 10);
            carry = sum / 10;
            i++;
        }

        while (j < l2) {
            int sum = (s2.charAt(l2 - j - 1) - '0') + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            j++;
        }

        if (carry != 0)
            sb.insert(0, carry);

        return new String(sb);

    }

    public String multiply(String num1, char ch) {

        int multiplicant = ch - '0';
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int len = num1.length();
        int i = 0;

        while (i < len) {

            int prod = (num1.charAt(len - i - 1) - '0') * multiplicant;
            sb.insert(0, (prod + carry) % 10);
            carry = (prod + carry) / 10;
            i++;
        }

        if (carry != 0)
            sb.insert(0, carry);

        return new String(sb);

    }

    public String multiply(String num1, String num2) {
        int num1len = num1.length();
        int num2len = num2.length();

        String currans = "0";

        int i = 0;

        while (i < num2len) {

            char curmultiplicant = num2.charAt(num2len - i - 1);
            String prod = multiply(num1, curmultiplicant);
            for (int j = 0; j < i; j++)
                prod += "0";

            // System.out.println(prod);

            currans = add(prod, currans);
            // System.out.println(currans);
            i++;
        }

        int k = 0;

        while (k < currans.length() && currans.charAt(k) == '0')
            k++;

        // System.out.println(k);
        if (k >= currans.length())
            return "0";

        return currans.substring(k, currans.length());

    }

    public static void main(String[] args) {
        
    }


}
