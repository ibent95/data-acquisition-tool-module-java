/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.data.acquisition.progressBar;

import javax.swing.WindowConstants;

/**
 *
 * @author ibent95
 */
public class ProgressBarFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProgressBarFrame
     */
    public ProgressBarFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBarPanel = new javax.swing.JPanel();
        jProgressBarCommand = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ProgressBarFrame.class, "ProgressBarFrame.title")); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(319, 30));
        setType(java.awt.Window.Type.POPUP);

        jProgressBarPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jProgressBarCommand.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jProgressBarCommand.setDoubleBuffered(true);
        jProgressBarCommand.setFocusCycleRoot(true);
        jProgressBarCommand.setFocusTraversalPolicyProvider(true);
        jProgressBarCommand.setIndeterminate(true);
        jProgressBarCommand.setInheritsPopupMenu(true);
        jProgressBarCommand.setOpaque(true);
        jProgressBarCommand.setString(org.openide.util.NbBundle.getMessage(ProgressBarFrame.class, "ProgressBarFrame.jProgressBarCommand.string")); // NOI18N
        jProgressBarCommand.setStringPainted(true);

        javax.swing.GroupLayout jProgressBarPanelLayout = new javax.swing.GroupLayout(jProgressBarPanel);
        jProgressBarPanel.setLayout(jProgressBarPanelLayout);
        jProgressBarPanelLayout.setHorizontalGroup(
            jProgressBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jProgressBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBarCommand, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );
        jProgressBarPanelLayout.setVerticalGroup(
            jProgressBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jProgressBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBarCommand, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jProgressBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ProgressBarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgressBarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgressBarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgressBarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProgressBarFrame frame = new ProgressBarFrame();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBarCommand;
    public javax.swing.JPanel jProgressBarPanel;
    // End of variables declaration//GEN-END:variables
}