package leetcode;

public class MaxValueAfterInsertion {
    public static String maxValue(String n, int x) {

        String res = "";
        if (n.charAt(0) == '-') {
            for (int i = 1; i < n.length(); i++) {

                int digit = n.charAt(i) - '0';
                if (x < digit) {

                    res = n.substring(0, i) + String.valueOf(x) + n.substring(i);
                    break;
                }

            }
        } else {
            // +ve

            for (int i = 0; i < n.length(); i++) {
                int digit = n.charAt(i) - '0';
                if (x >= digit) {
                    res = n.substring(0, i) + String.valueOf(x) + n.substring(i);
                    break;
                }

            }

        }
        if (res.length() != n.length() + 1) {
            res = n + String.valueOf(x);
        }
        return res;

    }
    public static void main(String[] args) {
        String s = "-7234";
        int x = 5;
        System.out.println(maxValue(s, x));
    }
}
