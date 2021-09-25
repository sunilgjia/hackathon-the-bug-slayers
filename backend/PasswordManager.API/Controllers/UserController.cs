using Microsoft.AspNetCore.Mvc;
using PasswordManager.DataAccess.Repository;

namespace PasswordManager.API.Controllers
{
    [Route("api/v1/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        public readonly IUserRepository _userRepository;

        public UserController(IUserRepository userRepository)
        {
            _userRepository = userRepository;
        }

        [HttpGet("get-all-users/{id}")]
        public IActionResult GetAllUsers(int id)
        {
            return Ok(_userRepository.GetAll(id));
        }


    }
}
