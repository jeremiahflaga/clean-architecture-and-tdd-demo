import org.junit.Assert;
import org.junit.Test;

public class GreeterTests {

    @Test
    public void shouldReturnCorrectMessage() {
        // arrange
        Greeter greeter = new Greeter();

        // act
        String greeting = greeter.greet("Jboy");

        // assert
        Assert.assertEquals("Hello, Jboy!", greeting);
    }
}
