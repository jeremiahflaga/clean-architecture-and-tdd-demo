using Interactors;
using System;
using Xunit;

namespace Presentation.ConsoleApp.Tests
{
    public class CatsControllerTests
    {
        [Fact]
        public void WhenTheCreateMethodIsCalledTheExcecuteMethodOfInteractorShouldBeCalled()
        {
            // arrange
            var interactor = new FakeCreateCatInteractor();
            var controller = new CatsController(interactor);

            // act
            controller.Create("", "");

            // assert
            Assert.True(interactor.TheExecuteMethodWasCalled);
        }

        [Fact]
        public void WhenTheCreateMethodIsCalledTheAppropriateRequestShouldBeCreated()
        {
            // arrange
            string name = "Kang Kang";
            string title = "The Great";
            var interactor = new FakeCreateCatInteractor();
            var controller = new CatsController(interactor);

            // act
            controller.Create(name, title);

            // assert
            Assert.Equal(name, interactor.TheRequestParameterPassedIntoTheExecuteMethod.Name);
            Assert.Equal(title, interactor.TheRequestParameterPassedIntoTheExecuteMethod.Title);
        }
    }
}
