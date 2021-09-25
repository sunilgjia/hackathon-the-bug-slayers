using Microsoft.AspNetCore.Mvc;
using PasswordManager.DataAccess.Repository;

namespace PasswordManager.API.Controllers
{
    [Route("api/v1/[controller]")]
    [ApiController]
    public class CredentialController : ControllerBase
    {
        public readonly ICredentialRepository _credentialRepository;

        public CredentialController(ICredentialRepository credentialRepository)
        {
            _credentialRepository = credentialRepository;
        }

        [HttpGet]
        public IActionResult GetAll([FromQuery] bool? isShared, int userId)
        {
            return Ok(_credentialRepository.GetAll(isShared,userId));
        }

        [HttpGet("{id}")]
        public IActionResult GetAllUsers(int id)
        {
            return Ok(_credentialRepository.GetById(id));
        }

    }
}
