using System;
using System.Collections.Generic;
using System.Text;

namespace Interactors.CreateCat
{
    public interface ICreateCatPresenter
    {
        void Execute(CreateCatResponse response);
    }
}
