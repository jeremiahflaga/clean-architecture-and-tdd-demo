using System;
using System.Collections.Generic;
using System.Linq;

namespace Monolith
{
    class Program
    {
        private static IList<Cat> catsDb = new List<Cat>();

        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to King Cat Creator App!\n");

            CreateCatRequest request = GetRequestFromUser();
            CreateCatResponse response = ProcessRequest(request);
            ShowNewKingToUser(response);
        }

        private static CreateCatRequest GetRequestFromUser()
        {
            // get input from user
            Console.WriteLine("Please enter name of cat: ");
            string name = Console.ReadLine();
            Console.WriteLine("Please enter title of cat: ");
            string title = Console.ReadLine();

            return new CreateCatRequest
            {
                name = name,
                title = title
            };
        }

        private static CreateCatResponse ProcessRequest(CreateCatRequest request)
        {
            // save new cat to the database
            Guid newCatId = Guid.NewGuid();
            Cat newCat = new Cat(newCatId)
            {
                Name = request.name,
                Title = request.title
            };
            catsDb.Add(newCat);

            // get cat from database
            Cat catFromDb = (from cat in catsDb
                             where cat.Id == newCatId
                             select cat).Single();

            // create response
            return MakeResponse(catFromDb);
        }

        private static CreateCatResponse MakeResponse(Cat catFromDb)
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

        private static void ShowNewKingToUser(CreateCatResponse response)
        {
            Console.Write("Hail the new king: ");
            
            if (response.isCatImportant)
                Console.ForegroundColor = ConsoleColor.Red;
            else
                Console.ForegroundColor = ConsoleColor.Blue;

            Console.WriteLine(response.grandioseName);
            Console.ReadLine();
        }
    }
}
