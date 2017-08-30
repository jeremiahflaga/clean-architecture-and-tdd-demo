using Interactors.CreateCat;
using Presentation.ConsoleApp.CreateCat;
using System;
using System.Collections.Generic;
using System.Text;
using Xunit;

namespace Presentation.ConsoleApp.Tests.Presenters
{
    public class CreateCatPresenterTests
    {
        CreateCatPresenter presenter;
        CreateCatResponse response;
        FakeCreatePresenterView view;

        public CreateCatPresenterTests()
        {
            // arrange
            view = new FakeCreatePresenterView();

            presenter = new CreateCatPresenter(view);
            response = new CreateCatResponse(Guid.NewGuid(), "Kang Kang", "The Great");

            // act
            presenter.Execute(response);
        }

        [Fact]
        public void ShouldCreateAViewModel()
        {
            // assert
            Assert.Equal("Kang Kang The Great", view.TheViewModelCreatedByThePresenter.PrettyName);
        }

        [Fact]
        public void ShouldCallTheRenderMethod()
        {
            // assert
            Assert.True(view.TheRenderMethodWasCalled);
        }
    }
}
