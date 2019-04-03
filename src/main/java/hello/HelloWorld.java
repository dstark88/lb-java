package hello;

// import org.joda.time.LocalTime;

// public class HelloWorld {
// 	public static void main(String[] args) {
// 		LocalTime currentTime = new LocalTime();
// 		System.out.println("The current local time is: " + currentTime);
// 		Greeter greeter = new Greeter();
// 		System.out.println(greeter.sayHello());
// 	}
// }
import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        // get("/hello", (req, res) -> "Hello Java World");
                //  port(5678); <- Uncomment this if you want spark to listen to port 5678 instead of the default 4567

                get("/hello", (request, response) -> "Hello Java World!");

                post("/hello", (request, response) ->
                    "Hello World: " + request.body()
                );
        
                get("/private", (request, response) -> {
                    response.status(401);
                    return "Go Away!!!";
                });

                get("/api/notes", (request, response) -> {
                    response.status(401);
                    return "/api/notes!!!";
                });
        
                get("/users/:name", (request, response) -> "Selected user: " + request.params(":name"));
        
                get("/news/:section", (request, response) -> {
                    response.type("text/xml");
                    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
                });
        
                get("/protected", (request, response) -> {
                    halt(403, "I don't think so!!!");
                    return null;
                });
        
                get("/redirect", (request, response) -> {
                    response.redirect("/news/world");
                    return null;
                });
        
                get("/", (request, response) -> "root");
    }
}

