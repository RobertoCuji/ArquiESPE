using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Security.Cryptography;
using System.Text;
using System.Web.Mvc;
using PRUEBAS_LOGIN.Models;

namespace PRUEBAS_LOGIN.Controllers
{
    public class UsersController : Controller
    {
        private LibraryEntities db = new LibraryEntities();

        // GET: Users
        public ActionResult Index()
        {
            return View(db.Users.ToList());
        }

        // GET: Users/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Users users = db.Users.Find(id);
            if (users == null)
            {
                return HttpNotFound();
            }
            return View(users);
        }

        // GET: Users/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Users/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "username,email,role,status,password,id_institucional")] Users users)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    // Encriptar la contraseña con SHA256 antes de guardarla
                    if (!string.IsNullOrEmpty(users.password))
                    {
                        users.password = ConvertirSha256(users.password);
                    }

                    // Agregar el usuario a la base de datos
                    db.Users.Add(users);
                    db.SaveChanges();
                    return RedirectToAction("Index");
                }
                catch (Exception ex)
                {
                    ModelState.AddModelError("", "Ocurrió un error al registrar el usuario: " + ex.Message);
                }
            }

            return View(users);
        }

        // GET: Users/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Users users = db.Users.Find(id);
            if (users == null)
            {
                return HttpNotFound();
            }
            return View(users);
        }

        // POST: Users/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id,username,email,role,status,password,id_institucional")] Users users)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    // Obtener el usuario actual de la base de datos
                    var usuarioExistente = db.Users.AsNoTracking().FirstOrDefault(u => u.id == users.id);

                    if (usuarioExistente == null)
                    {
                        ModelState.AddModelError("", "El usuario no existe.");
                        return View(users);
                    }

                    // Si el campo de contraseña está vacío, mantener la existente
                    if (string.IsNullOrEmpty(users.password))
                    {
                        users.password = usuarioExistente.password; // Mantiene la contraseña actual
                    }
                    else
                    {
                        // Si se proporciona una nueva contraseña, encriptarla
                        users.password = ConvertirSha256(users.password);
                    }

                    // Actualizar el usuario en la base de datos
                    db.Entry(users).State = EntityState.Modified;
                    db.SaveChanges();

                    return RedirectToAction("Index");
                }
                catch (Exception ex)
                {
                    ModelState.AddModelError("", "Ocurrió un error al actualizar el usuario: " + ex.Message);
                }
            }

            return View(users);
        }

        // GET: Users/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Users users = db.Users.Find(id);
            if (users == null)
            {
                return HttpNotFound();
            }
            return View(users);
        }

        // POST: Users/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Users users = db.Users.Find(id);
            try
            {
                db.Users.Remove(users);
                db.SaveChanges();
            }
            catch (Exception ex)
            {
                ModelState.AddModelError("", "Ocurrió un error al eliminar el usuario: " + ex.Message);
            }
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        // Método para encriptar la contraseña con SHA256
        private string ConvertirSha256(string texto)
        {
            using (SHA256 sha256 = SHA256.Create())
            {
                byte[] bytes = Encoding.UTF8.GetBytes(texto);
                byte[] hashBytes = sha256.ComputeHash(bytes);
                return BitConverter.ToString(hashBytes).Replace("-", "").ToLower();
            }
        }
    }
}
