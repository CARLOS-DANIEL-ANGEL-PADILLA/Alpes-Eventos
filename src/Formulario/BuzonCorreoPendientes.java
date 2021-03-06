/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conectar.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author TAMY
 */
public class BuzonCorreoPendientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuzonCorreoPendientes
     */
    public BuzonCorreoPendientes() {
        initComponents();
        CorreosLeidos();
        CorreosNoleidos();
        this.setLocation(440, 100);
        //jlSinleer.setVisible(false);
    }
    
    void CorreosLeidos(){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        jlYaleidos.setVisible(true);
        try{
            String lista="SELECT * FROM `buzon` WHERE `leido`='1'";
            String [] leidos= new String[1];
            Vector vector=new Vector();
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(lista);
            
            while(rs.next()==true){
                //contactos[0]=rs.getString(2)+"\n "+rs.getString(3)+" "+rs.getString(5)+" "+rs.getString(6);     //si se quiere obneter nombres completos de usuarios
                leidos[0]="<html>"+" "+rs.getString(1)+" "+"<-"+rs.getString(2)+" --- "+rs.getString(5)+"<br>"+rs.getString(3)+" "+rs.getString(6)+"<html>";
                vector.addElement(leidos[0]);
                jlLeidos.setListData(vector);
            }//No tiene ningun correo leido
            
            if(leidos[0]==null){
                jlYaleidos.setEnabled(false);
                jlYaleidos.setVisible(true);
                jlYaleidos.setText("No tiene ningun correo leido");
            }
            
            cc.CerrarConexion();
            
        }catch(Exception ex){
            System.out.println("Error al cargar leidos\n"+ex);
        }
        
    }
    
    void CorreosNoleidos(){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        jlSinleer.setVisible(false);
        try{
            String lista="SELECT * FROM `buzon` WHERE `leido`='0'";
            String [] Noleido= new String[1];
            Vector vector1=new Vector();
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(lista);
            
            while(rs.next()==true){
                //contactos[0]=rs.getString(2)+"\n "+rs.getString(3)+" "+rs.getString(5)+" "+rs.getString(6);     //si se quiere obneter nombres completos de usuarios
                Noleido[0]="<html>"+" "+rs.getString(1)+" "+"<-"+rs.getString(2)+" --- "+rs.getString(5)+"<br>"+rs.getString(3)+" "+rs.getString(6)+"<html>";
                vector1.addElement(Noleido[0]);
                jlNoleidos.setListData(vector1);
            }
            
            if(Noleido[0]==null){
                jlSinleer.setEnabled(false);
                jlSinleer.setVisible(true);
                jlSinleer.setText("No tiene ningun correo sin leer");
            }
                        
            cc.CerrarConexion();
            
        }catch(Exception ex){
            System.out.println("Error al cargar leidos\n"+ex);
        }
    }
    
    void MarcarLeido(String id){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        //UPDATE `buzon` SET `leido` = '1' WHERE `buzon`.`id` = 2;
        String marcar="UPDATE `buzon` SET `leido` = '1' WHERE `buzon`.`id` ="+id+"";
        
        try{
            PreparedStatement pst=cn.prepareStatement(marcar);
            pst.executeUpdate();
            this.dispose();
        }catch(Exception e){
            System.out.println("error al actualizar clase nuevatarea\n"+e);
        }
        cc.CerrarConexion();
    }
    
    void AlgoritmoSintactico(String Elemento){
        try{
            String datos = Elemento;//scanner.nextLine();
            String palabra = datos.split(" ")[1].trim();
            Correo cro=new Correo();
            Principal.jdpEscritorio.add(cro);
            cro.setVisible(true);
            cro.Correo(palabra);//se llama el metodo de la clase y se le envia el id contenida en palabra
            MarcarLeido(palabra);//se marca como leido
            this.dispose();
            
        }catch(Exception e){
            System.out.println(""+e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jlSinleer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlNoleidos = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jlYaleidos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlLeidos = new javax.swing.JList<>();

        setClosable(true);
        setTitle("Buzon De Correos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mini_ALPES logo(1).png"))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jlSinleer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 170, 20));

        jlNoleidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlNoleidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlNoleidos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 377, 280));

        jTabbedPane1.addTab("No Leidos", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jlYaleidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 170, 20));

        jlLeidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlLeidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jlLeidos);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 377, 280));

        jTabbedPane1.addTab("Leidos", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlNoleidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlNoleidosMouseClicked
        // TODO add your handling code here:
        AlgoritmoSintactico(jlNoleidos.getSelectedValue());
    }//GEN-LAST:event_jlNoleidosMouseClicked

    private void jlLeidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLeidosMouseClicked
        // TODO add your handling code here:
        AlgoritmoSintactico(jlLeidos.getSelectedValue());
    }//GEN-LAST:event_jlLeidosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> jlLeidos;
    private javax.swing.JList<String> jlNoleidos;
    private javax.swing.JLabel jlSinleer;
    private javax.swing.JLabel jlYaleidos;
    // End of variables declaration//GEN-END:variables
}
