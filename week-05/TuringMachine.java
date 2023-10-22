/**
 * @author Aiden Truong
 */

@SuppressWarnings("unchecked")
public class TuringMachine {
    private int state;
    private int startState;
    private String[] action;
    private ST<Character, Integer>[] next;
    private ST<Character, Character>[] out;

    public TuringMachine(String filename) {
        In file = new In(filename);
        int numberOfStates = file.readInt();
        String alphabet = file.readString();
        startState = file.readInt();
        action = new String[numberOfStates];
        next = new ST[numberOfStates];
        out = new ST[numberOfStates];

        for (int state = 0; state < numberOfStates; state++) {
            action[state] = file.readString();

            next[state] = new ST<>();
            for (int i = 0; i < alphabet.length(); i++) {
                int transition = file.readInt();
                // StdOut.print(transition + " ");
                next[state].put(alphabet.charAt(i), transition);
            }

            out[state] = new ST<>();
            for (int i = 0; i < alphabet.length(); i++) {
                char symbol = file.readString().charAt(0);
                // StdOut.print(symbol + " ");
                out[state].put(alphabet.charAt(i), symbol);
            }
        }
    }

    public String simulate(String input) {
        Tape tape = new Tape(input);
        state = startState;

        while (action[state].equals("L") || action[state].equals("R")) {
            char c = tape.read();
            tape.write(out[state].get(c));
            state = next[state].get(c);
            
            if (action[state].equals("R")) {
                tape.moveRight();
            }
            
            if (action[state].equals("L")) {
                tape.moveLeft();
            }
        }

        return action[state] + " " + tape;
    }

    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine(args[0]);

        while (StdIn.hasNextLine()) {
            String input = StdIn.readLine();
            StdOut.println(tm.simulate(input));
        }
    }
}