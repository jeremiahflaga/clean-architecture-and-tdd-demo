using System;
using System.Collections.Generic;
using Interactors.CreateCat;

namespace Interactors.Tests
{
    internal class FakeCreateCatPresenter : ICreateCatPresenter
    {
        public bool TheExecuteMethodWasCalled { get; set; } = false;
        public CreateCatRequest TheRequestPassedAsParameterToTheExecuteMethod { get; set; }

        public void Execute(CreateCatRequest request)
        {
            TheExecuteMethodWasCalled = true;
            TheRequestPassedAsParameterToTheExecuteMethod = request;
        }
    }
}