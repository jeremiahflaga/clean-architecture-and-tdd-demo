using System;

namespace TwoLayers
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
    }
}