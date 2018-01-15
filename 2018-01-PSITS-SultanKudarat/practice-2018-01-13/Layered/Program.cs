using System;
using System.Collections.Generic;
using System.Linq;

namespace Layered
{
    class Program
    {
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

            CreateCatService createCatService = new CreateCatService();
            Cat cat = createCatService.Execute(name, title);
           
            // show cat to the user
            Console.Write("Hail the new King: ");
            if (cat.IsImportant)
                Console.ForegroundColor = ConsoleColor.Red;
            else
                Console.ForegroundColor = ConsoleColor.Blue;

            Console.WriteLine(cat.GrandioseName);
            Console.ReadLine();
        }
    }
}
