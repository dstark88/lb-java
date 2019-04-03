package hello;

import org.joda.time.LocalTime;
import static spark.Spark.*;

public class HelloWorld {
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
        get("/hello", (req, res) -> "Hello World");
	}
}