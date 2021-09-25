using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace PasswordManager.BussinessLayer.ViewModel
{
    public class Permissions
    {
        [Key]
        public int Id { get; set; }


        [Display(Name = "Users")]
        public virtual int UserId { get; set; }

        [ForeignKey("Id")]
        public virtual User Users { get; set; }



        [Display(Name = "Credential")]
        public virtual int CredentialId { get; set; }

        [ForeignKey("Id")]
        public virtual Credentials Credential { get; set; }




        public bool CanView { get; set; }
        public bool CanEdit { get; set; }
        public bool CanDelete { get; set; }

    }
}
