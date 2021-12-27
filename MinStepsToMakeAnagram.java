package leetcode;
class MinStepsToMakeAnagram {
    public int minSteps(String s, String t) {

        int l1 = s.length();
        int l2 = t.length();

        int[] commonfreq = new int[26];

        for (int i = 0; i < l1; i++) {
            char ch = s.charAt(i);
            commonfreq[ch - 'a']++;
        }

        for (int i = 0; i < l2; i++) {
            char ch = t.charAt(i);
            commonfreq[ch - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (commonfreq[i] > 0)
                ans += commonfreq[i];
        }

        return ans;

    }
}