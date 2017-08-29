using System;
using Presentation.ConsoleApp.CreateCat;

namespace Presentation.ConsoleApp.Tests.Presenters
{
    internal class FakeCreatePresenterView : ICreateCatView
    {
        public CreateCatViewModel TheViewModelCreatedByThePresenter { get; internal set; }

        public void Render(CreateCatViewModel viewModel)
        {
            TheViewModelCreatedByThePresenter = viewModel;
        }
    }
}