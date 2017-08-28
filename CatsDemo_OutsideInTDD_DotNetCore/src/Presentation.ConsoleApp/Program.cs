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
                            string filename = args[3];
                            using (StreamWriter writer = File.CreateText(filename))
                            {
                                writer.WriteLine(catName);
                            }
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