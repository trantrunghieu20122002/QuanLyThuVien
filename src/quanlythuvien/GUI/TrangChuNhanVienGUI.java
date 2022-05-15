package quanlythuvien.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.CardLayout;
import java.util.Vector;

import quanlythuvien.BLL.DocGiaBLL;
import quanlythuvien.BLL.PhieuMuonBLL;
import quanlythuvien.DAL.DocGiaDAL;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DTO.PhieuMuonDTO;
import quanlythuvien.DTO.SachDTO;
import quanlythuvien.BLL.*;
import quanlythuvien.DTO.*;


public class TrangChuNhanVienGUI extends JFrame {

        TheLoaiBLL theLoaiBLL = new TheLoaiBLL();
        DanhMucBLL danhMucBLL = new DanhMucBLL();
        SachBLL sachBLL = new SachBLL();
	DocGiaBLL DocGia = new DocGiaBLL();
	DocGiaBLL docBLL = new DocGiaBLL();
	PhieuMuonBLL phieBLL = new PhieuMuonBLL();
	DocGiaDTO user = DocGia.getIdDocGia("DG001");
	Vector<SachDTO> DanhSachMuon = new Vector<SachDTO>();

	private JPanel contentPane;
	private JTextField txtTimKiemDocGia;
	private JTable tableThongTinDocGia;
	private JTextField txtMaDocGia;
	private JTextField txtTenDocGia;
	private JTextField txtNgaySinh;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTable tableDocGia;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table_2;
	private JTextField txtDanhMucTimKiem;
	private JTextField txtMaDanhMuc;
	private JTextField txtTenDanhMuc;
	private JTable tableDanhMuc;
	private JTable tablePhieuMuon;
	private JTextField txtMaPhieuMuon;

	private JTextField txtNgayMuon;
	private JTextField txtSoNgayMuon;
	private JTextField txtMaDGPhieuMuon;
	private JTextField txtMaNhanVien;
	private JTextField txtGhiChu;
	private JTextField txtTrangThai;
	private JTextField txtMaTheLoaiTimKiem;
	private JTextField txtMaTheLoai;
	private JTextField txtTenTheLoai;
	private JTable tableTheLoai;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuNhanVienGUI frame = new TrangChuNhanVienGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadDocGiaList(){
		DefaultTableModel dtmDocGia = new DefaultTableModel();
		dtmDocGia.addColumn("Mã độc giả");
		dtmDocGia.addColumn("Tên độc giả");
		dtmDocGia.addColumn("Ngày sinh");
		dtmDocGia.addColumn("Giới tính");
		dtmDocGia.addColumn("Email");
		dtmDocGia.addColumn("SDT");
		tableDocGia.setModel(dtmDocGia);
		Vector<DocGiaDTO> arr = new Vector<DocGiaDTO>();
		arr = docBLL.getAllDocGia();
		for (int i = 0; i < arr.size(); i++){
			DocGiaDTO doc = arr.get(i);
			String id = doc.getMaDocGia();
			String name = doc.getTenDocGia();
			String bitrhday = doc.getNgaySinh();
			String sex = doc.getGioiTinh();
			String email = doc.getEmail();
			String phone = doc.getSDT();
			Object[] row = {id, name, bitrhday, sex, email, phone};
			dtmDocGia.addRow(row);
		}
	}
	public void loadTimKiemDocGia(){
		DefaultTableModel dtmDocGia = new DefaultTableModel();
		dtmDocGia.addColumn("Mã độc giả");
		dtmDocGia.addColumn("Tên độc giả");
		dtmDocGia.addColumn("Ngày sinh");
		dtmDocGia.addColumn("Giới tính");
		dtmDocGia.addColumn("Email");
		dtmDocGia.addColumn("SDT");
		tableThongTinDocGia.setModel(dtmDocGia);
		Vector<DocGiaDTO> arr = new Vector<DocGiaDTO>();
		arr = docBLL.FindUserByName(txtTimKiemDocGia.getText());
		for (int i = 0; i < arr.size(); i++){
			DocGiaDTO doc = arr.get(i);
			String id = doc.getMaDocGia();
			String name = doc.getTenDocGia();
			String bitrhday = doc.getNgaySinh();
			String sex = doc.getGioiTinh();
			String email = doc.getEmail();
			String phone = doc.getSDT();
			Object[] row = {id, name, bitrhday, sex, email, phone};
			dtmDocGia.addRow(row);
		}
	}
	public void loadPhieuMuonList(){
		DefaultTableModel dtmPhieuMuong = new DefaultTableModel();
		dtmPhieuMuong.addColumn("Mã phiếu mượn");
		dtmPhieuMuong.addColumn("Ngày mượn");
		dtmPhieuMuong.addColumn("Số ngày mượn");
		dtmPhieuMuong.addColumn("Mã độc giả");
		dtmPhieuMuong.addColumn("Mã nhân viên");
		dtmPhieuMuong.addColumn("Ghi chú");
		dtmPhieuMuong.addColumn("Trạng thái");
		tablePhieuMuon.setModel(dtmPhieuMuong);
		Vector<PhieuMuonDTO> arr = new Vector<PhieuMuonDTO>();
		arr = phieBLL.getAllPhieuMuon();
		for (int i = 0; i < arr.size(); i++){
			PhieuMuonDTO phie = arr.get(i);
			String idPhieuMuon = phie.getMaPhieuMuon();
			String NgayMuon = phie.getNgayMuon();
			int SoNgayMuon = phie.getSoNgayMuon();
			String idDocGia = phie.getMaDocGia();
			String idNhanVien = phie.getMaNhanVien();
			String GhiChu = phie.getGhiChu();
			int TrangThai = phie.getTrangThai();
			Object[] row = {idPhieuMuon, NgayMuon, SoNgayMuon,idDocGia, idNhanVien, GhiChu, TrangThai};
			dtmPhieuMuong.addRow(row);
		}
	}
        public void loadBookList() {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Mã Sách");
            dtm.addColumn("Tên Sách");
            dtm.addColumn("Mã DM");
            dtm.addColumn("Mã TL");
            dtm.addColumn("Tác Giả");
            dtm.addColumn("Nhà Xuất Bản");
            dtm.addColumn("Năm XB");
            dtm.addColumn("Số lượng");
            dtm.addColumn("Tóm tắt");
            table_2.setModel(dtm);
            Vector<SachDTO> arr = new Vector<SachDTO>();
            arr = sachBLL.getAllBook();
            for (int i = 0; i < arr.size(); i++) {
                SachDTO book = arr.get(i);
                String id = book.getSach_id();
                String name = book.getSach_name();
                String dm = book.getSach_DM();
                String tl = book.getSach_TL();
                String author = book.getSach_author();
                String nxb = book.getSach_nxb();
                int year = book.getSach_year();
                int quantity = book.getSach_quantity();
                String sumary = book.getSach_noidung();
                Object[] row = {id, name, dm, tl, author, nxb, year, quantity, sumary};
                dtm.addRow(row);
            }
        }

