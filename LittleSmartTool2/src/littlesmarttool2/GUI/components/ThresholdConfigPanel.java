/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.GUI.components;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import littlesmarttool2.model.Command;
import littlesmarttool2.model.Configuration;
import littlesmarttool2.model.Threshold;

/**
 *
 * @author Rasmus
 */
public class ThresholdConfigPanel extends javax.swing.JPanel {

    DefaultListModel listModel = new DefaultListModel();
    Threshold threshold;
    ChannelTabPanel parent;
    /**
     * Creates new form ThresholdConfigPanel
     */
    public ThresholdConfigPanel(Configuration config, Threshold threshold, ChannelTabPanel parent){
        initComponents();
        this.parent = parent;
        this.threshold = threshold;
        populate(config);
        upList.setSelectedValue(threshold.getUpCommand(), true);
        downList.setSelectedValue(threshold.getDownCommand(), true);
        //TODO: Select
    }
    
    private ListModel getListModel() 
    {
        return listModel;
    }
    
    private void populate(Configuration config)
    {
        listModel.removeAllElements();
        listModel.add(0,Command.getNothingCommand());
        int i = 1;
        for (Command c : config.getRelevantCommands())
        {
            listModel.add(i++, c);
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

        jLabel1 = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        upList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        downList = new javax.swing.JList();
        southPanel = new javax.swing.JPanel();
        deleteThresholdButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Select an action to be performed when this threshold is passed");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        centerPanel.setLayout(new java.awt.GridLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Action going up ->");
        jPanel1.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        upList.setModel(getListModel());
        upList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                upListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(upList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        centerPanel.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Action going down <-");
        jPanel2.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        downList.setModel(getListModel());
        downList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                downListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(downList);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        centerPanel.add(jPanel2);

        add(centerPanel, java.awt.BorderLayout.CENTER);

        deleteThresholdButton.setText("Delete this threshold");
        deleteThresholdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteThresholdButtonActionPerformed(evt);
            }
        });
        southPanel.add(deleteThresholdButton);

        add(southPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void upListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_upListValueChanged
        if (upList.getSelectedValue() == null) return;
        threshold.setUpCommand((Command)upList.getSelectedValue());
    }//GEN-LAST:event_upListValueChanged

    private void downListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_downListValueChanged
        if (downList.getSelectedValue() == null) return;
        threshold.setDownCommand((Command)downList.getSelectedValue());
    }//GEN-LAST:event_downListValueChanged

    private void deleteThresholdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteThresholdButtonActionPerformed
        //TODO: Ask user which range to use?
        //JOptionPane.showConfirmDialog(this, "Do you really want to delete this threshold?\n\rThe block to the right will be removed");
        parent.deleteThreshold(threshold);
    }//GEN-LAST:event_deleteThresholdButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton deleteThresholdButton;
    private javax.swing.JList downList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel southPanel;
    private javax.swing.JList upList;
    // End of variables declaration//GEN-END:variables
}
