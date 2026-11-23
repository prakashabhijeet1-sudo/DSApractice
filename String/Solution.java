package String;

/*Given a string s consisting of only the characters 'a' and 'b', return true if every 'a' appears before every 'b' in the string. Otherwise, return false.*/

 class Solution {
    public boolean checkString(String s) {
        boolean foundB = false;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'b') {
                foundB = true;
            }

            if (s.charAt(i) == 'a' && foundB) {
                return false;
            }
        }

        return true;
    }
}
