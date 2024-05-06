/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithm;

/**
 *
 * @author dell
 */
public class NonRecursive {

    /**
     * @param args the command line arguments
     */
    public static int getLongestBalancedSubstring(String S) {
    int maxLength = 0;
    for (int i = 0; i < S.length(); i++) {
        int count1 = 0;
        int count2 = 0;
        char a = S.charAt(i);
        char b = ' ';
        for (int j = i; j < S.length(); j++) {
            char c = S.charAt(j);
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
    }
    return maxLength;
}

public static void main(String[] args) {
        System.out.println(getLongestBalancedSubstring("cabbacc"));
        System.out.println(getLongestBalancedSubstring("ababab"));
        System.out.println(getLongestBalancedSubstring("abbbbaac"));
    }
    

}
