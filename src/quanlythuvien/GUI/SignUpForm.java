
package quanlythuvien.GUI;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Arrays;
public class SignUpForm extends javax.swing.JFrame {
    private String gender = "Nam";
    public SignUpForm() {
        initComponents();
    }
    private Connection con;
    public boolean openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "localhost";
            String DatabaseName="QLThuVien" ;
            String username = "sa"; 
            String password= "123";
            String url = "jdbc:sqlserver://" +dbUrl + ":1433;DatabaseName=" + DatabaseName + ";username="+username+";password="+password+";encrypt=true;trustServerCertificate=true;";
            con=DriverManager.getConnection(url);  

            return true;
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    public void closeConection(){
        try {
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            System.out.println(ex); }
    }
    public boolean insert(){
        boolean result = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(fmtBirth.getDate());
        
        if(openConnection()){
            try{
                String pass = String.valueOf(txtPassword.getPassword());
                String id="DG00"+SoTaiKhoan();
                String sql="INSERT into [dbo].[TaiKhoan]([MaTaiKhoan],[TenDangNhap],[MatKhau],[Quyen])"+"Values(?,?,?,2)";
                PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1,id);
                    stmt.setString(2,txtUsername.getText());
                    stmt.setString(3,pass);
                
                
                String sql2="INSERT into [dbo].[DocGia]([MaDocGia],[TenDocGia],[NgaySinh],[GioiTinh],[Email],[SDT],[Status],[SoLuongMuon])"+"Values(?,?,?,?,?,?,1,0)";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                    stmt2.setString(1,id);
                    stmt2.setString(2,txtName.getText());
                    stmt2.setString(3,date);
                    stmt2.setString(4,gender);
                    stmt2.setString(5,txtMail.getText());
                    stmt2.setString(6,txtPhone.getText());
                if(stmt.executeUpdate()>0 && stmt2.executeUpdate()>0)
                    result = true;
                else
                    result = false;
            }catch (SQLException ex){
                System.out.println(ex+"Sai ??? ????y 1");
            }finally{
                closeConection();
            }
        }
        return result;
    }
    
    public int SoTaiKhoan(){
        int row=0;
        if(openConnection()){
            try {
                String sql = "Select * from TaiKhoan where Quyen = 2 or Quyen = 0";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next())
                    row++;
            }catch (SQLException ex){
                System.out.println(ex+"Sai ??? ????y 2");
            }
        }
        return row+1;
    }
    
    private boolean CheckName(String name){
        boolean result = true;
        if(openConnection()){
            try{
                String sql="select * from [dbo].[TaiKhoan] where TenDangNhap = ?";
                PreparedStatement ps=con.prepareCall(sql);
                ps.setString(1,name);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                    result= false;
                else
                    result = true;
            }catch (SQLException ex){
                System.out.println(ex+"Sai ??? ????y 3");
            }finally{
                closeConection();
            }
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnSignUp = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        cbSex = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        fmtBirth = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SignUp");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("????NG K?? T??I KHO???N");

        jLabel2.setText("T??i kho???n:");

        jLabel3.setText("M???t kh???u: ");

        jLabel4.setText("X??c nh???n m???t kh???u:");

        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignUp.setText("????ng k??");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setText("Tho??t");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel5.setText("E-mail:");

        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });

        jLabel6.setText("S??? ??i???n tho???i:");

        jLabel7.setText("Gi???i t??nh:");

        jLabel8.setText("Ng??y sinh:");

        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "N???" }));
        cbSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexActionPerformed(evt);
            }
        });

        jLabel9.setText("H??? v?? t??n:");

        fmtBirth.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txtMail)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(txtPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fmtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSignUp)
                        .addGap(27, 27, 27)
                        .addComponent(btnCancel)
                        .addGap(38, 38, 38)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(fmtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignUp)
                    .addComponent(btnCancel))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        LoginForm lf = new LoginForm();
            lf.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        String name = txtName.getText();
        String sdt = txtPhone.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String repassword = String.valueOf(txtConfirmPassword.getPassword());
        boolean confirm = true;
        
        if (txtUsername.getText().equals("")){
            JOptionPane.showMessageDialog(this,"T??n ????ng nh???p kh??ng ???????c ????? tr???ng \n");
            txtUsername.setBackground(Color.yellow);
            txtUsername.requestFocus();
            confirm = false;
        }
        else if(CheckName(txtUsername.getText())==false){
            JOptionPane.showMessageDialog(this,"T??n ????ng nh???p ???? ???????c s??? d???ng \n");
            txtUsername.setBackground(Color.yellow);
            txtUsername.requestFocus();
            confirm = false;
        }
        else if (txtMail.getText().equals("")){
            JOptionPane.showMessageDialog(this,"E-mail kh??ng ???????c ????? tr???ng\n");
            txtMail.setBackground(Color.yellow);
            txtMail.requestFocus();
            confirm = false;
        }
        else
        if (password.equals("")){
            JOptionPane.showMessageDialog(this,"M???t kh???u kh??ng ???????c ????? tr???ng \n");
            txtPassword.setBackground(Color.yellow);
            txtPassword.requestFocus();
            confirm = false;
        }
        else if (!password.equals(repassword) ){
            JOptionPane.showMessageDialog(this,"M???t kh???u ch??a kh???p \n");
            txtPassword.setBackground(Color.yellow);
            confirm = false;
        }
        else if(name.equals("")){
            JOptionPane.showMessageDialog(this,"Vui l??ng nh???p t??n c???a b???n\n");
            txtName.setBackground(Color.yellow);
            txtName.requestFocus();
            confirm = false;
        }
        else if(sdt.equals("")){
            JOptionPane.showMessageDialog(this,"Vui l??ng nh???p s??? ??i???n tho???i c???a b???n\n");
            txtPhone.setBackground(Color.yellow);
            txtPhone.requestFocus();
            confirm = false;
        }
        else if(fmtBirth.getDate()==null){
            JOptionPane.showMessageDialog(this,"Vui l??ng nh???p ng??y sinh\n");
            fmtBirth.setBackground(Color.yellow);
            fmtBirth.requestFocus();
            confirm = false;
        }
        else if ( confirm == true){
            if(insert())
            JOptionPane.showMessageDialog(this, "????ng k?? th??nh c??ng!");
            else
            JOptionPane.showMessageDialog(this, "????ng k?? th???t b???i");
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void cbSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexActionPerformed
        if (cbSex.getSelectedIndex() != -1)
            gender=cbSex.getItemAt(cbSex.getSelectedIndex());
    }//GEN-LAST:event_cbSexActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JComboBox<String> cbSex;
    private com.toedter.calendar.JDateChooser fmtBirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
