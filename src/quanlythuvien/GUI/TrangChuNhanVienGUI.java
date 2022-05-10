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
import quanlythuvien.DAL.DocGiaDAL;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.BLL.SachBLL;
import quanlythuvien.DTO.*;


public class TrangChuNhanVienGUI extends JFrame {

	DocGiaBLL docBLL = new DocGiaBLL();
        SachBLL sachBLL = new SachBLL();

	private JPanel contentPane;
	private JTextField textField_5;
	private JTable table;
	private JTextField txtMaDocGia;
	private JTextField txtTenDocGia;
	private JTextField txtNgaySinh;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTable table_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table_2;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	public  String idDocGia;

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
		table_1.setModel(dtmDocGia);
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
		lblNewLabel_2.setBounds(59, 108, 90, 35);
		panelQLDocGia.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Giới tính:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(59, 165, 90, 35);
		panelQLDocGia.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(386, 165, 90, 35);
		panelQLDocGia.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày sinh::");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(386, 108, 90, 35);
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
		txtTenDocGia.setBounds(152, 117, 181, 19);
		panelQLDocGia.add(txtTenDocGia);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(486, 117, 181, 19);
		panelQLDocGia.add(txtNgaySinh);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(486, 20, 181, 19);
		panelQLDocGia.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(486, 174, 181, 19);
		panelQLDocGia.add(txtEmail);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNam.setBounds(155, 173, 62, 21);
		panelQLDocGia.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNu.setBounds(219, 173, 103, 21);
		panelQLDocGia.add(rdbtnNu);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(82, 220, 90, 21);
		panelQLDocGia.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtMaDocGia.getText().trim().equals("") ||
						txtTenDocGia.getText().trim().equals("") ||

						txtSDT.getText().trim().equals("") ||
						txtNgaySinh.getText().trim().equals(""))
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
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1_1.setBounds(266, 220, 90, 21);
		panelQLDocGia.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1_2.setBounds(451, 220, 90, 21);
		panelQLDocGia.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtMaDocGia.getText().trim().equals(""))
						JOptionPane.showMessageDialog(null,"Vui lòng nhập mã độc giả để xóa");
					else{
						DocGiaDTO doc = new DocGiaDTO();
						doc.setMaDocGia(txtMaDocGia.getText());
						JOptionPane.showMessageDialog(null,docBLL.deleteDocGia(idDocGia));
						loadDocGiaList();
					}
				}catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ");
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 261, 760, 214);
		panelQLDocGia.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				txtMaDocGia.setText(model.getValueAt(i,0).toString());
				txtTenDocGia.setText(model.getValueAt(i,1).toString());
				txtNgaySinh.setText(model.getValueAt(i,2).toString());
				txtEmail.setText(model.getValueAt(i,4).toString());
				txtSDT.setText(model.getValueAt(i,5).toString());
				idDocGia = txtMaDocGia.getText();

			}
		});

		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tài khoản:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(59, 56, 90, 36);
		panelQLDocGia.add(lblNewLabel_1_2);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(152, 66, 181, 19);
		panelQLDocGia.add(txtTaiKhoan);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(386, 56, 90, 36);
		panelQLDocGia.add(lblNewLabel_1_1_1);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(486, 66, 181, 19);
		panelQLDocGia.add(txtMatKhau);
		
		JPanel panelThongTinDocGia = new JPanel();
		panelThongTinDocGia.setBounds(0, 25, 770, 480);
		QLDG.add(panelThongTinDocGia, "ThongTinDocGia");
		panelThongTinDocGia.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("TÌm kiếm thông tin bằng tên độc giả:");
		lblNewLabel_3.setBounds(66, 26, 245, 29);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelThongTinDocGia.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(299, 26, 267, 29);
		textField_5.setColumns(10);
		panelThongTinDocGia.add(textField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 760, 403);
		panelThongTinDocGia.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên đăng nhập", "Tên độc giả", "Ngày sinh", "Giới tính", "Email", "SDT"
			}
		));
		scrollPane.setViewportView(table);
		
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
		
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm bằng tên danh mục:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(47, 41, 176, 21);
		panelQLDanhMuc.add(lblNewLabel_5);
		
		textField_14 = new JTextField();
		textField_14.setBounds(261, 43, 185, 19);
		panelQLDanhMuc.add(textField_14);
		textField_14.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Tìm kiếm");
		btnNewButton_5.setBounds(491, 42, 85, 21);
		panelQLDanhMuc.add(btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("Thông tin của danh mục: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(88, 110, 185, 13);
		panelQLDanhMuc.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mã danh mục:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(24, 151, 96, 13);
		panelQLDanhMuc.add(lblNewLabel_7);
		
		textField_15 = new JTextField();
		textField_15.setBounds(145, 149, 128, 19);
		panelQLDanhMuc.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Tên danh mục:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1.setBounds(24, 200, 96, 13);
		panelQLDanhMuc.add(lblNewLabel_7_1);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(145, 198, 128, 19);
		panelQLDanhMuc.add(textField_16);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(375, 110, 385, 245);
		panelQLDanhMuc.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã danh mục", "Tên danh mục"
			}
		));
		scrollPane_3.setViewportView(table_3);
		
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
		
		JButton btnNewButton_4 = new JButton("Thêm");
		btnNewButton_4.setBounds(59, 229, 85, 21);
		panelQLSach.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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
				panelQLDanhMuc.hide();
				panelQLSach.show();
			}
		});
		btnQLS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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
		scrollPane_4.setBounds(10, 46, 750, 188);
		panelDSPM.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã phiếu mượn", "Tên độc giả", "Tên nhân viên", "Ngày mượn", "Số ngày mượn", "Ghi chú", "Trạng thái"
			}
		));
		scrollPane_4.setViewportView(table_4);
		
		JLabel lblNewLabel_9 = new JLabel("Mã phiếu mượn:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(37, 259, 102, 13);
		panelDSPM.add(lblNewLabel_9);
		
		textField_17 = new JTextField();
		textField_17.setBounds(166, 257, 156, 19);
		panelDSPM.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Mã sách:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9_1.setBounds(37, 299, 102, 13);
		panelDSPM.add(lblNewLabel_9_1);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(166, 297, 156, 19);
		panelDSPM.add(textField_18);
		
		JLabel lblNewLabel_9_2 = new JLabel("Ngày thực trả:");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9_2.setBounds(37, 340, 102, 13);
		panelDSPM.add(lblNewLabel_9_2);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(166, 338, 156, 19);
		panelDSPM.add(textField_19);
		
		JButton btnNewButton_3 = new JButton("Thêm ");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBounds(436, 256, 85, 21);
		panelDSPM.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Sửa");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_6.setBounds(551, 255, 85, 21);
		panelDSPM.add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("Xóa");
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_6_1.setBounds(675, 255, 85, 21);
		panelDSPM.add(btnNewButton_6_1);
		
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
				panelQLDanhMuc.show();
			}
		});
		
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
                loadBookList();
	}
}
