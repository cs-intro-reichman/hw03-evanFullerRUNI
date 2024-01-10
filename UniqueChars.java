/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }
    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        // initialize a new string
        String newString = "";
        int length = s.length();

        // loop through the string and add unique characters to the new string
        for (int i = 0; i < length; i++) {
            if (i == s.indexOf(s.charAt(i)) || s.charAt(i) == ' ') {
                newString += s.charAt(i);
            }
        }

        return newString;
    }
}
