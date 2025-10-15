public class Parser {

    private Scanner scan;
    private Token currentToken;

    public Parser(byte[] input) {
        scan = new Scanner(input);
        currentToken = scan.nextToken();
    }

    // Update token
    private void nextToken () {
        currentToken = scan.nextToken();
    }

    // Novo metodo match
    private void match(TokenType t) {
        if (currentToken.type == t) {
            nextToken();
        }else {
            throw new Error("syntax error");
        }
    }

    // Novo metodo Digit
    void number () {
        System.out.println("push " + currentToken.lexeme);
        match(TokenType.NUMBER);
    }

    // Novo metodo oper
    void oper () {
        if (currentToken.type == TokenType.PLUS) {
            match(TokenType.PLUS);
            number();
            System.out.println("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            match(TokenType.MINUS);
            number();
            System.out.println("sub");
            oper();
        }
    }

    // Permanece o mesmo
    void expr() {
        number();
        oper();
    }

    public void parse () {
        expr();
    }
}