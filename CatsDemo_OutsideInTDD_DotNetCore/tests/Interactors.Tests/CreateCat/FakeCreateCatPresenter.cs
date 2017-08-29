using System;
using System.Collections.Generic;
using Interactors.CreateCat;

namespace Interactors.Tests
{
    internal class FakeCreateCatPresenter : ICreateCatPresenter
    {
        public bool TheExecuteMethodWasCalled { get; set; } = false;
        public CreateCatResponse TheResponseModelPassedAsParameterToTheExecuteMethod { get; set; }

        public void Execute(CreateCatResponse response)
        {
            TheExecuteMethodWasCalled = true;
            TheResponseModelPassedAsParameterToTheExecuteMethod = response;
        }
    }
}