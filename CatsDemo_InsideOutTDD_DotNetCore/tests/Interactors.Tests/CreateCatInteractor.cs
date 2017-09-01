using System;

namespace Interactors.Tests
{
    internal class CreateCatInteractor
    {
        public CreateCatInteractor()
        {
        }
        
        public Cat Execute(string name)
        {
            return new Cat
            {
                Name = name
            };
        }
    }
}