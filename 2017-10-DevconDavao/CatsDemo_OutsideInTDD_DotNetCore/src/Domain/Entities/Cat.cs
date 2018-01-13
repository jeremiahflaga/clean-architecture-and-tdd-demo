using System;
using System.Collections.Generic;
using System.Text;

namespace Domain.Entities
{
    public class Cat
    {
        public Guid Id { get; private set; }
        public string Name { get; set; }
        public string Title { get; set; }

        public Cat(Guid id)
        {
            Id = id;
        }

        public static Cat NewCat()
        {
            return new Cat(Guid.NewGuid());
        }
    }
}