        public void loadTheLoaiList(int x) {
            Vector<TheLoaiDTO> arr = new Vector<>();
            if (x == 1) {
                arr = theLoaiBLL.getAllTL();
            } else {
                arr = theLoaiBLL.getTLByName(txtMaTheLoaiTimKiem.getText());
            }
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Mã thể loại ");
            dtm.addColumn("Tên thể loại");
            tableTheLoai.setModel(dtm);
            for (int i = 0; i < arr.size(); i++) {
                TheLoaiDTO tl = arr.get(i);
                String id = tl.getMaTheLoai();
                String name = tl.getTenTheLoai();
                Object[] row = {id, name};
                dtm.addRow(row);
            }
        }
        
        public void loadDanhMucList(int x) {
            Vector<DanhMucDTO> arr = new Vector<>();
            if (x == 1) {
                arr = danhMucBLL.getAllDM();
            } else {
                arr = danhMucBLL.getDMByName(txtDanhMucTimKiem.getText());
            }
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Mã thể loại ");
            dtm.addColumn("Tên thể loại");
            tableDanhMuc.setModel(dtm);
            for (int i = 0; i < arr.size(); i++) {
                DanhMucDTO dm = arr.get(i);
                String id = dm.getMaDM();
                String name = dm.getTenDM();
                Object[] row = {id, name};
                dtm.addRow(row);
            }
        }
	/**
	 * Create the frame.
	 */
	public TrangChuNhanVienGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Card = new JPanel();
		Card.setBounds(197, 58, 770, 505);
		contentPane.add(Card);
		Card.setLayout(new CardLayout(0, 0));

		JPanel QLDG = new JPanel();
		Card.add(QLDG, "QLDG");
		QLDG.setLayout(null);

		JPanel panelQLDocGia = new JPanel();
		panelQLDocGia.setLayout(null);
		panelQLDocGia.setBounds(0, 25, 760, 485);
		QLDG.add(panelQLDocGia, "QLDocGia");

