using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace Domain.Repositories
{
    public interface ICatsRepository
    {
        void Add(string name, string title);

        Cat Get(string name);
    }
}
