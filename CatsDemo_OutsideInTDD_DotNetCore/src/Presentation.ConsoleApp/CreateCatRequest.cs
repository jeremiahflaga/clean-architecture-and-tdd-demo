using Interactors;

namespace Presentation.ConsoleApp
{
    internal class CreateCatRequest : ICreateCatRequest
    {
        public string Name { get; set; }
        public string Title { get; set; }

        public CreateCatRequest(string name, string title)
        {
            this.Name = name;
            this.Title = title;
        }
    }
}