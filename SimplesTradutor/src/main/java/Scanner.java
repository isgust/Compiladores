public class Scanner {

    private byte[] input;
    private int current;

    public Scanner (byte[] input) {
        this.input = input;
    }

    // Metodo proveniente da classe Parser, agora no Scanner
    private char peek () {
        if (current < input.length)
            return (char)input[current];
        return '\0';
    }

    // Metodo auxiliar que encapsula avanço dos tokens e verifica se está no final de arquivo
    private void advance()  {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    // Retorna Token de 1 caractere
    public Token nextToken () {
        char ch = peek();
        if (ch == '0') {
            advance();
            return new Token (TokenType.NUMBER, Character.toString(ch));
        }  else if (Character.isDigit(ch))
            return number();



        switch (ch) {
            case '+':
                advance();
                return new Token (TokenType.PLUS,"+");
            case '-':
                advance();
                return new Token (TokenType.MINUS,"-");
            case '\0':
                return new Token (TokenType.EOF,"EOF");
            default:
                throw new Error("lexical error at " + ch);
        }
    }

    // Identificador de numero inteiro positivo
    private Token number() {
        int start = current ;
        while (Character.isDigit(peek())) {
            advance();
        }

        String n = new String(input, start, current-start)  ;
        return new Token(TokenType.NUMBER, n);
    }
}