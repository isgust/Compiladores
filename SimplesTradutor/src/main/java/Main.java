public class Main {
    public static void main(String[] args) throws Exception {
        String input = "8+5*2-7/3";
        Parser p = new Parser (input.getBytes());
        p.parse();

    }
}