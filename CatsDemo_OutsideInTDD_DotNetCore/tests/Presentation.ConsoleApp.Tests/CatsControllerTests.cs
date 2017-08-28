using System;
using Xunit;

namespace Presentation.ConsoleApp.Tests
{
    public class CatsControllerTests
    {
        [Fact]
        public void TestCreate()
        {
            // arrange
            string name = "Kang Kang";
            string title = "The Great";
            var controller = new CatsController();

            // act
            controller.Create(name, title);

            // assert
            // TODO:
        }
    }
}
