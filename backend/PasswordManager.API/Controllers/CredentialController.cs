using Microsoft.AspNetCore.Mvc;
using PasswordManager.DataAccess.Repository;

namespace PasswordManager.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CredentialController : ControllerBase
    {
        public readonly ICredentialRepository _credentialRepository;

        public CredentialController(ICredentialRepository credentialRepository)
        {
            _credentialRepository = credentialRepository;
        }
    }
}
