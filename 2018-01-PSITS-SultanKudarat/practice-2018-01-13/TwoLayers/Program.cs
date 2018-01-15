using System;
using System.Collections.Generic;

namespace TwoLayers
{
    class Program
    {
        private static IList<Cat> catsDb = new List<Cat>();

        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to King Cat Creator App!\n");
            CreateKingCat();
        }

        private static void CreateKingCat()
        {
            // get input from user
            Console.WriteLine("Please enter name of cat: ");
            string name = Console.ReadLine();
            Console.WriteLine("Please enter title of cat: ");
            string title = Console.ReadLine();

            // process input
            CreateCatService service = new CreateCatService();
            CreateCatResponse response = service.Execute(name, title);
            
            // show cat to the user
            Console.Write("Hail the new King: ");
            if (response.IsImportant)
                Console.ForegroundColor = ConsoleColor.Red;
            else
                Console.ForegroundColor = ConsoleColor.Blue;

            Console.WriteLine(response.GrandioseName);
            Console.ReadLine();
        }
    }
}
