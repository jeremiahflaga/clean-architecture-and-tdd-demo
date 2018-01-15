using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace Layered
{
    public class CatsRepository
    {
        private static IList<Cat> catsDb = new List<Cat>();

        public void Add(string name, string title)
        {
            Guid newCatId = Guid.NewGuid();
            Cat newCat = new Cat(newCatId)
            {
                Name = name,
                Title = title
            };

            catsDb.Add(newCat);
        }

        public Cat Get(string name)
        {
            return (from cat in catsDb
                             where cat.Name == name
                             select cat).First();
        }
    }
}
