using PasswordManager.BussinessLayer.Common;
using PasswordManager.BussinessLayer.ViewModel;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;

namespace PasswordManager.DataAccess.Repository
{
    public class CredentialRepository : ICredentialRepository
    {
        public IList<CredentialDto> GetAll(bool? isShared, int? userId)
        {
            using (SqlConnection con = new SqlConnection(AppSettings.ConnectionString))
            {
                if (isShared == true)
                {
                    string query = @"select cr.*,p.CanView,CanEdit,CanDelete from Permission p inner join [Credential] cr on  p.CredentialId = cr.id where p.UserId = "+userId;


                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            return (from credential in dt.AsEnumerable()
                                    select new CredentialDto
                                    {
                                        Id = credential.Field<int>("Id"),
                                        Name = credential.Field<string>("Name"),
                                        UserName = credential.Field<string>("UserName"),
                                        Password = credential.Field<string>("Password"),
                                        Description = credential.Field<string>("Description"),
                                        IsDeleted = credential.Field<bool>("IsDeleted"),
                                        UserId = credential.Field<int>("UserId"),
                                        CanView = credential.Field<bool>("CanView"),
                                        CanEdit = credential.Field<bool>("CanEdit"),
                                        CanDelete = credential.Field<bool>("CanDelete"),
                                    }).ToList();
                        }
                    }
                    
                }
                else
                {
                    string query = "select * from credential";

                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            return (from credential in dt.AsEnumerable()
                                    select new CredentialDto
                                    {
                                        Id = credential.Field<int>("Id"),
                                        Name = credential.Field<string>("Name"),
                                        UserName = credential.Field<string>("UserName"),
                                        Password = credential.Field<string>("Password"),
                                        Description = credential.Field<string>("Description"),
                                        IsDeleted = credential.Field<bool>("IsDeleted"),
                                        UserId = credential.Field<int>("UserId"),
                                    }).ToList();
                        }
                    }

                }
            }

        }

        public Credentials GetById(int id)
        {
            using (SqlConnection con = new SqlConnection(AppSettings.ConnectionString))
            {
                string query = @"select * from credential where id = " + id;

                using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                {
                    using (DataTable dt = new DataTable())
                    {
                        sda.Fill(dt);
                        return (from credential in dt.AsEnumerable()
                                select new Credentials
                                {
                                    Id = credential.Field<int>("Id"),
                                    Name = credential.Field<string>("Name"),
                                    UserName = credential.Field<string>("UserName"),
                                    Password = credential.Field<string>("Password"),
                                    Description = credential.Field<string>("Description"),
                                    IsDeleted = credential.Field<bool>("IsDeleted"),
                                    UserId = credential.Field<int>("UserId"),
                                }).SingleOrDefault();
                    }
                }
            }
        }
    }
}
