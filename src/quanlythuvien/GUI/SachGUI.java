package quanlythuvien.GUI;
import quanlythuvien.DTO.SachDTO;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.BLL.SachBLL;
import quanlythuvien.BLL.DocGiaBLL;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlythuvien.BLL.PhieuMuonBLL;

public class SachGUI extends javax.swing.JFrame {
    // ======================================================    
    String findName = "";
    String ChiTietID="";
    String IdSachMuon="";
    String IdUser ="DG001";
    int NgayMuon=7;
    int DeleteIndex=-1;
    // ======================================================      
    SachBLL empBLL = new SachBLL();
    DocGiaBLL DocGia = new DocGiaBLL();
    PhieuMuonBLL PhieuMuon = new PhieuMuonBLL();
    DocGiaDTO user = DocGia.getIdDocGia(IdUser);
     Vector<SachDTO> DanhSachMuon = new Vector<SachDTO>();
    // ======================================================      
    public SachGUI() {
        initComponents();
        SetSoLuongMuon();
        loadBookList();
        loadDanhSachMuon(DanhSachMuon);
        jLabel7.setText(user.getTenDocGia());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTop = new javax.swing.JPanel();
        TitleText = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TPGuide = new javax.swing.JTabbedPane();
        PanelBook = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnChiTiet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FindTextField = new javax.swing.JTextField();
        BtnAddBook = new javax.swing.JButton();
        PanelListBook = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SachMuonTb = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnDeleteBook = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        BtnMuon = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        PanelGuide = new javax.swing.JPanel();
        PGuideText = new javax.swing.JPanel();
        LGuideTitle = new javax.swing.JLabel();
        textArea1 = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelTop.setBackground(new java.awt.Color(255, 204, 204));

        TitleText.setFont(new java.awt.Font("MingLiU", 1, 24)); // NOI18N
        TitleText.setText("              SGU LIBRARY");

        LogOut.setBackground(new java.awt.Color(204, 255, 204));
        LogOut.setText("Đăng Xuất");
        LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Xin Chào :");

        javax.swing.GroupLayout PanelTopLayout = new javax.swing.GroupLayout(PanelTop);
        PanelTop.setLayout(PanelTopLayout);
        PanelTopLayout.setHorizontalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTopLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        PanelTopLayout.setVerticalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleText, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTopLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogOut, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        TPGuide.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Sách", "Tác Giả", "Nhà Xuất Bản", "Số lượng còn"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnChiTiet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BtnChiTiet.setText("Xem  chi tiết sách");
        BtnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnChiTietActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tìm Kiếm");

        FindTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FindTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                FindTextFieldCaretUpdate(evt);
            }
        });

        BtnAddBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BtnAddBook.setText("Thêm vào danh sách");
        BtnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBookLayout = new javax.swing.GroupLayout(PanelBook);
        PanelBook.setLayout(PanelBookLayout);
        PanelBookLayout.setHorizontalGroup(
            PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBookLayout.createSequentialGroup()
                .addGroup(PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBookLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(BtnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelBookLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelBookLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FindTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        PanelBookLayout.setVerticalGroup(
            PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBookLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(FindTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnChiTiet)
                    .addComponent(BtnAddBook))
                .addContainerGap())
        );

        TPGuide.addTab("Xem Sách", PanelBook);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Thông tin sách mượn");

        SachMuonTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        SachMuonTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SachMuonTbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SachMuonTb);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tổng lượt mượn :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel4.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("/ 3");

        BtnDeleteBook.setBackground(new java.awt.Color(255, 204, 153));
        BtnDeleteBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BtnDeleteBook.setText("Xóa");
        BtnDeleteBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteBookActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Chọn số ngày mượn");

        ComboBoxDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBoxDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "14", "30", " " }));
        ComboBoxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxDateActionPerformed(evt);
            }
        });

        BtnMuon.setBackground(new java.awt.Color(255, 204, 153));
        BtnMuon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BtnMuon.setText("Xác nhận mượn");
        BtnMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMuonActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(210, 209, 209));

        javax.swing.GroupLayout PanelListBookLayout = new javax.swing.GroupLayout(PanelListBook);
        PanelListBook.setLayout(PanelListBookLayout);
        PanelListBookLayout.setHorizontalGroup(
            PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(PanelListBookLayout.createSequentialGroup()
                        .addGroup(PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelListBookLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelListBookLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                        .addGroup(PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnDeleteBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PanelListBookLayout.setVerticalGroup(
            PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListBookLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(BtnDeleteBook))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnMuon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        TPGuide.addTab("Danh Sách Mượn", PanelListBook);

        LGuideTitle.setBackground(new java.awt.Color(199, 184, 216));
        LGuideTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LGuideTitle.setText("                                    THƯ VIỆN ĐẠI HỌC SÀI GÒN");

        textArea1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textArea1.setText("Xin chào các bạn sinh viên SGU thân mến !!!\nĐể có thể sử dụng online thư viện SGU các bạn vui lòng làm theo hướng dẫn sau :\nĐể xem danh sách những cuốn sách hiện có tại thư viện các bạn hãy vào mục \" Xem Sách \" tại đó các bạn có thể xem chi tiết thông tin sách và thêm vào danh sách mượn . \nSau khi thêm hãy nhấn vào mục \" Danh Sách Mượn \" để xem lại danh sách phiếu mượn của mình \n* LƯU Ý : mỗi sinh viên chỉ có thể mượn cùng lúc 5 cuốn sách.\nSau đó chọn ngày trả và bấm xác nhận để mượn.\nThời gian mượn sách bắt đầu từ lúc các bạn bấm \"mượn sách\" thế nên hãy vui lòng đến thư viện trong thời gian sớm nhất để nhận sách \nvà đừng quên đem theo thẻ sinh viên hoặc chứng minh nhân dân .\nXin cám ơn các bạn đã đồng hành cùng thư viện SGU trong thời gian qua . \n==========================================================================================================\nKhi trả sách nếu có bất cứ hư hại hay mất mát nào thì sinh viên sẽ phải chịu trách nhiệm tiền phạt như sau :\nSách rách bìa , mất trang : Phạt 20.000Đ\nLàm mất sách : Phạt 50.000Đ \nPhát hiện ăn cắp sách : Phạt 100.000Đ và cấm vĩnh viễn mượn sách tại thư viện\n\n");

        javax.swing.GroupLayout PGuideTextLayout = new javax.swing.GroupLayout(PGuideText);
        PGuideText.setLayout(PGuideTextLayout);
        PGuideTextLayout.setHorizontalGroup(
            PGuideTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LGuideTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PGuideTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PGuideTextLayout.setVerticalGroup(
            PGuideTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PGuideTextLayout.createSequentialGroup()
                .addComponent(LGuideTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelGuideLayout = new javax.swing.GroupLayout(PanelGuide);
        PanelGuide.setLayout(PanelGuideLayout);
        PanelGuideLayout.setHorizontalGroup(
            PanelGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PGuideText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelGuideLayout.setVerticalGroup(
            PanelGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGuideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PGuideText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        TPGuide.addTab("Hướng Dẫn Mượn Sách", PanelGuide);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TPGuide)
            .addComponent(PanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TPGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void SetSoLuongMuon(){
        jLabel4.setText(String.valueOf(user.getSoLuongMuon()));
    }
    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        LoginGUI lg=new LoginGUI();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int position = jTable1.rowAtPoint(evt.getPoint());
        ChiTietID = jTable1.getValueAt(position,0).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void BtnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnChiTietActionPerformed
        if(ChiTietID.equals(""))
            JOptionPane.showMessageDialog(this,"Bạn chưa chọn sách");
        else{
            ChiTietSach cts= new ChiTietSach(ChiTietID);
            cts.setVisible(true);
        }
    }//GEN-LAST:event_BtnChiTietActionPerformed
    
    private void BtnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddBookActionPerformed
        if(DanhSachMuon.size()<3){
            Vector<SachDTO> arr = new Vector<SachDTO>();
            arr = empBLL.getAllBook();
            for(int i = 0; i < arr.size(); i++){
                SachDTO em = arr.get(i);
                if(em.getSach_id().equals(ChiTietID)){
                    if(em.getSach_quantity()<=0)
                        JOptionPane.showMessageDialog(this,"Sách đã hết :((");
                    else if(!KiemTraSach(em.getSach_id()))
                        JOptionPane.showMessageDialog(this,"Sách đã tồn tại trong danh sách");
                    else{
                        DanhSachMuon.add(em);
                        loadDanhSachMuon(DanhSachMuon);
                        break;
                    }                        
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Danh sách mượn đã đầy không thể mượn thêm");
        }
    }//GEN-LAST:event_BtnAddBookActionPerformed
    
    private boolean KiemTraSach(String id){
        boolean result=true;
        for(int i = 0; i < DanhSachMuon.size(); i++){
            SachDTO em = DanhSachMuon.get(i);
            if(em.getSach_id().equals(id))
                result=false;
        }
        return result;
    }
    
    private void BtnDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteBookActionPerformed
        if(DeleteIndex==-1)
            JOptionPane.showMessageDialog(this,"Vui lòng chọn sách cần xóa");
        else{
            DanhSachMuon.remove(DeleteIndex);
            loadDanhSachMuon(DanhSachMuon);
            DeleteIndex=-1;
        }           
    }//GEN-LAST:event_BtnDeleteBookActionPerformed

    private void SachMuonTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SachMuonTbMouseClicked
        DeleteIndex = SachMuonTb.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_SachMuonTbMouseClicked

    private void BtnMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMuonActionPerformed
        if(DanhSachMuon.size()+user.getSoLuongMuon()>3)
            JOptionPane.showMessageDialog(this,"Bạn chỉ có thể mượn tối đa 3 quyển sách");
        else if(DanhSachMuon.size()==0)
            JOptionPane.showMessageDialog(this,"Danh sách mượn hiện đang rỗng");
        else{
            boolean kt=PhieuMuon.InsertPhieuMuon(DanhSachMuon, user, NgayMuon);
            if(kt==true){
                JOptionPane.showMessageDialog(this,"Mượn thành công !!!\nVui lòng đến nhận sách trong thời gian sớm nhất");
                DanhSachMuon.clear();
                loadDanhSachMuon(DanhSachMuon);
                user=DocGia.getIdDocGia(IdUser);
                SetSoLuongMuon();
            }
            else
                JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi ! xin vui lòng thử lại");
        }
    }//GEN-LAST:event_BtnMuonActionPerformed

    private void ComboBoxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDateActionPerformed
        if (ComboBoxDate.getSelectedIndex() != -1)
            NgayMuon=Integer.parseInt(ComboBoxDate.getItemAt(ComboBoxDate.getSelectedIndex()));
    }//GEN-LAST:event_ComboBoxDateActionPerformed

    private void FindTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_FindTextFieldCaretUpdate
        findName = FindTextField.getText();
        loadBookList();
    }//GEN-LAST:event_FindTextFieldCaretUpdate
       
    public void loadDanhSachMuon(Vector<SachDTO> arr2){
        DefaultTableModel dtm2 = new DefaultTableModel();
        dtm2.addColumn("ID Sách");
        dtm2.addColumn("Tên Sách");
        dtm2.addColumn("Tác Giả");
        dtm2.addColumn("Nhà Xuất Bản");
        SachMuonTb.setModel(dtm2);
        for(int i = 0; i < arr2.size(); i++){
            SachDTO em = arr2.get(i);
            String id= em.getSach_id();
            String name=em.getSach_name();
            String author=em.getSach_author();
            String nxb=em.getSach_nxb();
            Object[] row = {id,name,author,nxb};
            dtm2.addRow(row);
        }
    }
    public void loadBookList(){ 
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID Sách");
        dtm.addColumn("Tên Sách");
        dtm.addColumn("Tác Giả");
        dtm.addColumn("Nhà Xuất Bản");
        dtm.addColumn("Số lượng");
        jTable1.setModel(dtm);
        Vector<SachDTO> arr = new Vector<SachDTO>();
        arr = empBLL.FindBookByName(findName);
        for(int i = 0; i < arr.size(); i++){
            SachDTO em = arr.get(i);
            String id= em.getSach_id();
            String name=em.getSach_name();
            String author=em.getSach_author();
            String nxb=em.getSach_nxb();
            int quantity=em.getSach_quantity();
            Object[] row = {id,name,author,nxb,quantity};
            dtm.addRow(row);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SachGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddBook;
    private javax.swing.JButton BtnChiTiet;
    private javax.swing.JButton BtnDeleteBook;
    private javax.swing.JButton BtnMuon;
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JTextField FindTextField;
    private javax.swing.JLabel LGuideTitle;
    private javax.swing.JButton LogOut;
    private javax.swing.JPanel PGuideText;
    private javax.swing.JPanel PanelBook;
    private javax.swing.JPanel PanelGuide;
    private javax.swing.JPanel PanelListBook;
    private javax.swing.JPanel PanelTop;
    private javax.swing.JTable SachMuonTb;
    private javax.swing.JTabbedPane TPGuide;
    private javax.swing.JLabel TitleText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
