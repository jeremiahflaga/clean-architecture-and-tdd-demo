using System;
using Xunit;

namespace Interactors.Tests
{
    public class CreateCatInteractorTests
    {
        [Fact]
        public void ItShouldCreateANewCatWithTheSameNameWeSpecified()
        {
            // arrange
            string name = "Kang Kang";
            var interactor = new CreateCatInteractor();

            // act
            Cat cat = interactor.Execute(name);

            // assert
            Assert.Equal(name, cat.Name);
        }
    }
}
