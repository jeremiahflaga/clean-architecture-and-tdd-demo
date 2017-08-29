using Interactors.CreateCat;
using System;
using Xunit;

namespace Interactors.Tests
{
    public class CreateCatInteractorTests
    {
        [Fact]
        public void ShouldCreateAResponseModel()
        {
            // arrange
            var presenter = new FakeCreateCatPresenter();
            var request = new CreateCatRequest("Kang Kang", "The Great");
            var interactor = new CreateCatInteractor(presenter);

            // act
            interactor.Execute(request);

            // assert
            Assert.NotNull(presenter.TheResponseModelPassedAsParameterToTheExecuteMethod.Id);
            Assert.Equal("Kang Kang", presenter.TheResponseModelPassedAsParameterToTheExecuteMethod.Name);
            Assert.Equal("The Great", presenter.TheResponseModelPassedAsParameterToTheExecuteMethod.Title);
        }

        [Fact]
        public void ShouldExecuteThePresenter()
        {
            // arrange
            var presenter = new FakeCreateCatPresenter();
            var request = new CreateCatRequest("Kang Kang", "The Great");
            var interactor = new CreateCatInteractor(presenter);

            // act
            interactor.Execute(request);

            // assert
            Assert.True(presenter.TheExecuteMethodWasCalled);
        }
    }
}
