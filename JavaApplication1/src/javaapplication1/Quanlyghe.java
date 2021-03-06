/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import DAO.GheDAO;
import DAO.GheDAO;
import DAO.LoaiGheDAO;
import DAO.PhongChieuDAO;
import DTO.GheDTO;
import DTO.GheDTO;
import DTO.LoaiGheDTO;
import DTO.PhongChieuDTO;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.util.ValidationUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.jgoodies.validation.util.ValidationResultModel;
import com.jgoodies.validation.util.ValidationUtils;
import com.jgoodies.validation.view.ValidationResultViewFactory;
import javax.swing.JComponent;
/**
 *
 * @author abcd
 */
public class Quanlyghe extends javax.swing.JFrame {

    /**
     * Creates new form Quanlyghe
     */
    public Quanlyghe() {
        initComponents();
        laydanhsachghe();
        laydanhsachloaighe();
        laydanhsachphongchieu();
    }

    
     public void laydanhsachphongchieu()
    {
        try {
            PhongChieuDAO rap=new PhongChieuDAO();
            List<PhongChieuDTO> list=rap.laydanhsachPhongChieu();
            for(int i=0;i<list.size();i++)
            {
                cboMaPC.addItem(list.get(i).getMAPC());
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Quanlyphim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public void laydanhsachloaighe()
    {
        try {
            LoaiGheDAO rap=new LoaiGheDAO();
            List<LoaiGheDTO> list=rap.laydanhLoaiGhe();
            for(int i=0;i<list.size();i++)
            {
                cboMaLG.addItem(list.get(i).getMALG());
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Quanlyphim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     
     
      
      
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboTinhTrang = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtMaGhe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtViTri = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboMaLG = new javax.swing.JComboBox<>();
        cboMaPC = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        grvGhe = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt Động", "Không Hoạt Động" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ GHẾ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Ghế", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18), new java.awt.Color(0, 102, 255))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 102, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Mã ghế");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Mã LG");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Mã PC ");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Vị Trí");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Tình trạng");

        cboMaLG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaLGActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt Động", "Không Hoạt Động" }));
        jComboBox3.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(3, 3, 3)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtViTri, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaGhe)
                    .addComponent(cboMaLG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMaPC, javax.swing.GroupLayout.Alignment.TRAILING, 0, 245, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, 245, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaLG, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Rạp Phim"), "Danh Sách Ghế", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 102, 255))); // NOI18N

        grvGhe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Ghế", "Mã LG", "Mã PC", "Vị Trí", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        grvGhe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grvGheMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(grvGhe);

        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton9.setText("Thêm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton11.setText("Xóa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton12.setText("Sửa");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton10.setText("Mới");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         ValidationResult validationResult=validateIt();
        if(validationResult.isEmpty())
        {
        try {
            // TODO add your handling code here:
                
            
            GheDTO pc=new GheDTO();
            pc.setMAGHE(txtMaGhe.getText().toString());
            pc.setMALG(cboMaLG.getSelectedItem().toString());
             pc.setMAPC(cboMaPC.getSelectedItem().toString());
              pc.setVITRI(txtViTri.getText().toString());
            pc.setTINHTRANG(cboTinhTrang.getSelectedItem().toString());
          
          
            GheDAO pcdao=new GheDAO();
            pcdao.themGhe(pc);
            JOptionPane.showMessageDialog(null, "Lưu thành công ",
                  "Title", JOptionPane.WARNING_MESSAGE);
               
             
          laydanhsachghe();
          
             
               
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "thêm thất bại đã có lỗi xảy ra ",
                  "Title", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Quanlyphim.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else
        {
             JOptionPane.showMessageDialog(null,validationResult.getMessagesText()
                  );
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private ValidationResult validateIt() {
        ValidationResult validationResult = new ValidationResult();
        
        if (ValidationUtils.isEmpty(txtMaGhe.getText())) {
            validationResult.addError("Ma Ghe Khong Duoc TRong");
           
        } 
        
          if (ValidationUtils.isEmpty(txtViTri.getText())) {
            validationResult.addError("Vi Tri Khong Duoc TRong");
           
        } 
        

       
       

       

        return validationResult;
    }
     public void laydanhsachghe()
    {
         try {
            xoadanhsachghe();
            GheDAO pc=new GheDAO();
            List<GheDTO> list= pc.laydanhsachghe();
            
             DefaultTableModel model = (DefaultTableModel) grvGhe.getModel();
            
            for(int i=0;i<list.size();i++)
            {
              model.addRow(new Object[]{list.get(i).getMAGHE(),list.get(i).getMALG(),list.get(i).getMAPC(),list.get(i).getVITRI(),list.get(i).getTINHTRANG()});
            }
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Quanlyphim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      
      public void xoadanhsachghe()
    {
         try {
            
            GheDAO pc=new GheDAO();
            List<GheDTO> list= pc.laydanhsachghe();
         
             DefaultTableModel model = (DefaultTableModel) grvGhe.getModel();
            
           model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Quanlyphim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            GheDTO pc =new GheDTO();
            GheDAO pcdao=new GheDAO();
            pc.setMAGHE((grvGhe.getValueAt(grvGhe.getSelectedRow(), 0).toString()));
            pc.setMALG((grvGhe.getValueAt(grvGhe.getSelectedRow(), 1).toString()));
            pc.setMAPC((grvGhe.getValueAt(grvGhe.getSelectedRow(), 2).toString()));
           pc.setVITRI((grvGhe.getValueAt(grvGhe.getSelectedRow(), 3).toString()));
            pc.setTINHTRANG((grvGhe.getValueAt(grvGhe.getSelectedRow(), 4).toString()));
             
          
             
             pc.setMAGHE(txtMaGhe.getText());
            pc.setMALG(cboMaLG.getSelectedItem().toString());
              pc.setMAPC(cboMaPC.getSelectedItem().toString());
            pc.setVITRI(txtViTri.getText());
            pc.setTINHTRANG(cboTinhTrang.getSelectedItem().toString());
       
           
            pcdao.capnhatGhe(pc);
            
            
            laydanhsachghe();
              JOptionPane.showMessageDialog(null, "cap nhat thanh cong ",
                  "Title", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Quanlyphim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            GheDTO pc =new GheDTO();
            pc.setMAGHE((String)(grvGhe.getValueAt(grvGhe.getSelectedRow(), 0)));
            
            GheDAO pcdao=new GheDAO();
            pcdao.xoaGhe(pc);
            laydanhsachghe();
             JOptionPane.showMessageDialog(null, "xoa thanh cong ",
                  "Title", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Quanlyphim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        txtMaGhe.setText("");
       cboMaLG.setSelectedIndex(0);
          cboMaPC.setSelectedIndex(0);
          txtViTri.setText("");
            cboTinhTrang.setSelectedIndex(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void grvGheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grvGheMouseClicked
        // TODO add your handling code here:
        
           txtMaGhe.setText((grvGhe.getValueAt(grvGhe.getSelectedRow(), 0).toString()));
            cboMaLG.setSelectedItem((grvGhe.getValueAt(grvGhe.getSelectedRow(), 1).toString()));
            cboMaPC.setSelectedItem((grvGhe.getValueAt(grvGhe.getSelectedRow(), 2).toString()));
            txtViTri.setText((grvGhe.getValueAt(grvGhe.getSelectedRow(), 3).toString()));
            cboTinhTrang.setSelectedItem((grvGhe.getValueAt(grvGhe.getSelectedRow(),4).toString()));
            
    }//GEN-LAST:event_grvGheMouseClicked

    private void cboMaLGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaLGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaLGActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quanlyghe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quanlyghe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quanlyghe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quanlyghe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quanlyghe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboMaLG;
    private javax.swing.JComboBox<String> cboMaPC;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JTable grvGhe;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtMaGhe;
    private javax.swing.JTextField txtViTri;
    // End of variables declaration//GEN-END:variables
}
