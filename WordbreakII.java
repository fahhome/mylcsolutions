package leetcode;
import java.util.*;
public class WordbreakII {

        public void wbdfs(String s, int len, List<String> wordDict, int idx,
                List<String> curSentence, List<String> anslist) {

            if (idx >= len) {

                // System.out.println("We have a sentence");
                int cslen = curSentence.size();
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < cslen; i++) {

                    // System.out.print(curSentence.get(i) + " ");
                    if (i == cslen - 1)
                        sb.append(curSentence.get(i));
                    else
                        sb.append(curSentence.get(i) + " ");
                }

                anslist.add(new String(sb));
                return;

            }

            int i = idx + 1;

            while (i <= len) {

                String substr = s.substring(idx, i);
                if (wordDict.contains(substr)) {
                    // System.out.println(substr);
                    curSentence.add(substr);
                    wbdfs(s, len, wordDict, i, curSentence, anslist);
                    curSentence.remove(curSentence.size() - 1);
                }

                i++;
            }

        }

        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> anslist = new LinkedList<>();
            List<String> curSentence = new LinkedList<>();
            wbdfs(s, s.length(), wordDict, 0, curSentence, anslist);
            return anslist;
        }


}
