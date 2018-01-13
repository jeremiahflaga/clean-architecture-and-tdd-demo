using System;
using System.Collections.Generic;
using System.Text;

namespace Domain.Repositories
{
    public interface ICatsRepository
    {
        void Save(Cat cat);
    }
}
