package org.dpo.lackman;

public class C01Strings {

    public static void main(String[] args) {

    }

    public static boolean isUniqueChars(String str) {
        //ASCII has only 128 chars
        if (str.length() > 128) {
            return false;
        }

        boolean[] visited = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int charAt = str.charAt(i);
            if (visited[charAt]) {
                return false;
            } else {
                visited[charAt] = true;
            }
        }
        return false;
    }
}
