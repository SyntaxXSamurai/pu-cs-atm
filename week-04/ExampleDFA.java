/**
 * @author Robert Sedgewick and Kevin Wayne
 */

@SuppressWarnings("unchecked")
public class ExampleDFA {
    private String[] action;
    private ST<Character, Integer>[] next;

    public ExampleDFA(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        String alphabet = in.readString();
        action = new String[n];
        next = (ST<Character, Integer>[]) new ST[n];
        for (int state = 0; state < n; state++) {
            action[state] = in.readString();
            next[state] = new ST<Character, Integer>();
            for (int i = 0; i < alphabet.length(); i++)
                next[state].put(alphabet.charAt(i), in.readInt());
        }
    }

    public String simulate(String input) {
       int state = 0;
       for (int i = 0; i < input.length(); i++)
           state = next[state].get(input.charAt(i));
       return action[state];
    }

    public static void main(String[] args) {
        ExampleDFA dfa = new ExampleDFA(args[0]);
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            StdOut.println(dfa.simulate(line));
        }
    }
}
