/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zipdiu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Sara
 */
public class ZipThread extends SwingWorker<Void, Void>{
    
    private String path;
    private List<String> files;
    private int BUFFER_SIZE = 1024;
    private JProgressBar bar;
    private JFrame root;
    private ZipOutputStream out;
    private BufferedInputStream origin;
    private JLabel lab;
    
    public ZipThread(String path, List<String> files, JProgressBar bar, JFrame root, JLabel lab){
        this.path = path;
        this.files = files;
        this.bar = bar;
        this.bar.setMaximum(files.size());
        this.root = root;
        this.lab = lab;
        this.lab.setText("0/"+this.files.size());
    }
    
    @Override
        protected Void doInBackground() throws Exception {
            try{
                // Objeto para referenciar el archivo zip de salida
                FileOutputStream dest = new FileOutputStream(path);
                out = new ZipOutputStream(new BufferedOutputStream(dest));
                // Buffer de transferencia para almacenar datos a comprimir
                byte[] data = new byte[BUFFER_SIZE];
                for (String filename : files) {
                    File toZip = new File(filename);
                    FileInputStream fi = new FileInputStream(toZip);
                    origin = new BufferedInputStream(fi, BUFFER_SIZE);
                    ZipEntry entry = new ZipEntry( toZip.getName() );
                    out.putNextEntry( entry );
                    // Leemos datos desde el archivo origen y se envían al archivo destino
                    int count;
                    while((count = origin.read(data, 0, BUFFER_SIZE)) != -1){
                        out.write(data, 0, count);
                    }
                    bar.setValue(bar.getValue() + 1);
                    lab.setText(bar.getValue() +"/" +files.size());
                    // Cerramos el archivo origen, ya enviado a comprimir
                    origin.close();
                }
            // Cerramos el archivo zip
            }catch( IOException e ){
                e.getMessage();
            }
            return null;
        }
        
        @Override
        protected void done(){
        try {
            if(this.isCancelled()){origin.close();}
            out.close();
        } catch (IOException ex) {ex.getMessage();}
            if(this.isCancelled()){
                JOptionPane.showMessageDialog(root, "Compresión cancelada");
                new File(path).delete();
            }else{
                JOptionPane.showMessageDialog(root, "Compresión realizada");
            }
            root.dispose();
        }
}
