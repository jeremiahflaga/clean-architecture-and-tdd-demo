using Domain.Entities;

namespace Domain.Repositories
{
    public interface ICatRepository
    {
        void Save(Cat cat);
    }
}