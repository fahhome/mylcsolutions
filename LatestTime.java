package leetcode;
import java.util.*;

public class LatestTime {
    static String ansstr;

    public static boolean isSafe(int num, int idx, int prevnum) {

        if (idx == 0) {

            if (num > 2)
                return false;

        } else if (idx == 1) {
            if (prevnum == 2 && num > 3)
                return false;

        } else if (idx == 2) {
            if (num > 5)
                return false;
        } else {
        }

        return true;

    }

    public static void dfs(int idx, int[] arr, int[] visited, StringBuilder sb, int prevnum) {

        if (sb.length() > 4)
            return;

        if (idx > 3) {
            if (sb.length() > ansstr.length())
                ansstr = new String(sb);
            else {
                String temp = new String(sb);
                if (temp.compareTo(ansstr) > 0)
                    ansstr = temp;
            }
            return;
        }

        if (idx > 4)
            return;

        for (int i = 0; i < 4; i++) {

            if (visited[i] == 0 && isSafe(arr[i], idx, prevnum)) {
                sb.append((char) (arr[i] + '0'));
                visited[i] = 1;
                dfs(idx + 1, arr, visited, sb, arr[i]);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = 0;
            }

        }

    }

    public static String largestTimeFromDigits(int[] arr) {
        int len = arr.length;
        ansstr = "";

        StringBuilder sb = new StringBuilder();
        int[] visited = new int[4];

        dfs(0, arr, visited, sb, -1);

        if (ansstr.length() < 4)
            return "";

        return ansstr.substring(0, 2) + ":" + ansstr.substring(2, 4);

    }


    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
        System.out.println(largestTimeFromDigits(arr));
    }


}
