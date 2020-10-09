import java.io.PrintWriter;

public class Printer {
    private static PrintWriter out = new PrintWriter(System.out);

    public static void sendMessage(String message) {
        out.println(message);
        out.flush();
    }
}
