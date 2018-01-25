using Domain.Entities;
using Domain.Repositories;
using System;
using System.Data.SqlClient;

namespace CatsProject.Data.SqlClient
{
    public class CatsRepository : ICatsRepository
    {
        //private string _connectionString = @"Server=(localdb)\\v11.0;Database=CatsDB;Trusted_Connection=True;MultipleActiveResultSets=true";
        private string _connectionString = @"Server=(LocalDB)\MSSQLLocalDB; Integrated Security=true;AttachDbFileName=F:\Projects\jeremiahflaga\clean-architecture-and-tdd-demo\2018-01-PSITS-SultanKudarat\practice-2018-01-13\Decoupled_Final\Database\CatsDB.mdf";
        
        public void Add(Cat cat)
        {
            string insertCatCommand =
                "insert into Cats " +
                    "(Id, Name, Title) " +
                "values " +
                    "(@Id, @Name, @Title)";

            using (var connection = new SqlConnection(_connectionString))
            {
                using (var cmd = new SqlCommand(insertCatCommand, connection))
                {
                    cmd.Parameters.Add(createParameter("@Id", cat.Id));
                    cmd.Parameters.Add(createParameter("@Name", cat.Name));
                    cmd.Parameters.Add(createParameter("@Title", cat.Title));
                    
                    connection.Open();
                    cmd.ExecuteNonQuery();
                    connection.Close();
                }
            }
        }

        public Cat Get(Guid id)
        {
            string getCatsQuery = "select * from Cats where Id = @Id";

            using (var connection = new SqlConnection(_connectionString))
            {
                using (var cmd = new SqlCommand(getCatsQuery, connection))
                {
                    cmd.Parameters.Add(createParameter("@Id", id));

                    connection.Open();
                    SqlDataReader reader = cmd.ExecuteReader();
                    Cat cat = getNextCat(reader);
                    connection.Close();
                    return cat;
                }
            }
        }

        private Cat getNextCat(SqlDataReader reader)
        {
            reader.Read();

            return new Cat((Guid)reader["Id"])
            {
                Name = (string)reader["Name"],
                Title = (string)reader["Title"]
            };
        }

        private SqlParameter createParameter(string name, object value)
        {
            SqlParameter param = new SqlParameter();
            param.ParameterName = name;
            param.Value = value;
            return param;
        }
    }
}
