using PasswordManager.BussinessLayer.Common;
using PasswordManager.BussinessLayer.ViewModel;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;
using System.Linq;
namespace PasswordManager.DataAccess.Repository
{
    public class UserRepository : IUserRepository
    {
        public List<User> GetAll(int id)
        {
            using (SqlConnection con = new SqlConnection(AppSettings.ConnectionString))
            {
                string query = @"select * from Users where id <> " + id;

                using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                {
                    using (DataTable dt = new DataTable())
                    {
                        sda.Fill(dt);
                        return (from user in dt.AsEnumerable()
                                select new User
                                {
                                    Id = user.Field<int>("Id"),
                                    Email = user.Field<string>("Email"),
                                    Name = user.Field<string>("Name"),
                                    // Password = user.Field<string>("Password"),
                                }).ToList();

                    }
                }

            }
        }
    }
}
