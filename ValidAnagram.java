package leetcode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int l1 = s.length();
        int l2 = t.length();

        for (int i = 0; i < l1; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < l2; i++) {
            char ch = t.charAt(i);
            freq[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }

        return true;

    }
    public static void main(String[] args) {
        
    }
}
