using System;
using System.Collections.Generic;
using System.Text;
using Interactors;

namespace Presentation.ConsoleApp
{
    public class CatsController
    {
        private ICreateCatInteractor _interactor;

        public CatsController(ICreateCatInteractor interactor)
        {
            _interactor = interactor;
        }

        public void Create(string name, string title)
        {
            var request = new CreateCatRequest(name, title);
            _interactor.Execute(request);
        }
    }
}
