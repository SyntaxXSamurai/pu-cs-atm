/**
 * @author Robert Sedgewick and Keving Wayne
 */

@SuppressWarnings("unchecked")
public class TuringMachineExample {
    private int start;
    private String[] action;
    private ST<Character, Integer>[] next;
    private ST<Character, Character>[] out;

    public TuringMachineExample(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        String alphabet = in.readString();
        start = in.readInt();
        action = new String[n];
        next = new ST[n];
        out = new ST[n];
        for (int st = 0; st < n; st++) {
            action[st] = in.readString();
            if (action[st].equals("H") || action[st].equals("Yes") || action[st].equals("No"))
                continue;

            next[st] = new ST<Character, Integer>();

            for (int i = 0; i < alphabet.length(); i++) {
                int state = in.readInt();
                next[st].put(alphabet.charAt(i), state);
            }

            out[st] = new ST<Character, Character>();
            for (int i = 0; i < alphabet.length(); i++) {
                char symbol = in.readString().charAt(0);
                out[st].put(alphabet.charAt(i), symbol);
            }
       }
   }

    public String simulate(String input) {
        Tape tape = new Tape(input);
        int state = start;
        while (action[state].equals("L") || action[state].equals("R")) {
            if (action[state].equals("R")) tape.moveRight();
            if (action[state].equals("L")) tape.moveLeft();
            char c = tape.read();
            tape.write(out[state].get(c));
            state = next[state].get(c);
        }
        return action[state] + " " + tape;
    }

   public static void main(String[] args) {
       TuringMachineExample tm = new TuringMachineExample(args[0]);
       while (StdIn.hasNextLine()) {
           String input = StdIn.readLine();
           StdOut.println(tm.simulate(input));
       }
   }
}