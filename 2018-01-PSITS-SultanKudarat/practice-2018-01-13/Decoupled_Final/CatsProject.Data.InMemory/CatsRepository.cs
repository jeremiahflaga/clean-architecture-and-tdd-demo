using Domain.Entities;
using Domain.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;

namespace CatsProject.Data.InMemory
{
    public class CatsRepository : ICatsRepository
    {
        private static IList<Cat> catsDb = new List<Cat>();

        public void Add(Cat cat)
        {
            catsDb.Add(cat);
        }

        public Cat Get(Guid id)
        {
            return (from cat in catsDb
                    where cat.Id == id
                    select cat).First();
        }
    }
}
