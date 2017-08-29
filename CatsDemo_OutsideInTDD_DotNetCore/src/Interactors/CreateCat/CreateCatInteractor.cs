using Domain.Entities;
using Domain.Repositories;
using System;

namespace Interactors.CreateCat
{
    public class CreateCatInteractor : ICreateCatInteractor
    {
        private ICreateCatPresenter presenter;
        private ICatRepository repository;
        
        public CreateCatInteractor(ICreateCatPresenter presenter, ICatRepository repository)
        {
            this.presenter = presenter;
            this.repository = repository;
        }

        public void Execute(CreateCatRequest request)
        {
            Cat cat = Cat.NewCat();
            cat.Name = request.Name;
            cat.Title = request.Title;

            repository.Save(cat);

            var response = new CreateCatResponse(cat.Id, request.Name, request.Title);
            presenter.Execute(response);
        }
    }
}
