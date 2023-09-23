/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package agenda.gui;

/**
 *
 * @author Manu
 */
public class mainGUI extends javax.swing.JFrame {

    /**
     * Creates new form mainGUI
     */
    public mainGUI() {
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

        DisplayType = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitSubmenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda PUCV");

        DisplayType.addTab("Calendar", jTabbedPane2);
        DisplayType.addTab("Book", jTabbedPane1);

        jMenu1.setText("File");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });

        exitSubmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exitSubmenu.setText("exit");
        exitSubmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitSubmenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitSubmenu);

        MenuBar.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("Añadir Reunión");
        jMenu2.add(jMenuItem1);

        MenuBar.add(jMenu2);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DisplayType, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DisplayType, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MenuSelected

    private void exitSubmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitSubmenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitSubmenuActionPerformed

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
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane DisplayType;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem exitSubmenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
