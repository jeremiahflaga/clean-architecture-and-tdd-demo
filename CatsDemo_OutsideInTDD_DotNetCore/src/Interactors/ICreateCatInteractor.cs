using System;

namespace Interactors
{
    public interface ICreateCatInteractor
    {
        void Execute(ICreateCatRequest request);
    }
}
