import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class PrintFriendlyStrings {
    public static void main(String[] args) {
        String[] arr = {"acs", "dess", "gh", "hg", "bef", "sca", "seds"};
        sortArrayOfAnagram(arr);
    }

    public static void sortArrayOfAnagram(String[] arr) {
        ArrayList<String> list = null;
        Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
        for (int i = 0; i < arr.length; i++) {
            String sorted = sort(arr[i]);
            if (table.containsKey(sorted)) {
                list = table.get(sorted);
            } else {
                list = new ArrayList<String>();
            }
            list.add(arr[i]);
            table.put(sorted, list);
        }
        for (String s : table.keySet()) {
            list = table.get(s);
            if (list.size() > 1) {
                for (String s1 : list) {
                    System.out.print(s1 + " ");
                }
                System.out.print("\n");
            }
        }
    }

    public static String sort(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        s = new String(a);
        return s;
    }
}


