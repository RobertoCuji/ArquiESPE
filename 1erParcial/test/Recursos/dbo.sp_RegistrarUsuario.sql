USE [Library]
GO
/****** Object:  StoredProcedure [dbo].[sp_RegistrarUsuario]    Script Date: 6/1/2025 20:58:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[sp_RegistrarUsuario]
    @Username NVARCHAR(50),
    @Email NVARCHAR(100),
    @Password NVARCHAR(500),
    @Role NVARCHAR(50),
    @Status BIT,
    @Id_Institucional NVARCHAR(50),
    @Registrado BIT OUTPUT,
    @Mensaje NVARCHAR(100) OUTPUT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM dbo.Users WHERE Email = @Email)
    BEGIN
        INSERT INTO dbo.Users (Username, Email, Password, Role, Status, Id_Institucional)
        VALUES (@Username, @Email, @Password, @Role, @Status, @Id_Institucional);

        SET @Registrado = 1;
        SET @Mensaje = 'Usuario registrado correctamente.';
    END
    ELSE
    BEGIN
        SET @Registrado = 0;
        SET @Mensaje = 'El correo ya está registrado.';
    END
END;
