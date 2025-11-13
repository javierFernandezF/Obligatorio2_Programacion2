/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Dominio.Areas.Area;
import Dominio.Personas.Empleado;
import Sistema.Sistema;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class VentanaMovimientoArea extends javax.swing.JFrame implements Observer {
    private Sistema sistema;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaMovimientoArea.class.getName());

    
    public VentanaMovimientoArea(Sistema sistema) {
        this.sistema = sistema;
        this.sistema.addObserver((Observer) this);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArea = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaNuevaArea = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaMes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnCambiarEmpledoArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Empleado de Área");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Área");

        tablaArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Presupuesto anual", "Presupuesto disponible"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaArea);

        jLabel2.setText("Empleados");

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cedula", "Salario Mensual", "Área"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaEmpleados);

        tablaNuevaArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaNuevaArea);

        jLabel3.setText("Nueva Área");

        tablaMes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Mes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMes.setToolTipText("");
        jScrollPane4.setViewportView(tablaMes);

        jLabel4.setText("Mes de cambio");

        btnCambiarEmpledoArea.setText("Cambiar de Área");
        btnCambiarEmpledoArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEmpledoAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnCambiarEmpledoArea))
                    .addComponent(jLabel3))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnCambiarEmpledoArea)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarEmpledoAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEmpledoAreaActionPerformed
        
        int mesSeleccionado = tablaMes.getSelectedRow() + 1;
        int filaSeleccionadaEmpleado = tablaEmpleados.getSelectedRow();
        int filaSeleccionadaAreaNueva = tablaNuevaArea.getSelectedRow();
        
        
        int cedulaEmpleado = (Integer) tablaEmpleados.getValueAt(filaSeleccionadaEmpleado, 1);
        String nombreAreaNueva = (String) tablaNuevaArea.getValueAt(filaSeleccionadaAreaNueva, 0);

        Empleado empleadoSeleccionado = this.sistema.getListaPersonas().getEmpleadoPorCedula(cedulaEmpleado);
        Area areaNueva = this.sistema.getAreaPorNOmbre(nombreAreaNueva);
        
        System.out.println(empleadoSeleccionado.getCedula());
        System.out.println(areaNueva.getNombre());
        System.out.println(mesSeleccionado);
        
        if(filaSeleccionadaEmpleado != -1 && filaSeleccionadaAreaNueva != -1 && mesSeleccionado <= 12 && mesSeleccionado >= 0){
            if(this.sistema.validarPresupuestoArea(empleadoSeleccionado, areaNueva, mesSeleccionado)){
                
                this.sistema.cambiarEmpleadoDeArea(empleadoSeleccionado, areaNueva, mesSeleccionado);
                
                javax.swing.JOptionPane.showMessageDialog(this, "Empleado " + empleadoSeleccionado.getNombre() + " cambiado a área " + areaNueva.getNombre(), "info", javax.swing.JOptionPane.ERROR_MESSAGE);

            }else{
                javax.swing.JOptionPane.showMessageDialog(this, "Presupuesto insuficiente.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Falta seleccionar elementos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }
        
        tablaArea.clearSelection();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarEmpledoAreaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        actualizarAreas();
        cargarMeses();
        areasSinLaSeleccionada();
    }//GEN-LAST:event_formWindowOpened

    private void tablaAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAreaMouseClicked
        // TODO add your handling code here:
        areasSinLaSeleccionada();
        
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaArea.getModel();
        int filaSeleccionada = tablaArea.getSelectedRow();
        String nombreAreaSeleccionada = (String) tablaArea.getValueAt(filaSeleccionada, 0);
        actualizarEmpleados(this.sistema.getAreaPorNOmbre(nombreAreaSeleccionada));
        
        
        
    }//GEN-LAST:event_tablaAreaMouseClicked

    public void areasSinLaSeleccionada(){
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaNuevaArea.getModel();
        modeloTabla.setRowCount(0); 
        int filaSeleccionadaTablaAreaOriginal = tablaArea.getSelectedRow();

        for(int i = 0; i < this.sistema.getAreasOrdenadasPorNombre().size(); i++){
        if(i != filaSeleccionadaTablaAreaOriginal){
            Area area = this.sistema.getAreasOrdenadasPorNombre().get(i);

                modeloTabla.addRow(new Object[]{
                    area.getNombre()
                    

                    });

                }
        }
        
    }
    
    
    
    public void cargarMeses(){
    
    javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaMes.getModel();
    modeloTabla.setRowCount(0); 
    
    String[] meses = {"","Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};    
       
    for(int i = 1; i < meses.length; i++){
          
        
       
            modeloTabla.addRow(new Object[]{
                meses[i],
                

                });

            }
        
    }
    
    
    
    private void actualizarAreas(){
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaArea.getModel();
        modeloTabla.setRowCount(0); 
        
        for(int i = 0; i < this.sistema.getAreasOrdenadasPorNombre().size(); i++){
          
        Area area = this.sistema.getAreasOrdenadasPorNombre().get(i);
       
            modeloTabla.addRow(new Object[]{
                area.getNombre(),
                area.getPresupuesto(),
                this.sistema.getDistribucionPresupuesto().getPresupuestoDisponible(area),

                });

            }
    }
    
    public void actualizarEmpleados(Area areaSelecionada) {
    javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaEmpleados.getModel();
    modeloTabla.setRowCount(0); 
    
    for (int i = 0; i < areaSelecionada.getListaEmpleados().size(); i++) {
        
        Empleado empleado = areaSelecionada.getListaEmpleados().get(i);
        
        
        
        modeloTabla.addRow(new Object[]{
            empleado.getNombre(),
            empleado.getCedula(),
            empleado.getSalarioMensual(),
            this.sistema.getAreaDelEmpleado(empleado).getNombre(),
            
            });
        
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == sistema) {
            actualizarAreas();
            areasSinLaSeleccionada();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarEmpledoArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaArea;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaMes;
    private javax.swing.JTable tablaNuevaArea;
    // End of variables declaration//GEN-END:variables
}
