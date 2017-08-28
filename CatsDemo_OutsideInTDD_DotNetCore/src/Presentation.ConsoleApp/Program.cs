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
                            string filename = args[4];
                            using (StreamWriter writer = File.CreateText(filename))
                            {
                                writer.WriteLine(string.Format("{0}, {1}", catName, catTitle));
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