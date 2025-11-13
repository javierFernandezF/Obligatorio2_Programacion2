/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Sistema.Sistema;
import Dominio.Areas.Area;
import Dominio.Personas.Empleado;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * Ventana de Reporte de Estado de Áreas (versión con GUI autogenerado)
 * Usa solo los componentes generados por NetBeans:
 *   - listaAreas (JList)
 *   - pnlEmpleados (JPanel)
 *   - lblDetalle (JLabel)
 *
 * Requiere en Sistema:
 *   getAreasOrdenadasPorPorcentajeDesc(), porcentajeAsignado(Area),
 *   getEmpleadosDe(Area), minSalarioEn(Area), maxSalarioEn(Area)
 */
public class VentanaReporteEstadoArea extends javax.swing.JFrame implements Observer {

    // ----------- CAMPOS (no autogenerados) -----------
    private final Sistema sistema;
    private final DefaultListModel<Area> mdlAreas = new DefaultListModel<>();
    private final DecimalFormat df = new DecimalFormat("#0.0");

    // --------------------------------------------------
    public VentanaReporteEstadoArea(Sistema sistema) {
        this.sistema = sistema;
        initComponents();       // (guarded) generado por NetBeans
        postInit();             // configurar model/renderer/listeners
        this.sistema.addObserver(this);
        cargarAreas();
    }

    // Configuración extra sobre lo autogenerado
    @SuppressWarnings("unchecked")
    private void postInit() {
         
    listaAreas.setModel((DefaultListModel) mdlAreas);
        // model para la lista de áreas (aunque la lista sea JList<String>, acepta cualquier ListModel)
        

        // renderer con colores por % asignado
        listaAreas.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Area) {
                    Area a = (Area) value;
                    int pctRedondeado = (int)Math.round(sistema.porcentajeAsignado(a));
lbl.setText("• " + a.getNombre());

                    if (!isSelected) {
                        if (pctRedondeado > 90.0)      lbl.setBackground(new Color(255,153,153)); // rojo claro
                        else if (pctRedondeado >= 70.0) lbl.setBackground(new Color(255,245,157)); // amarillo claro
                        else                  lbl.setBackground(new Color(230,230,230)); // gris claro
                        lbl.setOpaque(true);
                    }
                }
                return lbl;
            }
        });

        // grilla 3 columnas para empleados
        pnlEmpleados.setLayout(new GridLayout(0, 3, 8, 8));

        // selección de áreas
        listaAreas.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Object sel = listaAreas.getSelectedValue();
                if (sel instanceof Area) actualizarDetalle((Area) sel);
                else limpiarDetalle();
            }
        });
    }

    // ------- LÓGICA -------
    private void cargarAreas() {
        mdlAreas.clear();
        List<Area> ordenadas = new ArrayList<>(sistema.getAreasOrdenadasPorPorcentajeDesc());
        for (Area a : ordenadas) mdlAreas.addElement(a);

        if (!ordenadas.isEmpty()) {
            listaAreas.setSelectedIndex(0);
        } else {
            limpiarDetalle();
        }
    }

    private void actualizarDetalle(Area area) {
        int pctRedondeado = (int)Math.round(sistema.porcentajeAsignado(area));
lblDetalle.setText("Área: " + area.getNombre() + " — " + pctRedondeado + "%");

        List<Empleado> empleados = sistema.getEmpleadosDe(area); // ya viene ordenado por nombre
        pnlEmpleados.removeAll();

        if (empleados.isEmpty()) {
            JLabel vacio = new JLabel("Sin empleados", SwingConstants.CENTER);
            pnlEmpleados.add(vacio);
        } else {
            double min = sistema.minSalarioEn(area);
            double max = sistema.maxSalarioEn(area);
            double rango = Math.max(1, max - min);

            for (Empleado emp : empleados) {
                JButton btn = new JButton(emp.getNombre());
                btn.setFocusPainted(false);
                btn.setMargin(new Insets(6, 8, 6, 8));

                // escala negro -> azul según salario mensual
                double val = emp.getSalarioMensual();
                int blue = (int) Math.round(255.0 * (val - min) / rango);
                blue = Math.max(0, Math.min(255, blue));
                Color bg = new Color(0, 0, Math.max(64, blue));
                btn.setBackground(bg);
                btn.setForeground(Color.WHITE);

                btn.addActionListener(ev -> {
                    String msg = emp.getNombre()
                            + "\nSalario mensual: " + String.format("USD %,.2f", emp.getSalarioMensual())
                            + "\nSalario anual (aprox): " + String.format("USD %,.2f", emp.getSalarioMensual() * 12.0)
                            + "\nÁrea: " + area.getNombre();
                    JOptionPane.showMessageDialog(this, msg, "Empleado", JOptionPane.INFORMATION_MESSAGE);
                });

                pnlEmpleados.add(btn);
            }
        }
        pnlEmpleados.revalidate();
        pnlEmpleados.repaint();
    }

    private void limpiarDetalle() {
        lblDetalle.setText("Seleccione un área…");
        pnlEmpleados.removeAll();
        pnlEmpleados.revalidate();
        pnlEmpleados.repaint();
    }

    // ------- OBSERVER -------
    @Override
    public void update(Observable o, Object arg) {
        cargarAreas();
        if (listaAreas.isSelectionEmpty()) limpiarDetalle();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaAreas = new javax.swing.JList<>();
        pnlEmpleados = new javax.swing.JPanel();
        lblDetalle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Area");

        jLabel2.setText("Personal");

        jScrollPane6.setViewportView(listaAreas);

        javax.swing.GroupLayout pnlEmpleadosLayout = new javax.swing.GroupLayout(pnlEmpleados);
        pnlEmpleados.setLayout(pnlEmpleadosLayout);
        pnlEmpleadosLayout.setHorizontalGroup(
            pnlEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        pnlEmpleadosLayout.setVerticalGroup(
            pnlEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        lblDetalle.setBackground(new java.awt.Color(255, 255, 255));
        lblDetalle.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(pnlEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JList<String> listaAreas;
    private javax.swing.JPanel pnlEmpleados;
    // End of variables declaration//GEN-END:variables

}
