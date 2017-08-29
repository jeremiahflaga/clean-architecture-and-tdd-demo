using System;
using System.Collections.Generic;
using System.Text;

namespace Interactors.CreateCat
{
    public class CreateCatInteractor : ICreateCatInteractor
    {
        private ICreateCatPresenter presenter;

        public CreateCatInteractor(ICreateCatPresenter presenter)
        {
            this.presenter = presenter;
        }

        public void Execute(CreateCatRequest request)
        {
            presenter.Execute(new CreateCatResponse());
        }
    }
}
