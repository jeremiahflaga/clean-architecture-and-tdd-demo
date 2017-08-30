using System;
using Domain.Entities;
using Domain.Repositories;

namespace Interactors.Tests
{
    internal class FakeCatRepository : ICatsRepository
    {
        public bool TheSaveMethodWasCalled { get; private set; } = false;
        
        public void Save(Cat cat)
        {
            TheSaveMethodWasCalled = true;
        }
    }
}