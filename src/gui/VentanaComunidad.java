
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

import accesoAdatos._controladores.ControladorComunidad;

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
public class VentanaComunidad extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JButton delComButton;
	private JButton addComButton;
	private JPanel ComButtonPanel;
	public JScrollPane ComunidadesScrollPane;
	private static JLabel statusbar;
	private JPanel ComunidadesPanel;


	//Tipos para ChangeStatusBar
	public static int IN_BORRADO=0, NO_FILA=0;
	public static int IN_EXIS=1;
	public static int GUARDA=4;
	private JMenuItem ventanaNotas;
	private JSeparator jSeparator1;
	private JMenuItem ventanaPagos;
	private JMenuItem facturasTodas;
	private JMenuItem facturasComunidad;
	private JMenu generarFacturas;
	private JMenuItem ventanaFacturas;
	private JMenu facturaMenu;
	private JButton detalleButton;
	private JMenuItem InmueblesTodos;
	private JMenuItem InmueblesDeComunidad;
	private JMenuItem InmueblesDePropietario;
	private JMenu ListadoInmuebles;

	private JButton editInmButton;
	private JButton borrarInmButton;
	public static JButton addInmButton;
	private JPanel InmButtonPanel;
	private JScrollPane InmueblesScrollPane;
	private JPanel InmueblesPanel;
	private JButton editPropButton;
	private JButton borrarPropButton;
	
	private JScrollPane PropietariosScrollPane;
	private JPanel PropButtonPanel;
	private JPanel PropietariosPanel;
	public static JTabbedPane jTabbedPane1;
	private JButton addPropButton;
	private JMenuItem listaComunidades;
	private JMenuItem listaPropietarios;
	private JMenu jMenu1;
	private JMenuBar jMenuBar1;
	private JButton editComButton;
	public static int CARGA=5;

		//public static GestionInmuebles gestion = new GestionInmuebles();


	public static JTable tablaCom;
	public static JTable tablaProp;
	public static JTable tablaInm;
	
	public static ModeloTablaComunidad modeloCom = new ModeloTablaComunidad();
	public static ModeloTablaPropietario modeloProp = new ModeloTablaPropietario();
	public static ModeloTablaInmueble modeloInm = new ModeloTablaInmueble();
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaComunidad inst = new VentanaComunidad();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		
		});
	}
	
	public VentanaComunidad() {
		super();		
		initGUI();
		addInmButton.setEnabled(false);
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
				this.setTitle("Gestion Comunidad");
				{
					jTabbedPane1 = new JTabbedPane();
					getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
					jTabbedPane1.setPreferredSize(new java.awt.Dimension(684, 435));
					{
						ComunidadesPanel = new JPanel();
						jTabbedPane1.addTab("Comunidades", null, ComunidadesPanel, null);
						BorderLayout jPanelLayout = new BorderLayout();
						ComunidadesPanel.setLayout(jPanelLayout);
						
						{
							statusbar = new JLabel();
							ComunidadesPanel.add(statusbar, BorderLayout.SOUTH);
							statusbar.setText("jLabel1");
							estadofecha();
						}
						{
							ComunidadesScrollPane = new JScrollPane();
							ComunidadesPanel.add(ComunidadesScrollPane, BorderLayout.CENTER);
							{
								tablaCom = new JTable(modeloCom);
								tablaCom.setModel(modeloCom);
								ComunidadesScrollPane.setViewportView(tablaCom);
								tablaCom.setFillsViewportHeight(true);
							}
						}
						{
							ComButtonPanel = new JPanel();
							GridLayout jPanel1Layout = new GridLayout(6, 1);
							jPanel1Layout.setColumns(1);
							jPanel1Layout.setRows(6);
							jPanel1Layout.setHgap(5);
							jPanel1Layout.setVgap(20);
							ComunidadesPanel.add(ComButtonPanel, BorderLayout.EAST);
							ComButtonPanel.setLayout(jPanel1Layout);
							ComButtonPanel.setSize(110, 407);
							{
								addComButton = new JButton();
								ComButtonPanel.add(addComButton);
								addComButton.setText("Nuevo");
								addComButton.setName("addComButton");
								addComButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										VentanaComunidadNueva v=new VentanaComunidadNueva(modeloCom); 
										v.setVisible(true);								
									}
								});
							}
							{
								editComButton = new JButton();
								ComButtonPanel.add(editComButton);
								editComButton.setText("Editar");
								editComButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("editComButton.actionPerformed, event="+evt);
										//TODO add your code for editComButton.actionPerformed
										if(tablaCom.getRowCount()<1||tablaCom.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int rowSel = tablaCom.getSelectedRow();
											Comunidad  cAux=modeloCom.getComunidadPorPos(rowSel);
											System.out.println(cAux.getIdComunidad());
											VentanaComunidadNueva prop=new VentanaComunidadNueva(cAux,tablaCom.getSelectedRow());
											prop.setVisible(true);
										}
									}
								});
							}
							{
								delComButton = new JButton();
								ComButtonPanel.add(delComButton);
								delComButton.setText("Borrar");
								delComButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										if(tablaCom.getRowCount()<1||tablaCom.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int rowSel = tablaCom.getSelectedRow();
											Comunidad  cAux=modeloCom.getComunidadPorPos(rowSel);
											int op=OpcionesBorra(cAux.getIdComunidad(),"Comunidad");
											if(op==0){
												modeloCom.borraComunidadPorPosicion(tablaCom.getSelectedRow());													
												if(cAux == modeloInm.comunidad){
													modeloInm.limpiaTabla();
													addInmButton.setEnabled(false);
												}
												ChangeStatusBar(IN_BORRADO,cAux.getIdComunidad(),null);
												
											}
										}
									}
								});
							}
							{
								detalleButton = new JButton();
								ComButtonPanel.add(detalleButton);
								detalleButton.setText("Detalle");
								detalleButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("detalleButton.actionPerformed, event="+evt);
										//TODO add your code for detalleButton.actionPerformed																				
										if(tablaCom.getRowCount()<1||tablaCom.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int selRow = tablaCom.getSelectedRow();
											Comunidad c = ControladorComunidad.getControladorComunidad().getComunidadPorPos(selRow);											
											modeloInm.cargaInmueblesComunidad(c);
											addInmButton.setEnabled(true);
											jTabbedPane1.setSelectedIndex(2);
										}
									}
								});
							}
						}
					}
					{
						PropietariosPanel = new JPanel();
						BorderLayout PropietariosPanelLayout = new BorderLayout();
						PropietariosPanel.setLayout(PropietariosPanelLayout);
						jTabbedPane1.addTab("Propietarios", null, PropietariosPanel, null);
						{
							PropietariosScrollPane = new JScrollPane();
							PropietariosPanel.add(PropietariosScrollPane, BorderLayout.CENTER);
							{								
								tablaProp = new JTable(modeloProp);
								PropietariosScrollPane.setViewportView(tablaProp);
								tablaProp.setModel(modeloProp);
								tablaProp.setFillsViewportHeight(true);
							}
						}
						{
							PropButtonPanel = new JPanel();
							PropietariosPanel.add(PropButtonPanel, BorderLayout.EAST);
							GridLayout posicionBotonesPanel2Layout = new GridLayout(6, 1);
							posicionBotonesPanel2Layout.setHgap(5);
							posicionBotonesPanel2Layout.setVgap(20);
							posicionBotonesPanel2Layout.setColumns(1);
							posicionBotonesPanel2Layout.setRows(6);
							PropButtonPanel.setLayout(posicionBotonesPanel2Layout);
							{
								addPropButton = new JButton();
								PropButtonPanel.add(addPropButton);
								addPropButton.setText("Nuevo Propietario");
								addPropButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {								
										//TODO add your code for addPropButton.actionPerformed
										VentanaPropietario v=new VentanaPropietario(); 
										v.setVisible(true);	
									}
								});
								
							}
							{
								borrarPropButton = new JButton();
								PropButtonPanel.add(borrarPropButton);
								borrarPropButton.setText("Borrar Propietario");
								borrarPropButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										//System.out.println("borrarPropButton.actionPerformed, event="+evt);
										//TODO add your code for borrarPropButton.actionPerformed
										
										if(tablaProp.getRowCount()<1||tablaProp.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int rowSel = tablaProp.getSelectedRow();
											Propietario p = modeloProp.getPropietarioPorPosicion(rowSel);
											
											int op=OpcionesBorra(p.getIdPropietario(),"Propietario");
											if(op==0){
												
												if(p.getListaInmuebles().isEmpty()){
													modeloProp.borraPropietarioPorPosicion(tablaProp.getSelectedRow());
													ChangeStatusBar(IN_BORRADO,p.getIdPropietario(),null);
												}
												else{
													javax.swing.JOptionPane.showMessageDialog(null, "No se puede borrar un propietario si tiene inmuebles asociados.");
													
													
												}
											}
										}
									}
								});
							}
							{
								editPropButton = new JButton();
								PropButtonPanel.add(editPropButton);
								editPropButton.setText("Editar Propietario");
								editPropButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										if(tablaProp.getRowCount()<1||tablaProp.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											Propietario p=modeloProp.getPropietarioPorPosicion(tablaProp.getSelectedRow());
											System.out.println(p.getIdPropietario());
											VentanaPropietario prop=new VentanaPropietario(p,tablaProp.getSelectedRow());
											prop.setVisible(true);
										}
									}
								});
							}
						}
					}
					{
		
						InmueblesPanel = new JPanel();
						BorderLayout InmueblesPanelLayout = new BorderLayout();
						InmueblesPanel.setLayout(InmueblesPanelLayout);
						jTabbedPane1.addTab("Inmuebles", null, InmueblesPanel, null);
						{
							InmueblesScrollPane = new JScrollPane();
							InmueblesPanel.add(InmueblesScrollPane, BorderLayout.CENTER);
							{
								tablaInm = new JTable(modeloInm);
								InmueblesScrollPane.setViewportView(tablaInm);
								tablaInm.setModel(modeloInm);								
								tablaInm.setFillsViewportHeight(true);
							}
						}
						{
							InmButtonPanel = new JPanel();
							InmueblesPanel.add(InmButtonPanel, BorderLayout.EAST);
							GridLayout InmButtonPanelLayout = new GridLayout(6, 1);
							InmButtonPanelLayout.setHgap(5);
							InmButtonPanelLayout.setVgap(20);
							InmButtonPanelLayout.setColumns(1);
							InmButtonPanelLayout.setRows(6);
							InmButtonPanel.setLayout(InmButtonPanelLayout);
							InmButtonPanel.setSize(110, 407);
							{
								addInmButton = new JButton();
								InmButtonPanel.add(addInmButton);
								addInmButton.setText("Nuevo Inmueble");
								addInmButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										VentanaInmuebleDetalle v=new VentanaInmuebleDetalle(modeloInm.comunidad); 
										v.setVisible(true);
									}
								});
							}
							{
								borrarInmButton = new JButton();
								InmButtonPanel.add(borrarInmButton);
								borrarInmButton.setText("Borrar Inmueble");
								borrarInmButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										if(tablaInm.getRowCount()<1||tablaInm.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int selRow = tablaInm.getSelectedRow();
											Inmueble i = modeloInm.getInmueblePorPos(selRow);										
											int op=OpcionesBorra(i.getIdInmueble(),"Inmueble");
											if(op==0){
												modeloInm.borraInmueblePorPos(selRow);
												ChangeStatusBar(IN_BORRADO,i.getIdInmueble(),null);
											}
										}
									}
								});
							}
							{
								editInmButton = new JButton();
								InmButtonPanel.add(editInmButton);
								editInmButton.setText("Editar Inmueble");
								editInmButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										if(tablaInm.getRowCount()<1||tablaInm.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int selRow = tablaInm.getSelectedRow();
											Inmueble i = modeloInm.getInmueblePorPos(selRow);								
											VentanaInmuebleDetalle v=new VentanaInmuebleDetalle(selRow,i);
											v.setVisible(true);		
										}
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
							listaPropietarios = new JMenuItem();
							jMenu1.add(listaPropietarios);
							listaPropietarios.setText("Listado Propietarios");
							listaPropietarios.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ReportPropietarios report= new ReportPropietarios();
									report.muestraTodos();
								}
							});
						}
						{
							ListadoInmuebles = new JMenu();
							jMenu1.add(ListadoInmuebles);
							ListadoInmuebles.setText("Listado Inmuebles");
							{
								InmueblesDePropietario = new JMenuItem();
								ListadoInmuebles.add(InmueblesDePropietario);
								InmueblesDePropietario.setText("De Propietario");
								InmueblesDePropietario.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("InmueblesDePropietario.actionPerformed, event="+evt);
										//TODO add your code for InmueblesDePropietario.actionPerformed
										if(tablaProp.getRowCount()<1||tablaProp.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											ReportInmuebles report= new ReportInmuebles();
											int selRow = tablaProp.getSelectedRow();
											Propietario p = modeloProp.getPropietarioPorPosicion(selRow);
											report.muestraPorPropietario(p.getIdPropietario());
										}
									}
								});
							}
							{
								InmueblesDeComunidad = new JMenuItem();
								ListadoInmuebles.add(InmueblesDeComunidad);
								InmueblesDeComunidad.setText("De Comunidad");
								InmueblesDeComunidad.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("InmueblesDeComunidad.actionPerformed, event="+evt);
										//TODO add your code for InmueblesDePropietario.actionPerformed
										if(tablaCom.getRowCount()<1||tablaCom.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											ReportInmuebles report= new ReportInmuebles();
											int selRow = tablaCom.getSelectedRow();
											Comunidad c = modeloCom.getComunidadPorPos(selRow);				
											report.muestraPorComunidad(c.getIdComunidad());
										}
									}
								});
							}
							{
								InmueblesTodos = new JMenuItem();
								ListadoInmuebles.add(InmueblesTodos);
								InmueblesTodos.setText("Todos");
								InmueblesTodos.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("InmueblesTodos.actionPerformed, event="+evt);
										//TODO add your code for InmueblesDePropietario.actionPerformed
										ReportInmuebles report= new ReportInmuebles();
										report.muestraTodos();
									}
								});
							}
						}
						{
							listaComunidades = new JMenuItem();
							jMenu1.add(listaComunidades);
							listaComunidades.setText("Listado Comunidades");
							listaComunidades.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("listaComunidades.actionPerformed, event="+evt);
									//TODO add your code for listaComunidades.actionPerformed
									ReportComunidades report= new ReportComunidades();
									report.muestraTodos();
								}
							});
						}
					}
					{
						facturaMenu = new JMenu();
						jMenuBar1.add(facturaMenu);
						facturaMenu.setText("Pagos y Facturas");
						{
							ventanaFacturas = new JMenuItem();
							facturaMenu.add(ventanaFacturas);
							ventanaFacturas.setText("Gestion Facturas");
							ventanaFacturas.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("ventanaFacturas.actionPerformed, event="+evt);									
									//TODO add your code for detalleButton.actionPerformed									
									if(tablaCom.getRowCount()<1||tablaCom.getSelectedRow()==-1){
										MuestraMensaje(NO_FILA);										
									}else{
										int rowSel = tablaCom.getSelectedRow();
										Comunidad  caux=modeloCom.getComunidadPorPos(rowSel);
										System.out.println(caux.getIdComunidad());
										VentanaFacturas vF = new VentanaFacturas(caux);
										vF.setVisible(true);
									}									
								}
							});
						}
						{
							generarFacturas = new JMenu();
							facturaMenu.add(generarFacturas);
							generarFacturas.setText("Generar Facturas");
							{
								facturasComunidad = new JMenuItem();
								generarFacturas.add(facturasComunidad);
								facturasComunidad.setText("De Comunidad");
								facturasComunidad.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("facturasComunidad.actionPerformed, event="+evt);
										//TODO add your code for facturasComunidad.actionPerformed
										if(tablaCom.getRowCount()<1||tablaCom.getSelectedRow()==-1){
											MuestraMensaje(NO_FILA);										
										}else{
											int rowSel = tablaCom.getSelectedRow();
											Comunidad  caux=modeloCom.getComunidadPorPos(rowSel);
											System.out.println(caux.getIdComunidad());
											ReportFacturas report = new ReportFacturas();
											report.muestraPorComunidad(caux.getIdComunidad());
										}
									}
								});
							}
							{
								facturasTodas = new JMenuItem();
								generarFacturas.add(facturasTodas);
								facturasTodas.setText("Todas");
								facturasTodas.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										System.out.println("facturasTodas.actionPerformed, event="+evt);										
										ReportFacturas report= new ReportFacturas();
										report.muestraTodos();
									}
								});
							}
						}
						{
							jSeparator1 = new JSeparator();
							facturaMenu.add(jSeparator1);
						}
						{
							ventanaPagos = new JMenuItem();
							facturaMenu.add(ventanaPagos);
							ventanaPagos.setText("Gestion Pagos");
							ventanaPagos.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("ventanaPagos.actionPerformed, event="+evt);
									//TODO add your code for ventanaPagos.actionPerformed
									VentanaPagoRecibos v = new VentanaPagoRecibos();
									v.setVisible(true);
								}
							});
						}
						{
							ventanaNotas = new JMenuItem();
							facturaMenu.add(ventanaNotas);
							ventanaNotas.setText("Gestion Notas");
							ventanaNotas.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("ventanaNotas.actionPerformed, event="+evt);
									//TODO add your code for ventanaNotas.actionPerformed
									if(tablaCom.getRowCount()<1||tablaCom.getSelectedRow()==-1){
										MuestraMensaje(NO_FILA);										
									}else{
										int rowSel = tablaCom.getSelectedRow();
										Comunidad  cAux=modeloCom.getComunidadPorPos(rowSel);
										System.out.println(cAux.getIdComunidad());
										VentanaNotas v = new VentanaNotas(cAux);
										v.setVisible(true);
									}
								}
							});
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
			null,options,options[0]);    
		return n;
	}
	
	public static void Salir() {
			Object[] options = {"Si", "No"};
			int n = JOptionPane.showOptionDialog(
			null, "¿Desea Salir?",
			"Salir",
			JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,	null,
			options,options[0]);
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