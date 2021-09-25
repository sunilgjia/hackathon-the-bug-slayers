using PasswordManager.BussinessLayer.ViewModel;
using System;
using System.Collections.Generic;
using System.Text;

namespace PasswordManager.DataAccess.Repository
{
    public interface IUserRepository
    {
        List<User> GetAll(int id);
    }
}
