
CREATE TABLE taikhoan (
	IDTaiKhoan INT NOT NULL AUTO_INCREMENT ,
    TenDangNhap VARCHAR(255) NOT NULL,
    MatKhau VARCHAR(255) NOT NULL,
    TinhTrang VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (IDTaiKhoan)
);

CREATE TABLE cachly (
	IDCachLy INT NOT NULL AUTO_INCREMENT,
    IDNhanKhau INT DEFAULT NULL,
    HoTen VARCHAR(255) DEFAULT NULL,
    NoiCachLy VARCHAR(255) DEFAULT NULL,
    ThoiGianBatDau date DEFAULT NULL,
    MucDoCachLy VARCHAR(255) DEFAULT NULL,
    DaKiemTra VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (IDCachLy)
);

CREATE TABLE kiemtra (
	IDTest INT NOT NULL AUTO_INCREMENT,
    IDNhanKhau INT DEFAULT NULL,
    HoTen VARCHAR(255) DEFAULT NULL,
    ThoiDiemTest date DEFAULT NULL,
    HinhThucTest VARCHAR(255) DEFAULT NULL,
    KetQua VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (IDTest)
);

CREATE TABLE nhankhau (
	ID INT NOT NULL AUTO_INCREMENT,
    HoTen VARCHAR(255) DEFAULT NULL,
    NgaySinh date DEFAULT NULL,
    GioiTinh VARCHAR(255) DEFAULT NULL,
    NoiSinh VARCHAR(255) DEFAULT NULL,
    DiaChi VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE `hokhau` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `maHoKhau` varchar(100)DEFAULT NULL,
  `idChuHo` int DEFAULT NULL,
  `maKhuVuc` varchar(100) DEFAULT NULL,
  `diaChi` varchar(100) DEFAULT NULL,
  `ngayLap` date DEFAULT NULL,
  `ngayChuyenDi` date DEFAULT NULL,
  `lyDoChuyen` text DEFAULT NULL,
  `nguoiThucHien` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `khaibao` (
  `idkhaibao` int NOT NULL AUTO_INCREMENT,
  `idNhanKhau` int NOT NULL,
  `vungDich` varchar(100)DEFAULT NULL,
  `bieuHien` text DEFAULT NULL,
  `ngayKhaiBao` date DEFAULT NULL,
  PRIMARY KEY (`idkhaibao`)
);


INSERT INTO `taikhoan` (`IDTaiKhoan`, `TenDangNhap`, `MatKhau`, `TinhTrang`) VALUES (1, 'admin', '123', 1);