using System;
using System.Collections.Generic;
using System.Text;

namespace Interactors.CreateCat
{
    public class CreateCatResponse
    {
        public Guid Id { get; private set; }
        public string Name { get; private set; }
        public string Title { get; private set; }

        public CreateCatResponse(Guid id, string name, string title)
        {
            Id = id;
            Name = name;
            Title = title;
        }
    }
}
