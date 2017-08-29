using System;
using System.IO;
using Xunit;

namespace Specification.ConsoleApp
{
    public class CreateCatSpecs
    {
        string _outputFilename = System.IO.Path.Combine(System.AppContext.BaseDirectory, "output.txt");

        string _name = "";
        string _title = "";

        public CreateCatSpecs()
        {
            GivenTheFollowCatInfo();
            WhenICreateACat();
        }

        private void GivenTheFollowCatInfo()
        {
            _name = "Kang Kang";
            _title = "The Great";
        }

        private void WhenICreateACat()
        {
            // 0. clear the file first
            using (StreamWriter writer = File.CreateText(_outputFilename))
            {
                writer.Flush();
            }

            // 1. run the console app
            // 2. make a request to add a new cat
            string[] args = { "CREATE", "cat", _name, _title, _outputFilename };
            Presentation.ConsoleApp.Program.Main(args);
        }

        [Fact]
        public void ThenItShouldAddTheNewCatToTheListOfCats()
        {
            // 3. check whether the new cat is in the list of cats
            using (StreamReader reader = File.OpenText(_outputFilename))
            {
                string line = reader.ReadLine();
                Assert.Contains(string.Format("{0}, {1}", _name, _title), line);
            }
        }
    }
}
