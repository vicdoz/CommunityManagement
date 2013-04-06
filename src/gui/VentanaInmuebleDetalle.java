package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import excepciones.*;
import negocio.*;
import negocio._tablas.*;
import accesoAdatos._controladores.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class VentanaInmuebleDetalle extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

        private JPanel jContentPane;
        private JPanel jPanel1;
        private JLabel jLabel;
        private JTextField porcTextField;
        private JLabel porcLabel;
        private JTextField ComTextField;
        private JLabel ComLab;

        private JLabel PropLab;
        private JTextField puertaTextField;
        private JLabel escaleraLabel;
        private JLabel puertaLabel;
        private JTextField pisoTextField;
        private JTextField escaleraTextField;
        private JLabel pisoLocal;
        private JButton volverButton;
        private JButton guardarButton;
        private JPanel formularioPanel;
        @SuppressWarnings("unchecked")
		private JComboBox propietarios;
        private int editMode=0;
        private int rowAux;
        public static ModeloTablaInmueble modelo = null;
        public static Inmueble InAux=new Inmueble();
        private Comunidad comunidad;
        /**
        * Auto-generated main method to display this JFrame
        */
        public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                                VentanaInmuebleDetalle inst = new VentanaInmuebleDetalle();
                                inst.setLocationRelativeTo(null);
                                inst.setVisible(true);                          
                        }
                });
        }
        public VentanaInmuebleDetalle() {
            super(); 
            initGUI();
        }
        @SuppressWarnings("static-access")
        public VentanaInmuebleDetalle(ModeloTablaInmueble mod) {
                super();
                this.modelo=mod;
                comunidad = modelo.comunidad; 
                initGUI();
        }
        /*@SuppressWarnings("static-access")
        public VentanaInmuebleDetalle(ModeloTablaInmueble mod,Comunidad c,Inmueble i) {
                super();
                this.modelo=mod;
                initGUI();
                comunidad=c;
                InAux=i;
        }
        @SuppressWarnings("static-access")
        public VentanaInmuebleDetalle(ModeloTablaInmueble mod,Comunidad c) {
                super();
                this.modelo=mod;
                comunidad=c;
                initGUI();
                
        
        }*/
        
        public VentanaInmuebleDetalle(int row, Inmueble i) {
                super();
                editMode=1;
                comunidad=i.getComunidad();
                initGUI();
                
                escaleraTextField.setText(i.getEscalera());             pisoTextField.setText(i.getPiso());
                puertaTextField.setText(i.getPuerta());
                propietarios.setSelectedIndex(i.getPropietario().getIdPropietario()-1);
                //String idProp=i.getPropietario().getIdPropietario()+"";
                String idCom=i.getComunidad().getIdComunidad()+"";
                porcTextField.setText(String.valueOf(i.getPorcentaje()));         
                ComTextField.setText(idCom);    
                InAux=i;
                this.rowAux=row;
        }

        
        @SuppressWarnings("unchecked")
		private void initGUI() {
                try {
                        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        this.setTitle("Datos Inmueble");
                        {
                                jContentPane = new JPanel();
                                BorderLayout jPanelLayout = new BorderLayout();
                                jContentPane.setLayout(jPanelLayout);
                                getContentPane().add(jContentPane, BorderLayout.CENTER);
                                {
                                        formularioPanel = new JPanel();
                                        GridBagLayout jPanel1Layout = new GridBagLayout();
                                     
                                                                                
                                        jPanel1Layout.columnWidths = new int[] {7, 7, 7};
                                        jPanel1Layout.rowHeights = new int[] {7, 7, 7, 20, 20, 7};
                                        jPanel1Layout.columnWeights = new double[] {0.005, 0.1, 0.1};
                                        jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
                                        jContentPane.add(formularioPanel, BorderLayout.CENTER);
                                        formularioPanel.setLayout(jPanel1Layout);
                                        formularioPanel.setPreferredSize(new java.awt.Dimension(384, 183));
                                        {
                                                escaleraLabel = new JLabel();
                                                escaleraLabel.setLayout(null);
                                                formularioPanel.add(escaleraLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
                                                escaleraLabel.setText("Escalera:");
                                        }
                                        {
                                                escaleraTextField = new JTextField();
                                                formularioPanel.add(escaleraTextField, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
                                                if(InAux==null) escaleraTextField.setText("");
                                                
                                        }
                                        {
                                                pisoLocal = new JLabel();
                                                formularioPanel.add(pisoLocal, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
                                                pisoLocal.setText("Piso:");
                                        }
                                        {
                                                pisoTextField = new JTextField();
                                                formularioPanel.add(pisoTextField, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
                                                if(InAux==null) pisoTextField.setText("");
                                                
                                        }
                                        {
                                                puertaLabel = new JLabel();
                                                formularioPanel.add(puertaLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
                                                puertaLabel.setText("Puerta:");
                                        }
                                        {
                                                puertaTextField = new JTextField();
                                                formularioPanel.add(puertaTextField, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
                                                if(InAux==null) puertaTextField.setText("");

                                        }
                                        {
                                        	porcLabel = new JLabel();
                                        	formularioPanel.add(porcLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                                        	porcLabel.setText("Porcentaje");
                                        }
                                        {
                                        	porcTextField = new JTextField();
                                        	formularioPanel.add(porcTextField, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
                                        	if(InAux==null) porcTextField.setText("");
                                        }
                                        {
                                                ComLab = new JLabel();
                                                formularioPanel.add(ComLab, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
                                                ComLab.setText("Comunidad");
                                        }
                                        {
                                                ComTextField = new JTextField();
                                                formularioPanel.add(ComTextField, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
                                                if(comunidad!=null)	ComTextField.setText(""+comunidad.getIdComunidad());
                                                ComTextField.setEnabled(false);
                                        }
                                        {
                                        	PropLab = new JLabel();
                                        	formularioPanel.add(PropLab, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
                                        	PropLab.setText("Propietario");
                                        }
                                        {
                                        	
                                        	ArrayList<String> listaPropietarios=ControladorPropietario.getControladorPropietario().GetListaNombresPropietarios();
                                        	propietarios = new JComboBox(listaPropietarios.toArray());
                                        	formularioPanel.add(propietarios, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
                                        }
                                }
                                {
                                        jPanel1 = new JPanel();
                                        jContentPane.add(jPanel1, BorderLayout.SOUTH);
                                        jPanel1.setPreferredSize(new java.awt.Dimension(384, 33));
                                        {
                                                guardarButton = new JButton();
                                                jPanel1.add(guardarButton);
                                                guardarButton.setText("Guardar");
                                                
                                                guardarButton.addActionListener(new ActionListener() {
                                                        public void actionPerformed(ActionEvent evt) {
                                                                        try {
                                                                                System.out.println("guardando");
                                                                                guardarDatos();
                                                                        } catch (InmuebleYaExiste e) {
                                                                                System.out.println("Inmueble ya existe, Exception in handler");
                                                                        }
                                                        }
                                                });
                                        }
                                        {
                                                volverButton = new JButton();
                                                jPanel1.add(volverButton);
                                                volverButton.setText("Volver");
                                                volverButton.addActionListener(new ActionListener() {
                                                        public void actionPerformed(ActionEvent evt) {
                                                                InAux=null;
                                                                dispose();
                                                        }
                                                });
                                        }
                                }
                                {
                                        jLabel = new JLabel();
                                        jContentPane.add(jLabel, BorderLayout.NORTH);
                                        jLabel.setText(" ");
                                }
                        }
                        pack();
                        setSize(400, 300);
                } catch (Exception e) {
                    //add your error handling code here
                        e.printStackTrace();
                }
        }
        private void guardarDatos() throws InmuebleYaExiste{            
                if(ComTextField.getText().isEmpty() 
                                ||escaleraTextField.getText().isEmpty() || puertaTextField.getText().isEmpty() || pisoTextField.getText().isEmpty() ){
                        javax.swing.JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
                }else {
                        String Escalera = escaleraTextField.getText();  String Puerta = puertaTextField.getText();
                        String Piso = pisoTextField.getText();    
                        float Porcentaje=Float.parseFloat(porcTextField.getText());
                        int idProp =ControladorPropietario.getControladorPropietario().getPropietarioPorPos(propietarios.getSelectedIndex()).getIdPropietario();
                        int idCom = Integer.parseInt(ComTextField.getText());
                        
                        if(ControladorPropietario.getControladorPropietario().getPropietarioPorId(idProp)==null){
                                javax.swing.JOptionPane.showMessageDialog(null, "Por favor introduzca un ID de Propietario correcto");
                        }else{
                        
                                if(editMode==1){        
                                        
                                        InAux.setEscalera(Escalera);    InAux.setPiso(Piso); 
                                        InAux.setPuerta(Puerta);                InAux.setComunidad(comunidad);                          
                                        InAux.setComunidad(ControladorComunidad.getControladorComunidad().getComunidadPorId(idCom));
                                        InAux.setPropietario(ControladorPropietario.getControladorPropietario().getPropietarioPorId(idProp));
                                        InAux.setPorcentaje(Porcentaje);
                                        try {                   
                                                
                                                ControladorInmueble.getControladorInmueble().actualizarInmueble(InAux);                                 
                                                VentanaComunidad.modeloInm.updateRow(rowAux,InAux);             
                                                VentanaComunidad.modeloInm.fireTableDataChanged();
                                                VentanaComunidad.tablaInm.setModel(VentanaComunidad.modeloInm);                 
                                                
                                                dispose();
                                                
                                        } catch (DAOExcepcion e) {
                                                e.printStackTrace();
                                        }
                                        
                                }
                                else{
                                        Inmueble i = new Inmueble();
                                        i.setEscalera(Escalera);
                                        i.setPiso(Piso);
                                        i.setPuerta(Puerta);                            
                                        i.setComunidad(ControladorComunidad.getControladorComunidad().getComunidadPorId(
                                                        Integer.parseInt(ComTextField.getText())));
                                        i.setPropietario(ControladorPropietario.getControladorPropietario().getPropietarioPorId(
                                        		ControladorPropietario.getControladorPropietario().getPropietarioPorPos(propietarios.getSelectedIndex()).getIdPropietario()));
                                        
                                        System.out.println(i.getPropietario().getIdPropietario());
                                        try {           
                                                ControladorInmueble.getControladorInmueble().nuevoInmueble(i);
                                                VentanaComunidad.modeloInm.addInmueble(i);
                                                VentanaComunidad.tablaInm.setModel(VentanaComunidad.modeloInm);
                                                dispose();
                                        } catch (DAOExcepcion e) {
                                                e.printStackTrace();
                                        }
                                }
                        }
                }
        }                       
}