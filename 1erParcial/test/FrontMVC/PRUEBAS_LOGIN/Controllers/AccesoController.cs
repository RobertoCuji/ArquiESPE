using System;
using System.Data;
using System.Data.SqlClient;
using System.Security.Cryptography;
using System.Text;
using System.Web.Mvc;
using PRUEBAS_LOGIN.Models;

namespace PRUEBAS_LOGIN.Controllers
{
    public class AccesoController : Controller
    {
        // Cadena de conexión a la base de datos
        static string cadena = "Data Source=localhost;Initial Catalog=library;User ID=sa;Password=admin1234;";

        // Vista de Login
        public ActionResult Login()
        {
            return View();
        }

        // Vista de Registro
        public ActionResult Registrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Registrar(Usuario oUsuario)
        {
            // Validaciones básicas
            if (string.IsNullOrWhiteSpace(oUsuario.Email))
            {
                ViewData["Mensaje"] = "El correo es obligatorio.";
                return View();
            }

            if (string.IsNullOrWhiteSpace(oUsuario.Password) || string.IsNullOrWhiteSpace(oUsuario.ConfirmPassword))
            {
                ViewData["Mensaje"] = "Las contraseñas no pueden estar vacías.";
                return View();
            }

            if (oUsuario.Password != oUsuario.ConfirmPassword)
            {
                ViewData["Mensaje"] = "Las contraseñas no coinciden.";
                return View();
            }

            try
            {
                // Encriptar la contraseña
                oUsuario.Password = ConvertirSha256(oUsuario.Password);

                using (SqlConnection cn = new SqlConnection(cadena))
                {
                    SqlCommand cmd = new SqlCommand("sp_RegistrarUsuario", cn)
                    {
                        CommandType = CommandType.StoredProcedure
                    };

                    // Parámetros de entrada
                    cmd.Parameters.AddWithValue("Username", oUsuario.Username);
                    cmd.Parameters.AddWithValue("Email", oUsuario.Email);
                    cmd.Parameters.AddWithValue("Password", oUsuario.Password);
                    cmd.Parameters.AddWithValue("Role", oUsuario.Role);
                    cmd.Parameters.AddWithValue("Status", oUsuario.Status ? 1 : 0); // Manejo del checkbox
                    cmd.Parameters.AddWithValue("Id_Institucional", oUsuario.Id_Institucional);

                    // Parámetros de salida
                    cmd.Parameters.Add("Registrado", SqlDbType.Bit).Direction = ParameterDirection.Output;
                    cmd.Parameters.Add("Mensaje", SqlDbType.NVarChar, 100).Direction = ParameterDirection.Output;

                    // Ejecutar procedimiento almacenado
                    cn.Open();
                    cmd.ExecuteNonQuery();

                    // Obtener valores de salida
                    bool registrado = Convert.ToBoolean(cmd.Parameters["Registrado"].Value);
                    string mensaje = cmd.Parameters["Mensaje"].Value.ToString();

                    ViewData["Mensaje"] = mensaje;

                    if (registrado)
                    {
                        return RedirectToAction("Login", "Acceso");
                    }
                }
            }
            catch (Exception ex)
            {
                ViewData["Mensaje"] = "Ocurrió un error al registrar: " + ex.Message;
            }

            return View();
        }


        public ActionResult Logout()
        {
            Session.Clear(); // Elimina todas las variables de sesión
            return RedirectToAction("Login", "Acceso");
        }




        [HttpPost]
        public ActionResult Login(Usuario oUsuario)
        {
            // Validación de entrada
            if (string.IsNullOrWhiteSpace(oUsuario.Email) || string.IsNullOrWhiteSpace(oUsuario.Password))
            {
                ViewData["Mensaje"] = "El correo y la contraseña son obligatorios.";
                return View();
            }

            try
            {
                // Encriptar contraseña
                oUsuario.Password = ConvertirSha256(oUsuario.Password);

                using (SqlConnection cn = new SqlConnection(cadena))
                {
                    SqlCommand cmd = new SqlCommand("sp_ValidarUsuario", cn)
                    {
                        CommandType = CommandType.StoredProcedure
                    };

                    // Parámetros de entrada
                    cmd.Parameters.AddWithValue("@Email", oUsuario.Email); // Asegúrate de usar @Email
                    cmd.Parameters.AddWithValue("@Password", oUsuario.Password);

                    // Ejecutar procedimiento almacenado
                    cn.Open();
                    object result = cmd.ExecuteScalar();

                    // Verificar si el usuario existe
                    oUsuario.Id = result != null ? Convert.ToInt32(result) : 0;
                }

                if (oUsuario.Id != 0)
                {
                    Session["usuario"] = oUsuario;
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ViewData["Mensaje"] = "Usuario no encontrado.";
                }
            }
            catch (Exception ex)
            {
                ViewData["Mensaje"] = "Ocurrió un error al iniciar sesión: " + ex.Message;
            }

            return View();
        }


        // Método para encriptar contraseñas con SHA256
        public static string ConvertirSha256(string texto)
        {
            if (string.IsNullOrWhiteSpace(texto))
                throw new ArgumentNullException(nameof(texto), "El texto a convertir no puede ser nulo o vacío.");

            StringBuilder Sb = new StringBuilder();
            using (SHA256 hash = SHA256.Create())
            {
                byte[] result = hash.ComputeHash(Encoding.UTF8.GetBytes(texto));
                foreach (byte b in result)
                {
                    Sb.Append(b.ToString("x2"));
                }
            }

            return Sb.ToString();
        }
    }
}