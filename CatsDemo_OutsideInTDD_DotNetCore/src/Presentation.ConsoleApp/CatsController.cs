using System;
using System.Collections.Generic;
using System.Text;
using Interactors;

namespace Presentation.ConsoleApp
{
    public class CatsController
    {
        private ICreateCatInteractor interactor;

        public CatsController(ICreateCatInteractor interactor)
        {
            this.interactor = interactor;
        }

        public void Create(string name, string title)
        {
            
        }
    }
}
