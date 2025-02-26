USE [Library]
GO
/****** Object:  StoredProcedure [dbo].[sp_ValidarUsuario]    Script Date: 6/1/2025 20:59:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[sp_ValidarUsuario]
    @Email NVARCHAR(100),
    @Password NVARCHAR(100)
AS
BEGIN
    IF EXISTS (SELECT 1 FROM dbo.Users WHERE Email = @Email AND Password = @Password)
    BEGIN
        SELECT Id FROM dbo.Users WHERE Email = @Email AND Password = @Password;
    END
    ELSE
    BEGIN
        SELECT 0;
    END
END;