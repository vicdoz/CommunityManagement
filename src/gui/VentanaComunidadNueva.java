package gui;
import negocio.*;
import negocio._tablas.*;

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

import accesoAdatos._controladores.ControladorComunidad;
import accesoAdatos._controladores.ControladorPropietario;

import excepciones.*;




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
public class VentanaComunidadNueva extends javax.swing.JFrame {
	private JPanel jContentPane;
	private JPanel jPanel1;
	private JLabel jLabel;
	private JTextField pobTextField;
	private JLabel poblabel;
	private JLabel contactLabel;
	private JTextField direccionTextField;
	private JLabel nifLabel;
	private JLabel direccionLabel;
	private JTextField nombreTextField;
	private JButton volverButton;
	private JButton guardarButton;
	private JPanel formularioPanel;
	private JComboBox<String> propietarios;
	private int editMode=0;
	private int rowAux;
	public static ModeloTablaComunidad modelo = null;
	public static Comunidad comAux=null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaComunidadNueva inst = new VentanaComunidadNueva();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	public VentanaComunidadNueva() {
		super();
		initGUI();
	}	
	@SuppressWarnings("static-access")
	public VentanaComunidadNueva(ModeloTablaComunidad mod) {
		super();
		this.modelo=mod;
		initGUI();

	}
	@SuppressWarnings("static-access")
	public VentanaComunidadNueva(Comunidad c,int row) {
		super();

		this.comAux=c;
		this.rowAux=row;
		editMode=1;
		initGUI();
		
		nombreTextField.setText(c.getNombre());
		
		direccionTextField.setText(c.getCalle());		
		pobTextField.setText(c.getPoblacion());	
	}
	
	
	@SuppressWarnings("unchecked")
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Datos Comunidad");
			{
				jContentPane = new JPanel();
				BorderLayout jPanelLayout = new BorderLayout();
				jContentPane.setLayout(jPanelLayout);
				getContentPane().add(jContentPane, BorderLayout.CENTER);
				jContentPane.setPreferredSize(new java.awt.Dimension(437, 276));
				{
					formularioPanel = new JPanel();
					GridBagLayout jPanel1Layout = new GridBagLayout();
					
					jPanel1Layout.columnWidths = new int[] {7, 7, 7};
					jPanel1Layout.rowHeights = new int[] {7, 20, 7, 7};
					jPanel1Layout.columnWeights = new double[] {0.005, 0.1, 0.1};
					jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jContentPane.add(formularioPanel, BorderLayout.CENTER);
					formularioPanel.setLayout(jPanel1Layout);
					formularioPanel.setPreferredSize(new java.awt.Dimension(437, 215));
					{
						nifLabel = new JLabel();
						formularioPanel.add(nifLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						nifLabel.setText("Nombre");
						nifLabel.setLayout(null);
						;
						nifLabel.setName("nifLabel");
						
					}
					{
						nombreTextField = new JTextField();
						formularioPanel.add(nombreTextField, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(comAux==null)	nombreTextField.setText("");
						
					}
					{
						direccionLabel = new JLabel();
						formularioPanel.add(direccionLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						direccionLabel.setText("Direccion");
						direccionLabel.setName("direccionLabel");
					}
					{
						direccionTextField = new JTextField();
						formularioPanel.add(direccionTextField, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(comAux==null)	direccionTextField.setText("");

					}
					{
						poblabel = new JLabel();
						formularioPanel.add(poblabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						poblabel.setName("poblabel");
						poblabel.setText("Poblacion");
					}
					{
						pobTextField = new JTextField();
						formularioPanel.add(pobTextField, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
					}
					{
						contactLabel = new JLabel();
						formularioPanel.add(contactLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						contactLabel.setName("contactLabel");
						contactLabel.setText("Contacto");
					}
					{
						
						ArrayList<String> listaPropietarios=ControladorPropietario.getControladorPropietario().GetListaNombresPropietarios();
						propietarios = new JComboBox(listaPropietarios.toArray());
						formularioPanel.add(propietarios, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
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
								comAux=null;
								modelo=null;
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
			this.setSize(389, 269);
			//Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public boolean isInteger( String input ){
	   try{
	      Integer.parseInt( input );
	      return true;
	   }catch( Exception e){
	      return false;
	   }
	}

	private void guardarDatos() throws InmuebleYaExiste{
		int idCont=0;
		String nombre = nombreTextField.getText();		String direccion = direccionTextField.getText();
		String poblacion = pobTextField.getText();		String auxCont = String.valueOf(ControladorPropietario.getControladorPropietario().getPropietarioPorPos(propietarios.getSelectedIndex()).getIdPropietario());
		if(isInteger(auxCont))	idCont = Integer.parseInt(auxCont);
		else	idCont=-1;
		System.out.println("idCont="+idCont);
		if(nombre.isEmpty() || direccion.isEmpty() || poblacion.isEmpty()){
			javax.swing.JOptionPane.showMessageDialog(null, "Los campos Nombre, Dirección y Población deben completarse");
		} 
		else if((!auxCont.isEmpty()&&idCont==-1) ){ 
			javax.swing.JOptionPane.showMessageDialog(null, "Por favor introduzca un ID de Contacto correcto");
		}
		else if(idCont>0 && ControladorPropietario.getControladorPropietario().getPropietarioPorId(idCont)==null){
			javax.swing.JOptionPane.showMessageDialog(null, "Por favor introduzca un ID de Contacto correcto");
		}
		else{
			Comunidad c = new Comunidad();
			c.setCalle(direccion);		c.setNombre(nombre);
			c.setPoblacion(poblacion);	c.setMaxRecibosPendientes(0);
			c.setEstado(1);	
			if(idCont>0)	c.setIdPresidente(idCont);
			if(editMode==1){
				comAux.setCalle(direccion);
				comAux.setNombre(nombre);
				comAux.setPoblacion(poblacion);					
				try {
					ControladorComunidad.getControladorComunidad().actualizarComunidad(comAux);
					VentanaComunidad.modeloCom.updateRow(rowAux,comAux);		
					VentanaComunidad.modeloCom.fireTableDataChanged();
					VentanaComunidad.tablaCom.setModel(VentanaComunidad.modeloCom);
					dispose();
				} catch (DAOExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			else{ //Comunidad nueva
				try {		
					ControladorComunidad.getControladorComunidad().nuevaComunidad(c);
					VentanaComunidad.modeloCom.addComunidad(c);
					VentanaComunidad.tablaCom.setModel(VentanaComunidad.modeloCom);
					//Abrimos la ventana de añadir inmuebles
					VentanaComunidad.modeloInm.cargaInmueblesComunidad(c);
					VentanaComunidad.addInmButton.setEnabled(true);
					VentanaComunidad.jTabbedPane1.setSelectedIndex(2);
					VentanaInmuebleDetalle v = new VentanaInmuebleDetalle(c);
					v.setVisible(true);
					//Cerramos esta ventana
					dispose();
				} catch (DAOExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}			
	}		
}