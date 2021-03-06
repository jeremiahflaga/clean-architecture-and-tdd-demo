using Domain;
using Interactors;
using System;
using Xunit;

namespace Interactors.Tests
{
    public class CreateCatInteractorTests
    {
        private string name;
        private CreateCatInteractor interactor;
        private CreateCatResponse response;

        private FakeCatRepository repository;

        public CreateCatInteractorTests()
        {
            // arrange
            name = "Kang Kang";
            repository = new FakeCatRepository();
            interactor = new CreateCatInteractor(repository);

            var request = new CreateCatRequest();
            request.Name = name;

            // act
            response = interactor.Execute(request);
        }

        [Fact]
        public void ShouldReturnTheCorrectResponse()
        {
            // assert
            Assert.NotNull(response);
            Assert.Equal(name, response.Name);
        }

        [Fact]
        public void ShouldSaveTheNewCatToTheDatabase()
        {
            // assert
            Assert.True(repository.TheSaveMethodWasCalled);
        }
    }
}