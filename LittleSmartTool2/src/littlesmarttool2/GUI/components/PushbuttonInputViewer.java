/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.GUI.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Rasmus
 */
public class PushbuttonInputViewer extends javax.swing.JPanel {

    private boolean value = true;
    
    public void setValue(boolean pressed)
    {
        this.value = pressed;
    }
    
    /**
     * Creates new form PushbuttonInputViewer
     */
    public PushbuttonInputViewer() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        //Pressed
        if (value)
        {
            g2.setColor(Color.green);
            g2.fillOval(0,0, getWidth(), getHeight());
        }
        //Border & lines
        g2.setColor(Color.black);
        g2.fillOval(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2);
        g2.drawOval(0,0, getWidth()-1, getHeight()-1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}