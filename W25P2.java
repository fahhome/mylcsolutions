package leetcode;
import java.util.*;

public class W25P2 {

    public static String complexNumberMultiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder();

        int realpartans = 0;
        int imgpartans = 0;


        int num1realpart = num1.split("\\+")[0].length() > 1 ? (-1 * (num1.charAt(1) - '0')) : (num1.charAt(0) - '0');
        int num1imgpart = num1.split("\\+")[1].length() > 2 ? (-1 * (num1.charAt(3) - '0')) : (num1.charAt(2) - '0');

        int num2realpart = num2.split("\\+")[0].length() > 1 ? (-1 * (num2.charAt(1) - '0')) : (num2.charAt(0) - '0')   ;
        int num2imgpart = num2.split("\\+")[1].length() > 2 ? (  -1* (num2.charAt(3) - '0') ) : ( num2.charAt(2) - '0')  ;


        realpartans = num1realpart*num1realpart + (-1*(num1imgpart*num2imgpart));
        imgpartans = num1imgpart*num2realpart + num1realpart*num2imgpart;

        ans.append(realpartans);
        ans.append("+");
        ans.append(imgpartans);
        ans.append("i");

        return new String(ans);
    }

    public static void main(String[] args) {
        String num1 = "1+1i", num2 = "1+1i";

        System.out.println(complexNumberMultiply(num1, num2));
    }
}
