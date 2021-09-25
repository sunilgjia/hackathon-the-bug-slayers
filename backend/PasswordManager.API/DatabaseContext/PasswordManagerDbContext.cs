using Microsoft.EntityFrameworkCore;
using PasswordManager.BussinessLayer.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
namespace PasswordManager.DatabaseContext
{
    public class PasswordManagerDbContext : DbContext
    {
        public PasswordManagerDbContext(DbContextOptions dbContextOptions) : base(dbContextOptions) { }

        DbSet<User> Users { get; set; }
        DbSet<Credentials> Credential { get; set; }
        DbSet<Permissions> Permission { get; set; }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {

            foreach (var relationship in modelBuilder.Model.GetEntityTypes().SelectMany(e => e.GetForeignKeys()))
            {
                relationship.DeleteBehavior = DeleteBehavior.Restrict;
            }


            modelBuilder.Entity<User>().HasData(
                new User() { Id = 1,Name="Nayan", Email = "nayan@gmail.com", Password = "Data@1234" },
                new User() { Id = 2,Name="Sunil", Email = "sunil@gmail.com", Password = "Data@1234" },
                new User() { Id = 3,Name="Palak", Email = "palak@gmail.com", Password = "Data@1234" },
                new User() { Id = 4,Name="Divya", Email = "divya@gmail.com", Password = "Data@1234" },
                new User() { Id = 5,Name="Tejas", Email = "tejas@gmail.com", Password = "Data@1234" });
        }
    }

    
}
