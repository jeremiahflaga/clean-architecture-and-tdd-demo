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
                             select cat).First();

            // show cat to the user
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
