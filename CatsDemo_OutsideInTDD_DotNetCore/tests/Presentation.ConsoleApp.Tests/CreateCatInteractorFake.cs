using System;
using Interactors;

namespace Presentation.ConsoleApp.Tests
{
    internal class CreateCatInteractorFake : ICreateCatInteractor
    {
        public bool IsExecuteCalled { get; private set; } = false;

        public void Execute(ICreateCatRequest request)
        {
            IsExecuteCalled = true;
        }        
    }
}