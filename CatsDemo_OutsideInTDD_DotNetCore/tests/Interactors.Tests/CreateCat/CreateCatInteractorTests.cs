using Interactors.CreateCat;
using System;
using Xunit;

namespace Interactors.Tests
{
    public class CreateCatInteractorTests
    {
        private FakeCreateCatPresenter presenter;
        private FakeCatRepository repository;

        private CreateCatRequest request;
        private CreateCatInteractor interactor;

        public CreateCatInteractorTests()
        {
            // arrange
            presenter = new FakeCreateCatPresenter();
            repository = new FakeCatRepository();
            request = new CreateCatRequest("Kang Kang", "The Great");
            interactor = new CreateCatInteractor(presenter, repository);

            // act
            interactor.Execute(request);
        }

        [Fact]
        public void ShouldSaveNewCatToTheDatabase()
        {
            // assert
            Assert.True(repository.TheSaveMethodWasCalled);
        }

        [Fact]
        public void ShouldCreateAResponseModel()
        {
            // assert
            Assert.NotNull(presenter.TheResponseModelPassedAsParameterToTheExecuteMethod.Id);
            Assert.Equal("Kang Kang", presenter.TheResponseModelPassedAsParameterToTheExecuteMethod.Name);
            Assert.Equal("The Great", presenter.TheResponseModelPassedAsParameterToTheExecuteMethod.Title);
        }

        [Fact]
        public void ShouldExecuteThePresenter()
        {
            // assert
            Assert.True(presenter.TheExecuteMethodWasCalled);
        }
    }
}
