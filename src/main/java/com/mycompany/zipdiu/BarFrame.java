/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zipdiu;

import java.util.List;

public class BarFrame extends javax.swing.JFrame {

    private ZipThread zip;
    
    public BarFrame(String path, List<String> files) {
        initComponents();
        bar.setStringPainted(true);
        zip = new ZipThread(path, files, bar, this, lab);
        zip.execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bar = new javax.swing.JProgressBar();
        cancelB = new javax.swing.JButton();
        lab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelB.setText("Cancel");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });

        lab.setText(" ");

        jLabel1.setText("Comprimiendo...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(cancelB))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(lab)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelB)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        // TODO add your handling code here:
        zip.cancel(true);
        this.dispose();
        
    }//GEN-LAST:event_cancelBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar;
    private javax.swing.JButton cancelB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lab;
    // End of variables declaration//GEN-END:variables
}