using System;

namespace Interactors.CreateCat
{
    public interface ICreateCatInteractor
    {
        void Execute(CreateCatRequest request);
    }
}
