using Interactors;
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
            var interactor = new CreateCatInteractorFake();
            var controller = new CatsController(interactor);

            // act
            controller.Create(name, title);

            // assert
            Assert.True(interactor.IsExecuteCalled);
        }
    }
}
