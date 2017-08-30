using Interactors.CreateCat;
using System;
using System.Collections.Generic;
using System.Text;

namespace Presentation.ConsoleApp.CreateCat
{
    public class CreateCatPresenter : ICreateCatPresenter
    {
        private ICreateCatView view;

        public CreateCatPresenter(ICreateCatView view)
        {
            this.view = view;
        }

        public void Execute(CreateCatResponse response)
        {
            var viewModel = new CreateCatViewModel();
            viewModel.Id = response.Id;
            viewModel.PrettyName = string.Format("{0} {1}", response.Name, response.Title);

            view.Render(viewModel);
        }
    }
}
