public class LRS {
    public static String lcp(String s, String t) {
        int iMinimumLength = Math.min(s.length(), t.length());
        for (int i = 0; i < iMinimumLength; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(0, i);
            }
        }

        return s.substring(0, iMinimumLength);
    }

    public static String lrs(String s) {
        int iStringLenth = s.length();
        String sLRS = "";

        for (int i = 0; i < iStringLenth; i++) {
            for (int j = i + 1; j < iStringLenth; j++) {
                String x = lcp(s.substring(i, iStringLenth), s.substring(j, iStringLenth));
                if (x.length() > sLRS.length()) {
                    sLRS = x;
                }
            }
        }

        return sLRS;
    }

    public static void main(String[] args) {
        String sSubstring = StdIn.readAll();

        StdOut.println(lrs(sSubstring));
    }
}