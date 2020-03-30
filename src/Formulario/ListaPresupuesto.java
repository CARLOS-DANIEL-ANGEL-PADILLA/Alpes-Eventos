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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TAMY-IA
 */
public class ListaPresupuesto extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    /**
     * Creates new form ListaPresupuesto
     */
    public ListaPresupuesto() {
        initComponents();
        Cargar("");
    }
    
    void Cargar(String valor){
        try{
            String[] titulos={"Folio","Nombre","Categoria","Nota","Cantidad Estimada"};
            String[] registros=new String[5];
            model=new DefaultTableModel(null, titulos);
            String cons="SELECT * FROM presupuesto WHERE CONCAT (`idPresupuesto`, `nombre`, `categoria`, `nota`, `estimada`, `folio`) LIKE '%"+valor+"%'";
            
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(cons);
            
            while(rs.next()){
                registros[0]=rs.getString(6);
                registros[1]=rs.getString(2);
                registros[2]=rs.getString(3);
                registros[3]=rs.getString(4);
                registros[4]=rs.getString(5);
                
                model.addRow(registros);
                
            }
            
            tbListaPresupuesto.setModel(model);
            
        }catch(Exception e){
            System.out.println("Error al cargar la lista\n"+e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaPresupuesto = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setClosable(true);
        setTitle("Lista De Presupuestos");

        tbListaPresupuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Categoria", "Nota", "Cantidad Estimada"
            }
        ));
        jScrollPane1.setViewportView(tbListaPresupuesto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar:");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVer)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        Cargar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int filase1= tbListaPresupuesto.getSelectedRow();
        int confirmar=JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
        
        if(confirmar==JOptionPane.YES_OPTION){
            try{
            if(filase1==-1){
                JOptionPane.showMessageDialog(null, "Seleccione el producto a eliminar");
            }else{
                String cod=(String)tbListaPresupuesto.getValueAt(filase1, 0);
                String eliminarSQL="DELETE FROM Presupuesto WHERE folio='"+cod+"'";
                try{
                    PreparedStatement pst = cn.prepareStatement(eliminarSQL);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Producto Eliminado");
                    Cargar("");
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            
        }catch(Exception e){
            
        }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        int fila = tbListaPresupuesto.getSelectedRow();
	
        try {

            String nombre="",categoria="",nota="",estimada="",folio="";

           if(fila==-1){
               JOptionPane.showMessageDialog(null, "No ha seleccionado ningun presupuesto");
           }else{
               
               Presupuesto pp=new Presupuesto();
               Principal.jdpEscritorio.add(pp);
               pp.setVisible(true);
        
                folio=(String)tbListaPresupuesto.getValueAt(fila, 0).toString();
                nombre =  (String)tbListaPresupuesto.getValueAt(fila, 1).toString();
                categoria =  (String)tbListaPresupuesto.getValueAt(fila, 2).toString();
                nota =  (String)tbListaPresupuesto.getValueAt(fila, 3).toString();
                estimada =  (String)tbListaPresupuesto.getValueAt(fila, 4).toString();

                Presupuesto.jlFolio.setText(folio);
                Presupuesto.txtNombre.setText(nombre);
                Presupuesto.jcbCategoria.setSelectedItem(categoria);
                Presupuesto.txtNota.setText(nota);
                Presupuesto.txtCantidad.setText(estimada);
                Presupuesto.jlEquilibrar.setText(estimada);
                pp.Cargar(folio);
            
            this.dispose();

           }
       }catch (Exception e) {
           System.out.println("Error aol enviar datos\n"+e);
       }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        Presupuesto ps=new Presupuesto();
        Principal.jdpEscritorio.add(ps);
        ps.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListaPresupuesto;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
}