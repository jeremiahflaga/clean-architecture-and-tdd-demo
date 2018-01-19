using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace Domain.Repositories
{
    public interface ICatsRepository
    {
        void Add(Cat cat);

        Cat Get(Guid id);
    }
}
