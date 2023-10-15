import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Aiden Truong
 */

public class Harvester {
    public static void main(String[] args) {
        String re = args[0];
        In file = new In(args[1]);
        String text = file.readAll();
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            StdOut.println(matcher.group());
        }
    }
}