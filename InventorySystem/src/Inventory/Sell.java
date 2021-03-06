/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Inventory;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author allan
 */
public class Sell extends javax.swing.JInternalFrame {

    /** Creates new form AddItem */
    
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection con;
        
    private ImageIcon format = null;
    String fname = null;
    int s = 0;
    byte[] pimage = null;   
    
    String sid;
    String iid;
    String uprice;
    String noofitem;
    String totalprice;
    String discount;
    String payable;
    String cash;
    String balance;
    String date;
    
    public Sell() {
        initComponents();
        con = DBConnection.connect();
        billheader();
        autoId();
         this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }
    
    private void lordData()
    {
        sid = lblsid.getText();
        iid = txtiid.getText();
        uprice = txtuprice.getText();
        noofitem = txtnoitems.getText();
        totalprice = txttprice.getText();
        discount = txtdiscount.getText();
        payable = txtpayable.getText();
        cash = txtcash.getText();
        balance = txtbalance.getText();
        LocalDate ndate  =LocalDate.now();
        date  = ndate+"";
    }

    private void itemLord(){
    try{
            String sql = "SELECT `item_name`, `serial_no`, `sale_price`, `image` FROM `stock` WHERE item_id='"+txtiid.getText()+"'";
             pst = (PreparedStatement) con.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next()){
                 
                    txtiname.setText(rs.getString("item_name"));
                    txtserialno.setText(rs.getString("serial_no"));
                    txtuprice.setText(rs.getString("sale_price"));
                   
                    
                    byte[] imagedata = rs.getBytes("image");
                    format = new ImageIcon(imagedata);
                    Image mm = format.getImage();
                    Image img2 = mm.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon image = new ImageIcon(img2);
                    lblimage.setIcon(image);
             }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtiid = new javax.swing.JTextField();
        txtiname = new javax.swing.JTextField();
        txtuprice = new javax.swing.JTextField();
        txtnoitems = new javax.swing.JTextField();
        txtdiscount = new javax.swing.JTextField();
        txttprice = new javax.swing.JTextField();
        txtserialno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtpayable = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtcash = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtbalance = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblimage = new javax.swing.JLabel();
        lblsid = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(640, 510));

