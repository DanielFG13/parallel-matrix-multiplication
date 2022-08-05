import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main extends javax.swing.JFrame {

    private Matrix a;
    private Matrix b;
    
    public Main() {
        initComponents();
        btnSecuencial.setEnabled(false);
        btnConcurrente.setEnabled(false);
        btnParalelo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        aFilas = new javax.swing.JTextField();
        aColumnas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bFilas = new javax.swing.JTextField();
        bColumnas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tiempoS = new javax.swing.JLabel();
        tiempoC = new javax.swing.JLabel();
        btnSecuencial = new javax.swing.JButton();
        btnConcurrente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        btnEstablecer = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tiempoP = new javax.swing.JLabel();
        btnParalelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("MATRIZ A");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("MATRIZ B");

        jLabel3.setText("Filas:");

        jLabel4.setText("Columnas:");

        jLabel5.setText("Filas:");

        jLabel6.setText("Columnas:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("TIEMPOS DE EJECUCION");

        jLabel9.setText("Tiempo secuencial (segundos)");

        jLabel10.setText("Tiempo concurrente (segundos)");

        tiempoS.setText("0");

        tiempoC.setText("0");

        btnSecuencial.setText("Iniciar secuencial");
        btnSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuencialActionPerformed(evt);
            }
        });

        btnConcurrente.setText("Iniciar concurrente");
        btnConcurrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcurrenteActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jLabel13.setText("LOG");

        btnEstablecer.setText("ESTABLECER");
        btnEstablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstablecerActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel11.setText("Tiempo paralelo (segundos)");

        tiempoP.setText("0");

        btnParalelo.setText("Iniciar Paralelo");
        btnParalelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaleloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tiempoS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(btnSecuencial))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(btnConcurrente)))))
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnParalelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEstablecer)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(425, 425, 425)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(386, 386, 386)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tiempoC, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(236, 236, 236)
                                .addComponent(tiempoP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(aFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(298, 298, 298))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel1)
                                        .addGap(346, 346, 346))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(aColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bFilas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bColumnas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2))))
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnEstablecer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(aFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(aColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(bColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempoC)
                    .addComponent(tiempoS)
                    .addComponent(tiempoP))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcurrente)
                    .addComponent(btnSecuencial)
                    .addComponent(btnParalelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuencialActionPerformed
        MatrixMulSequential mulSequential = new MatrixMulSequential();
        long start = System.currentTimeMillis();
        Matrix resultSequential = mulSequential.multiply(a, b);
        long end = System.currentTimeMillis();
        //resultSequential.printMatrix("Result Sequential");
        tiempoS.setText(String.valueOf(((double)(end - start) / 1000)));
    }//GEN-LAST:event_btnSecuencialActionPerformed

    private void btnConcurrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcurrenteActionPerformed
        MatrixMulForkJoinConcurrente mulConcurrent = new MatrixMulForkJoinConcurrente();
        long start = System.currentTimeMillis();
        Matrix resultConcurrent = mulConcurrent.multiply(a, b);
        long end = System.currentTimeMillis();
        //resultConcurrent.printMatrix("Result Concurrent");
        tiempoC.setText(String.valueOf(((double)(end - start) / 1000)));
    }//GEN-LAST:event_btnConcurrenteActionPerformed

    private void btnEstablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstablecerActionPerformed
        int aFilasInt = Integer.parseInt(this.aFilas.getText());
        int aColumnasInt = Integer.parseInt(this.aColumnas.getText());
        int bFilasInt = Integer.parseInt(this.bFilas.getText());
        int bColumnasInt = Integer.parseInt(this.bColumnas.getText());
        if(aColumnasInt != bFilasInt) {
            textArea.setText("No se puede realizar multiplicacion");
            btnSecuencial.setEnabled(false);
            btnConcurrente.setEnabled(false);
            return;
        }
        btnSecuencial.setEnabled(true);
        btnConcurrente.setEnabled(true);
        btnParalelo.setEnabled(true);
        a = new Matrix(aFilasInt, aColumnasInt);
        b = new Matrix(bFilasInt, bColumnasInt);
        a.setRandomValues();
        b.setRandomValues();
        //a.printMatrix("MATRIX A");
        //b.printMatrix("MATRIX B");
        textArea.setText("");
    }//GEN-LAST:event_btnEstablecerActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        aFilas.setText("");
        bFilas.setText("");
        aColumnas.setText("");
        bColumnas.setText("");
        tiempoC.setText("0");
        tiempoS.setText("0");
        tiempoP.setText("0");
        textArea.setText("");
        btnSecuencial.setEnabled(false);
        btnConcurrente.setEnabled(false);
        btnParalelo.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnParaleloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaleloActionPerformed

        int[][] c;
        String host = "192.168.3.3";
        int port = 2081;
        
        generateFile(a.array, a.getNumOfRows(), "A.txt");
        generateFile(b.array, a.getNumOfRows(), "B.txt");
        System.out.println("Matriz A.txt y B.txt han sido generados");
 
         try {
            Registry r = LocateRegistry.getRegistry(host, port);
            Operation operation = (Operation) r.lookup("operation");
            textArea.setText(">>>Calculando matriz C...");
            long start = System.currentTimeMillis();
            c = operation.mul(a.array, b.array);
            long end =  System.currentTimeMillis();
            tiempoP.setText(String.valueOf(((double)(end - start) / 1000)));
            System.out.println("Creando resultado en C.txt...");
            generateFile(c, c.length, "C.txt");
            System.out.println("Matrix C.txt fue generado\n");
        } catch (RemoteException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (NotBoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }//GEN-LAST:event_btnParaleloActionPerformed

    public static void generateFile(int[][] array, int size, String fileName) {
        PrintStream output = null;
        try {
            output = new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    output.print(array[i][j]);
                    if (j != size - 1) output.print(" ");
                }
                if (i != size - 1) output.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al escribir archivos.");
            e.printStackTrace();
        } finally {
            if (output != null) output.close();
        }
    }
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aColumnas;
    private javax.swing.JTextField aFilas;
    private javax.swing.JTextField bColumnas;
    private javax.swing.JTextField bFilas;
    private javax.swing.JButton btnConcurrente;
    private javax.swing.JButton btnEstablecer;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnParalelo;
    private javax.swing.JButton btnSecuencial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel tiempoC;
    private javax.swing.JLabel tiempoP;
    private javax.swing.JLabel tiempoS;
    // End of variables declaration//GEN-END:variables
}
