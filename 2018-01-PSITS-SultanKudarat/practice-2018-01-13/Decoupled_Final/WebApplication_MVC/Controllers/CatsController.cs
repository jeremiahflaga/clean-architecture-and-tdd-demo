using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Domain.Interactors.CreateCat;
using Microsoft.AspNetCore.Mvc;
using WebApplication_MVC.Models;
using WebApplication_MVC.Models.Cats;

namespace WebApplication_MVC.Controllers
{
    public class CatsController : Controller
    {
        private CreateCatInteractor _interactor;

        public CatsController(CreateCatInteractor interactor)
        {
            _interactor = interactor;
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View(new CreateCatViewModel());
        }

        [HttpPost]
        public IActionResult Created(CreateCatViewModel model)
        {
            CreateCatResponse response = _interactor.Execute(model.Name, model.Title);

            return View(new CatCreatedViewModel
            {
                GrandioseName = response.grandioseName,
                CssColor = response.isCatImportant ? "red" : "blue"
            });
        }
    }
}
