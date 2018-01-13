using Presentation.ConsoleApp.CreateCat;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Presentation.ConsoleApp.Views
{
    class CreateCatView : ICreateCatView
    {
        private string outputFilename;

        public CreateCatView(string outputFilename)
        {
            this.outputFilename = outputFilename;
        }

        public void Render(CreateCatViewModel viewModel)
        {
            using (StreamWriter writer = File.CreateText(outputFilename))
            {
                writer.WriteLine(string.Format("{0}: {1}", viewModel.Id, viewModel.PrettyName));
            }
        }
    }
}
