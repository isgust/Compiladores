public class Parser {

    private Scanner scan;
    private char currentToken;

    public Parser (byte[] input) {
        scan = new Scanner(input);
        currentToken = scan.nextToken();
    }

    // Update token
    private void nextToken () {
        currentToken = scan.nextToken();
    }

    // Novo metodo match
    private void match(char t) {
        if (currentToken == t) {
            nextToken();
        }else {
            throw new Error("syntax error");
        }
    }

    // Novo metodo Digit
    void digit () {
        if (Character.isDigit(currentToken)) {
            System.out.println("push " + currentToken);
            match(currentToken);
        } else {
            throw new Error("syntax error");
        }
    }

    // Novo metodo oper
    void oper () {
        if (currentToken == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (currentToken == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }

    // Permanece o mesmo
    void expr() {
        digit();
        oper();
    }

    public void parse () {
        expr();
    }
}