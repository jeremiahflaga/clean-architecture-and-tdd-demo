using Domain.Entities;

namespace Domain.Repositories
{
    public interface ICatsRepository
    {
        void Save(Cat cat);
    }
}