import java.util.Arrays;
import java.util.Hashtable;

public class stringManipulation {

    public static void main(String args[]) {

        /* check if all characters in a String are Unique */
        /* 1.1*/
        String str = "abchdesds";
        if (isUnique(str)) {
            System.out.print(str + "Is Unique");
        } else {
            System.out.print(str + "Is Not Unique");
        }
        System.out.print("\n");

        /* string reverse */
        /* 1.2*/
        String output = stringReversal(str);
        System.out.print(str + " reversal result is " + output);
        System.out.print("\n");

        /* check if one string is permutation of another */
        /* 1.3*/
        String str2 = "eabchds";
        String str3 = "abchdse";
        if (isPermutation(str2, str3)) {
            System.out.print(str2 + " is permutation of " + str3);

        } else {
            System.out.print(str2 + " is not a permutation of " + str3);
        }
        /* 1.4*/
        str2 = " a fd ";
        str3 = fillSpace(str2);
        System.out.print(str2 + " space filled " + str3);
        System.out.print("\n");

        /* 1.5*/
        str2 = "aaabbcceeeefgg";
        str3 = compressStr(str2);
        System.out.print(str2 + " compressed to " + str3);
        System.out.print("\n");

        /* 1.6*/
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.print("print original matrix");
        System.out.print("\n");
        printMatrix(m);
        System.out.print("\n");

        rotateToLeft(m);

        int[][] m3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        System.out.print("\n");
        rotateToRight(m3);

        /* 1.8*/
        setRowColumnZero();
        String s1 = "water";
        String s2 = "terwa";

        /* 1.8*/
        checkStringRotation(s1, s2);
        System.out.print("\n");
        s2 = "terpa";
        checkStringRotation(s1, s2);

        String str1 = "edd";
        String str4 = "bgg";
        System.out.println("is Isomorphic :" + isIsomorphic(str1, str4));

    }

    /* check if all characters in a String are Unique */
    public static boolean isUnique(String string) {
        if (string.length() > 256) {
            return false;
        }
        boolean[] charset = new boolean[256];
        for (int i = 0; i < string.length(); i++) {
            char val = string.charAt(i);
            if (charset[val]) {
                return false;
            }
            charset[val] = true;
        }
        return true;
    }

    /* reverse a string */
    public static String stringReversal(String string) {
        String reversedStr = new String();
        for (int i = string.length() - 1; i >= 0; i--) {
            char c = string.charAt(i);
            reversedStr += c;
        }
        return reversedStr;
    }
    
    /* better
    public static String reverseString(String str) {
        int strLength = str.length() % 2;
        int i = str.length() / 2;
        if (strLength == 0) {
            return swapItems(i - 1, i, str.toCharArray());
        } else {
            return swapItems(i, i, str.toCharArray());
        }
    }

    public static String swapItems(int i, int j, char[] s) {
        int begin = i;
        int end = j;
        while (begin >= 0 && end <= s.length && begin <= end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin--;
            end++;
        }
        return new String(s);
    }
    */

    /* check if one string is permutation of another */
    public static boolean isPermutation(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        //return (Sort(string1).equals(Sort(string2)));
        return (Arrays.equals(Sort(string1), Sort(string2)));
    }

    public static char[] Sort(String string) {
        char[] arr1 = string.toCharArray();
        Arrays.sort(arr1);
        System.out.print(arr1);
        return arr1;
    }

    /* fill empty space with "%20 */
    /*bad way*/
    public static String fillSpace(String s) {
        String n = new String();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                n += '%';
                n += '2';
                n += '0';
            } else {
                n += s.charAt(i);
            }
        }
        return (n);
    }

    /* fill empty space with "%20 */
    public static void fillSpaceBetter(char[] str) {
        int count = 0;
        for (int i = 0; i <= str.length - 1; i++) {
            if (str[i] == ' ') {
                count++;
            }
        }
        int newLength = str.length + count * 2;
        char[] newArr = new char[newLength];
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                newArr[newLength - 1] = '0';
                newArr[newLength - 2] = '2';
                newArr[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                newArr[newLength - 1] = str[i];
                newLength = newLength - 1;
            }

        }
        System.out.println(newArr);
    }

    /* compress a string */
    public static String compressStr(String s) {
        char last = s.charAt(0);
        int count = 0;
        String newStr = new String();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                char s1 = s.charAt(i - 1);
                newStr += s1;
                newStr += count;
                count = 1;
                last = s.charAt(i);
            }
        }
        newStr += last;
        newStr += count;
        return (newStr);
    }

    /* rotate a matrix */
    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void rotateToLeft(int[][] m) {
        int m1[][] = transpose(m);       /*transpose*/
        System.out.print("print transpose of matrix");
        System.out.print("\n");
        printMatrix(m1);
        System.out.print("\n");
        m1 = swapColumn(m1); /*swapColumn() columns   */
        System.out.print("matrix rotated to left");
        System.out.print("\n");
        printMatrix(m1);
    }

    public static void rotateToRight(int[][] m1) {
        System.out.print("\n");
        m1 = swapColumn(m1); /*swapColumn() columns   */
        System.out.print("swap columns");
        System.out.print("\n");
        printMatrix(m1);

        m1 = transpose(m1);       /*transpose*/
        System.out.print("matrix rotated to right");
        System.out.print("\n");
        printMatrix(m1);
    }

    public static int[][] transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m.length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        return m;
    }

    public static int[][] swapColumn(int[][] m1) {
        for (int i = 0; i < m1.length / 2; i++) {
            for (int j = 0; i < m1.length; i++) {
                int temp = m1[i][j];
                m1[i][j] = m1[i][m1.length - 1 - j];
                m1[i][m1.length - 1 - j] = temp;
            }
        }
        return m1;
    }

    /* if a cell matrix is 0, entire row an  and column becomes 0 */
    public static void setRowColumnZero() {
        int[][] m = {
                {1, 2, 0},
                {4, 5, 6},
                {7, 9, 9},
        };
        System.out.println("print original matrix");
        System.out.println("\n");
        printMatrix(m);
        boolean[] rows = new boolean[m.length];
        boolean[] cols = new boolean[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if ((rows[i]) || (cols[j])) {
                    m[i][j] = 0;
                }
            }
        }
        System.out.println("print modified matrix");
        System.out.println("\n");
        printMatrix(m);
    }

    /* check String rotation */
    public static void checkStringRotation(String s1, String s2) {
        String s3 = s2 + s2;
        if (s3.contains(s1)) {
            System.out.print(s2 + " is rotation of " + s1);
        } else {
            System.out.print(s2 + " is not rotation of " + s1);
        }
    }

    public static boolean isIsomorphic(String s, String t) {
        Hashtable<Character, Character> hash = new Hashtable<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            Character s1 = s.charAt(i);
            Character t1 = t.charAt(i);
            if (!hash.containsKey(s1) && !hash.containsValue(t1)) {
                hash.put(s1, t1);
            } else {
                Character c = hash.get(s1);
                if (t1 != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
