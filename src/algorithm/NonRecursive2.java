/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

/**
 *
 * @author dell
 */
public class NonRecursive2 {
    public static int longestBalancedSubstring(String S) {
        int maxLength = 0;
        int left = 0;
        char char1 = '\0';
        int count1 = 0;
        char char2 = '\0';
        int count2 = 0;

        for (int right = 0; right < S.length(); right++) {
            char c = S.charAt(right);

            if (char1 == '\0' || c == char1) {
                char1 = c;
                count1++;
            } else if (char2 == '\0' || c == char2) {
                char2 = c;
                count2++;
            } else {
                int currentLength = count1 < count2 ? count1 * 2 : count2 * 2;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                left = right - 1;
                char1 = S.charAt(left);
                count1 = 1;
                char2 = c;
                count2 = 1;
            }

            if (char1 != '\0' && char2 != '\0' && count1 == count2) {
                int currentLength = right - left + 1;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }

            return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(longestBalancedSubstring("cabbacc"));
        System.out.println(longestBalancedSubstring("ababab"));
        System.out.println(longestBalancedSubstring("aaaaaa"));
    }
}
