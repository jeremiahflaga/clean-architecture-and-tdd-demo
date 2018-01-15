using System;

namespace Layered
{
    public class Cat
    {
        public Cat(Guid id)
        {
            Id = id;
        }

        public Guid Id { get; private set; }
        public string Name { get; set; }
        public string Title { get; set; }

        public string GrandioseName
        {
            get
            {
                return string.Format("{0}, \"{1}\"", Name, Title);
            }
        }

        public bool IsImportant
        {
            get
            {
                return GrandioseName.Length <= 10;
            }
        }
    }
}