        jPanel1.setBackground(new java.awt.Color(72, 126, 176));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Item ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Item Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Serial No");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Unit Price");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("No Of Item");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Total Price");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Discount");

        txtiid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtiid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtiidKeyReleased(evt);
            }
        });

        txtiname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtuprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtnoitems.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnoitems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnoitemsKeyReleased(evt);
            }
        });

        txtdiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscountKeyReleased(evt);
            }
        });

        txttprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttpriceActionPerformed(evt);
            }
        });

        txtserialno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Payable");

        txtpayable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpayable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayableActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Cash");

        txtcash.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcashKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Change");

        txtbalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel10.setBackground(new java.awt.Color(0, 153, 255));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sell");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 153, 255));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Print");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(0, 153, 255));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Clear");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtiid, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtiname)
                            .addComponent(txtserialno)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(40, 40, 40)
                        .addComponent(txtuprice))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcash, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtpayable, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdiscount, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttprice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnoitems)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(52, 52, 52)
                        .addComponent(txtbalance)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtiid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtiname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtserialno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnoitems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpayable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 470));

        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblsid.setText("SID");

        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblsid)
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblsid)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 310, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpayableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpayableActionPerformed

    private void txtiidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiidKeyReleased
        // TODO add your handling code here:
        if(txtiid.getText().length() == 7){
          itemLord();  
        }
        
    }//GEN-LAST:event_txtiidKeyReleased

    private void txtnoitemsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoitemsKeyReleased
        try {
            // TODO add your handling code here:

            String sql = "SELECT `no_of_items` FROM `stock`";
             pst = (PreparedStatement) con.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next()){
            
            
            int currentQty = Integer.parseInt(rs.getString("no_of_items"));
            
            int newQty = Integer.parseInt(txtnoitems.getText());
            
            if(newQty > currentQty){
                JOptionPane.showMessageDialog(rootPane, "Not Enough Quantity");
            }
            }else{
                
                String queryUpdateStock = "UPDATE `stock` SET no_of_items = Qty WHERE item_id='"+sid+ "'";
                pst = (PreparedStatement) con.prepareStatement(queryUpdateStock);
                pst.execute();
                
                int currentQty = Integer.parseInt(rs.getString("no_of_items"));
            
                int newQty = Integer.parseInt(txtnoitems.getText());
                
                int Qty = currentQty - newQty;
                
                 
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(Sell.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        double price = Double.parseDouble(txtuprice.getText()); 
        double unit = Double.parseDouble(txtnoitems.getText());
        double tprice = price * unit;
        txttprice.setText(tprice+"");
    }//GEN-LAST:event_txtnoitemsKeyReleased

    private void txttpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttpriceActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txttpriceActionPerformed

    private void txtdiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscountKeyReleased
        // TODO add your handling code here:
        double discount = Double.parseDouble(txtdiscount.getText());
        double tprice = Double.parseDouble(txttprice.getText());
        double payable = tprice - discount;
        txtpayable.setText(payable+""); 
        
    }//GEN-LAST:event_txtdiscountKeyReleased

    private void txtcashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcashKeyReleased
        // TODO add your handling code here:
         double cash = Double.parseDouble(txtcash.getText());
        double payable = Double.parseDouble(txtpayable.getText());
        double balance = cash - payable;
        txtbalance.setText(balance+"");
    }//GEN-LAST:event_txtcashKeyReleased

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
//        makeBill();
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
       
        makeBill();
        lordData();
        try{
            String query = "INSERT INTO `sale`(`sale_id`, `item_id`, `unit_price`, `no_of_item`, `total_price`, `discount`, `payable`, `cash`, `balance`, `date`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, sid);
            pst.setString(2, iid);
            pst.setString(3, uprice);
            pst.setString(4, noofitem); 
            pst.setString(5, totalprice);
            pst.setString(6, discount);
            pst.setString(7, payable);
            pst.setString(8, cash);
            pst.setString(9, balance);
            pst.setString(10, date);
            
            
            
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(rootPane, "Transaction Completed");
            
        }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, e);
        }
        
         
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        try{
            txtbill.print();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
        
        autoId();
        txtiid.setText("");
        txtiname.setText("");
        txtserialno.setText("");
        txtuprice.setText("");
        txtnoitems.setText("");
        txttprice.setText("");
        txtdiscount.setText("");
        txtpayable.setText("");
        txtcash.setText("");
        txtbalance.setText("");
        txtbill.setText("");
    }//GEN-LAST:event_jPanel14MouseClicked
    private void makeBill()
    {
        txtbill.setText(txtbill.getText()+ "Item Name\t"+txtiname.getText()+"\nNo Of Item\t"+txtnoitems.getText()+"\nUnit Price\t"+txtuprice.getText()+"\nTotal Price\t"+txttprice.getText()+"\n----------------------\nDiscount\t"+txtdiscount.getText()+"\nPayable\t"+txtpayable.getText()+"\nCash\t"+txtcash.getText()+"\n--------------------\nChange\t"+txtbalance.getText()+"\n\n");
    }
    private void billheader()
    {
      txtbill.setText("-------------------Increment Software LTD--------------\n\n");
      
    }
     private void autoId()
    {
        
        try{
            String sql = "SELECT `sale_id` FROM `sale` ORDER BY sale_id DESC LIMIT 1";
            pst = (PreparedStatement) con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                
                String rnno = rs.getString("sale_id");
                int co = rnno.length();
                String txt =rnno.substring(0,3);
                String num = rnno.substring(3, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt+snum;
                lblsid.setText(ftxt);
            }
            else
            {
                  lblsid.setText("SID1000");
            }
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblimage;
    private javax.swing.JLabel lblsid;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JTextArea txtbill;
    private javax.swing.JTextField txtcash;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtiid;
    private javax.swing.JTextField txtiname;
    private javax.swing.JTextField txtnoitems;
    private javax.swing.JTextField txtpayable;
    private javax.swing.JTextField txtserialno;
    private javax.swing.JTextField txttprice;
    private javax.swing.JTextField txtuprice;
    // End of variables declaration//GEN-END:variables

}
