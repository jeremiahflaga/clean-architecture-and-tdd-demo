using System;
using System.Collections.Generic;
using System.Linq;

namespace TwoLayers
{
    class CreateCatService
    {
        private static IList<Cat> catsDb = new List<Cat>();

        public CreateCatResponse Execute(string name, string title)
        {
            // save new cat to the database
            Guid newCatId = Guid.NewGuid();
            Cat newCat = new Cat(newCatId)
            {
                Name = name,
                Title = title
            };
            catsDb.Add(newCat);

            // get cat from database
            Cat catFromDb = (from cat in catsDb
                             where cat.Id == newCatId
                             select cat).Single();

            return MakeResponse(catFromDb);
        }

        private CreateCatResponse MakeResponse(Cat catFromDb)
        {
            string grandioseName;
            if (string.IsNullOrEmpty(catFromDb.Title))
                grandioseName = catFromDb.Name;
            else
                grandioseName = string.Format("{0}, \"{1}\"", catFromDb.Name, catFromDb.Title);

            CreateCatResponse response = new CreateCatResponse
            {
                grandioseName = grandioseName,
                isCatImportant = grandioseName.Length <= 10
            };

            return response;
        }
    }
}
