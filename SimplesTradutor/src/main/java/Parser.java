public class Parser {
    private byte[] input;
    private int current;

    public Parser (byte[] input) {
        this.input = input;
    }

    public void parse () {
        // aqui ainda ira o código
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

}