using System;
using Domain;
using Domain.Repositories;

namespace Interactors.Tests
{
    internal class FakeCatRepository : ICatsRepository
    {
        public bool TheSaveMethodWasCalled { get; private set; }

        public FakeCatRepository()
        {
            TheSaveMethodWasCalled = false;
        }

        public void Save(Cat cat)
        {
            TheSaveMethodWasCalled = true;
        }
    }
}