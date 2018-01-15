using System;
using System.Collections.Generic;
using System.Linq;

namespace ThreeLayers
{
    class CreateCatService
    {
        private static IList<Cat> catsDb = new List<Cat>();

        public CreateCatResponse Execute(string name, string title)
        {
            CatsRepository catsRepository = new CatsRepository();            
            catsRepository.Add(name, title);
            Cat catFromDb = catsRepository.Get(name);

            return MakeResponse(catFromDb);
        }

        private CreateCatResponse MakeResponse(Cat catFromDb)
        {
            string grandioseName = string.Format("{0}, \"{1}\"", catFromDb.Name, catFromDb.Title);
            CreateCatResponse response = new CreateCatResponse
            {
                GrandioseName = grandioseName,
                IsImportant = grandioseName.Length <= 10
            };

            return response;
        }
    }
}
