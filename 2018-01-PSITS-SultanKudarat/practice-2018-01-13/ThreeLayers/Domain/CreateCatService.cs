using System;
using System.Collections.Generic;
using System.Linq;

namespace ThreeLayers
{
    class CreateCatService
    {
        public CreateCatResponse Execute(string name, string title)
        {
            CatsRepository catsRepository = new CatsRepository();
            Guid newCatId = Guid.NewGuid();
            Cat newCat = new Cat(newCatId)
            {
                Name = name,
                Title = title
            };

            catsRepository.Add(newCat);
            Cat catFromDb = catsRepository.Get(newCatId);

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
