using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PRUEBAS_LOGIN.Models
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Username { get; set; }
        public string Email { get; set; }
        public string Role { get; set; }
        public bool Status { get; set; } // Actualizado para tipo booleano
        public string Password { get; set; }
        public string Id_Institucional { get; set; }
        public string ConfirmPassword { get; set; }
    }
}