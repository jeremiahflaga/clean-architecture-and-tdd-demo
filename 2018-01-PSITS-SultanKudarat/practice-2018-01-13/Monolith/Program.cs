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

            CreateKingCat();

        }

        private static void CreateKingCat()
        {
            // get input from user
            Console.WriteLine("Please enter name of cat: ");
            string name = Console.ReadLine();
            Console.WriteLine("Please enter title of cat: ");
            string title = Console.ReadLine();

            // validate user input
            if (name == "Devil")
            {
                Console.WriteLine("ERROR: We cannot make the Devil as our new king");
                return;
            }

            // save new cat to the database
            Guid newCatId = Guid.NewGuid();
            Cat newCat = new Cat(newCatId)
            {
                Name = name,
                Title = title
            };
            catsDb.Add(newCat);

            // get cat from database
            Cat catFromDb = (from cat in catsDb
                             where cat.Id == newCatId
                             select cat).First();

            // show cat to the user
            Console.Write("Hail the new King: ");
            string grandioseName = string.Format("{0}, \"{1}\"", catFromDb.Name, catFromDb.Title);
            if (grandioseName.Length <= 10)
                Console.ForegroundColor = ConsoleColor.Red;
            else
                Console.ForegroundColor = ConsoleColor.Blue;
            
            Console.WriteLine(grandioseName);
            Console.ReadLine();
        }
    }
}
