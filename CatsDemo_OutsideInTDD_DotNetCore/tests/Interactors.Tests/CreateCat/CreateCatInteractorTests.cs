using Interactors.CreateCat;
using System;
using Xunit;

namespace Interactors.Tests
{
    public class CreateCatInteractorTests
    {
        [Fact]
        public void ExecuteShouldCallThePresenterPassingTheRequiredParameters()
        {
            // arrange
            var presenter = new FakeCreateCatPresenter();
            var request = new CreateCatRequest("Kang Kang", "The Great");
            var interactor = new CreateCatInteractor(presenter);

            // act
            interactor.Execute(request);

            // assert
            Assert.Equal("Kang Kang", presenter.TheRequestPassedAsParameterToTheExecuteMethod.Name);
            Assert.Equal("The Great", presenter.TheRequestPassedAsParameterToTheExecuteMethod.Title);
        }
    }
}
