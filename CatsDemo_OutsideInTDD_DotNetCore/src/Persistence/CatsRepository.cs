using System.IO;
using Domain.Entities;
using Domain.Repositories;

namespace Persistence
{
    public class CatsRepository : ICatsRepository
    {
        private string dbFilename;

        public CatsRepository(string dbFilename)
        {
            this.dbFilename = dbFilename;
        }

        public void Save(Cat cat)
        {
            using (StreamWriter writer = File.CreateText(dbFilename))
            {
                writer.WriteLine(string.Format("{0},{1},{2}", cat.Id, cat.Name, cat.Title));
            }
        }
    }
}
