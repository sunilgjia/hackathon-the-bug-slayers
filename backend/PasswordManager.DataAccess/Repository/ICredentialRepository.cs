using PasswordManager.BussinessLayer.ViewModel;
using System.Collections.Generic;

namespace PasswordManager.DataAccess.Repository
{
    public interface ICredentialRepository
    {
        IList<CredentialDto> GetAll(bool? IsShared,int? userId);

        Credentials GetById(int id);

    }
}
