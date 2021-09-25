namespace PasswordManager.BussinessLayer.ViewModel
{
    public class CredentialDto : Credentials
    {
        public bool CanView { get; set; }

        public bool CanEdit { get; set; }

        public bool CanDelete { get; set; }
    }
}
