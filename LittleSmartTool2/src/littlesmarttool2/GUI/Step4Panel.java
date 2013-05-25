/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.GUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import littlesmarttool2.model.ModelUtil;

/**
 *
 * @author marcher89
 */
public class Step4Panel extends StepPanel {

    /**
     * Creates new form Step1Panel
     */
    public Step4Panel(SS2Wizard wizard) {
        super(wizard);
        initComponents();
    }
    
    @Override
    public void onDisplay() {
        wizard.setNextEnabled(false);
        //TODO: Do anything??
    }

    @Override
    public void onHide() {
        //TODO: Do anything??
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uplaodButton = new javax.swing.JButton();

        setName("Test and upload"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        uplaodButton.setText("Upload configuration to StratoSnapper");
        uplaodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uplaodButtonActionPerformed(evt);
            }
        });
        add(uplaodButton, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void uplaodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uplaodButtonActionPerformed
        try {
            ModelUtil.SendConfigurationToSnapper(wizard.getConfiguration(), wizard.getSerialController());
        } catch (IOException ex) {//TODO: Do something smarter
            JOptionPane.showMessageDialog(this, ex, "Something went terribly wrong!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Everything was good", "Goooood", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_uplaodButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton uplaodButton;
    // End of variables declaration//GEN-END:variables
}
