import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Date: 7/27/16
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class stringManipulation {

    public static void main(String[] args) {
        /* check if all characters in a String are Unique */
        String str = "abchdesds";
        if (isUnique(str)) {
            System.out.print("Is Unique");
        } else {
            System.out.print("Is Not Unique");
        }
        System.out.print("\n");

        /* string reverse */
        String output = stringReversal(str);
        System.out.print(str+" reversal result is "+output);
        System.out.print("\n");

        /* check if one string is permutation of another */
        String str2 = "eabchds";
        String str3 = "abchdse";
        if (isPermutation(str2, str3)) {
            System.out.print(str2 + " is permutation of " + str3);

        } else {
            System.out.print(str2 + " is not a permutation of " + str3);
        }

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

    /* check if one string is permutation of another */
    public static boolean isPermutation(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        return (Sort(string1).equals(Sort(string2)));
    }

    public static char[] Sort(String string) {
        char[] arr1 = string.toCharArray();
        Arrays.sort(arr1);
        System.out.print(arr1);
        return arr1;
    }


}
