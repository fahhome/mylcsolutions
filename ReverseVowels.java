package leetcode;

public class ReverseVowels {
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' ||
                c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' ||
                c == 'O' || c == 'U')
            return true;
        return false;
    }

    public String reverseVowels(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char[] chararr = s.toCharArray();

        while (left <= right) {

            while (left < len && !isVowel(chararr[left]))
                left++;

            while (right > 0 && !isVowel(chararr[right]))
                right--;

            if (left > right)
                break;

            char temp = chararr[left];
            chararr[left] = chararr[right];
            chararr[right] = temp;

            left++;
            right--;

        }

        String ans = new String(chararr);
        return ans;

    }
    public static void main(String[] args) {
        
    }
}
