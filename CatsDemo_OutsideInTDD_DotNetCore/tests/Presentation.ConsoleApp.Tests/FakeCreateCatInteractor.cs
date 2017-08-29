using System;
using Interactors;
using Interactors.CreateCat;

namespace Presentation.ConsoleApp.Tests
{
    internal class FakeCreateCatInteractor : ICreateCatInteractor
    {
        public bool TheExecuteMethodWasCalled { get; private set; } = false;
        public CreateCatRequest TheRequestParameterPassedIntoTheExecuteMethod { get; private set; }

        public void Execute(CreateCatRequest request)
        {
            TheExecuteMethodWasCalled = true;
            TheRequestParameterPassedIntoTheExecuteMethod = request;
        }
    }
}