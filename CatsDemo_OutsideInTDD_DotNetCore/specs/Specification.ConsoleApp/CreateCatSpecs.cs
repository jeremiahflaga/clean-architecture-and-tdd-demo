using System;
using System.IO;
using Xunit;

namespace Specification.ConsoleApp
{
    public class CreateCatSpecs
    {
        String _name = "";

        public CreateCatSpecs()
        {
            GivenTheFollowCatInfo();
            WhenICreateACat();
        }

        private void GivenTheFollowCatInfo()
        {
            _name = "Kang Kang";
        }

        private void WhenICreateACat()
        {
            // 0. clear the file first
            using (StreamWriter writer = File.CreateText("c:\\temp\\output.txt"))
            {
                writer.Flush();
            }

            // 1. run the console app
            // 2. make a request to add a new cat
            string[] args = { "CREATE", "cat", _name, "c:\\temp\\output.txt" };
            Presentation.ConsoleApp.Program.Main(args);
        }

        [Fact]
        public void ThenItShouldAddTheNewCatToTheListOfCats()
        {
            // 3. check whether the new cat is in the list of cats
            using (StreamReader reader = File.OpenText("c:\\temp\\output.txt"))
            {
                string line = reader.ReadLine();
                Assert.Contains(_name, line);
            }
        }
    }
}
