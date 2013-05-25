/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.GUI.components;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import littlesmarttool2.GUI.components.ChannelSettingViewer.BlockPressedListener;
import littlesmarttool2.GUI.components.ChannelSettingViewer.ThresholdPressedListener;
import littlesmarttool2.model.Block;
import littlesmarttool2.model.Channel;
import littlesmarttool2.model.Configuration;
import littlesmarttool2.model.Threshold;

/**
 *
 * @author Rasmus
 */
public class ChannelTabPanel extends javax.swing.JPanel implements ThresholdPressedListener, BlockPressedListener {
    private Channel channel;
    private Configuration config;
    /**
     * Creates new form ChannelTabPanel
     */
    public ChannelTabPanel(Configuration config) {
        initComponents();
        this.config = config;
        channelSettingViewer1.addBlockPressedListener(this);
        channelSettingViewer1.addThresholdPressedListener(this);
    }
    
    void deleteThreshold(Threshold threshold)
    {
        channel.getSetting().removeThreshold(threshold);
        setChannel(channel); //Update
        configPanel.removeAll();
        configPanel.add(new JPanel(),BorderLayout.CENTER);
        configPanel.revalidate();
    }
    
    public void updateChannelReading(int value)
    {
        channelSettingViewer1.updateValue(value);
        channelSettingViewer1.updateBounds(channel.getCalibLow(), channel.getCalibHigh());
    }
    
    public void setChannel(Channel channel)
    {
        this.channel = channel;
        channelSettingViewer1.updateBounds(channel.getCalibLow(), channel.getCalibHigh());
        channelSettingViewer1.setBlockList(channel.getSetting().getBlocks());
        channelSettingViewer1.setThresholdlist(channel.getSetting().getThresholds());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        channelSettingViewer1 = new littlesmarttool2.GUI.components.ChannelSettingViewer();
        configPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setText("Click on a block or a threshold below to configure");
        jPanel3.add(jLabel1);

        jButton1.setText("Add threshold");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout channelSettingViewer1Layout = new javax.swing.GroupLayout(channelSettingViewer1);
        channelSettingViewer1.setLayout(channelSettingViewer1Layout);
        channelSettingViewer1Layout.setHorizontalGroup(
            channelSettingViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        channelSettingViewer1Layout.setVerticalGroup(
            channelSettingViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(channelSettingViewer1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        configPanel.setLayout(new java.awt.BorderLayout());
        add(configPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        channel.getSetting().addSection();
        channelSettingViewer1.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private littlesmarttool2.GUI.components.ChannelSettingViewer channelSettingViewer1;
    private javax.swing.JPanel configPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void thresholdPressed(Threshold threshold) {
        configPanel.removeAll();
        ThresholdConfigPanel panel = new ThresholdConfigPanel(config, threshold, this);
        configPanel.add(panel, BorderLayout.CENTER);
        configPanel.revalidate();
    }

    @Override
    public void blockPressed(Block block) {
        configPanel.removeAll();
        BlockConfigPanel panel = new BlockConfigPanel(config, block);
        configPanel.add(panel, BorderLayout.CENTER);
        configPanel.revalidate();
    }
}