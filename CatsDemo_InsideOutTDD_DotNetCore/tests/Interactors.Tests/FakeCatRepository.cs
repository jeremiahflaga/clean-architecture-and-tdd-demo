using System;
using Domain;
using Domain.Repositories;

namespace Interactors.Tests
{
    internal class FakeCatRepository : ICatsRepository
    {
        public bool TheSaveMethodShouldBeCalled { get; private set; }

        public FakeCatRepository()
        {
            TheSaveMethodShouldBeCalled = false;
        }

        public void Save(Cat cat)
        {
            TheSaveMethodShouldBeCalled = true;
        }
    }
}