@echo off
:: Base directory
set BASE_DIR=src\main\java\com\libreria\gestionbiblioteca

:: Crear carpetas principales
mkdir %BASE_DIR%\config
mkdir %BASE_DIR%\controllers
mkdir %BASE_DIR%\controllers\soap
mkdir %BASE_DIR%\dto
mkdir %BASE_DIR%\entities
mkdir %BASE_DIR%\exceptions
mkdir %BASE_DIR%\repositories
mkdir %BASE_DIR%\resilience
mkdir %BASE_DIR%\services

:: Crear archivos en /config
echo package com.sistema.gestion.biblioteca.config;> %BASE_DIR%\config\DatabaseConfig.java
echo package com.sistema.gestion.biblioteca.config;> %BASE_DIR%\config\RestTemplateConfig.java
echo package com.sistema.gestion.biblioteca.config;> %BASE_DIR%\config\SwaggerConfig.java
echo package com.sistema.gestion.biblioteca.config;> %BASE_DIR%\config\SecurityConfig.java

:: Crear archivos en /controllers
echo package com.sistema.gestion.biblioteca.controllers;> %BASE_DIR%\controllers\BookController.java
echo package com.sistema.gestion.biblioteca.controllers;> %BASE_DIR%\controllers\UserController.java
echo package com.sistema.gestion.biblioteca.controllers;> %BASE_DIR%\controllers\LoanController.java

:: Crear archivos en /controllers/soap
echo package com.sistema.gestion.biblioteca.controllers.soap;> %BASE_DIR%\controllers\soap\BookSoapService.java
echo package com.sistema.gestion.biblioteca.controllers.soap;> %BASE_DIR%\controllers\soap\UserSoapService.java
echo package com.sistema.gestion.biblioteca.controllers.soap;> %BASE_DIR%\controllers\soap\LoanSoapService.java

:: Crear archivos en /dto
echo package com.sistema.gestion.biblioteca.dto;> %BASE_DIR%\dto\BookDTO.java
echo package com.sistema.gestion.biblioteca.dto;> %BASE_DIR%\dto\UserDTO.java
echo package com.sistema.gestion.biblioteca.dto;> %BASE_DIR%\dto\LoanDTO.java

:: Crear archivos en /entities
echo package com.sistema.gestion.biblioteca.entities;> %BASE_DIR%\entities\Book.java
echo package com.sistema.gestion.biblioteca.entities;> %BASE_DIR%\entities\User.java
echo package com.sistema.gestion.biblioteca.entities;> %BASE_DIR%\entities\Loan.java

:: Crear archivos en /exceptions
echo package com.sistema.gestion.biblioteca.exceptions;> %BASE_DIR%\exceptions\GlobalExceptionHandler.java
echo package com.sistema.gestion.biblioteca.exceptions;> %BASE_DIR%\exceptions\BookNotFoundException.java
echo package com.sistema.gestion.biblioteca.exceptions;> %BASE_DIR%\exceptions\ValidationException.java

:: Crear archivos en /repositories
echo package com.sistema.gestion.biblioteca.repositories;> %BASE_DIR%\repositories\BookRepository.java
echo package com.sistema.gestion.biblioteca.repositories;> %BASE_DIR%\repositories\UserRepository.java
echo package com.sistema.gestion.biblioteca.repositories;> %BASE_DIR%\repositories\LoanRepository.java

:: Crear archivos en /resilience
echo package com.sistema.gestion.biblioteca.resilience;> %BASE_DIR%\resilience\CircuitBreakerConfig.java
echo package com.sistema.gestion.biblioteca.resilience;> %BASE_DIR%\resilience\RetryPolicyConfig.java
echo package com.sistema.gestion.biblioteca.resilience;> %BASE_DIR%\resilience\ServiceFallbackHandler.java

:: Crear archivos en /services
echo package com.sistema.gestion.biblioteca.services;> %BASE_DIR%\services\BookService.java
echo package com.sistema.gestion.biblioteca.services;> %BASE_DIR%\services\UserService.java
echo package com.sistema.gestion.biblioteca.services;> %BASE_DIR%\services\LoanService.java

:: Mensaje de éxito
echo Estructura de carpetas y archivos creada exitosamente.
pause
