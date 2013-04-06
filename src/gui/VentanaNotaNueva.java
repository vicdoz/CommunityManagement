package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
public class VentanaNotaNueva extends javax.swing.JFrame {
	private JPanel jContentPane;
	private JPanel jPanel1;
	private JLabel jLabel;
	private JTextField ComTextField;
	private JLabel ComLab;
	private JLabel fechaLabel;
	private JTextField fechaTextField;
	private JButton volverButton;
	private JButton guardarButton;
	private JPanel formularioPanel;
	private int editMode=0;
	private int rowAux;
	
	public static ModeloTablaFactura modelo = null;
	public static NotaInformativa nAux=new NotaInformativa();
	private Comunidad comunidad;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaNotaNueva inst = new VentanaNotaNueva();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);				
			}
		});
	}

	public VentanaNotaNueva() {
		super();
		initGUI();
	}
	public VentanaNotaNueva(Comunidad c) {
		super();
		this.comunidad = c;
		initGUI();
	}
	
	public VentanaNotaNueva(int row, NotaInformativa nI) {
		super();
		editMode=1;
		this.comunidad = nI.getComunidad();
		initGUI();
		fechaTextField.setText(nI.getFechaCalculo());		
		nAux = nI;
		
		this.rowAux=row;
	}

	
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
					jPanel1Layout.rowHeights = new int[] {7, 20};
					jPanel1Layout.columnWeights = new double[] {0.005, 0.1, 0.1};
					jPanel1Layout.rowWeights = new double[] {0.1, 0.1};
					jContentPane.add(formularioPanel, BorderLayout.CENTER);
					formularioPanel.setLayout(jPanel1Layout);
					formularioPanel.setPreferredSize(new java.awt.Dimension(384, 183));
					{
						fechaLabel = new JLabel();
						fechaLabel.setLayout(null);
						formularioPanel.add(fechaLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
						fechaLabel.setText("Fecha de Cálculo:");
					}
					{
						fechaTextField = new JTextField();
						formularioPanel.add(fechaTextField, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(nAux==null)	fechaTextField.setText("yyyy-mm-dd");
						
					}
					{
						ComLab = new JLabel();
						formularioPanel.add(ComLab, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						ComLab.setText("Comunidad");
					}
					{
						ComTextField = new JTextField();
						formularioPanel.add(ComTextField, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						ComTextField.setText(""+comunidad.getIdComunidad());
						ComTextField.setEnabled(false);		
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
								nAux=null;
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
			this.setSize(281, 197);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public boolean checkFecha( String input ){
		   	
		      return true;		   
		}
	private void guardarDatos() throws InmuebleYaExiste{
		String fecha = fechaTextField.getText();
		if(ComTextField.getText().isEmpty()	||fecha.isEmpty()){
			javax.swing.JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
		}else if(!checkFecha(fecha)) {
			javax.swing.JOptionPane.showMessageDialog(null, "El formato de fecha es incorrecto \n Ejemplo: 2013-03-20");
		}else{	
			int idCom = Integer.parseInt(ComTextField.getText());						
			if(ControladorComunidad.getControladorComunidad().getComunidadPorId(idCom)==null){
				javax.swing.JOptionPane.showMessageDialog(null, "Por favor introduzca un ID de Comunidad correcto");
			}else{			
				if(editMode==1){	
					nAux.setFechaCalculo(fecha);
					nAux.setComunidad(ControladorComunidad.getControladorComunidad().getComunidadPorId(idCom));					
					try {									
						ControladorNotaInformativa.getControladorNotaInformativa().actualizarNotaInformativa(nAux);
						VentanaNotas.notasModel.updateRow(rowAux, nAux);
						VentanaNotas.notasTable.setModel(VentanaNotas.notasModel);								
						dispose();
						
					} catch (DAOExcepcion e) {
						e.printStackTrace();
					}
					
				}
				else{
					NotaInformativa n = new NotaInformativa();
					n.setFechaCalculo(fecha);
					n.setComunidad(ControladorComunidad.getControladorComunidad().getComunidadPorId(
							Integer.parseInt(ComTextField.getText())));																								
					System.out.println(n.getIdNotaInformativa());
					try {		
						ControladorNotaInformativa.getControladorNotaInformativa().nuevaNotaInformativa(n);
						VentanaNotas.notasModel.addNotaInformativa(n);
						VentanaNotas.notasTable.setModel(VentanaNotas.notasModel);						
						dispose();
					} catch (DAOExcepcion e) {
						e.printStackTrace();
					}
				}
			}
		}
	}			
}
