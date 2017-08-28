using System;
using Interactors;
using Interactors.CreateCat;

namespace Presentation.ConsoleApp.Tests
{
    internal class CreateCatInteractorFake : ICreateCatInteractor
    {
        public bool IsExecuteCalled { get; private set; } = false;
        public CreateCatRequest TheGeneratedRequest { get; private set; }

        public void Execute(CreateCatRequest request)
        {
            IsExecuteCalled = true;
            TheGeneratedRequest = request;
        }
    }
}