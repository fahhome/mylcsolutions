package leetcode;



// The letter value of a letter is its position in the alphabet starting from 0 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).

// The numerical value of some string of lowercase English letters s is the concatenation of the letter values of each letter in s, which is then converted into an integer.

// For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we get 21.
// You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase English letters 'a' through 'j' inclusive.

// Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or false otherwise.

public class SummationOfTwoWords {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        int val1 = 0;
        int val2 = 0;
        int val3 = 0;

        int i = 0;
        while (i < firstWord.length() && firstWord.charAt(i) == 'a') {
            i++;
        }

        int len = firstWord.substring(i).length();
        int tens = 0;
        int j = 0;
        while (j < len) {
            int digit = firstWord.charAt(firstWord.length() - j - 1) - 97;
            val1 += Math.pow(10, tens) * digit;
            tens += 1;
            System.out.print(val1 + " ");
            j++;
        }
        System.out.println();

        i = 0;
        while (i < secondWord.length() && secondWord.charAt(i) == 'a') {
            i++;
        }
        len = secondWord.substring(i).length();
        tens = 0;
        j = 0;
        while (j < len) {
            int digit = secondWord.charAt(secondWord.length() - j - 1) - 97;
            val2 += Math.pow(10, tens) * digit;
            tens += 1;
            System.out.print(val2 + " ");
            j++;
        }

        i = 0;
        while (i < targetWord.length() && targetWord.charAt(i) == 'a') {
            i++;
        }
        len = targetWord.substring(i).length();
        tens = 0;
        j = 0;
        while (j < len) {
            int digit = targetWord.charAt(targetWord.length() - j - 1) - 97;
            val3 += Math.pow(10, tens) * digit;
            tens += 1;
            System.out.print(val3 + " ");
            j++;
        }

        if (val1 + val2 == val3)
            return true;

        return false;

    }
    public static void main(String[] args) {
        
    }
}
