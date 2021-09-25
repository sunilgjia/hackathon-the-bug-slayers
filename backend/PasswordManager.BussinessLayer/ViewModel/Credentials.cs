using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace PasswordManager.BussinessLayer.ViewModel
{
    public class Credentials
    {
        [Key]
        public int Id { get; set; }
        [Required]
        public string Name { get; set; }

        [Required]
        public string UserName { get; set; }
        [Required]
        public string Password { get; set; }
        public string Description { get; set; }
        public bool IsDeleted { get; set; }
       

        [Display(Name = "Users")]
        public virtual int UserId { get; set; }

        [ForeignKey("Id")]
        public virtual User Users { get; set; }

    }
}
