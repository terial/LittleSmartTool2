/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.GUI.components;

import javax.swing.*;

/**
 *
 * @author marcher89
 */
public class ListWithHeadline extends javax.swing.JPanel {

    /**
     * Creates new form ListWithHeadline
     */
    public ListWithHeadline() {
        initComponents();
    }
    
    public void setElements(Object[] elements) {
        DefaultListModel model = new DefaultListModel();
        for (Object cameraBrand : elements) {
            model.addElement(cameraBrand);
        }
        list.setModel(model);
    }
    
    public Object getSelectedElement() {
        return list.getModel().getElementAt(list.getSelectedIndex());
    }
    
    public void setHeadLine(String text){
        headline.setText(text);
    }
    
    public JList getList(){
        return list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headline = new javax.swing.JLabel();
        list = new javax.swing.JList();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        setLayout(new java.awt.BorderLayout());

        headline.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        headline.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        headline.setLabelFor(list);
        headline.setText("jLabel1");
        headline.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        headline.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 5, 0));
        headline.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(headline, java.awt.BorderLayout.NORTH);

        list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        add(list, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headline;
    private javax.swing.JList list;
    // End of variables declaration//GEN-END:variables
}
