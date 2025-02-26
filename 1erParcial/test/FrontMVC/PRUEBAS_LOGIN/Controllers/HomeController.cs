﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

using PRUEBAS_LOGIN.Permisos;

namespace PRUEBAS_LOGIN.Controllers
{

    [ValidarSesion]
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Libros()
        {
            ViewBag.Message = "Your application description page. Libros";

            return View();
        }

        public ActionResult Usuarios()
        {
            ViewBag.Message = "Your application description page. Usuarios";

            return View();
        }

        public ActionResult Prestamos()
        {
            ViewBag.Message = "Your application description page. Usuarios";

            return View();
        }

        public ActionResult Devoluciones()
        {
            ViewBag.Message = "Your application description page. Usuarios";

            return View();
        }


        
        public ActionResult CerrarSesion()
        {
            Session["usuario"] = null;
            return RedirectToAction("Login", "Acceso");
        }




    }
}