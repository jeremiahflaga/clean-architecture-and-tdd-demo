using System;
using Domain;
using Domain.Repositories;

namespace Interactors
{
    public class CreateCatInteractor
    {
        private ICatsRepository repository;
        
        public CreateCatInteractor(ICatsRepository repository)
        {
            this.repository = repository;
        }

        public CreateCatReponse Execute(CreateCatRequest request)
        {
            var cat = new Cat
            {
                Name = request.Name
            };

            repository.Save(cat);

            var response = new CreateCatReponse();
            response.Name = cat.Name;
            return response;
        }
    }
}