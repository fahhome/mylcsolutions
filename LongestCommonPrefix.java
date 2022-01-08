package leetcode;

public class LongestCommonPrefix {
    String longestCommonPrefix(String arr[], int n) {
        // code here
        int anslen = 0;
        int ansendidx = 0;

        int longeststrlen = 0;
        int longeststridx = -1;

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.length() > longeststrlen) {
                longeststrlen = str.length();
                longeststridx = i;
            }
        }

        String longeststr = arr[longeststridx];

        for (ansendidx = 0; ansendidx < 1002; ansendidx++) {
            if (ansendidx >= longeststrlen)
                break;
            char ch = longeststr.charAt(ansendidx);
            int flag = 0;
            for (String str : arr) {
                if (str.length() <= ansendidx) {
                    flag = 1;
                    break;

                }
                if (str.charAt(ansendidx) != ch) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1)
                break;
        }

        if (ansendidx == 0)
            return "-1";

        return arr[0].substring(0, ansendidx);

    }
}
