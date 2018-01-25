using Decoupled.Data;
using Decoupled.Domain;
using Decoupled.Domain.Repositories;
using System;

namespace Decoupled.Presentation
{
    class Program
    {
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
            // process input
            ICatsRepository repository = new CatsRepository();
            CreateCatInteractor service = new CreateCatInteractor(repository);
            CreateCatResponse response = service.Execute(request.name, request.title);
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