		JLabel lblNewLabel_1 = new JLabel("Mã độc giả:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(59, 10, 90, 36);
		panelQLDocGia.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên độc giả:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(59, 135, 90, 35);
		panelQLDocGia.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Giới tính:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(59, 192, 90, 35);
		panelQLDocGia.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(386, 192, 90, 35);
		panelQLDocGia.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Ngày sinh::");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(386, 135, 90, 35);
		panelQLDocGia.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(386, 10, 90, 36);
		panelQLDocGia.add(lblNewLabel_1_1);

				txtMaDocGia = new JTextField();
				txtMaDocGia.setColumns(10);
				txtMaDocGia.setBounds(152, 20, 181, 19);
				panelQLDocGia.add(txtMaDocGia);

						txtTenDocGia = new JTextField();
						txtTenDocGia.setColumns(10);
						txtTenDocGia.setBounds(152, 144, 181, 19);
						panelQLDocGia.add(txtTenDocGia);

						txtNgaySinh = new JTextField();
						txtNgaySinh.setColumns(10);
						txtNgaySinh.setBounds(486, 144, 181, 19);
						panelQLDocGia.add(txtNgaySinh);

						txtSDT = new JTextField();
						txtSDT.setColumns(10);
						txtSDT.setBounds(486, 20, 181, 19);
						panelQLDocGia.add(txtSDT);

						txtEmail = new JTextField();
						txtEmail.setColumns(10);
						txtEmail.setBounds(486, 201, 181, 19);
						panelQLDocGia.add(txtEmail);

						JRadioButton rdbtnNam = new JRadioButton("Nam");
						rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
						rdbtnNam.setBounds(155, 200, 62, 21);
						panelQLDocGia.add(rdbtnNam);

						JRadioButton rdbtnNu = new JRadioButton("Nữ");
						rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
						rdbtnNu.setBounds(219, 200, 103, 21);
						panelQLDocGia.add(rdbtnNu);

						JButton btnThemDocGia = new JButton("Thêm");
						btnThemDocGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
						btnThemDocGia.setBounds(82, 247, 90, 21);
						panelQLDocGia.add(btnThemDocGia);
						btnThemDocGia.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if (txtMaDocGia.getText().trim().equals(""))
										JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
									else {
										DocGiaDTO doc = new DocGiaDTO();
										doc.setMaDocGia(txtMaDocGia.getText());
										doc.setTenDocGia(txtTenDocGia.getText());
										doc.setTenDangNhap(txtTaiKhoan.getText());
										doc.setMatKhau(txtMatKhau.getText());
										if(rdbtnNam.isSelected()){
											doc.setGioiTinh(rdbtnNam.getText());
										}else doc.setGioiTinh(rdbtnNu.getText());
										doc.setSDT(txtSDT.getText());
										doc.setNgaySinh(txtNgaySinh.getText());
										doc.setEmail(txtEmail.getText());
										doc.setStatus(0);
										doc.setSoLuongMuon(5);
										JOptionPane.showMessageDialog(null,docBLL.addDocGia(doc));
										loadDocGiaList();
									}
								}catch (NumberFormatException ex){
									JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ");
								}
							}
						});

						JButton btnSuaDocGia = new JButton("Sửa");
						btnSuaDocGia.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if (txtMaDocGia.getText().trim().equals(""))
										JOptionPane.showMessageDialog(null,"Vui lòng nhập mã độc giả để sửa");
									else{
										DocGiaDTO doc = new DocGiaDTO();
										doc.setMaDocGia(txtMaDocGia.getText());
										System.out.println(doc.getMaDocGia());
										doc.setSDT(txtSDT.getText());
										doc.setTenDocGia(txtTenDocGia.getText());
										if (rdbtnNam.isSelected()){
											doc.setGioiTinh(rdbtnNam.getText());
										}else doc.setGioiTinh(rdbtnNu.getText());
										doc.setNgaySinh(txtNgaySinh.getText());
										doc.setEmail(txtEmail.getText());
										loadDocGiaList();
										JOptionPane.showMessageDialog(null,docBLL.editDocGia(doc.getTenDocGia(), doc.getNgaySinh(), doc.getTenDocGia(), doc.getEmail(), doc.getSDT(), doc.getMaDocGia()));
										loadDocGiaList();
									}
								}catch (NumberFormatException ex){
									JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ");
								}
							}
						});
						btnSuaDocGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
						btnSuaDocGia.setBounds(266, 247, 90, 21);
						panelQLDocGia.add(btnSuaDocGia);

						JButton btnXoaDocGia = new JButton("Xóa");
						btnXoaDocGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
						btnXoaDocGia.setBounds(451, 247, 90, 21);
						panelQLDocGia.add(btnXoaDocGia);
						btnXoaDocGia.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									if (txtMaDocGia.getText().trim().equals(""))
										JOptionPane.showMessageDialog(null,"Vui lòng nhập mã độc giả để xóa");
									else{
										DocGiaDTO doc = new DocGiaDTO();
										doc.setMaDocGia(txtMaDocGia.getText());
										JOptionPane.showMessageDialog(null,docBLL.deleteDocGia(doc.getMaDocGia()));
										loadDocGiaList();
									}
								}catch (NumberFormatException ex){
									JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ");
								}
							}
						});

						JScrollPane scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(0, 278, 760, 197);
						panelQLDocGia.add(scrollPane_1);

						tableDocGia = new JTable();
						tableDocGia.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int i = tableDocGia.getSelectedRow();
								TableModel model = tableDocGia.getModel();
								txtMaDocGia.setText(model.getValueAt(i,0).toString());
								txtTenDocGia.setText(model.getValueAt(i,1).toString());
								txtNgaySinh.setText(model.getValueAt(i,2).toString());
								txtEmail.setText(model.getValueAt(i,4).toString());
								txtSDT.setText(model.getValueAt(i,5).toString());

							}
						});

								scrollPane_1.setViewportView(tableDocGia);
								
								JLabel labeltaikhoan = new JLabel("Tài khoản: ");
								labeltaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
								labeltaikhoan.setBounds(59, 76, 90, 35);
								panelQLDocGia.add(labeltaikhoan);
								
								txtTaiKhoan = new JTextField();
								txtTaiKhoan.setColumns(10);
								txtTaiKhoan.setBounds(152, 85, 181, 19);
								panelQLDocGia.add(txtTaiKhoan);
								
								JLabel lblNewLabel_2_2_1 = new JLabel("Ngày sinh::");
								lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblNewLabel_2_2_1.setBounds(386, 76, 90, 35);
								panelQLDocGia.add(lblNewLabel_2_2_1);
								
								txtMatKhau = new JTextField();
								txtMatKhau.setColumns(10);
								txtMatKhau.setBounds(486, 85, 181, 19);
								panelQLDocGia.add(txtMatKhau);

		JPanel panelThongTinDocGia = new JPanel();
		panelThongTinDocGia.setBounds(0, 25, 770, 480);
		QLDG.add(panelThongTinDocGia, "ThongTinDocGia");
		panelThongTinDocGia.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("TÌm kiếm thông tin bằng tên độc giả:");
		lblNewLabel_3.setBounds(66, 26, 245, 29);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelThongTinDocGia.add(lblNewLabel_3);

		txtTimKiemDocGia = new JTextField();
		txtTimKiemDocGia.setBounds(299, 26, 267, 29);
		txtTimKiemDocGia.setColumns(10);
		panelThongTinDocGia.add(txtTimKiemDocGia);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 760, 403);
		panelThongTinDocGia.add(scrollPane);

		tableThongTinDocGia = new JTable();
		tableThongTinDocGia.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên đăng nhập", "Tên độc giả", "Ngày sinh", "Giới tính", "Email", "SDT"
			}
		));
		scrollPane.setViewportView(tableThongTinDocGia);

		JButton btnTimKiemDocGia = new JButton("Tìm kiếm");
		btnTimKiemDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtTimKiemDocGia.getText().trim().equals(""))
						JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
					else {
						docBLL.FindUserByName(txtTimKiemDocGia.getText());
						JOptionPane.showMessageDialog(null,"Đã tìm thấy kết quả");
						loadTimKiemDocGia();
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnTimKiemDocGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiemDocGia.setBounds(611, 31, 99, 21);
		panelThongTinDocGia.add(btnTimKiemDocGia);

		JButton btnQLDG = new JButton("Quản lý độc giả");
		JButton btnThongTinDocGia = new JButton("Xem thông tin độc giả");
		btnQLDG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDG.removeAll();
				QLDG.repaint();
				QLDG.revalidate();
				QLDG.add(btnQLDG);
				QLDG.add(btnThongTinDocGia);
				QLDG.add(panelQLDocGia);

			}
		});
		btnQLDG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLDG.setBounds(0, 0, 139, 26);
		QLDG.add(btnQLDG);


		btnThongTinDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDG.removeAll();
				QLDG.repaint();
				QLDG.revalidate();
				QLDG.add(btnQLDG);
				QLDG.add(btnThongTinDocGia);
				QLDG.add(panelThongTinDocGia);
			}
		});
		contentPane.remove(QLDG);
		btnThongTinDocGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThongTinDocGia.setBounds(136, 0, 173, 26);
		QLDG.add(btnThongTinDocGia);

                JPanel QLS = new JPanel();
                Card.add(QLS, "QLS");
                QLS.setLayout(null);

                JPanel panelQLDanhMuc = new JPanel();
                panelQLDanhMuc.setBounds(0, 26, 770, 479);
                QLS.add(panelQLDanhMuc);
                panelQLDanhMuc.setLayout(null);

                JLabel lblFindDM = new JLabel("Tìm kiếm bằng tên danh mục");
                lblFindDM.setFont(new Font("Tahoma", Font.PLAIN, 13));
                lblFindDM.setBounds(47, 41, 176, 21);
                panelQLDanhMuc.add(lblFindDM);

                txtDanhMucTimKiem = new JTextField();
                txtDanhMucTimKiem.setBounds(261, 43, 185, 19);
                panelQLDanhMuc.add(txtDanhMucTimKiem);
                txtDanhMucTimKiem.setColumns(10);

                JButton btnTimKiemDanhMuc = new JButton("Tìm kiếm");
                btnTimKiemDanhMuc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text = "";
                        if (txtDanhMucTimKiem.getText().trim().equals(text)) {
                            loadDanhMucList(1);
                        }
                        else {
                            loadDanhMucList(2);
                        }
                    }
                });
                btnTimKiemDanhMuc.setBounds(491, 42, 85, 21);
                panelQLDanhMuc.add(btnTimKiemDanhMuc);

                JLabel lblNewLabel_6 = new JLabel("Thông tin của danh mục: ");
                lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
                lblNewLabel_6.setBounds(88, 110, 185, 13);
                panelQLDanhMuc.add(lblNewLabel_6);

                JLabel lblNewLabel_7 = new JLabel("Mã danh mục:");
                lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
                lblNewLabel_7.setBounds(24, 151, 96, 13);
                panelQLDanhMuc.add(lblNewLabel_7);

                txtMaDanhMuc = new JTextField();
                txtMaDanhMuc.setBounds(145, 149, 128, 19);
                panelQLDanhMuc.add(txtMaDanhMuc);
                txtMaDanhMuc.setColumns(10);

                JLabel lblNewLabel_7_1 = new JLabel("Tên danh mục:");
                lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
                lblNewLabel_7_1.setBounds(24, 200, 96, 13);
                panelQLDanhMuc.add(lblNewLabel_7_1);

                txtTenDanhMuc = new JTextField();
                txtTenDanhMuc.setColumns(10);
                txtTenDanhMuc.setBounds(145, 198, 128, 19);
                panelQLDanhMuc.add(txtTenDanhMuc);

                JScrollPane scrollPane_3 = new JScrollPane();
                scrollPane_3.setBounds(375, 110, 385, 245);
                panelQLDanhMuc.add(scrollPane_3);

                tableDanhMuc = new JTable();
                tableDanhMuc.setModel(new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "Mã danh mục", "Tên danh mục"
                        }
                ));
                
                tableDanhMuc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableDanhMuc.getSelectedRow();
				TableModel model = tableDanhMuc.getModel();
                                txtMaDanhMuc.setText(model.getValueAt(i, 0).toString());
                                txtTenDanhMuc.setText(model.getValueAt(i, 1).toString());
			}
		});
                
                scrollPane_3.setViewportView(tableDanhMuc);

                JButton btnAddDM = new JButton("Thêm");
                btnAddDM.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (txtMaDanhMuc.getText().trim().equals("") || txtTenDanhMuc.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                            } else {
                                DanhMucDTO dm = new DanhMucDTO();
                                dm.setMaDM(txtMaDanhMuc.getText());
                                dm.setTenDM(txtTenDanhMuc.getText());
                                JOptionPane.showMessageDialog(null, danhMucBLL.addDM(dm));
                                loadDanhMucList(1);
                            }
                    }
                });
                btnAddDM.setBounds(24, 313, 85, 21);
                panelQLDanhMuc.add(btnAddDM);

                JButton btnUpdateDM = new JButton("Sửa");
                btnUpdateDM.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (txtMaDanhMuc.getText().trim().equals("") || txtTenDanhMuc.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                            } else {
                                DanhMucDTO dm = new DanhMucDTO();
                                dm.setMaDM(txtMaDanhMuc.getText());
                                dm.setTenDM(txtTenDanhMuc.getText());
                                JOptionPane.showMessageDialog(null, danhMucBLL.updateDM(dm));
                                loadDanhMucList(1);
                            }
                    }
                });
                btnUpdateDM.setBounds(145, 313, 85, 21);
                panelQLDanhMuc.add(btnUpdateDM);

                JButton btnDeleteDM = new JButton("Xóa");
                btnDeleteDM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            if (txtMaDanhMuc.getText().trim().equals("") || txtTenDanhMuc.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                            } else {
                                DanhMucDTO dm = new DanhMucDTO();
                                dm.setMaDM(txtMaDanhMuc.getText());
                                dm.setTenDM(txtTenDanhMuc.getText());
                                JOptionPane.showMessageDialog(null, danhMucBLL.deleteDM(dm));
                                loadDanhMucList(1);
                            }
			}
		});
                btnDeleteDM.setBounds(261, 313, 85, 21);
                panelQLDanhMuc.add(btnDeleteDM);
                panelQLDanhMuc.hide();
		
		JPanel panelQLTheLoai = new JPanel();
		panelQLTheLoai.setLayout(null);
		panelQLTheLoai.setBounds(0, 26, 770, 479);
		QLS.add(panelQLTheLoai);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tìm kiếm bằng tên thể loại:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(47, 41, 176, 21);
		panelQLTheLoai.add(lblNewLabel_5_1);
		
		txtMaTheLoaiTimKiem = new JTextField();
		txtMaTheLoaiTimKiem.setColumns(10);
		txtMaTheLoaiTimKiem.setBounds(261, 43, 185, 19);
		panelQLTheLoai.add(txtMaTheLoaiTimKiem);
		
		JButton btnTimKiemTheLoai = new JButton("Tìm kiếm");
                btnTimKiemTheLoai.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text = "";
                        if (txtMaTheLoaiTimKiem.getText().trim().equals(text)) {
                            loadTheLoaiList(1);
                        }
                        else {
                            loadTheLoaiList(2);
                        }
                    }
                });
		btnTimKiemTheLoai.setBounds(491, 42, 85, 21);
		panelQLTheLoai.add(btnTimKiemTheLoai);
		
		JLabel lblNewLabel_6_1 = new JLabel("Thông tin của thể loại");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(88, 110, 185, 13);
		panelQLTheLoai.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Mã thể loại:");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_2.setBounds(24, 151, 96, 13);
		panelQLTheLoai.add(lblNewLabel_7_2);
		
		txtMaTheLoai = new JTextField();
		txtMaTheLoai.setColumns(10);
		txtMaTheLoai.setBounds(145, 149, 128, 19);
		panelQLTheLoai.add(txtMaTheLoai);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Tên thể loại:");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1_1.setBounds(24, 200, 96, 13);
		panelQLTheLoai.add(lblNewLabel_7_1_1);
		
		txtTenTheLoai = new JTextField();
		txtTenTheLoai.setColumns(10);
		txtTenTheLoai.setBounds(145, 198, 128, 19);
		panelQLTheLoai.add(txtTenTheLoai);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(375, 110, 385, 245);
		panelQLTheLoai.add(scrollPane_5);
		
		tableTheLoai = new JTable();
		tableTheLoai.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã thể loại", "Tên thể loại"
				}
			));
		scrollPane_5.setViewportView(tableTheLoai);
                
                tableTheLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableTheLoai.getSelectedRow();
				TableModel model = tableTheLoai.getModel();
                                txtMaTheLoai.setText(model.getValueAt(i, 0).toString());
                                txtTenTheLoai.setText(model.getValueAt(i, 1).toString());
			}
		});
		
		JButton btnAddTL = new JButton("Thêm");
		btnAddTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            if (txtMaTheLoai.getText().trim().equals("") || txtTenTheLoai.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                            } else {
                                TheLoaiDTO tl = new TheLoaiDTO();
                                tl.setMaTheLoai(txtMaTheLoai.getText());
                                tl.setTenTheLoai(txtTenTheLoai.getText());
                                JOptionPane.showMessageDialog(null, theLoaiBLL.addTL(tl));
                                loadTheLoaiList(1);
                            }
			}
		});
		btnAddTL.setBounds(24, 313, 85, 21);
		panelQLTheLoai.add(btnAddTL);
		
		JButton btnUpdateTL = new JButton("Sửa");
                btnUpdateTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            if (txtMaTheLoai.getText().trim().equals("") || txtTenTheLoai.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                            } else {
                                TheLoaiDTO tl = new TheLoaiDTO();
                                tl.setMaTheLoai(txtMaTheLoai.getText());
                                tl.setTenTheLoai(txtTenTheLoai.getText());
                                JOptionPane.showMessageDialog(null, theLoaiBLL.updateTL(tl));
                                loadTheLoaiList(1);
                            }
			}
		});
		btnUpdateTL.setBounds(145, 313, 85, 21);
		panelQLTheLoai.add(btnUpdateTL);
		
		JButton btnDeleteTL = new JButton("Xóa");
                btnDeleteTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            if (txtMaTheLoai.getText().trim().equals("") || txtTenTheLoai.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                            } else {
                                TheLoaiDTO tl = new TheLoaiDTO();
                                tl.setMaTheLoai(txtMaTheLoai.getText());
                                tl.setTenTheLoai(txtTenTheLoai.getText());
                                JOptionPane.showMessageDialog(null, theLoaiBLL.deleteTL(tl));
                                loadTheLoaiList(1);
                            }
			}
		});
		btnDeleteTL.setBounds(261, 313, 85, 21);
		panelQLTheLoai.add(btnDeleteTL);
		panelQLTheLoai.hide();

		JButton btnQLDM = new JButton("Quản lý danh mục");

		btnQLDM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLDM.setBounds(111, 0, 145, 28);
		QLS.add(btnQLDM);
		Card.add(QLS, "QLS");

		JPanel panelQLSach = new JPanel();
		panelQLSach.setBounds(0, 30, 770, 32537);
		QLS.add(panelQLSach);
		panelQLSach.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Mã sách:");
		lblNewLabel_4.setBounds(27, 0, 87, 16);
		panelQLSach.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_1 = new JLabel("Tên sách:");
		lblNewLabel_4_1.setBounds(27, 40, 87, 16);
		panelQLSach.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_2 = new JLabel("Mã thể loại:");
		lblNewLabel_4_2.setBounds(27, 78, 87, 16);
		panelQLSach.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_1_1 = new JLabel("Thể loại:");
		lblNewLabel_4_1_1.setBounds(27, 119, 87, 16);
		panelQLSach.add(lblNewLabel_4_1_1);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_3 = new JLabel("Số lượng còn:");
		lblNewLabel_4_3.setBounds(27, 157, 87, 16);
		panelQLSach.add(lblNewLabel_4_3);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_1_2 = new JLabel("Năm xuất bản:");
		lblNewLabel_4_1_2.setBounds(27, 190, 87, 16);
		panelQLSach.add(lblNewLabel_4_1_2);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_4 = new JLabel("Tác giả:");
		lblNewLabel_4_4.setBounds(350, 0, 87, 16);
		panelQLSach.add(lblNewLabel_4_4);
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_1_3 = new JLabel("Nhà xuất bản:");
		lblNewLabel_4_1_3.setBounds(350, 40, 87, 16);
		panelQLSach.add(lblNewLabel_4_1_3);
		lblNewLabel_4_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_2_1 = new JLabel("Mã danh mục:");
		lblNewLabel_4_2_1.setBounds(350, 78, 87, 16);
		panelQLSach.add(lblNewLabel_4_2_1);
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Tên danh mục:");
		lblNewLabel_4_1_1_1.setBounds(350, 119, 87, 16);
		panelQLSach.add(lblNewLabel_4_1_1_1);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4_3_1 = new JLabel("Tóm tắt nội dung:");
		lblNewLabel_4_3_1.setBounds(350, 157, 104, 16);
		panelQLSach.add(lblNewLabel_4_3_1);
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField_6 = new JTextField();
		textField_6.setBounds(121, 0, 157, 19);
		panelQLSach.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(121, 40, 157, 19);
		panelQLSach.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(121, 119, 157, 19);
		panelQLSach.add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(121, 157, 157, 19);
		panelQLSach.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(121, 190, 157, 19);
		panelQLSach.add(textField_10);
		textField_10.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 77, 154, 21);
		panelQLSach.add(comboBox);

		textField_11 = new JTextField();
		textField_11.setBounds(466, 0, 200, 19);
		panelQLSach.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(466, 40, 200, 19);
		panelQLSach.add(textField_12);
		textField_12.setColumns(10);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(469, 77, 197, 21);
		panelQLSach.add(comboBox_1);

		textField_13 = new JTextField();
		textField_13.setBounds(466, 119, 200, 19);
		panelQLSach.add(textField_13);
		textField_13.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(473, 160, 193, 59);
		panelQLSach.add(textArea);

		JButton btnThemSach = new JButton("Thêm");
		btnThemSach.setBounds(59, 229, 85, 21);
		panelQLSach.add(btnThemSach);
		btnThemSach.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 266, 770, 32263);
		panelQLSach.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sách", "Tên sách", "Mã DM", "Mã TL", "Tác giả", "Nhà XB", "Năm XB", "SL", "Tóm tắt"
			}
		));
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_2.setViewportView(table_2);
                
		JButton btnNewButton_4_1 = new JButton("Sửa");
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4_1.setBounds(176, 230, 85, 21);
		panelQLSach.add(btnNewButton_4_1);
                
		JButton btnNewButton_4_2 = new JButton("Xóa");
		btnNewButton_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4_2.setBounds(294, 230, 85, 21);
		panelQLSach.add(btnNewButton_4_2);
		JButton btnQLS = new JButton("Quản lý sách");
		btnQLS.setBounds(0, 0, 114, 28);
		QLS.add(btnQLS);
		btnQLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				QLS.remove(panelQLDanhMuc);
