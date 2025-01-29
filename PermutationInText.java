// 29-01-2025
//Prathmesh Deshmukh 

import java.util.Arrays;
import java.util.Scanner;

public class PermutationInText {
    // Function to check if any permutation of pattern exists in text
    public static boolean checkPermutationExists(String pattern, String text) {
        int patLen = pattern.length();
        int textLen = text.length();
 
        // If the pattern is longer than the text, it is impossible for the permutation to exist
        if (patLen > textLen) return false;

        // Convert the pattern into a character array and sort it
        char[] patternArr = pattern.toCharArray();
        Arrays.sort(patternArr);
        String sortedPattern = new String(patternArr);

        // Check every substring of length pattern.length()
        for (int i = 0; i <= textLen - patLen; i++) {
            String sub = text.substring(i, i + patLen);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            String sortedSub = new String(subArr);

            // If the sorted substring is the same as the sorted pattern, we found a match
            if (sortedPattern.equals(sortedSub)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Term = sc.nextInt();
        sc.nextLine();

        while (Term-- > 0) {
            String pattern = sc.next();
            String text = sc.next();
            System.out.println(checkPermutationExists(pattern, text) ? "YES" : "NO");
        }
        sc.close();
    }
}