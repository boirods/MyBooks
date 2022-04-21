package top.rregio.mybooks;
import io.javalin.Javalin;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(10000);
        app.get("/", ctx -> ctx.result("<h1>Ol&aacute; Mundo em meu Javalin!</h1>"));
    }
}
