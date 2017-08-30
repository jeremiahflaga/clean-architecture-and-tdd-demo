using System;
using Presentation.ConsoleApp.CreateCat;

namespace Presentation.ConsoleApp.Tests.Presenters
{
    internal class FakeCreatePresenterView : ICreateCatView
    {
        public CreateCatViewModel TheViewModelCreatedByThePresenter { get; private set; }
        public bool TheRenderMethodWasCalled { get; private set; } = false;

        public void Render(CreateCatViewModel viewModel)
        {
            TheRenderMethodWasCalled = true;
            TheViewModelCreatedByThePresenter = viewModel;
        }
    }
}