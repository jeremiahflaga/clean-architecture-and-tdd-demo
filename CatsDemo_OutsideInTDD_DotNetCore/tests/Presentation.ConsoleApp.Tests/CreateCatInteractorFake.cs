using System;
using Interactors;

namespace Presentation.ConsoleApp.Tests
{
    internal class CreateCatInteractorFake : ICreateCatInteractor
    {
        public bool IsExecuteCalled { get; private set; } = false;
        public ICreateCatRequest TheGeneratedRequest { get; private set; }

        public void Execute(ICreateCatRequest request)
        {
            IsExecuteCalled = true;
            TheGeneratedRequest = request;
        }        
    }
}