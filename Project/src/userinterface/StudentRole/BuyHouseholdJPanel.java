/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StudentRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AccomodationAssisstantManagerWorkRequest;
import Business.WorkQueue.HouseholdAssisstantManagerWorkRequest;
import Business.WorkQueue.HouseholdWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaynee
 */
public class BuyHouseholdJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BuyHouseholdJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount userAccount;
    Organization studentOrganization;
    EcoSystem system;
    
    public BuyHouseholdJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount userAccount,Organization organization, EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
          this.enterprise=enterprise;
          this.userAccount=userAccount;
          this.studentOrganization=(StudentOrganization)organization;
          this.system=system;
          populateData();
    }
    
    public void populateData(){
       
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for(UserAccount userAccount1: studentOrganization.getUserAccountDirectory().getUserAccountList())
        {
        for (HouseholdWorkRequest request : userAccount1.getWorkQueue().getHouseholdWorkRequests()){
            Object[] row = new Object[10];
            row[0] = request;
            row[1]=request.getfName();
            row[2] = request.getlName();
            row[3] = request.getFurnitureType();
            row[4]=request.getQuantity();
            row[5]=request.getCost();
            row[6] = request.getStatus();
            
            model.addRow(row);
        }
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addToCartButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Result", "First Name", "Last Name", "Furniture Type", "Quantity", "Cost", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Buy Household Products");

        addToCartButton.setText("Add to cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addToCartButton)
                                .addGap(49, 49, 49)
                                .addComponent(backJButton))
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addComponent(nextButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(315, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addToCartButton)
                    .addComponent(nextButton)
                    .addComponent(backJButton))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        HouseholdAssisstantManagerWorkRequest request = (HouseholdAssisstantManagerWorkRequest)workRequestJTable.getValueAt(selectedRow,0);
        if(!request.getStatus().equalsIgnoreCase("Purchased"))
        {
            boolean flag =false;
            if(!request.getTrackCartUser().equalsIgnoreCase(userAccount.getUsername()))
            {
                JOptionPane.showMessageDialog(null, "Item unavailable. Item added to Cart by someone else");
                flag = true;

            }
            if (!flag &&!request.getStatus().equalsIgnoreCase("Added to Cart"))
            {
                JOptionPane.showMessageDialog(null, "Please add the item to the cart");

            }
            if(request.getTrackCartUser().equalsIgnoreCase(userAccount.getUsername())&& request.getStatus().equalsIgnoreCase("Added to Cart"))
            {
                HouseholdBuyerDetailsJPanel buyer = new HouseholdBuyerDetailsJPanel(userProcessContainer,enterprise,userAccount,studentOrganization,system);
                userProcessContainer.add("BookstoreBuyerDetails", buyer);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The selected item is sold to somenone else");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        HouseholdAssisstantManagerWorkRequest request = (HouseholdAssisstantManagerWorkRequest)workRequestJTable.getValueAt(selectedRow,0);
        String currentState=request.getStatus();

        switch(currentState.toUpperCase())
        {
            case "PENDING":
            JOptionPane.showMessageDialog(null, "Request is not yet processed by the authority.");
            break;
            case "PROCESSING":
            JOptionPane.showMessageDialog(null, "Request is not yet processed by the authority.");
            break;
            case "COMPLETED":
            request.setStatus("Added To Cart");
            request.setTrackCartUser(userAccount.getUsername());
            break;
            case "ADDED TO CART":
            JOptionPane.showMessageDialog(null, "Request is  already added to the cart");
            break;
            case "PURCHASED":
            JOptionPane.showMessageDialog(null, "The selected Accomodation has been sold");
            break;

        }
        populateData();
    }//GEN-LAST:event_addToCartButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
