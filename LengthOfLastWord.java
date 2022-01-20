package leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int i = len - 1;

        int ans = 0;

        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        int wordlen = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            wordlen++;
            i--;
        }

        return wordlen;

    }
}
