/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/visualPanel.java to edit this template
 */
package com.data.acquisition.wizard;

import com.data.acquisition.DataAcquisitionAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public final class DataAcquisitionVisualPanel1 extends JPanel {

    JFileChooser chooser;
    String chooserTitle = "Pilih sumber";

    private static JFrame jFrame;
    private static JPanel jPanel;
    private static JProgressBar jProgressBar;  

    /**
     * Creates new form DataAcquisitionVisualPanel1
     */
    public DataAcquisitionVisualPanel1() {
        initComponents();
//        this.initialProgressBar();
//        jFrame.setVisible(true);
    }
    
    private void initialProgressBar() {
        jFrame          = new JFrame(" Progress Bar ");
        jPanel          = new JPanel();
        jProgressBar    = new JProgressBar(0, 1);

        jProgressBar.setValue(0);
        jProgressBar.setIndeterminate(true);
        jPanel.setSize(300, 200);
        jPanel.add(jProgressBar);
        jFrame.add(jPanel);
        jFrame.setSize(300, 200);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setUndecorated(true);
    }

    @Override
    public String getName() {
        return "Step #1";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceChooserLbl = new javax.swing.JLabel();
        sourceChooserBtn = new javax.swing.JButton();
        sourceChooserTxt = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(sourceChooserLbl, org.openide.util.NbBundle.getMessage(DataAcquisitionVisualPanel1.class, "DataAcquisitionVisualPanel1.sourceChooserLbl.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(sourceChooserBtn, org.openide.util.NbBundle.getMessage(DataAcquisitionVisualPanel1.class, "DataAcquisitionVisualPanel1.sourceChooserBtn.text")); // NOI18N
        sourceChooserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceChooserBtnActionPerformed(evt);
            }
        });

        sourceChooserTxt.setText(org.openide.util.NbBundle.getMessage(DataAcquisitionVisualPanel1.class, "DataAcquisitionVisualPanel1.sourceChooserTxt.text")); // NOI18N
        sourceChooserTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceChooserTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(sourceChooserLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourceChooserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourceChooserBtn)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceChooserLbl)
                    .addComponent(sourceChooserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sourceChooserBtn))
                .addContainerGap(356, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sourceChooserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceChooserBtnActionPerformed
        chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(this.chooserTitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.sourceChooserTxt.setText(chooser.getSelectedFile().toString());
            
            DataAcquisitionVisualPanel4.setSourcePath(this.sourceChooserTxt.getText());
            DataAcquisitionAction.sourcePath = this.sourceChooserTxt.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Konfirmasi", "Lokasi sumber belum dipilih.", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // DataAcquisitionAction.jProgressBarFrame.setVisible(true);
    }//GEN-LAST:event_sourceChooserBtnActionPerformed

    private void sourceChooserTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceChooserTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceChooserTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton sourceChooserBtn;
    private javax.swing.JLabel sourceChooserLbl;
    private javax.swing.JTextField sourceChooserTxt;
    // End of variables declaration//GEN-END:variables
}
