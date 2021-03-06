﻿using Domain.Entities;
using Domain.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Domain.Interactors.CreateCat
{
    public class CreateCatInteractor
    {
        private ICatsRepository _respository;

        public CreateCatInteractor(ICatsRepository repository)
        {
            _respository = repository;
        }

        public CreateCatResponse Execute(string name, string title)
        {
            Guid newCatId = Guid.NewGuid();
            Cat newCat = new Cat(newCatId)
            {
                Name = name,
                Title = title
            };

            _respository.Add(newCat);
            Cat catFromDb = _respository.Get(newCatId);

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
