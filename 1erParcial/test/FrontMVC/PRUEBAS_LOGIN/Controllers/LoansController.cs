using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using PRUEBAS_LOGIN.Models;

namespace PRUEBAS_LOGIN.Controllers
{
    public class LoansController : Controller
    {
        private LibraryEntities db = new LibraryEntities();

        // GET: Loans
        public ActionResult Index()
        {
            var loans = db.Loans.Include(l => l.Books).Include(l => l.Users);
            return View(loans.ToList());
        }

        // GET: Loans/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Loans loans = db.Loans.Find(id);
            if (loans == null)
            {
                return HttpNotFound();
            }
            return View(loans);
        }

        // GET: Loans/Create
        public ActionResult Create()
        {
            ViewBag.book_id = new SelectList(db.Books, "id", "title");
            ViewBag.user_id = new SelectList(db.Users, "id", "username");
            return View();
        }

        // POST: Loans/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id,user_id,book_id,loan_date,due_date,return_date,fine")] Loans loans)
        {
            if (ModelState.IsValid)
            {
                db.Loans.Add(loans);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.book_id = new SelectList(db.Books, "id", "title", loans.book_id);
            ViewBag.user_id = new SelectList(db.Users, "id", "username", loans.user_id);
            return View(loans);
        }

        // GET: Loans/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Loans loans = db.Loans.Find(id);
            if (loans == null)
            {
                return HttpNotFound();
            }
            ViewBag.book_id = new SelectList(db.Books, "id", "title", loans.book_id);
            ViewBag.user_id = new SelectList(db.Users, "id", "username", loans.user_id);
            return View(loans);
        }

        // POST: Loans/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id,user_id,book_id,loan_date,due_date,return_date,fine")] Loans loans)
        {
            if (ModelState.IsValid)
            {
                db.Entry(loans).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.book_id = new SelectList(db.Books, "id", "title", loans.book_id);
            ViewBag.user_id = new SelectList(db.Users, "id", "username", loans.user_id);
            return View(loans);
        }

        // GET: Loans/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Loans loans = db.Loans.Find(id);
            if (loans == null)
            {
                return HttpNotFound();
            }
            return View(loans);
        }

        // POST: Loans/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Loans loans = db.Loans.Find(id);
            db.Loans.Remove(loans);
            db.SaveChanges();
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
    }
}
