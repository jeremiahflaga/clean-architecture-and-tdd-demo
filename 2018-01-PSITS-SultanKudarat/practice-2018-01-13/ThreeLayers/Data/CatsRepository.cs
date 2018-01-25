using System;
using System.Collections.Generic;
using System.Linq;

namespace ThreeLayers
{
    public class CatsRepository
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
