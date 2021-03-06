/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoftp;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import static proyectoftp.cargar.ftp;

/**
 *
 * @author MiguelSC
 */
public class Presentacion extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    cargar hilo;
    int cont = 1;
   

    static final String servidor = "www.peru-software.com";
    static final int puerto = 21;
    static final String usuario = "pp20172@peru-software.com";
    static final String password = "fisi20172";

    static FTPClient ftp = new FTPClient();

    public Presentacion() {
        initComponents();
        setLocationRelativeTo(null);
        listarArchivos(textArea);
        //hilo = new cargar(progreso,textArea);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void listarArchivos(JTextArea txt) {
        try {
            ftp.connect(servidor, puerto);
            ftp.login(usuario, password);
            ftp.enterLocalPassiveMode();

            // Esencial para mostrar el tamaño original de descarga
            ftp.setFileType(ftp.BINARY_FILE_TYPE);

            // lists files and directories in the current working directory
            FTPFile[] files = ftp.listFiles();
            // iterates over the files and prints details for each
            DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int tamano;
            int tamTotal = 0;
            int tamAcumulado = 0;

            for (FTPFile file : files) {

                //if (file.getName().equals("so01.pptx")) { //captura y muestra datos de un archivo especifico
                String details = file.getName();
                if (file.isDirectory()) {
                    tamano = (int) file.getSize();
                    details = "[" + details + "]";
                }
                tamTotal = (int) file.getSize();
                details += "\t\t" + file.getSize();
                details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
                if (cont > 2) {
                    txt.append(details);
                    txt.append(System.getProperty("line.separator")); // Esto para el salto de línea     
                }
                //System.out.println(details);
                //}
                cont++;
            }

        } catch (IOException ex) {
            Logger.getLogger(cargar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.logout();
                    ftp.disconnect();
                } catch (IOException ex) {
                    Logger.getLogger(cargar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        progreso = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoftp/descarga.png"))); // NOI18N

        progreso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                progresoStateChanged(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descargue los archivos :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Descargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(76, 76, 76)
                        .addComponent(jButton1)
                        .addGap(180, 180, 180)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addComponent(progreso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void progresoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_progresoStateChanged
        if (progreso.getValue() == 100) {
            //dispose();
            //File file = new File("C:\\Users\\GRLIMA\\Documents\\NetBeansProjects\\ProyectoFTP\\introduccion.pptx");
            //File file = new File("C:\\Users\\Joselyn CCanto\\Desktop\\VII-CICLO\\Programación paralela\\Laboratorios\\Labo 3\\introduccion.pptx");
            /*if (Desktop.isDesktopSupported()) {
                Desktop desktop = null;
                desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(Presentacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
        }
    }//GEN-LAST:event_progresoStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            hilo = new cargar(progreso, "so01.pptx");
            hilo.start();
            hilo = null;
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progreso;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
