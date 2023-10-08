/**
 * @author Aiden Truong
 */

public class Generator {
    public static String RandomGenerator(String alphabet, int length) {
        char[] cStringChar = new char[length];
        int iRandomLengthOfString = 0;

        for (int i = 0; i < cStringChar.length; i++) {
            iRandomLengthOfString = StdRandom.uniformInt(alphabet.length());
            cStringChar[i] = alphabet.charAt(iRandomLengthOfString);
        }

        return new String(cStringChar);
    }

    public static void main(String[] args) {
        int iNumOfRandomStrings = Integer.parseInt(args[0]);
        int iLengthOfRandomString = Integer.parseInt(args[1]);
        String sAlphabet = args[2];
        
        for (int i = 0; i < iNumOfRandomStrings; i++) {
            StdOut.println(RandomGenerator(sAlphabet, iLengthOfRandomString));
        }
    }
}