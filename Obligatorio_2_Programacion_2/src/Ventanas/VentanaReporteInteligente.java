/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Dominio.Areas.Area;
import Dominio.Personas.Empleado;
import Sistema.Sistema;
import IA.ServicioGemini;
import FuncionalidadTexto.ArchivoLectura;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.SwingUtilities;


public class VentanaReporteInteligente extends javax.swing.JFrame {
    private Sistema sistema;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaReporteInteligente.class.getName());

    
    public VentanaReporteInteligente(Sistema sistema) {
        this.sistema = sistema;

        initComponents();
        
        
        lbCargandoSolicitud.setVisible(false);
        
        actualizarAreas();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerarReporte = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaNuevaArea = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaArea = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRespuestaIA = new javax.swing.JTextArea();
        lbCargandoSolicitud = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        tablaArea.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAreaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaArea);

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtRespuestaIA.setEditable(false);
        txtRespuestaIA.setColumns(20);
        txtRespuestaIA.setRows(5);
        jScrollPane1.setViewportView(txtRespuestaIA);

        lbCargandoSolicitud.setText("Gargando solicitud...");

        javax.swing.GroupLayout btnGenerarReporteLayout = new javax.swing.GroupLayout(btnGenerarReporte);
        btnGenerarReporte.setLayout(btnGenerarReporteLayout);
        btnGenerarReporteLayout.setHorizontalGroup(
            btnGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGenerarReporteLayout.createSequentialGroup()
                .addGroup(btnGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnGenerarReporteLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(btnGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(btnGenerarReporteLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(btnGenerarReporteLayout.createSequentialGroup()
                        .addGap(427, 427, 427)
                        .addGroup(btnGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(lbCargandoSolicitud))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        btnGenerarReporteLayout.setVerticalGroup(
            btnGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGenerarReporteLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(btnGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addComponent(lbCargandoSolicitud)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAreaMouseClicked
       
        
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaArea.getModel();
        int filaSeleccionada = tablaArea.getSelectedRow();
        String nombreAreaSeleccionada = (String) tablaArea.getValueAt(filaSeleccionada, 0);
        actualizarEmpleados(this.sistema.getAreaPorNOmbre(nombreAreaSeleccionada));
        
        areasSinLaSeleccionada();
        
        
    }//GEN-LAST:event_tablaAreaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generarReporteInteligente();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
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
    
    private void actualizarAreas(){
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaArea.getModel();
        modeloTabla.setRowCount(0); 
        
        
        
        for(int i = 0; i < this.sistema.getAreasOrdenadasPorNombre().size(); i++){
          
            Area area = this.sistema.getAreasOrdenadasPorNombre().get(i);

            modeloTabla.addRow(new Object[]{
                    area.getNombre(),
                    

            });
            
            

        }
    }
    
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
    
    private void generarReporteInteligente() {
        lbCargandoSolicitud.setVisible(true);

        int filaEmpleado = tablaEmpleados.getSelectedRow();
        int filaAreaDestino = tablaNuevaArea.getSelectedRow();
        int filaAreaOrigen = tablaArea.getSelectedRow();

        int cedulaEmpleado = (Integer) tablaEmpleados.getValueAt(filaEmpleado, 1);
        Empleado empleado = sistema.getListaPersonas().getEmpleadoPorCedula(cedulaEmpleado);

        String nombreAreaOrigen = (String) tablaArea.getValueAt(filaAreaOrigen, 0);
        String nombreAreaDestino = (String) tablaNuevaArea.getValueAt(filaAreaDestino, 0);

        String cvEmpleado = leerCV(empleado.getCedula());

        txtRespuestaIA.setText("Generando reporte...");
        jButton1.setEnabled(false);

        new Thread(() -> {
            String resultado;
            try {
                ServicioGemini servicioGemini = new ServicioGemini();
                resultado = servicioGemini.generarReporteInteligente(nombreAreaOrigen, "", nombreAreaDestino, "", cvEmpleado);
            } catch (Exception e) {
                resultado = "Error: " + e.getMessage();
            }

            final String textoFinal = resultado;
            SwingUtilities.invokeLater(() -> {
                txtRespuestaIA.setText(textoFinal);
                jButton1.setEnabled(true);
                lbCargandoSolicitud.setVisible(false);
            });
        }).start();
    }
    
    private String leerCV(int cedulaEmpleado) {
        try {
            String rutaArchivo = "cvs/CV" + cedulaEmpleado;
            Path archivoCv = Paths.get(rutaArchivo);
            
            
            ArchivoLectura archivoLectura = new ArchivoLectura(rutaArchivo);
            String contenidoCV = " ";
                
            while (archivoLectura.hayMasLineas()) {
                contenidoCV +=  archivoLectura.linea() + " ";
            }
                
                archivoLectura.cerrar();
                return contenidoCV;
            
        } catch (Exception e) {
            return "Error al leer el CV: " + e.getMessage() + 
                   "\nSe utilizará información básica del empleado.";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnGenerarReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbCargandoSolicitud;
    private javax.swing.JTable tablaArea;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaNuevaArea;
    private javax.swing.JTextArea txtRespuestaIA;
    // End of variables declaration//GEN-END:variables
}
