/**
 * @author Aiden Truong
 */

@SuppressWarnings("unchecked")
public class DFA {
    private int startState;
    private boolean[] action;
    private ST<Character, Integer>[] next;

    public DFA(String filename) {
        In file = new In(filename);
        int numberOfStates = file.readInt();
        String alphabet = file.readString();
        int startState = file.readInt();
        action = new boolean[numberOfStates];
        next = new ST[numberOfStates];
        
        for (int state = startState; state < numberOfStates; state++) {
            action[state] = file.readBoolean();
            next[state] = new ST<>();

            for (int i = 0; i < alphabet.length(); i++) {
                next[state].put(alphabet.charAt(i), file.readInt());
            }
        }
    }

    public boolean recognises(String input) {
        int state = startState;

        for (int i = 0; i < input.length(); i++) {
            state = next[state].get(input.charAt(i));
        }

        return action[state];
    }

    public static void main(String[] args) {
        DFA dfa = new DFA(args[0]);

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();

            if (dfa.recognises(input)) {
                StdOut.print("yes");
            } else {
                StdOut.print("no");
            }
        }
    }
}