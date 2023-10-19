/*
 * Clase App
 */
package chendongdiqijava03;

import chendongdiqijava03.MyList.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Di Qi
 */
public class App extends javax.swing.JFrame {

    private MyList<Empleado> lista;
    private boolean modoCrear;
    private MyList<Empleado> listaSinFiltrar;
    private boolean filtroActivado;

    /**
     * Creates new form App
     */
    public App() {
        initComponents();

        this.lista = new MyList<Empleado>();
        lista.add(new Empleado(1, "Di Qi", 1000, 10000));
        lista.add(new Empleado(2, "Alejandro"));
        lista.add(new Empleado(3, "Bruno", 2000, 20000));
        lista.add(new Empleado(4, "Carmen"));
        lista.add(new Empleado(5, "Diana", 3000, 30000));

        this.modoCrear = false;
        contenedorBotonesAux.setVisible(false);

        filtroActivado = false;
        this.listaSinFiltrar = this.lista;

        mostrarDatos();
        actualizarBotones();
        actualizarOpcionesFiltro();
    }

    /**
     * Muestra los datos del empleado actual de la lista
     */
    private void mostrarDatos() {
        Empleado e = this.lista.getActualNode().getMain();
        txtNumero.setText(e.getNumero() + "");
        txtFechaAlta.setText(e.getFechaAltaStr());
        txtNombre.setText(e.getNombre());
        txtSueldo.setText(e.getSueldo() + "");
        txtSueldoMaximo.setText(e.getSueldoMaximo() + "");
    }

    /**
     * Actualiza el estado de los botones
     */
    private void actualizarBotones() {
        Node n = this.lista.getActualNode();

        if (n.isFirstNode()) {
            btnAnterior.setEnabled(false);
        } else {
            btnAnterior.setEnabled(true);
        }

        if (n.isLastNode()) {
            btnSiguiente.setEnabled(false);
        } else {
            btnSiguiente.setEnabled(true);
        }

        if (this.filtroActivado) {  // Filtro activado, botones de crear, modificar y borrar bloqueados
            btnCrear.setEnabled(false);
            btnModificar.setEnabled(false);
            btnBorrar.setEnabled(false);
        } else {
            btnCrear.setEnabled(true);
            btnModificar.setEnabled(true);
            btnBorrar.setEnabled(true);
        }
    }

    /**
     * Deshabilita todos los botones principales
     */
    private void deshabilitarBotonesPrincipales() {
        btnAnterior.setEnabled(false);
        btnCrear.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnSiguiente.setEnabled(false);
    }

    /**
     * Habilita o deshabilita los campos editables
     *
     * @param habilitar true editable, false si no
     */
    private void habilitarCamposTexto(boolean habilitar) {
        txtNumero.setEditable(habilitar);
        txtNombre.setEditable(habilitar);
        txtSueldo.setEditable(habilitar);
        txtSueldoMaximo.setEditable(habilitar);
    }

