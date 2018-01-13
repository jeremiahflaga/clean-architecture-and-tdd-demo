using Xunit;
using System.IO;

namespace Persistence.Tests
{
    public class CatsRepositoryTests
    {
        [Fact]
        public void ShouldSaveDataToDatabase()
        {
            // arrange
            string dbFilename = Path.Combine(System.AppContext.BaseDirectory, "test_cats.db");
            var repository = new CatsRepository(dbFilename);
            var cat = Domain.Entities.Cat.NewCat();
            cat.Name = "Kang Kang";
            cat.Title = "The Great";

            // act
            repository.Save(cat);

            // assert
            using (StreamReader reader = File.OpenText(dbFilename))
            {
                Assert.Equal(string.Format("{0},{1},{2}", cat.Id, cat.Name, cat.Title), reader.ReadLine());
            }
        }
    }
}
