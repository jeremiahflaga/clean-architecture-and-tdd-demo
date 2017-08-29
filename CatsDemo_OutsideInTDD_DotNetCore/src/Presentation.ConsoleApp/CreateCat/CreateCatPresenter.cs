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
            throw new NotImplementedException();
        }
    }
}
