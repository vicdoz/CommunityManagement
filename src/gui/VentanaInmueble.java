
package gui;

import negocio.*;
import negocio._tablas.*;

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
import java.awt.Color;


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
public class VentanaInmueble extends javax.swing.JFrame {

	private JButton abrirButton;
	private JToolBar jToolBarBar;
	private JButton detalleButton;
	private JButton delButton;
	private JButton addButton;
	private JPanel posicionBotonesPanel;
	public JScrollPane jScrollPane;
	private static JLabel statusbar;
	private JPanel jPanel;
		
	//Tipos para ChangeStatusBar
	public static int IN_BORRADO=0, NO_FILA=0;
	public static int IN_EXIS=1;
	public static int GUARDA=4;
	private JTable tablaInmueble;
	private JButton mostrarRecibos;
	private JButton mostrarFacturas;
	private JButton editButton;
	public static int CARGA=5;

	//public static GestionInmuebles gestion = new GestionInmuebles();
	public static Comunidad comunidad;
	public static ModeloTablaInmueble modelo = new ModeloTablaInmueble();
	public static JTable tabla;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaInmueble inst = new VentanaInmueble(comunidad);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		
		});
	}
	
	@SuppressWarnings("static-access")
	public VentanaInmueble(Comunidad c) {
		super();
		this.comunidad=c;
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
				this.setTitle("Gestion Comunidad - Inmuebles");
			}
			{
				jPanel = new JPanel();
				BorderLayout jPanelLayout = new BorderLayout();
				getContentPane().add(jPanel, BorderLayout.CENTER);
				jPanel.setLayout(jPanelLayout);

				{
					statusbar = new JLabel();
					jPanel.add(statusbar, BorderLayout.SOUTH);
					statusbar.setText("jLabel1");
					estadofecha();
				}
				{
					jScrollPane = new JScrollPane();
					jPanel.add(jScrollPane, BorderLayout.CENTER);
					{
						TableModel tablaInmuebleModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] {"Escalera", "Piso", "Puerta","Partic.", "Propietario" });
						tablaInmueble = new JTable();
						jScrollPane.setViewportView(tablaInmueble);
						tablaInmueble.setModel(tablaInmuebleModel);
						tablaInmueble.setPreferredSize(new java.awt.Dimension(631, -8));
					}
					{
						tabla = new JTable(new ModeloTablaInmueble());
						tabla.setModel(modelo);
						jScrollPane.setViewportView(tabla);

					}
				}
				{
					posicionBotonesPanel = new JPanel();
					GridLayout jPanel1Layout = new GridLayout(6, 1);
					jPanel1Layout.setColumns(1);
					jPanel1Layout.setRows(6);
					jPanel1Layout.setHgap(5);
					jPanel1Layout.setVgap(20);
					jPanel.add(posicionBotonesPanel, BorderLayout.EAST);
					posicionBotonesPanel.setLayout(jPanel1Layout);
					{
						addButton = new JButton();
						posicionBotonesPanel.add(addButton);
						addButton.setText("Nuevo");
						addButton.setName("addButton");
						addButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								VentanaInmuebleDetalle v=new VentanaInmuebleDetalle(modelo,comunidad); 
								v.setVisible(true);								
							}
						});
					}
					{
						editButton = new JButton();
						posicionBotonesPanel.add(editButton);
						editButton.setText("Editar");
						editButton.setEnabled(true);
						editButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(tabla.getRowCount()<1||tabla.getSelectedRow()==-1){
									MuestraMensaje(NO_FILA);										
								}else{
									int selRow = tabla.getSelectedRow();
									Inmueble i = modelo.getInmueblePorPos(selRow);								
									VentanaInmuebleDetalle v=new VentanaInmuebleDetalle(selRow,i);
									v.setVisible(true);														
								}
							}
						});
					}
					{
						delButton = new JButton();
						posicionBotonesPanel.add(delButton);
						delButton.setText("Borrar");
						delButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(tabla.getRowCount()<1||tabla.getSelectedRow()==-1){
									MuestraMensaje(NO_FILA);										
								}else{
									int selRow = tabla.getSelectedRow();
									Inmueble i = modelo.getInmueblePorPos(selRow);										
									int op=OpcionesBorra(i.getIdInmueble());
									if(op==0){
										modelo.borraInmueblePorPos(selRow);
										ChangeStatusBar(IN_BORRADO,i.getIdInmueble(),null);										
									}
								}
							}															
						});
					}
				}
				{
					jToolBarBar = new JToolBar();
					jPanel.add(jToolBarBar, BorderLayout.NORTH);
					{
						abrirButton = new JButton();
						jToolBarBar.add(abrirButton);
						abrirButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gui/openFile.png")));
						abrirButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//CargaBD();
							}
						});
					}
					{
						mostrarFacturas = new JButton();
						jToolBarBar.add(mostrarFacturas);
						mostrarFacturas.setText("Facturas");
					}
					{
						mostrarRecibos = new JButton();
						jToolBarBar.add(mostrarRecibos);
						mostrarRecibos.setText("Recibos");
					}
				}
			}
			this.setSize(700, 500);
			//Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ChangeColor(Color col,int bac){
		if(bac==1){			
			tabla.setBackground(col);posicionBotonesPanel.setBackground(col);
			addButton.setBackground(col);delButton.setBackground(col);
			detalleButton.setBackground(col);jToolBarBar.setBackground(col);
		}else{			
			tabla.setForeground(col);posicionBotonesPanel.setForeground(col);
			addButton.setForeground(col);delButton.setForeground(col);
			detalleButton.setForeground(col);jToolBarBar.setForeground(col);
		}
	}
	public static int OpcionesBorra(int id){
		Object[] options = {"Sí", "No"};
		int n = JOptionPane.showOptionDialog(
			null, "Esta a punto de borrar el inmueble "+id+
					"\n ¿Desea continuar?","Borrar Inmueble",
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
			case 2:
				statusbar.setText("Color texto cambiado");
				break;
			case 3:
				statusbar.setText("Color fondo cambiado");
				break;
			case 4:
				statusbar.setText("Fichero guardado en "+auxstr);
				break;
			case 5:
				statusbar.setText("Fichero cargado de "+auxstr);
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