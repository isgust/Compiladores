public class Parser {
    private byte[] input;
    private int current;

    public Parser (byte[] input) {
        this.input = input;
    }

    public void parse () {
        expr();
    }

    // Metodos Auxiliares

    // Retorna o token (carácter) corrente
    private char peek () {
        if (current < input.length)
            return (char)input[current];
        return '\0';
    }

    //Verifica se o caractere corrente casa com um carácter de entrada

    private void match (char c) {
        if (c == peek()) {
            current++;
        } else {
            throw new Error("syntax error");
        }
    }

    void expr() {
        digit();
        oper();
    }

    void digit () {
        if (Character.isDigit(peek())) {
            System.out.println("push " + peek());
            match(peek());
        } else {
            throw new Error("syntax error");
        }
    }

    void oper () {
        if (peek() == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (peek() == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }

}