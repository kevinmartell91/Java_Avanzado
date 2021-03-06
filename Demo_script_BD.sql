USE [DemoUpc]
GO
/****** Object:  Table [dbo].[Rol]    Script Date: 02/21/2015 01:03:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Rol](
	[idRol] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Rol] PRIMARY KEY CLUSTERED 
(
	[idRol] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Rol] ON
INSERT [dbo].[Rol] ([idRol], [nombre]) VALUES (1, N'ADM-Producto')
INSERT [dbo].[Rol] ([idRol], [nombre]) VALUES (2, N'ADM-Categoria')
SET IDENTITY_INSERT [dbo].[Rol] OFF
/****** Object:  Table [dbo].[Categoria]    Script Date: 02/21/2015 01:03:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Categoria](
	[idCategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Categoria] PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Categoria] ON
INSERT [dbo].[Categoria] ([idCategoria], [nombre]) VALUES (15, N'GASEOSAS')
SET IDENTITY_INSERT [dbo].[Categoria] OFF
/****** Object:  Table [dbo].[Usuario]    Script Date: 02/21/2015 01:03:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Usuario](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL,
	[usuario] [varchar](50) NULL,
	[clave] [varchar](50) NULL,
	[idRol] [int] NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Usuario] ON
INSERT [dbo].[Usuario] ([idUsuario], [nombre], [usuario], [clave], [idRol]) VALUES (1, N'Adminsitrador Producto', N'producto', N'producto', 1)
INSERT [dbo].[Usuario] ([idUsuario], [nombre], [usuario], [clave], [idRol]) VALUES (2, N'Administrador Categoria', N'categoria', N'categoria', 2)
SET IDENTITY_INSERT [dbo].[Usuario] OFF
/****** Object:  Table [dbo].[Producto]    Script Date: 02/21/2015 01:03:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Producto](
	[idProducto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[precio] [decimal](6, 2) NULL,
	[idCategoria] [int] NULL,
 CONSTRAINT [PK_Producto] PRIMARY KEY CLUSTERED 
(
	[idProducto] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Menu]    Script Date: 02/21/2015 01:03:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Menu](
	[idMenu] [int] NOT NULL,
	[url] [varchar](200) NULL,
	[esJsp] [bit] NULL,
	[descripcion] [varchar](50) NULL,
	[idRol] [int] NULL,
 CONSTRAINT [PK_Menu] PRIMARY KEY CLUSTERED 
(
	[idMenu] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (101, N'index.jsp', 1, NULL, 1)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (102, N'/pages/producto/mntProducto.jsp', 1, N'Mantenimiento Producto', 1)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (103, N'/pages/producto/regProducto.jsp', 1, N'Registrar Producto', 1)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (104, N'/pages/producto/actProducto.jsp', 1, NULL, 1)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (105, N'/pages/producto/topProducto.jsp', 1, N'Top Productos', 1)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (106, N'/CerrarSesionController', 1, N'Cerrar Sesión', 1)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (201, N'index.jsp', 1, NULL, 2)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (202, N'/pages/categoria/mntCategoria.jsp', 1, N'Mantenimiento Categoria', 2)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (203, N'/pages/categoria/regCategoria.jsp', 1, N'Registrar Categoria', 2)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (204, N'/pages/categoria/actCategoria.jsp', 1, NULL, 2)
INSERT [dbo].[Menu] ([idMenu], [url], [esJsp], [descripcion], [idRol]) VALUES (205, N'/CerrarSesionController', 1, N'Cerrar Sesión', 2)
/****** Object:  ForeignKey [FK_Menu_Rol]    Script Date: 02/21/2015 01:03:28 ******/
ALTER TABLE [dbo].[Menu]  WITH CHECK ADD  CONSTRAINT [FK_Menu_Rol] FOREIGN KEY([idRol])
REFERENCES [dbo].[Rol] ([idRol])
GO
ALTER TABLE [dbo].[Menu] CHECK CONSTRAINT [FK_Menu_Rol]
GO
/****** Object:  ForeignKey [FK_Producto_Categoria]    Script Date: 02/21/2015 01:03:28 ******/
ALTER TABLE [dbo].[Producto]  WITH CHECK ADD  CONSTRAINT [FK_Producto_Categoria] FOREIGN KEY([idCategoria])
REFERENCES [dbo].[Categoria] ([idCategoria])
GO
ALTER TABLE [dbo].[Producto] CHECK CONSTRAINT [FK_Producto_Categoria]
GO
/****** Object:  ForeignKey [FK_Usuario_Rol]    Script Date: 02/21/2015 01:03:28 ******/
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [FK_Usuario_Rol] FOREIGN KEY([idRol])
REFERENCES [dbo].[Rol] ([idRol])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [FK_Usuario_Rol]
GO
