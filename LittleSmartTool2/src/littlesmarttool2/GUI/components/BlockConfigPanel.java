/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.GUI.components;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import littlesmarttool2.model.Block;
import littlesmarttool2.model.Command;
import littlesmarttool2.model.Configuration;

/**
 *
 * @author Rasmus
 */
public class BlockConfigPanel extends javax.swing.JPanel {

    DefaultListModel listModel = new DefaultListModel();
    Block block;
    /**
     * Creates new form RangeConfigPanel
     */
    public BlockConfigPanel(Configuration config, Block block) {
        initComponents();
        populate(config);
        this.block = block;
        jList1.setSelectedValue(block.getCommand(), true);
        jSlider1.setValue(block.getInterval()/100); //Stored as ms
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
    private ListModel getListModel() 
    {
        return listModel;
    }
    public Command getSelectedCommand()
    {
        return (Command)jList1.getSelectedValue();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        repetitionsLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Select an action to be performed while this block is active");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jList1.setModel(getListModel());
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSlider1.setPaintTicks(true);
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel3.setText("Select how often to repeat the action while the block is active");

        jLabel4.setText("Repetition: ");

        repetitionsLabel.setText("just once");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repetitionsLabel))
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(repetitionsLabel))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if (jList1.getSelectedValue() == null) return;
        block.setCommand((Command)jList1.getSelectedValue());
    }//GEN-LAST:event_jList1ValueChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        block.setInterval(jSlider1.getValue()*100); //Store as ms
        if (jSlider1.getValue() == 0)
            repetitionsLabel.setText("just once");
        else if (jSlider1.getValue() < 10)
            repetitionsLabel.setText("every " + jSlider1.getValue() + "00 ms");
        else
            repetitionsLabel.setText(String.format("every %.1f seconds", (jSlider1.getValue()/10.0)));
    }//GEN-LAST:event_jSlider1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel repetitionsLabel;
    // End of variables declaration//GEN-END:variables
}
