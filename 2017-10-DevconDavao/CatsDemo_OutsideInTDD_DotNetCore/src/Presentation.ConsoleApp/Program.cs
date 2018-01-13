using Interactors.CreateCat;
using Persistence;
using Presentation.ConsoleApp.CreateCat;
using Presentation.ConsoleApp.Views;
using System;
using System.IO;

namespace Presentation.ConsoleApp
{
    public class Program
    {
        public static void Main(string[] args)
        {
            if (args.Length > 0)
            {
                string command = args[0];
                switch (command.ToUpper())
                {
                    case "CREATE":
                        if (args[1].ToLower() == "cat")
                        {
                            string catName = args[2];
                            string catTitle = args[3];
                            string outputFilename = args[4];
                            string catsDbFilename = "cats.db";

                            var controller = new CatsController(
                                new CreateCatInteractor(
                                    new CreateCatPresenter(
                                        new CreateCatView(outputFilename)),
                                    new CatsRepository(catsDbFilename)));

                            controller.Create(catName, catTitle);
                        }
                        break;
                    case "GET":

                        break;
                    default:
                        break;
                }
            }
        }
    }
}