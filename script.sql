USE [master]
GO
/****** Object:  Database [QLThuVien]    Script Date: 06/05/2022 1:50:25 AM ******/
CREATE DATABASE [QLThuVien]
 
GO
ALTER DATABASE [QLThuVien] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLThuVien].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLThuVien] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLThuVien] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLThuVien] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLThuVien] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLThuVien] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLThuVien] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLThuVien] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QLThuVien] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLThuVien] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLThuVien] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLThuVien] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLThuVien] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLThuVien] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLThuVien] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLThuVien] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLThuVien] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLThuVien] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLThuVien] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLThuVien] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLThuVien] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLThuVien] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLThuVien] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLThuVien] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLThuVien] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLThuVien] SET  MULTI_USER 
GO
ALTER DATABASE [QLThuVien] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLThuVien] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLThuVien] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLThuVien] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QLThuVien]
GO
/****** Object:  Table [dbo].[ChiTietPM]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTietPM](
	[MaPhieuMuon] [varchar](5) NOT NULL,
	[MaSach] [varchar](5) NOT NULL,
	[NgayThucTra] [date] NULL,
	[TienPhat] [money] NULL,
	[TinhTrangSach] [nvarchar](100) NULL,
 CONSTRAINT [PK_CTPM] PRIMARY KEY CLUSTERED 
(
	[MaPhieuMuon] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DanhMucSach]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DanhMucSach](
	[MaDanhMuc] [varchar](10) NOT NULL,
	[TenDanhMuc] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DocGia]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DocGia](
	[MaDocGia] [varchar](10) NOT NULL,
	[TenDocGia] [nvarchar](100) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[Email] [varchar](100) NULL,
	[SDT] [varchar](11) NULL,
	[Status] [int] NULL,
	[SoLuongMuon] [int] NULL,
 CONSTRAINT [PK__DocGia__F165F9450C553422] PRIMARY KEY CLUSTERED 
(
	[MaDocGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [varchar](10) NOT NULL,
	[TenNhanVien] [nvarchar](100) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SDT] [varchar](11) NULL,
	[Email] [varchar](100) NULL,
 CONSTRAINT [PK__NhanVien__77B2CA474C424880] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhieuMuon]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PhieuMuon](
	[MaPhieuMuon] [varchar](5) NOT NULL,
	[NgayMuon] [date] NULL,
	[SoNgayMuon] [int] NULL,
	[MaDocGia] [varchar](10) NULL,
	[MaNhanVien] [varchar](10) NULL,
	[GhiChu] [text] NULL,
	[TrangThai] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuMuon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [varchar](5) NOT NULL,
	[TenSach] [nvarchar](100) NULL,
	[DanhMuc] [varchar](10) NULL,
	[TheLoai] [varchar](10) NULL,
	[TacGia] [nvarchar](100) NULL,
	[NXB] [nvarchar](100) NULL,
	[NamXB] [int] NULL,
	[SoLuongCon] [int] NULL,
	[NoiDung] [ntext] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaTaiKhoan] [varchar](10) NOT NULL,
	[TenDangNhap] [varchar](20) NULL,
	[MatKhau] [varchar](10) NULL,
	[Quyen] [int] NULL,

PRIMARY KEY CLUSTERED 
(
	[MaTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TheLoaiSach]    Script Date: 06/05/2022 1:50:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TheLoaiSach](
	[MaTheLoai] [varchar](10) NOT NULL,
	[TenTheLoai] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTheLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[ChiTietPM] ([MaPhieuMuon], [MaSach], [NgayThucTra], [TienPhat], [TinhTrangSach]) VALUES (N'PM001', N'BK001', NULL, NULL, NULL)
INSERT [dbo].[ChiTietPM] ([MaPhieuMuon], [MaSach], [NgayThucTra], [TienPhat], [TinhTrangSach]) VALUES (N'PM001', N'BK002', NULL, NULL, NULL)
INSERT [dbo].[DanhMucSach] ([MaDanhMuc], [TenDanhMuc]) VALUES (N'DM01', N'Danh mục 1')
INSERT [dbo].[DanhMucSach] ([MaDanhMuc], [TenDanhMuc]) VALUES (N'DM02', N'Danh mục 2')
INSERT [dbo].[DanhMucSach] ([MaDanhMuc], [TenDanhMuc]) VALUES (N'DM03', N'Danh mục 3')
INSERT [dbo].[DanhMucSach] ([MaDanhMuc], [TenDanhMuc]) VALUES (N'DM04 ', N'Danh mục 4')
INSERT [dbo].[DanhMucSach] ([MaDanhMuc], [TenDanhMuc]) VALUES (N'DM05', N'Danh mục 5')
INSERT [dbo].[DocGia] ([MaDocGia], [TenDocGia], [NgaySinh], [GioiTinh], [Email], [SDT], [Status], [SoLuongMuon]) VALUES (N'DG001', N'Huy', CAST(N'2002-03-29' AS Date), N'Nam', N'huy@gmail.com', N'0312121212', 1, 0)
INSERT [dbo].[DocGia] ([MaDocGia], [TenDocGia], [NgaySinh], [GioiTinh], [Email], [SDT], [Status], [SoLuongMuon]) VALUES (N'DG002', N'Hiếu', CAST(N'2002-03-29' AS Date), N'Nam', N'hieu@gmail.com', N'0312121215', 2, 2)
INSERT [dbo].[DocGia] ([MaDocGia], [TenDocGia], [NgaySinh], [GioiTinh], [Email], [SDT], [Status], [SoLuongMuon]) VALUES (N'NV004', N'Nghia', CAST(N'2002-02-15' AS Date), N'Nghia', N'huy@gmail.com', N'0312121212', 1, 0)
INSERT [dbo].[DocGia] ([MaDocGia], [TenDocGia], [NgaySinh], [GioiTinh], [Email], [SDT], [Status], [SoLuongMuon]) VALUES (N'DG003', N'Hiếu', CAST(N'2002-12-20' AS Date), N'Nam', N'toicandangki004@gmail.com', N'0396108457', 2, 2)

INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [DiaChi], [SDT], [Email]) VALUES (N'NV001', N'Nam', CAST(N'2002-03-29' AS Date), N'Nam', N'TP HCM', N'031212129', N'nam@gmail.com')
INSERT [dbo].[PhieuMuon] ([MaPhieuMuon], [NgayMuon], [SoNgayMuon], [MaDocGia], [MaNhanVien], [GhiChu], [TrangThai]) VALUES (N'PM001', CAST(N'2022-05-06' AS Date), 14, N'DG002', N'NV001', N'Không', N'1')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [DanhMuc], [TheLoai], [TacGia], [NXB], [NamXB], [SoLuongCon], [NoiDung]) VALUES (N'BK001', N'Tớ học lập trình', N'DM02', N'TL06', N'Huy', N'Dân Trí', 2012, 20, N'Dạy lập trình cơ bản')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [DanhMuc], [TheLoai], [TacGia], [NXB], [NamXB], [SoLuongCon], [NoiDung]) VALUES (N'BK002', N'Dế mèn phiêu lưu kí', N'DM03', N'TL03', N'Hiếu', N'Kim Đồng', 2002, 1000, N'Câu truyện về cuộc phiêu lưu của Dế Mèn')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [DanhMuc], [TheLoai], [TacGia], [NXB], [NamXB], [SoLuongCon], [NoiDung]) VALUES (N'BK003', N'Chúng ta không thuộc về nhau', N'DM05', N'TL06', N'Nam', N'Trẻ', 2008, 120, N'Đẳng cấp')
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [Quyen]) VALUES (N'DG001', N'huy', N'huyhuyhuy', 2)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [Quyen]) VALUES (N'DG002', N'hieu', N'hieuhieu', 2)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [Quyen]) VALUES (N'DG003', N'hieu', N'hiudeeptry', 2)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [Quyen]) VALUES (N'NV001', N'nam', N'namnam', 1)
INSERT [dbo].[TheLoaiSach] ([MaTheLoai], [TenTheLoai]) VALUES (N'TL01', N'Giáo trình')
INSERT [dbo].[TheLoaiSach] ([MaTheLoai], [TenTheLoai]) VALUES (N'TL02', N'Chính trị - pháp luật')
INSERT [dbo].[TheLoaiSach] ([MaTheLoai], [TenTheLoai]) VALUES (N'TL03', N'Văn học nghệ thuật')
INSERT [dbo].[TheLoaiSach] ([MaTheLoai], [TenTheLoai]) VALUES (N'TL04', N'Tiểu thuyết')
INSERT [dbo].[TheLoaiSach] ([MaTheLoai], [TenTheLoai]) VALUES (N'TL05', N'Lịch sử')
INSERT [dbo].[TheLoaiSach] ([MaTheLoai], [TenTheLoai]) VALUES (N'TL06', N'Khoa học công nghệ')
INSERT [dbo].[TheLoaiSach] ([MaTheLoai], [TenTheLoai]) VALUES (N'TL07', N'Kinh tế')
Delete from DocGia where MaDocGia = 'DG1233'

INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [Quyen]) VALUES (N'DG100', N'van', N'van123', 1)

CREATE PROCEDURE insertDocGia
	@MaTaiKhoan varchar(10),
	@MaDocGia varchar(10),
	@TenDangNhap varchar(20),
	@MatKhau varchar(10),
	@Quyen int,
	@TenDocGia nvarchar(100),
	@NgaySinh date,
	@GioiTinh [varchar(10),
	@Email varchar(100),
	@SDT varchar(11),
	@Status int,
	@SoLuongMuon int
AS
BEGIN
	INSERT INTO DocGia VALUES(@MaDocGia, @TenDocGia, @NgaySinh, @GioiTinh, @Email, @SDT, @Status, @SoLuongMuon);
	INSERT INTO TaiKhoan VALUES (@MaTaiKhoan, @TenDangNhap, @MatKhau, @Quyen);
END;

exec insertDocGia
ALTER TABLE [dbo].[ChiTietPM]  WITH CHECK ADD  CONSTRAINT [FK_CTPM_PhieuMuon] FOREIGN KEY([MaPhieuMuon])
REFERENCES [dbo].[PhieuMuon] ([MaPhieuMuon])
GO
ALTER TABLE [dbo].[ChiTietPM] CHECK CONSTRAINT [FK_CTPM_PhieuMuon]
GO
ALTER TABLE [dbo].[ChiTietPM]  WITH CHECK ADD  CONSTRAINT [FK_CTPM_Sach] FOREIGN KEY([MaSach])
REFERENCES [dbo].[Sach] ([MaSach])
GO
ALTER TABLE [dbo].[ChiTietPM] CHECK CONSTRAINT [FK_CTPM_Sach]
GO
ALTER TABLE [dbo].[DocGia]  WITH CHECK ADD  CONSTRAINT [FK_DocGia_TaiKhoan] FOREIGN KEY([MaDocGia])
REFERENCES [dbo].[TaiKhoan] ([MaTaiKhoan])
GO
ALTER TABLE [dbo].[DocGia] CHECK CONSTRAINT [FK_DocGia_TaiKhoan]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[TaiKhoan] ([MaTaiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[PhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuon_DocGia] FOREIGN KEY([MaDocGia])
REFERENCES [dbo].[DocGia] ([MaDocGia])
GO
ALTER TABLE [dbo].[PhieuMuon] CHECK CONSTRAINT [FK_PhieuMuon_DocGia]
GO
ALTER TABLE [dbo].[PhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuon_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[PhieuMuon] CHECK CONSTRAINT [FK_PhieuMuon_NhanVien]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_DanhMucSach] FOREIGN KEY([DanhMuc])
REFERENCES [dbo].[DanhMucSach] ([MaDanhMuc])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_DanhMucSach]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_TheLoaiSach] FOREIGN KEY([TheLoai])
REFERENCES [dbo].[TheLoaiSach] ([MaTheLoai])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_TheLoaiSach]
GO
USE [master]
GO
ALTER DATABASE [QLThuVien] SET  READ_WRITE 
GO
