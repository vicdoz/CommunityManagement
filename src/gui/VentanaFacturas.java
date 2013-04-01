
package gui;

import negocio.*;
import negocio._tablas.*;
import reports.*;
//import org.jdesktop.application.Application;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;


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
public class VentanaFacturas extends javax.swing.JFrame {

	private JButton delFactButton;
	private JButton addFactButton;
	private JPanel factButtonPanel;
	public JScrollPane facturasScrollPane;
	private static JLabel statusbar;
	private JPanel facturasPanel;


	//Tipos para ChangeStatusBar
	public static int IN_BORRADO=0, NO_FILA=0;
	public static int IN_EXIS=1;
	public static int GUARDA=4;
	private JPanel facturaDetallePanel;
	private JButton delLineaButton;
	private JButton editLineaButton;
	private JButton addLineaButton;
	private JPanel detalleButtonPanel;
	private JScrollPane detalleScrollPane;
	private JMenuItem listaFacturaDetalle;
	private JMenu listaFacturas;

	private JButton editConcButton;
	private JButton borrarConcButton;
	
	private JScrollPane conceptosScrollPane;
	private JPanel concButtonPanel;
	private JPanel conceptosPanel;
	private JTabbedPane jTabbedPane1;
	private JButton addConcButton;
	private JMenuItem listaFacturasTodas;
	private JMenuItem listaConceptos;
	private JMenu jMenu1;
	private JMenuBar jMenuBar1;
	private JButton editFactButton;
	public static int CARGA=5;

		//public static GestionInmuebles gestion = new GestionInmuebles();


