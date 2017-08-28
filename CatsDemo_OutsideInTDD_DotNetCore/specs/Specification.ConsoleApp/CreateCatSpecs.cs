using System;
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
            // 1. run the console app
            // 2. make a request to add a new cat
            string[] args = { "CREATE", "cat", _name };
            ConsoleApp.Program.Main(args);
        }

        [Fact]
        public void ThenItShouldAddTheNewCatToTheListOfCats()
        {
            // 3. make a request to get all cats
            string[] args = { "GET", "cat", "c:\\temp\\output.txt" };
            ConsoleApp.Program.Main(args);

            // 4. check whether the new cat is in the list of cats
            throw new NotImplementedException();
        }
    }
}
