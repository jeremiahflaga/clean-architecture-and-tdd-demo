using System;
using System.Collections.Generic;
using System.Text;

namespace Layered
{
    public class CreateCatService
    {
        public Cat Execute(string name, string title)
        {
            CatsRepository catsRepository = new CatsRepository();

            // save new cat to the database
            catsRepository.Add(name, title);

            // get cat from database
            Cat catFromDb = catsRepository.Get(name);

            return catFromDb;
        }
    }
}
