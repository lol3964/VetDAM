/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

/**
 *
 * @author Enrique Moya García
 */
public class DialogModificarMascota extends javax.swing.JDialog {

    /**
     * Creates new form DialogModificarMascota
     */
    public DialogModificarMascota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        dialogModificarMascota = new javax.swing.JPanel();
        txtDialogModAnimalId = new javax.swing.JTextField();
        txtDialogModAnimalNombre = new javax.swing.JTextField();
        btnAdminDarCitaAceptar2 = new javax.swing.JButton();
        btnAdminDarCitaCancelar2 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        spinnerDialogModAnimalPeso = new javax.swing.JSpinner();
        txtDialogModAnimalDueño = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dialogModificarMascota.setBackground(new java.awt.Color(255, 204, 204));

        txtDialogModAnimalId.setEditable(false);
        txtDialogModAnimalId.setBackground(dialogModificarMascota.getBackground());
        txtDialogModAnimalId.setText("ID");
        txtDialogModAnimalId.setBorder(null);
        txtDialogModAnimalId.setFocusable(false);
        txtDialogModAnimalId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDialogModAnimalIdActionPerformed(evt);
            }
        });

        txtDialogModAnimalNombre.setBackground(dialogModificarMascota.getBackground());
        txtDialogModAnimalNombre.setText("Nombre");
        txtDialogModAnimalNombre.setBorder(null);

        btnAdminDarCitaAceptar2.setText("Aceptar");

        btnAdminDarCitaCancelar2.setText("Cancelar");

        jLabel20.setText("Peso");

        spinnerDialogModAnimalPeso.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(1.0f), null, Float.valueOf(1.0f)));

        txtDialogModAnimalDueño.setBackground(dialogModificarMascota.getBackground());
        txtDialogModAnimalDueño.setText("Dueño");
        txtDialogModAnimalDueño.setBorder(null);

        javax.swing.GroupLayout dialogModificarMascotaLayout = new javax.swing.GroupLayout(dialogModificarMascota);
        dialogModificarMascota.setLayout(dialogModificarMascotaLayout);
        dialogModificarMascotaLayout.setHorizontalGroup(
            dialogModificarMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogModificarMascotaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogModificarMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator15)
                    .addGroup(dialogModificarMascotaLayout.createSequentialGroup()
                        .addGroup(dialogModificarMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogModificarMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(dialogModificarMascotaLayout.createSequentialGroup()
                                    .addComponent(btnAdminDarCitaAceptar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                    .addComponent(btnAdminDarCitaCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator10)
                                .addComponent(txtDialogModAnimalId)
                                .addComponent(jSeparator11)
                                .addComponent(txtDialogModAnimalNombre)
                                .addComponent(spinnerDialogModAnimalPeso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(txtDialogModAnimalDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogModificarMascotaLayout.setVerticalGroup(
            dialogModificarMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogModificarMascotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDialogModAnimalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDialogModAnimalNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerDialogModAnimalPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(txtDialogModAnimalDueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dialogModificarMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdminDarCitaAceptar2)
                    .addComponent(btnAdminDarCitaCancelar2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dialogModificarMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dialogModificarMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDialogModAnimalIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDialogModAnimalIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDialogModAnimalIdActionPerformed

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
            java.util.logging.Logger.getLogger(DialogModificarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogModificarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogModificarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogModificarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogModificarMascota dialog = new DialogModificarMascota(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminDarCitaAceptar2;
    private javax.swing.JButton btnAdminDarCitaCancelar2;
    private javax.swing.JPanel dialogModificarMascota;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSpinner spinnerDialogModAnimalPeso;
    private javax.swing.JTextField txtDialogModAnimalDueño;
    private javax.swing.JTextField txtDialogModAnimalId;
    private javax.swing.JTextField txtDialogModAnimalNombre;
    // End of variables declaration//GEN-END:variables
}
