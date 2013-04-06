package gui;
import negocio.*;
import accesoAdatos._controladores.*;



import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;

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
public class VentanaPropietario extends javax.swing.JFrame {
	private JPanel jContentPane;
	private JPanel jPanel1;
	private JLabel jLabel;
	private JTextField cuentaTextField;
	private JTextField entidadTextField;
	private JLabel obsLabel;
	private JLabel cuentaLabel;
	private JLabel entidadLabel;
	private JTextField pobTextField;
	private JTextField telefTextField;
	private JLabel emailLabel;
	private JTextField dcTextField;
	private JTextField sucursalTextField;
	private JLabel digcontrolLabel;
	private JLabel sucursalLabel;
	private JTextField emailTextField;

	private JEditorPane obsEditorPane;
	private JLabel teleflabel;
	private JLabel poblabel;
	private JLabel labelnom;
	private JTextField direccionTextField;
	private JLabel nifLabel;
	private JLabel direccionLabel;
	private JTextField nombreTextField;
	private JTextField nifTextField;
	private JButton volverButton;
	private JButton guardarButton;
	private JPanel formularioPanel;
	private int rowAux;
	//public static ModeloTablaInmueble modelo = null;
	private int editMode=0;
	public static Propietario pAux = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaPropietario inst = new VentanaPropietario();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	public VentanaPropietario() {
		super();
		initGUI();

	}
	@SuppressWarnings("static-access")
	public VentanaPropietario(Propietario p, int row){
		super();
		this.pAux=p;
		this.rowAux=row;
		editMode=1;
		initGUI();
		
		nifTextField.setText(pAux.getNif());
		nombreTextField.setText(pAux.getNombre());
		emailTextField.setText(pAux.getEmail());
		direccionTextField.setText(pAux.getDireccion());
		pobTextField.setText(pAux.getPoblacion());
		telefTextField.setText(pAux.getTelefono().toString());
		entidadTextField.setText(Integer.toString(pAux.getEntidad()));
		cuentaTextField.setText(Integer.toString(pAux.getNumerocuenta()));
		obsEditorPane.setText(Integer.toString(pAux.getEntidad()));
		sucursalTextField.setText(Integer.toString(pAux.getSucursal()));
		dcTextField.setText(Integer.toString(pAux.getdigitocontrol()));
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Datos Propietario");
			{
				jContentPane = new JPanel();
				BorderLayout jPanelLayout = new BorderLayout();
				jContentPane.setLayout(jPanelLayout);
				getContentPane().add(jContentPane, BorderLayout.CENTER);
				jContentPane.setPreferredSize(new java.awt.Dimension(437, 390));
				{
					formularioPanel = new JPanel();
					GridBagLayout jPanel1Layout = new GridBagLayout();
								
					
					jPanel1Layout.columnWidths = new int[] {7, 100, 128, 20};
					jPanel1Layout.rowHeights = new int[] {7, 20, 20, 7, 7, 7, 20, 20, 20, 20};
					jPanel1Layout.columnWeights = new double[] {0.005, 0.0, 0.0, 0.1};
					jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jContentPane.add(formularioPanel, BorderLayout.CENTER);
					formularioPanel.setLayout(jPanel1Layout);
					formularioPanel.setPreferredSize(new java.awt.Dimension(439, 406));
					{
						nifLabel = new JLabel();
						formularioPanel.add(nifLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 0), 0, 0));
						nifLabel.setText("NIF:");
						nifLabel.setLayout(null);
						;
						nifLabel.setName("nifLabel");
						
					}
					{
						nifTextField = new JTextField();
						formularioPanel.add(nifTextField, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(pAux==null)	nifTextField.setText("");
						
					}
					{
						labelnom = new JLabel();
						formularioPanel.add(labelnom, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 0), 0, 0));
						labelnom.setName("labelnom");
						labelnom.setText("Nombre:");
					}
					{
						nombreTextField = new JTextField();
						formularioPanel.add(nombreTextField, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(pAux==null)	nombreTextField.setText("");
							
					}
					{
						emailLabel = new JLabel();
						formularioPanel.add(emailLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 0), 0, 0));
						emailLabel.setText("E-Mail");
					}
					{
						emailTextField = new JTextField();
						formularioPanel.add(emailTextField, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(pAux==null)	emailTextField.setText("");
					}
					{
						direccionLabel = new JLabel();
						formularioPanel.add(direccionLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 0), 0, 0));
						direccionLabel.setText("Direccion");
						direccionLabel.setName("direccionLabel");
					}
					{
						direccionTextField = new JTextField();
						formularioPanel.add(direccionTextField, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(pAux==null)	direccionTextField.setText("");
					}
					{
						poblabel = new JLabel();
						formularioPanel.add(poblabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						poblabel.setName("poblabel");
						poblabel.setText("Poblacion");
					}
					{
						pobTextField = new JTextField();
						formularioPanel.add(pobTextField, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(pAux==null) pobTextField.setText("");
					}
					{					
						teleflabel = new JLabel();
						formularioPanel.add(teleflabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						teleflabel.setName("teleflabel");
						teleflabel.setText("Telefono:");
					}
					{
						telefTextField = new JTextField();
						formularioPanel.add(telefTextField, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(pAux==null) telefTextField.setText("");
					}
					{
						entidadLabel = new JLabel();
						formularioPanel.add(entidadLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						entidadLabel.setText("Entidad");
						
					}
					{
						entidadTextField = new JTextField();
						formularioPanel.add(entidadTextField, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(pAux==null) entidadTextField.setText("");
					}
					{
						cuentaLabel = new JLabel();
						formularioPanel.add(cuentaLabel, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						cuentaLabel.setText("N. Cuenta");
					}
					{
						cuentaTextField = new JTextField();
						formularioPanel.add(cuentaTextField, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 60, 0, 10), 0, 0));
						cuentaTextField.setText("");
					}
					{
						obsLabel = new JLabel();
						formularioPanel.add(obsLabel, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						obsLabel.setText("Observ.:");
					}
					{
						obsEditorPane = new JEditorPane();
						formularioPanel.add(obsEditorPane, new GridBagConstraints(1, 8, 2, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
						obsEditorPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						obsEditorPane.setSize(362, 40);
						obsEditorPane.setMaximumSize(new java.awt.Dimension(362, 50));
						if(pAux==null) obsEditorPane.setText("");
						
					}
					{
						sucursalTextField = new JTextField();
						formularioPanel.add(sucursalTextField, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 60, 0, 10), 0, 0));
					}
					{
						sucursalLabel = new JLabel();
						formularioPanel.add(sucursalLabel, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						sucursalLabel.setText("Sucursal");
					}
					{
						dcTextField = new JTextField();
						formularioPanel.add(dcTextField, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
					}
					{
						digcontrolLabel = new JLabel();
						formularioPanel.add(digcontrolLabel, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						digcontrolLabel.setText("        DC");
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
										System.out.println("Propietario ya existe, Exception in handler");
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
								/*InAux=null;
								modelo=null;*/
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
			this.setSize(455, 521);
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
		String nif = nifTextField.getText();		String direccion = direccionTextField.getText();
		String nombre = nombreTextField.getText();	String poblacion=pobTextField.getText();
		String telefono=telefTextField.getText(); 	String obs =obsEditorPane.getText();
		String email = emailTextField.getText();
		String sucursal=sucursalTextField.getText();
		String digitoControl=dcTextField.getText();
		if(nif.isEmpty() || nombre.isEmpty()){
		
			javax.swing.JOptionPane.showMessageDialog(null, "Los campos NIF y Nombre son obligatorios");
		
		}else if ((entidadTextField.getText().isEmpty() || !isInteger(entidadTextField.getText()))
				||(cuentaTextField.getText().isEmpty() || !isInteger(cuentaTextField.getText()))
				||(dcTextField.getText().isEmpty() || !isInteger(dcTextField.getText()))
				||(sucursalTextField.getText().isEmpty() || !isInteger(sucursalTextField.getText()))){
					javax.swing.JOptionPane.showMessageDialog(null, "Los campos Entidad,Sucursal,digito de control y Cuenta son cadenas numéricas no vacias");	
		}else{		
			int entidad = Integer.parseInt(entidadTextField.getText());
			int numcuenta = Integer.parseInt(cuentaTextField.getText());
			Calendar DiaSemana= Calendar.getInstance();
			String fechaalta=DiaSemana.get(Calendar.YEAR)+"-"+DiaSemana.get(Calendar.MONTH)+"-"+DiaSemana.get(Calendar.DAY_OF_MONTH);
			if(ControladorPropietario.getControladorPropietario().datosBancariosCorrectos(String.valueOf(entidad),sucursal,digitoControl,String.valueOf(numcuenta))){
				if(editMode==1){
					pAux.setNif(nif);					pAux.setEmail(email);
					pAux.setDireccion(direccion); 		pAux.setEntidad(entidad);
					pAux.setNombre(nombre); 			pAux.setPoblacion(poblacion);
					pAux.setTelefono(telefono); 		pAux.setObservaciones(obs);
					pAux.setNumerocuenta(numcuenta);	pAux.setFechaalta(fechaalta);
					pAux.setdigitocontrol(Integer.parseInt(digitoControl));
					pAux.setSucursal(Integer.parseInt(sucursal));
					try {
						ControladorPropietario.getControladorPropietario().actualizarPropietario(pAux);					
						VentanaComunidad.modeloProp.updateRow(rowAux,pAux);				
						VentanaComunidad.tablaProp.setModel(VentanaComunidad.modeloProp);
						VentanaComunidad.tablaProp.repaint();
					} catch (DAOExcepcion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					
					Propietario p=new Propietario(nif,nombre,poblacion,direccion,telefono,obs,entidad,numcuenta,email,Integer.parseInt(sucursal),Integer.parseInt(digitoControl));				
					try {
						p.setFechaalta(fechaalta);
						System.out.println("Fecha de alta asignada. Creando en controlador");
						ControladorPropietario.getControladorPropietario().NuevoPropietario(p);
						System.out.println("Creando en tabla");
						VentanaComunidad.modeloProp.addPropietario(p);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block				
						System.out.println("Error guardando el propietario");
						e.printStackTrace();
					}	
			}	
			dispose();
		}else{
			javax.swing.JOptionPane.showMessageDialog(null, "Error en formato datos bancaris:Entidad:4 digitos,Sucursal:4 digitos,DC:2digitos,Numero de cuenta:10 digitos.");	
			
		}
		}
	}		
}