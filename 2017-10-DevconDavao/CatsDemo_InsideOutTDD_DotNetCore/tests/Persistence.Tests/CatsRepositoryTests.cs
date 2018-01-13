using Domain;
using Persistence;
using System.IO;
using Xunit;

namespace Persistence.Tests
{
    public class CatsRepositoryTests
    {
        [Fact]
        public void ShouldSaveNewCatIntoTheDatabase()
        {
            // arrange
            var repository = new CatsRepository("cats.db");
            var cat = new Cat { Name = "Kang Kang" };

            // act
            repository.Save(cat);

            // assert
            using (StreamReader reader = File.OpenText("cats.db"))
            {
                Assert.Contains("Kang Kang", reader.ReadLine());
            }
        }
    }
}