    /**
     * Actualiza las opciones del filtro
     */
    private void actualizarOpcionesFiltro() {
        Node aux = this.lista.getFirstNode();
        Set<String> opciones = new HashSet<>();
        
        while (true) {
            if (aux != null) {
                opciones.add(((Empleado) aux.getMain()).getFechaAltaStr());
            }
            if (aux == null || aux.isLastNode()) {
                break;
            } else {
                aux = aux.getNextNode();
            }
        }
        List<String> listaOrdenada = new ArrayList<>(opciones);
        Collections.sort(listaOrdenada);

        comboFiltro.removeAllItems();
        comboFiltro.addItem("Todos");
        for (String o : listaOrdenada) {
            comboFiltro.addItem(o);
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

        labelNumero = new javax.swing.JLabel();
        labelFechaAlta = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelSueldo = new javax.swing.JLabel();
        labelSueldoMaximo = new javax.swing.JLabel();
        txtFechaAlta = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JTextField();
        txtSueldoMaximo = new javax.swing.JTextField();
        btnAnterior = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        labelFiltro = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox<>();
        btnIr = new javax.swing.JButton();
        contenedorBotonesAux = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNumero.setText("Número:");

        labelFechaAlta.setText("Fecha de alta:");

        labelNombre.setText("Nombre:");

        labelSueldo.setText("Sueldo:");

        labelSueldoMaximo.setText("Sueldo máximo:");

        txtFechaAlta.setEditable(false);

        txtNumero.setEditable(false);
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);

        txtSueldo.setEditable(false);

        txtSueldoMaximo.setEditable(false);

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        labelFiltro.setText("Filtro:");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        btnIr.setText("Ir");
        btnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorBotonesAuxLayout = new javax.swing.GroupLayout(contenedorBotonesAux);
        contenedorBotonesAux.setLayout(contenedorBotonesAuxLayout);
        contenedorBotonesAuxLayout.setHorizontalGroup(
            contenedorBotonesAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesAuxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(27, 27, 27))
        );
        contenedorBotonesAuxLayout.setVerticalGroup(
            contenedorBotonesAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesAuxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorBotonesAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelSueldoMaximo)
                                    .addComponent(labelSueldo)
                                    .addComponent(labelNombre)
                                    .addComponent(labelFechaAlta)
                                    .addComponent(labelNumero))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumero)
                                    .addComponent(txtFechaAlta)
                                    .addComponent(txtNombre)
                                    .addComponent(txtSueldo)
                                    .addComponent(txtSueldoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelFiltro)
                                .addGap(18, 18, 18)
                                .addComponent(comboFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnIr))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrar))
                            .addComponent(contenedorBotonesAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFiltro)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFechaAlta)
                    .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSueldo)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSueldoMaximo)
                    .addComponent(txtSueldoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnCrear)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar)
                    .addComponent(btnSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedorBotonesAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        deshabilitarBotonesPrincipales();
        habilitarCamposTexto(true);
        contenedorBotonesAux.setVisible(true);
        modoCrear = true;
        txtNumero.setText("");
        txtFechaAlta.setText("Automático");
        txtNombre.setText("");
        txtSueldo.setText("");
        txtSueldoMaximo.setText("");
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        deshabilitarBotonesPrincipales();
        habilitarCamposTexto(true);
        contenedorBotonesAux.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Node aux = lista.getActualNode();

        if (lista.getCouter() > 1) {
            if (aux.isFirstNode()) {
                lista.next();
                lista.delete(aux);
            } else {
                lista.prev();
                lista.delete(aux);
            }
            mostrarDatos();
            actualizarBotones();
            actualizarOpcionesFiltro();
        } else {    // Si solo queda un nodo, crear nueva lista y activar solo el botón crear
            lista = new MyList<Empleado>();
            listaSinFiltrar = lista;
            deshabilitarBotonesPrincipales();
            habilitarCamposTexto(false);
            btnCrear.setEnabled(true);
            txtNumero.setText("");
            txtFechaAlta.setText("");
            txtNombre.setText("");
            txtSueldo.setText("");
            txtSueldoMaximo.setText("");
            actualizarOpcionesFiltro();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.lista.next();
        mostrarDatos();
        actualizarBotones();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.lista.prev();
        mostrarDatos();
        actualizarBotones();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int numero = -1;
        String nombre = null;
        double sueldo = -1;
        double sueldoMaximo = -1;
        boolean datos_correctos;

        // Comprobar tipos de los datos
        try {
            numero = Integer.parseInt(txtNumero.getText());
            nombre = txtNombre.getText();
            sueldo = Double.parseDouble(txtSueldo.getText());
            sueldoMaximo = Double.parseDouble(txtSueldoMaximo.getText());
        } catch (Exception ex) {
            datos_correctos = false;
        }

        // Comprobar datos
        if (numero >= 0 && !nombre.isEmpty() && sueldo >= 0 && sueldoMaximo >= 0 && sueldo <= sueldoMaximo) {
            datos_correctos = true;
        } else {
            datos_correctos = false;
        }

        if (datos_correctos) {
            if (modoCrear) {    // Modo crear
                lista.add(new Empleado(numero, nombre, sueldo, sueldoMaximo));
                modoCrear = false;
                actualizarOpcionesFiltro();
            } else {    // Modo editar
                lista.getActualNode().getMain().setNumero(numero);
                lista.getActualNode().getMain().setNombre(nombre);
                lista.getActualNode().getMain().setSueldo(sueldo);
                lista.getActualNode().getMain().setSueldoMaximo(sueldoMaximo);
                mostrarDatos();
            }
            actualizarBotones();
            mostrarDatos();
            habilitarCamposTexto(false);
            contenedorBotonesAux.setVisible(false);
            habilitarCamposTexto(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Datos incorrectos.");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        mostrarDatos();
        habilitarCamposTexto(false);
        actualizarBotones();
        contenedorBotonesAux.setVisible(false);
        modoCrear = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
        MyList<Empleado> listaFiltrada = new MyList<>();
        String filtro = comboFiltro.getSelectedItem().toString();
        Node aux = this.listaSinFiltrar.getFirstNode();
        
        if (filtro.equals("Todos")) {   // Vista normal
            this.lista = this.listaSinFiltrar;
            while (this.lista.getActualNode() != this.lista.getFirstNode()) {
                this.lista.prev();
            }
            mostrarDatos();
            this.filtroActivado = false;
            actualizarBotones();
        } else {    // Vista filtrada
            while (true) {
                if (aux != null && (filtro.equals("Todos") || ((Empleado) aux.getMain()).getFechaAltaStr().equals(filtro))) {
                    listaFiltrada.add(((Empleado) aux.getMain()));
                }
                if (aux == null || aux.isLastNode()) {
                    break;
                } else {
                    aux = aux.getNextNode();
                }
            }
            this.lista = listaFiltrada;
            mostrarDatos();
            this.filtroActivado = true;
            actualizarBotones();
        }
    }//GEN-LAST:event_btnIrActionPerformed

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnIr;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JPanel contenedorBotonesAux;
    private javax.swing.JLabel labelFechaAlta;
    private javax.swing.JLabel labelFiltro;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelSueldo;
    private javax.swing.JLabel labelSueldoMaximo;
    private javax.swing.JTextField txtFechaAlta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtSueldoMaximo;
    // End of variables declaration//GEN-END:variables
}