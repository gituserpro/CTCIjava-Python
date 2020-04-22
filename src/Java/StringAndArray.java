package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringAndArray {


    public static boolean IsUnique1(String str) {

        boolean[] boolArr = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);

            if (boolArr[value] == true) {
                return false;
            } else {
                boolArr[value] = true;
            }
        }
        return true;
    }

    public static boolean isPrem(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 1) + 1);
        }

        for (int j = 0; j < s2.length(); j++) {

            if (!map.containsKey(s2.charAt(j))) {
                return false;
            }
            map.remove(s2.charAt(j));
        }

        map.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

        if (map.isEmpty()) {
            return true;
        }
        System.out.println(map.size() + " zine ");
        return false;
    }

    public static boolean IsPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 1) + 1);
        }

        int max = 0;

        for (Entry<Character, Integer> entry : map.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (v % 2 == 0) {
                max++;
            }
        }

        if (max > 2) {

            return false;
        }

        if (s.length() % 2 == 0 && max == 0 || s.length() % 2 != 0 && max == 1) {
            return true;
        }

        return false;
    }


    public static void StringCompression(String input){

    StringBuffer sb = new StringBuffer();

    int j  = 0;
    for(int i = 0; i < input.length(); i++){

        int count = 1;
        j = i+1;

        while( j < input.length() && input.charAt(i) == input.charAt(j) ){
            j++;
            count++;
        }

        sb.append(input.charAt(i));
        sb.append(count);
        i = j;
    }

        for(int l = 0; l < sb.length(); l++ ){
            System.out.print(sb.charAt(l));
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(" CTCI Java 8 and up up up ... Lets Goo!!! ");
//        boolean bool = IsUnique1("Helo");
//        System.out.println("Perm   ->  " + isPrem("abcd", "bcdaa") );

//        System.out.println("IsPalindrome   ->  " + IsPalindrome("abaaabxc"));

        System.out.println("StringCompression   ->  " );
        StringCompression("aaaabbbcccdddeeffgghi");
    }
}

