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
    public String nextToken () {
        char ch = peek();

        if (ch == '0') {
            advance();
            return Character.toString(ch);
        } else if (Character.isDigit(ch)) {
            return number();

        }
        switch (ch) {
            case '+':
            case '-':
                advance();
                return Character.toString(ch);
            default:
                break;
        }
        throw new Error("lexical error");

    }

    // Identificador de numero inteiro positivo
    private String number() {
        int start = current ;
        while (Character.isDigit(peek())) {
            advance();
        }

        String n = new String(input, start, current-start)  ;
        return n;
    }
}