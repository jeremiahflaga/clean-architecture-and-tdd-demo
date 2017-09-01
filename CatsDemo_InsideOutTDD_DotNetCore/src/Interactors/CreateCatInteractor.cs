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

        public Cat Execute(string name)
        {
            var cat = new Cat
            {
                Name = name
            };

            repository.Save(cat);

            return cat;
        }
    }
}