//				QLS.repaint();
//				QLS.revalidate();
//				QLS.add(panelQLSach);
//				QLS.revalidate();
				panelQLTheLoai.hide();
				panelQLDanhMuc.hide();
				panelQLSach.show();
			}
		});
		btnQLS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnQLTL = new JButton("Quản lý thể loại");
		btnQLTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelQLSach.hide();
				panelQLDanhMuc.hide();
				panelQLTheLoai.show();
			}
		});
		btnQLTL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLTL.setBounds(252, 0, 145, 28);
		QLS.add(btnQLTL);

		JPanel QLPM = new JPanel();
		Card.add(QLPM, "name_394520549870200");
		QLPM.setLayout(null);

		JPanel panelDSPM = new JPanel();
		panelDSPM.setBounds(0, 24, 770, 481);
		QLPM.add(panelDSPM);
		panelDSPM.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Các phiếu mượn đã đăng ký");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(238, 10, 265, 37);
		panelDSPM.add(lblNewLabel_8);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 46, 750, 111);
		panelDSPM.add(scrollPane_4);

		tablePhieuMuon = new JTable();

		scrollPane_4.setViewportView(tablePhieuMuon);

		tablePhieuMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tablePhieuMuon.getSelectedRow();
				TableModel model = tablePhieuMuon.getModel();
				txtMaPhieuMuon.setText(model.getValueAt(i,0).toString());
				txtNgayMuon.setText(model.getValueAt(i,1).toString());
				txtSoNgayMuon.setText(model.getValueAt(i,2).toString());
				txtMaDGPhieuMuon.setText(model.getValueAt(i,3).toString());
				txtMaNhanVien.setText(model.getValueAt(i,4).toString());
				txtGhiChu.setText(model.getValueAt(i,5).toString());
				txtTrangThai.setText(model.getValueAt(i,6).toString());

			}
		});

		JButton btnThemPhieuMuon = new JButton("Thêm ");
		btnThemPhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtMaPhieuMuon.getText().trim().equals(""))
						JOptionPane.showMessageDialog(null,"Vui lòng không bỏ trống mã phiếu mượn");
					else {

						PhieuMuonDTO phie = new PhieuMuonDTO();
						phie.setMaPhieuMuon(txtMaPhieuMuon.getText());
						System.out.println(phie.getMaPhieuMuon());
						phie.setNgayMuon(txtNgayMuon.getText());
						phie.setSoNgayMuon(Integer.parseInt(txtSoNgayMuon.getText()));
						phie.setMaDocGia(txtMaDocGia.getText());
						phie.setMaNhanVien(txtMaNhanVien.getText());
						phie.setGhiChu(txtMaDocGia.getText());
						phie.setTrangThai(Integer.parseInt(txtTrangThai.getText()));

						JOptionPane.showMessageDialog(null,phieBLL.InsertPhieuMuon(DanhSachMuon,user,7));
						loadPhieuMuonList();
					}
				}catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ");
				}
			}
		});
		btnThemPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThemPhieuMuon.setBounds(444, 176, 85, 21);
		panelDSPM.add(btnThemPhieuMuon);

		JButton btnSuaPhieuMuon = new JButton("Sửa");
		btnSuaPhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtMaPhieuMuon.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đây đủ thông tin!!");
					}else {
						PhieuMuonDTO phie = new PhieuMuonDTO();
						String id = (txtMaPhieuMuon.getText());
						String ngaymuon = (txtNgayMuon.getText());
						int songaymuon = (Integer.parseInt(txtSoNgayMuon.getText()));
						String idDocGia = (txtMaDocGia.getText());
						String idNhanVien = (txtMaNhanVien.getText());
						String ghichu = (txtGhiChu.getText());
						int trangthai = (Integer.parseInt(txtTrangThai.getText()));

						JOptionPane.showMessageDialog(null,phieBLL.editPhieuMuon(ngaymuon, songaymuon, idDocGia, idNhanVien, ghichu,trangthai,id));
						loadPhieuMuonList();
					}
				} catch (HeadlessException ex) {
					ex.printStackTrace();
					System.out.println("Lỗi update");
				}
			}
		});
		btnSuaPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuaPhieuMuon.setBounds(568, 176, 85, 21);
		panelDSPM.add(btnSuaPhieuMuon);

		JButton btnXoaPhieuMuon = new JButton("Xóa");
		btnXoaPhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtMaPhieuMuon.getText().trim().equals(""))
						JOptionPane.showMessageDialog(null,"Vui lòng nhập mã phiếu mượn để xóa");
					else{
						PhieuMuonDTO phie = new PhieuMuonDTO();
						phie.setMaPhieuMuon(txtMaPhieuMuon.getText());
						JOptionPane.showMessageDialog(null,phieBLL.deletePhieuMuon(phie.getMaPhieuMuon()));
						loadPhieuMuonList();
					}
				}catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ");
				}
			}
		});
		btnXoaPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaPhieuMuon.setBounds(675, 176, 85, 21);
		panelDSPM.add(btnXoaPhieuMuon);

		JLabel lblNewLabel_9 = new JLabel("Chi tiết phiếu mượn");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(270, 224, 198, 37);
		panelDSPM.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Mã phiếu mượn:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(23, 289, 106, 13);
		panelDSPM.add(lblNewLabel_10);

		txtMaPhieuMuon = new JTextField();
		txtMaPhieuMuon.setBounds(144, 287, 141, 19);
		panelDSPM.add(txtMaPhieuMuon);
		txtMaPhieuMuon.setColumns(10);

		JLabel lblNewLabel_10_1 = new JLabel("Ngày mượn:");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10_1.setBounds(23, 332, 85, 13);
		panelDSPM.add(lblNewLabel_10_1);

		txtNgayMuon = new JTextField();
		txtNgayMuon.setColumns(10);
		txtNgayMuon.setBounds(144, 330, 141, 19);
		panelDSPM.add(txtNgayMuon);

		JLabel lblNewLabel_10_2 = new JLabel("Số ngày mượn:");
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10_2.setBounds(23, 377, 106, 13);
		panelDSPM.add(lblNewLabel_10_2);

		txtSoNgayMuon = new JTextField();
		txtSoNgayMuon.setColumns(10);
		txtSoNgayMuon.setBounds(144, 375, 141, 19);
		panelDSPM.add(txtSoNgayMuon);

		JLabel lblNewLabel_10_3 = new JLabel("Mã độc giả: ");
		lblNewLabel_10_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10_3.setBounds(398, 289, 85, 13);
		panelDSPM.add(lblNewLabel_10_3);

		txtMaDGPhieuMuon = new JTextField();
		txtMaDGPhieuMuon.setColumns(10);
		txtMaDGPhieuMuon.setBounds(519, 287, 141, 19);
		panelDSPM.add(txtMaDGPhieuMuon);

		JLabel lblNewLabel_10_4 = new JLabel("Mã nhân viên: ");
		lblNewLabel_10_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10_4.setBounds(398, 334, 85, 13);
		panelDSPM.add(lblNewLabel_10_4);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(519, 332, 141, 19);
		panelDSPM.add(txtMaNhanVien);

		JLabel lblNewLabel_10_5 = new JLabel("Ghi chú:");
		lblNewLabel_10_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10_5.setBounds(398, 379, 85, 13);
		panelDSPM.add(lblNewLabel_10_5);

		txtGhiChu = new JTextField();
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(519, 377, 141, 19);
		panelDSPM.add(txtGhiChu);

		JLabel lblNewLabel_10_6 = new JLabel("Trạng thái:");
		lblNewLabel_10_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10_6.setBounds(23, 422, 85, 13);
		panelDSPM.add(lblNewLabel_10_6);

		txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(144, 420, 141, 19);
		panelDSPM.add(txtTrangThai);

		JButton btnNewButton_2 = new JButton("Danh sách phiếu mượn");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(0, 0, 175, 26);
		QLPM.add(btnNewButton_2);

		JPanel header = new JPanel();
		header.setBackground(SystemColor.info);
		header.setBounds(0, 0, 986, 60);
		contentPane.add(header);
		header.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ THƯ VIỆN TRƯỜNG ĐẠI HỌC SÀI GÒN\r\n");
		lblNewLabel.setBounds(241, 17, 518, 29);
		header.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setBounds(812, 15, 98, 31);
		header.add(btnNewButton);

		JButton btnQLDocGia = new JButton("QUẢN LÝ ĐỘC GIẢ");

		btnQLDocGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQLDocGia.setBounds(0, 82, 200, 49);
		contentPane.add(btnQLDocGia);

		JButton btnQLSach = new JButton("QUẢN LÝ SÁCH");

		btnQLSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQLSach.setBounds(0, 128, 200, 49);
		contentPane.add(btnQLSach);
		txtMaPhieuMuon.setEditable(false);

		JButton btnQLMuonTra = new JButton("QUẢN LÝ MƯỢN TRẢ");
		
		btnQLMuonTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQLMuonTra.setBounds(0, 176, 200, 49);
		contentPane.add(btnQLMuonTra);
		btnQLDM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				QLS.remove(panelQLSach);
//				QLS.repaint();
//				QLS.revalidate();
//				QLS.add(panelQLSach);
//				QLS.revalidate();
				panelQLSach.hide();
				panelQLTheLoai.hide();
				panelQLDanhMuc.show();
			}
		});
		panelQLTheLoai.hide();
		ButtonGroup bg = new ButtonGroup();
		btnQLDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.remove(QLS);
				Card.remove(QLPM);
				Card.add(QLDG);
				Card.validate();
				
			}
		});
		btnQLSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.remove(QLDG);
				Card.remove(QLPM);
				Card.add(QLS);
				Card.validate();
			}
		});
		btnQLMuonTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.remove(QLDG);
				Card.remove(QLS);
				Card.add(QLPM);
				Card.validate();
			}
		});
		loadDocGiaList();
		loadPhieuMuonList();
                loadBookList();
                loadTheLoaiList(1);
                loadDanhMucList(1);
	}
}
