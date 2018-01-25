using System;
using Xunit;

namespace TDDSample
{
    public class GreeterTests
    {
        [Fact]
        public void shouldReturnCorrectGreeting()
        {
            // arrange
            Greeter greeter = new Greeter();

            // act
            string greeting = greeter.Greet("Jboy");

            // assert
            Assert.Equal("Hello, Jboy!", greeting);
        }
        
        [Fact]
        public void shouldReturnCorrectGreeting_2()
        {
            // arrange
            Greeter greeter = new Greeter();

            // act
            string greeting = greeter.Greet("World");

            // assert
            Assert.Equal("Hello, World!", greeting);
        }
    }
}
