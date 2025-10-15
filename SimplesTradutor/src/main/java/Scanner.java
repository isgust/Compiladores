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
    public char nextToken () {
        char ch = peek();

        if (Character.isDigit(ch)) {
            advance();
            return ch;
        }

        switch (ch) {
            case '+':
            case '-':
                advance();
                return ch;
            default:
                break;
        }

        return '\0';
    }

}