/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

/**
 *
 * @author dell
 */
public class Recursive {
    public static int getLongestBalancedSubstringRecursive(String S, int startIndex) {
    int maxLength = 0;

    
    if (startIndex >= S.length()) {
        return 0;
    }

    int count1 = 0;
    int count2 = 0;
    char a = S.charAt(startIndex);
    char b = ' ';

    for (int i = startIndex; i < S.length(); i++) {
        char c = S.charAt(i);
        if (c == a) {
            count1++;
            if (count1 == count2 && maxLength < count1 * 2) {
                maxLength = count1 * 2;
            }
        } else {
            if (b == ' ') {
                b = c;
                count2++;
                if (count1 == count2 && maxLength < count1 * 2) {
                    maxLength = count1 * 2;
                }
            } else if (c == b) {
                count2++;
                if (count1 == count2 && maxLength < count1 * 2) {
                    maxLength = count1 * 2;
                }
            } else {
                break;
            }
        }
    }

    
    int recursiveMaxLength = getLongestBalancedSubstringRecursive(S, startIndex + 1);
    if (maxLength < recursiveMaxLength) {
        maxLength = recursiveMaxLength;
    }
    return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(getLongestBalancedSubstringRecursive("cabbacc",0));
        System.out.println(getLongestBalancedSubstringRecursive("ababab",0));
        System.out.println(getLongestBalancedSubstringRecursive("aaaaaa",0));
    }
    
}
