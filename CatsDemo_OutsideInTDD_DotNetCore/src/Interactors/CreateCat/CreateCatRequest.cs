namespace Interactors.CreateCat
{
    public class CreateCatRequest
    {
        public string Name { get; private set; }
        public string Title { get; private set; }

        public CreateCatRequest(string name, string title)
        {
            Name = name;
            Title = title;
        }
    }
}