	public static JTable tablaFact;
	public static JTable tablaConc;
	public static JTable tablaFactDet;
	public static ModeloTablaFactura modeloFact = new ModeloTablaFactura();
	public static ModeloTablaConcepto modeloConc = new ModeloTablaConcepto();	
	public static ModeloTablaFacturaDetalle modeloFactDet = new ModeloTablaFacturaDetalle();
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaFacturas inst = new VentanaFacturas();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		
		});
	}
	
	public VentanaFacturas() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						Salir();
					}
				});
				this.setResizable(true);
				this.setEnabled(true);
				this.setTitle("Gestion Facturas");
				{
					jTabbedPane1 = new JTabbedPane();
					getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
					jTabbedPane1.setPreferredSize(new java.awt.Dimension(684, 435));
					{
						facturasPanel = new JPanel();
						jTabbedPane1.addTab("Facturas", null, facturasPanel, null);
						BorderLayout jPanelLayout = new BorderLayout();
						facturasPanel.setLayout(jPanelLayout);
						
						{
							statusbar = new JLabel();
							facturasPanel.add(statusbar, BorderLayout.SOUTH);
							statusbar.setText("jLabel1");
							estadofecha();
						}
						{
							facturasScrollPane = new JScrollPane();
							facturasPanel.add(facturasScrollPane, BorderLayout.CENTER);
							{
								tablaFact = new JTable(modeloFact);
								tablaFact.setModel(modeloFact);
								facturasScrollPane.setViewportView(tablaFact);
								tablaFact.setFillsViewportHeight(true);
							}
						}
						{
							factButtonPanel = new JPanel();
							GridLayout jPanel1Layout = new GridLayout(6, 1);
							jPanel1Layout.setColumns(1);
							jPanel1Layout.setRows(6);
							jPanel1Layout.setHgap(5);
							jPanel1Layout.setVgap(20);
							facturasPanel.add(factButtonPanel, BorderLayout.EAST);
							factButtonPanel.setLayout(jPanel1Layout);
							factButtonPanel.setSize(110, 407);
							{
								addFactButton = new JButton();
								factButtonPanel.add(addFactButton);
								addFactButton.setText("Nueva");
								addFactButton.setName("addFactButton");
								addFactButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {

									}
								});
							}
							{
								editFactButton = new JButton();
								factButtonPanel.add(editFactButton);
								editFactButton.setText("Editar");
								editFactButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("editFactButton.actionPerformed, event="+evt);
										//TODO add your code for editFactButton.actionPerformed
									}
								});
							}
							{
								delFactButton = new JButton();
								factButtonPanel.add(delFactButton);
								delFactButton.setText("Borrar factura");
								delFactButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										//TODO add your code for editFactButton.actionPerformed
										if(tablaFact.getRowCount()<1||tablaFact.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int rowSel = tablaFact.getSelectedRow();
											Factura  fAux=modeloFact.getFacturaPorPos(rowSel);
											int op=OpcionesBorra(fAux.getidFactura(),"Factura");
											if(op==0){
												modeloFact.borraFacturaPorPos(tablaFact.getSelectedRow());
												ChangeStatusBar(IN_BORRADO,fAux.getidFactura(),null);
												
											}
										}
									}
								});
							}
						}
					}
					{
						conceptosPanel = new JPanel();
						jTabbedPane1.addTab("Conceptos", null, conceptosPanel, null);
						BorderLayout PropietariosPanelLayout = new BorderLayout();
						conceptosPanel.setLayout(PropietariosPanelLayout);
						{
							conceptosScrollPane = new JScrollPane();
							conceptosPanel.add(conceptosScrollPane, BorderLayout.CENTER);
							{								
								tablaConc = new JTable(modeloConc);
								conceptosScrollPane.setViewportView(tablaConc);
								tablaConc.setModel(modeloConc);
								tablaConc.setFillsViewportHeight(true);
								tablaConc.getColumnModel().getColumn(0).setMaxWidth(100);
								tablaConc.getColumnModel().getColumn(1).setMaxWidth(150);
							}
						}
						{
							concButtonPanel = new JPanel();
							conceptosPanel.add(concButtonPanel, BorderLayout.EAST);
							GridLayout posicionBotonesPanel2Layout = new GridLayout(6, 1);
							posicionBotonesPanel2Layout.setHgap(5);
							posicionBotonesPanel2Layout.setVgap(20);
							posicionBotonesPanel2Layout.setColumns(1);
							posicionBotonesPanel2Layout.setRows(6);
							concButtonPanel.setLayout(posicionBotonesPanel2Layout);
							{
								addConcButton = new JButton();
								concButtonPanel.add(addConcButton);
								addConcButton.setText("Nuevo");
								addConcButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {								
										//TODO add your code for addConcButton.actionPerformed
										VentanaConcepto v=new VentanaConcepto(); 
										v.setVisible(true);	
									}
								});
								
							}
							{
								borrarConcButton = new JButton();
								concButtonPanel.add(borrarConcButton);
								borrarConcButton.setText("Borrar");
								borrarConcButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										//System.out.println("borrarConcButton.actionPerformed, event="+evt);
										if(tablaConc.getRowCount()<1||tablaConc.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int rowSel = tablaConc.getSelectedRow();
											Concepto  cAux=modeloConc.getConceptoPorPos(rowSel);
											int op=OpcionesBorra(cAux.getIdConcepto(),"Concepto");
											if(op==0){
												modeloConc.borraConceptoPorPos(tablaConc.getSelectedRow());
												ChangeStatusBar(IN_BORRADO,cAux.getIdConcepto(),null);
												
											}
										}
										
									}
								});
							}
							{
								editConcButton = new JButton();
								concButtonPanel.add(editConcButton);
								editConcButton.setText("Editar");
								editConcButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										if(tablaConc.getRowCount()<1||tablaConc.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int rowSel = tablaConc.getSelectedRow();
											Concepto cAux = modeloConc.getConceptoPorPos(rowSel);
											System.out.println(cAux.getIdConcepto());
											VentanaConcepto v=new VentanaConcepto(cAux,tablaConc.getSelectedRow());
											v.setVisible(true);
										}
									}
								});
							}
						}
					}
					{
						facturaDetallePanel = new JPanel();
						BorderLayout facturaDetallePanelLayout = new BorderLayout();
						jTabbedPane1.addTab("Líneas", null, facturaDetallePanel, null);
						facturaDetallePanel.setLayout(facturaDetallePanelLayout);
						{
							detalleScrollPane = new JScrollPane();
							facturaDetallePanel.add(detalleScrollPane, BorderLayout.CENTER);
							{
								tablaFactDet = new JTable(modeloFactDet);
								tablaFactDet.setModel(modeloFactDet);
								detalleScrollPane.setViewportView(tablaFactDet);						
								tablaFactDet.setFillsViewportHeight(true);
								tablaFactDet.getColumnModel().getColumn(0).setMaxWidth(50);
							}
						}
						{
							detalleButtonPanel = new JPanel();
							GridLayout detalleButtonPanelLayout = new GridLayout(6, 1);
							detalleButtonPanelLayout.setHgap(5);
							detalleButtonPanelLayout.setVgap(20);
							detalleButtonPanelLayout.setColumns(1);
							detalleButtonPanelLayout.setRows(6);
							facturaDetallePanel.add(detalleButtonPanel, BorderLayout.EAST);
							detalleButtonPanel.setLayout(detalleButtonPanelLayout);
							{
								addLineaButton = new JButton();
								detalleButtonPanel.add(addLineaButton);
								addLineaButton.setText("Nueva Linea");
								addLineaButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("addLineaButton.actionPerformed, event="+evt);
										//TODO add your code for addLineaButton.actionPerformed
									}
								});
							}
							{
								editLineaButton = new JButton();
								detalleButtonPanel.add(editLineaButton);
								editLineaButton.setText("Edita Linea");
								editLineaButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("editLineaButton.actionPerformed, event="+evt);
										//TODO add your code for editLineaButton.actionPerformed
									}
								});
							}
							{
								delLineaButton = new JButton();
								detalleButtonPanel.add(delLineaButton);
								delLineaButton.setText("Borrar Linea");
								delLineaButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("delLineaButton.actionPerformed, event="+evt);
										//TODO add your code for delLineaButton.actionPerformed
									}
								});
							}
						}
					}
				}
				{
					jMenuBar1 = new JMenuBar();
					setJMenuBar(jMenuBar1);
					{
						jMenu1 = new JMenu();
						jMenuBar1.add(jMenu1);
						jMenu1.setText("Generar Informes");
						{
							listaConceptos = new JMenuItem();
							jMenu1.add(listaConceptos);
							listaConceptos.setText("Listado Conceptos");
							listaConceptos.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ReportConceptos report = new ReportConceptos();
									report.muestraTodos();
								}
							});
						}
						{
							listaFacturas = new JMenu();
							jMenu1.add(listaFacturas);
							listaFacturas.setText("Listado Facturas");
							{
								listaFacturaDetalle = new JMenuItem();
								listaFacturas.add(listaFacturaDetalle);
								listaFacturaDetalle.setText("Detalle Factura");
								listaFacturaDetalle.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("listaFacturaDetalle.actionPerformed, event="+evt);										
										if(tablaFact.getRowCount()<1||tablaFact.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											ReportFacturas report= new ReportFacturas();
											int rowSel = tablaFact.getSelectedRow();
											Factura f = modeloFact.getFacturaPorPos(rowSel);
											report.muestraDetalle(f.getidFactura());
										}
									}
								});
							}
							{
								listaFacturasTodas = new JMenuItem();
								listaFacturas.add(listaFacturasTodas);
								listaFacturasTodas.setText("Todas");
								listaFacturasTodas.setBounds(0, 21, 110, 21);
								listaFacturasTodas.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("listaFacturasTodas.actionPerformed, event="+evt);
										ReportFacturas report= new ReportFacturas();
										report.muestraTodos();
									}
								});
							}
						}
					}
				}
			}
			this.setSize(700, 500);
			//Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int OpcionesBorra(int id, String tipo){ 
		Object[] options = {"Sí", "No"};		
		int n = JOptionPane.showOptionDialog(
			null, "Esta a punto de borrar el "+tipo+" "+id+
					"\n ¿Desea continuar?","Borrar "+tipo,
			JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
			null,options,options[1]);    
		return n;
	}
	
	public static void Salir() {
			Object[] options = {"Si", "No"};
			int n = JOptionPane.showOptionDialog(
			null, "¿Desea Salir?",
			"Salir",
			JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,	null,
			options,options[1]);
			if(n == 0)		System.exit(0);
	}
	public static void MuestraMensaje(int tipo){
		switch(tipo){
			case 0:
				javax.swing.JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
				break;
			case 1:
				javax.swing.JOptionPane.showMessageDialog(null, 
						"El ID del inmueble ya existe. \n " +"Seleccione otro por favor");
				break;
			default:
				break;
		}
	}
	public static void ChangeStatusBar(int tipo,int auxint,String auxstr){
		switch(tipo){
			case 0:
				statusbar.setText("Inmueble "+auxint+" borrado");
				break;
			case 1:
				statusbar.setText("Inmueble "+auxint+" aÃ±adido");
				break;
			case 9:
				estadofecha();
				break;
			default:
				break;
		}
	}
	public static void estadofecha() {
		Calendar DiaSemana= Calendar.getInstance();
		int NumeroDia;
		NumeroDia=DiaSemana.get(Calendar.DAY_OF_WEEK);
		String DiaSemanaLetra="";
		if (NumeroDia==1){DiaSemanaLetra="Domingo";}
		else if(NumeroDia==2){DiaSemanaLetra="Lunes";}
		else if(NumeroDia==3){DiaSemanaLetra="Martes";}
		else if(NumeroDia==4){DiaSemanaLetra="MiÃ©rcoles";}
		else if(NumeroDia==5){DiaSemanaLetra="Jueves";}
		else if(NumeroDia==6){DiaSemanaLetra="Viernes";}
		else if(NumeroDia==7){DiaSemanaLetra="SÃ¡bado";}
		Calendar DiaMes= Calendar.getInstance();
		int NumeroMes;
		NumeroMes=DiaMes.get(Calendar.MONTH);
		String DiaMesLetra="";
		if (NumeroMes==0){DiaMesLetra="Enero";}
		else if(NumeroMes==1){DiaMesLetra="Febrero";}
		else if(NumeroMes==2){DiaMesLetra="Marzo";}
		else if(NumeroMes==3){DiaMesLetra="Abril";}
		else if(NumeroMes==4){DiaMesLetra="Mayo";}
		else if(NumeroMes==5){DiaMesLetra="Junio";}
		else if(NumeroMes==6){DiaMesLetra="Julio";}
		else if(NumeroMes==7){DiaMesLetra="Agosto";}
		else if(NumeroMes==8){DiaMesLetra="Septiembre";}
		else if(NumeroMes==9){DiaMesLetra="Octubre";}
		else if(NumeroMes==10){DiaMesLetra="Noviembre";}
		else if(NumeroMes==11){DiaMesLetra="Diciembre";}
		statusbar.setText(DiaSemanaLetra + ", " + DiaMes.get(Calendar.DAY_OF_MONTH) + " de " + DiaMesLetra + " " + DiaMes.get(Calendar.YEAR));
	}
}