package leetcode;
import java.util.*;

// Time Difference
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;

        int len = timePoints.size();

        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {

                String h1 = timePoints.get(i).split(":")[0];
                String m1 = timePoints.get(i).split(":")[1];

                String h2 = timePoints.get(j).split(":")[0];
                String m2 = timePoints.get(j).split(":")[1];

                if (h1.equals(h2)) {
                    ans = Math.min(ans, Math.abs(Integer.valueOf(m2) - Integer.valueOf(m1)));
                } else {

                    int h1int = Integer.valueOf(h1);
                    int h2int = Integer.valueOf(h2);
                    int m1int = Integer.valueOf(m1);
                    int m2int = Integer.valueOf(m2);

                    int hourlyminutes = Math.min(Math.abs(Integer.valueOf(h1) - Integer.valueOf(h2)), Math.min(
                            Math.abs(24 - h1int) + Math.abs(h2int - 0), Math.abs(24 - h2int) + Math.abs(h1int - 0)))
                            * 60;

                    if (h1int > h2int) {
                        int temp = m1int;
                        m1int = m2int;
                        m2int = temp;
                    }

                    if (Math.min(Math.abs(24 - h1int) + Math.abs(h2int - 0), Math.abs(24 - h2int)
                            + Math.abs(h1int - 0)) < Math.abs(Integer.valueOf(h1) - Integer.valueOf(h2))) {

                        int temp = m1int;
                        m1int = m2int;
                        m2int = temp;

                    }

                    int diff = hourlyminutes - m1int + m2int;
                    ans = Math.min(ans, diff);

                    if (ans == 0)
                        break;
                }

            }
        return ans;
    }
}
