/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.GUI;

import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import littlesmarttool2.comm.*;
import littlesmarttool2.model.ModelUtil;

/**
 *
 * @author marcher89
 */
public class Step4Panel extends StepPanel implements ResponseListener, ConnectionListener {

    /**
     * Creates new form Step1Panel
     */
    public Step4Panel(SS2Wizard wizard) {
        super(wizard);
        initComponents();
    }
    
    @Override
    public void onDisplay() {
        //wizard.setNextEnabled(false);
        
        channelTester1.setChannel(wizard.getConfiguration().getChannels().get(0));
        channelTester2.setChannel(wizard.getConfiguration().getChannels().get(1));
        channelTester3.setChannel(wizard.getConfiguration().getChannels().get(2));
        channelTester4.setChannel(wizard.getConfiguration().getChannels().get(3));
        
        wizard.getSerialController().addConnectionListener(this);
        
        updateUploadLabel();
        
        wizard.setHasUploaded(false);
    }

    @Override
    public void onHide() {
        wizard.getSerialController().removeConnectionListener(this);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testerPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        descriptionLabel = new javax.swing.JLabel();
        channelTester1 = new littlesmarttool2.GUI.components.ChannelTester();
        channelTester2 = new littlesmarttool2.GUI.components.ChannelTester();
        channelTester3 = new littlesmarttool2.GUI.components.ChannelTester();
        channelTester4 = new littlesmarttool2.GUI.components.ChannelTester();
        jPanel1 = new javax.swing.JPanel();
        uploadLabel = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();

        setName("Test and upload"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        testerPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        infoPanel.setLayout(new javax.swing.BoxLayout(infoPanel, javax.swing.BoxLayout.LINE_AXIS));

        descriptionLabel.setText("<html>Test your configuration by using the controls on your transmitter.<br/>\nBelow is shown an overview of the 4 channels with the output from each channel shown to the right<br/>\nUse your transmitter to verify that the correct commands are send at the right times.<br>\nPress the \"Upload configuration to StratoSnapper\" button when ready</html>");
        infoPanel.add(descriptionLabel);

        testerPanel.add(infoPanel);
        testerPanel.add(channelTester1);
        testerPanel.add(channelTester2);
        testerPanel.add(channelTester3);
        testerPanel.add(channelTester4);

        add(testerPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        uploadLabel.setText("Ready for upload");
        jPanel1.add(uploadLabel);

        uploadButton.setText("Upload configuration to StratoSnapper");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        jPanel1.add(uploadButton);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        
        uploadLabel.setText("Now uploading, please wait...");
        uploadButton.setEnabled(false);
        uploadLabel.setForeground(Color.BLACK);
        repaint();
        
        Thread t = new Thread(new SSProgrammerRunnable(this));
        t.start();
        
        /*try {
            wizard.stopAutoServoPulling();
            ModelUtil.SendConfigurationToSnapper(wizard.getConfiguration(), wizard.getSerialController());
            wizard.startAutoServoPulling();
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(SS2Wizard.class.getName()).log(Level.SEVERE, null, ex); //Keep this!
            wizard.setHasUploaded(false);
            uploadLabel.setText("An error occurred, please try agian.");
            uploadLabel.setForeground(new Color(0x660000));
            JOptionPane.showMessageDialog(this, ex.getMessage(), "An error occurred!", JOptionPane.ERROR_MESSAGE);
            return;
        }*/
        
    }//GEN-LAST:event_uploadButtonActionPerformed

    private class SSProgrammerRunnable implements Runnable
    {
        Step4Panel panel;
        public SSProgrammerRunnable(Step4Panel panel)
        {
            this.panel = panel;
        }
        @Override
        public void run() {
            try {
                wizard.stopAutoServoPulling();
                ModelUtil.SendConfigurationToSnapper(wizard.getConfiguration(), wizard.getSerialController(), new ProgrammingUpdateListener(){
                    @Override
                    public void update(String message) {
                        uploadLabel.setText(message);
                    } 
                });
                wizard.startAutoServoPulling();
            } catch (IOException | TimeoutException ex) {
                Logger.getLogger(SS2Wizard.class.getName()).log(Level.SEVERE, null, ex); //Keep this!
                wizard.setHasUploaded(false);
                uploadLabel.setText("An error occurred, please try agian.");
                uploadLabel.setForeground(new Color(0x660000));
                JOptionPane.showMessageDialog(panel, ex.getMessage(), "An error occurred!", JOptionPane.ERROR_MESSAGE);
                uploadButton.setEnabled(true);
                return;
            }
            wizard.setHasUploaded(true);
            uploadLabel.setText("The configuration was successfully uploaded.");
            uploadLabel.setForeground(new Color(0x006600));
            uploadButton.setEnabled(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private littlesmarttool2.GUI.components.ChannelTester channelTester1;
    private littlesmarttool2.GUI.components.ChannelTester channelTester2;
    private littlesmarttool2.GUI.components.ChannelTester channelTester3;
    private littlesmarttool2.GUI.components.ChannelTester channelTester4;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel testerPanel;
    private javax.swing.JButton uploadButton;
    private javax.swing.JLabel uploadLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void receiveResponse(char command, String[] args) {
        if (command != 'S') return;
        if (args.length < 4) return;
        try
        {
            channelTester1.updateValue(Integer.parseInt(args[0]));
            channelTester2.updateValue(Integer.parseInt(args[1]));
            channelTester3.updateValue(Integer.parseInt(args[2]));
            channelTester4.updateValue(Integer.parseInt(args[3]));
        }
        catch (Exception e)
        {}
    }

    @Override
    public void connectionStateChanged(boolean connected) {
        updateUploadLabel();
    }
    
    private void updateUploadLabel(){
        if(wizard.getSerialController().connected()){
            uploadLabel.setText("Ready for upload.");
            uploadLabel.setForeground(Color.BLACK);
            uploadButton.setEnabled(true);
        }
        else{
            uploadLabel.setText("Please connect to the StratoSnapper2.");
            uploadButton.setEnabled(false);
            uploadLabel.setForeground(new Color(0x660000));
        }
    }
}
