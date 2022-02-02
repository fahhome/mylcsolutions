package leetcode;
import java.util.*;

public class ReorderDataInLogFiles {


    // IMPORTANT
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2); // Split into two parts (JAVA important)
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (isDigit1 && !isDigit2)
                    return 1;
                else if (!isDigit1 && !isDigit2) {
                    if (!split1[1].equals(split2[1]))
                        return split1[1].compareTo(split2[1]);
                    else
                        return split1[0].compareTo(split2[0]);
                } else if (!isDigit1 && isDigit2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        Arrays.sort(logs, myComp);
        return logs;

    }


}
