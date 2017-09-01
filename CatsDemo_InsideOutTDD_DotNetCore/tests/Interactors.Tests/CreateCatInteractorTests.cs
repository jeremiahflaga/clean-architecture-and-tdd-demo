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
        private Cat cat;

        private FakeCatRepository repository;

        public CreateCatInteractorTests()
        {
            // arrange
            name = "Kang Kang";
            repository = new FakeCatRepository();
            interactor = new CreateCatInteractor(repository);

            // act
            cat = interactor.Execute(name);
        }

        [Fact]
        public void ItShouldCreateANewCatWithTheSameNameWeSpecified()
        {
            // assert
            Assert.Equal(name, cat.Name);
        }

        [Fact]
        public void ItShouldSaveTheNewCatToTheDatabase()
        {
            // assert
            Assert.True(repository.TheSaveMethodShouldBeCalled);
        }
    }
}
