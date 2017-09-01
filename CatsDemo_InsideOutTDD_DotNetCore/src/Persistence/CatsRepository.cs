using System;
using Domain;
using Domain.Repositories;
using System.IO;

namespace Persistence
{
    public class CatsRepository : ICatsRepository
    {
        private string dbFileName;
        
        public CatsRepository(string dbFileName)
        {
            this.dbFileName = dbFileName;
        }

        public void Save(Cat cat)
        {
            using (StreamWriter writer = File.CreateText(dbFileName))
            {
                writer.WriteLine(cat.Name);
            }
        }
    }
}