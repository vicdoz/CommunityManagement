package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;

import reports.ReportCarta;
import reports.ReportFacturas;
import reports.ReportJustificantePago;

import excepciones.DAOExcepcion;

import accesoAdatos._controladores.ControladorReciboInmueble;

import negocio.Factura;
import negocio.Inmueble;
import negocio.Propietario;
import negocio.ReciboInmueble;
import negocio._tablas.ModeloTablaInmueble;
import negocio._tablas.ModeloTablaPropietario;
import negocio._tablas.ModeloTablaRecibo;


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
public class VentanaPagoRecibos extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JPanel recibosPanel;
	private JButton pagarReciboButton;
	private JTable recibosTable;
	private JScrollPane recibosScrollPane;
	private JPanel recibosButtonsPanel;
	private JTabbedPane propInmTabbedPane;
	private JButton enviarCartaButton;
	private JPanel propPanel;
	private JButton mostrarRecibosInmButton;
	private JButton mostrarListaInmueblesButton;
	private JTable inmTable;
	private JScrollPane inmScrollPane;
	private JPanel inmButtonsPanel;
	private JButton mostrarRecibosPropButton;
	private JButton mostrarInmPropButton;
	private JTable propTable;
	private JScrollPane propScrollPane;
	private JPanel propButtonsPanel;
	private JPanel inmPanel;
	
	public static ModeloTablaRecibo recibosModel = new ModeloTablaRecibo();
	public static ModeloTablaPropietario propModel = new ModeloTablaPropietario();
	public static ModeloTablaInmueble inmModel = new ModeloTablaInmueble();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaPagoRecibos inst = new VentanaPagoRecibos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VentanaPagoRecibos() {
		super();
		inmModel.cargaInmueblesTodos();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);						
			GridLayout thisLayout = new GridLayout(1, 1);
			thisLayout.setHgap(5);
			thisLayout.setVgap(5);
			thisLayout.setColumns(1);
			getContentPane().setLayout(thisLayout);
			this.setTitle("Gestion Pagos");
			{
				propInmTabbedPane = new JTabbedPane();
				getContentPane().add(propInmTabbedPane);
				propInmTabbedPane.setPreferredSize(new java.awt.Dimension(380, 331));
				{
					propPanel = new JPanel();
					BorderLayout propPanelLayout = new BorderLayout();
					propPanel.setLayout(propPanelLayout);
					propInmTabbedPane.addTab("Propietarios", null, propPanel, null);
					{
						propButtonsPanel = new JPanel();
						GridBagLayout propButtonsPanelLayout = new GridBagLayout();
						propButtonsPanelLayout.rowWeights = new double[] {0.1};
						propButtonsPanelLayout.rowHeights = new int[] {7};
						propButtonsPanelLayout.columnWeights = new double[] {0.1, 0.1};
						propButtonsPanelLayout.columnWidths = new int[] {7, 7};
						propPanel.add(propButtonsPanel, BorderLayout.NORTH);
						propButtonsPanel.setLayout(propButtonsPanelLayout);
						{
							mostrarInmPropButton = new JButton();
							propButtonsPanel.add(mostrarInmPropButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10, 5, 10), 0, 0));
							mostrarInmPropButton.setText("Inmuebles del propietario");
							mostrarInmPropButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("mostrarInmPropButton.actionPerformed, event="+evt);
									//TODO add your code for mostrarInmPropButton.actionPerformed
									if(propTable.getRowCount()<1||propTable.getSelectedRow()==-1){
                                        javax.swing.JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");                                                                            
									}else{
                                        int rowSel = propTable.getSelectedRow();
                                        Propietario pAux = propModel.getPropietarioPorPosicion(rowSel);                                                                                                                 
                                        inmModel.cargaInmueblesPropietario(pAux); 
										propInmTabbedPane.setSelectedIndex(1);
									}
								}
							});
						}
						{
							mostrarRecibosPropButton = new JButton();
							propButtonsPanel.add(mostrarRecibosPropButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10, 5, 10), 0, 0));
							mostrarRecibosPropButton.setText("Recibos del Propietario");
							mostrarRecibosPropButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("mostrarRecibosPropButton.actionPerformed, event="+evt);
									//TODO add your code for mostrarRecibosPropButton.actionPerformed
                                    if(propTable.getRowCount()<1||propTable.getSelectedRow()==-1){
                                        javax.swing.JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");                                                                            
                                    }else{
                                        int rowSel = propTable.getSelectedRow();
                                        Propietario pAux = propModel.getPropietarioPorPosicion(rowSel); 
                                        recibosModel.cargaRecibosPropietario(pAux);
                                        recibosTable.setModel(recibosModel);                                          
                                    }
								}
							});
						}
					}
					{
						propScrollPane = new JScrollPane();
						propPanel.add(propScrollPane, BorderLayout.CENTER);
						{
					        propTable = new JTable(propModel);
                            propTable.setModel(propModel);                                                                                          
                            propScrollPane.setViewportView(propTable);
                            propTable.setSize(250, 200);    
                            
                            propTable.removeColumn(propTable.getColumnModel().getColumn(9));        propTable.removeColumn(propTable.getColumnModel().getColumn(8));
                            propTable.removeColumn(propTable.getColumnModel().getColumn(7));        propTable.removeColumn(propTable.getColumnModel().getColumn(6));
                            propTable.removeColumn(propTable.getColumnModel().getColumn(5));        propTable.removeColumn(propTable.getColumnModel().getColumn(4));
                            propTable.removeColumn(propTable.getColumnModel().getColumn(3));        propTable.removeColumn(propTable.getColumnModel().getColumn(1));
                            propTable.getColumnModel().getColumn(0).setMaxWidth(40);
                            						
							propTable.setFillsViewportHeight(true);
						}
					}
				}
				{
					inmPanel = new JPanel();
					BorderLayout inmPanelLayout = new BorderLayout();
					inmPanel.setLayout(inmPanelLayout);
					propInmTabbedPane.addTab("Inmuebles", null, inmPanel, null);
					{
						inmButtonsPanel = new JPanel();
						GridBagLayout inmButtonsPanelLayout = new GridBagLayout();
						inmButtonsPanelLayout.rowWeights = new double[] {0.1};
						inmButtonsPanelLayout.rowHeights = new int[] {7};
						inmButtonsPanelLayout.columnWeights = new double[] {0.1, 0.1};
						inmButtonsPanelLayout.columnWidths = new int[] {7, 7};
						inmPanel.add(inmButtonsPanel, BorderLayout.NORTH);
						inmButtonsPanel.setLayout(inmButtonsPanelLayout);
						{
							mostrarListaInmueblesButton = new JButton();
							inmButtonsPanel.add(mostrarListaInmueblesButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10, 5, 10), 0, 0));
							mostrarListaInmueblesButton.setText("Ver todos los Inmuebles");
							mostrarListaInmueblesButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("mostrarListaInmueblesButton.actionPerformed, event="+evt);
									//TODO add your code for mostrarListaInmueblesButton.actionPerformed
									inmModel.cargaInmueblesTodos();
                                    inmTable.setModel(inmModel);
								}
							});
						}
						{
							mostrarRecibosInmButton = new JButton();
							inmButtonsPanel.add(mostrarRecibosInmButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10, 5, 10), 0, 0));
							mostrarRecibosInmButton.setText("Recibos del Inmueble");
							mostrarRecibosInmButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("mostrarRecibosInmButton.actionPerformed, event="+evt);
									//TODO add your code for mostrarRecibosInmButton.actionPerformed
									if(inmTable.getRowCount()<1||inmTable.getSelectedRow()==-1){
                                        javax.swing.JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");                                                                            
									}else{
                                        int rowSel = inmTable.getSelectedRow();
                                        Inmueble iAux = inmModel.getInmueblePorPos(rowSel);
                                        recibosModel.cargaRecibosInmueble(iAux);
                                        recibosTable.setModel(recibosModel);
									}
								}
							});
						}
					}
					{
						inmScrollPane = new JScrollPane();
						inmPanel.add(inmScrollPane, BorderLayout.CENTER);
						{
							inmTable = new JTable(inmModel);
                            inmTable.setModel(inmModel);
                            inmScrollPane.setViewportView(inmTable);
                            inmTable.setFillsViewportHeight(true);                            
						}
					}
				}
			}
			{
				recibosPanel = new JPanel();
				getContentPane().add(recibosPanel);
				BorderLayout mainLayoutLayout = new BorderLayout();
				recibosPanel.setLayout(mainLayoutLayout);
				recibosPanel.setPreferredSize(new java.awt.Dimension(314, 331));
				recibosPanel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, true));
				{
					recibosButtonsPanel = new JPanel();
					GridBagLayout recibosButtonsPanelLayout = new GridBagLayout();
					recibosButtonsPanelLayout.rowWeights = new double[] {0.1, 0.1};
					recibosButtonsPanelLayout.rowHeights = new int[] {7, 7};
					recibosButtonsPanelLayout.columnWeights = new double[] {0.1};
					recibosButtonsPanelLayout.columnWidths = new int[] {7};
					recibosPanel.add(recibosButtonsPanel, BorderLayout.SOUTH);
					recibosButtonsPanel.setLayout(recibosButtonsPanelLayout);
					{
						pagarReciboButton = new JButton();
						recibosButtonsPanel.add(pagarReciboButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10, 5, 10), 0, 0));
						pagarReciboButton.setText("Pagar Recibo");
						pagarReciboButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("pagarReciboButton.actionPerformed, event="+evt);
								//TODO add your code for pagarReciboButton.actionPerformed
								if(recibosTable.getRowCount()<1||recibosTable.getSelectedRow()==-1){
									javax.swing.JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");									
								}else{
									int rowSel = recibosTable.getSelectedRow();
									int idRecibo = Integer.parseInt(recibosTable.getValueAt(rowSel, 0).toString());
									ReciboInmueble rAux = recibosModel.getReciboPorId(idRecibo);	
									System.out.println(rAux.getIdRecibo()+","+rAux.getImporte()+","+rAux.getFechaPago()+".");
									if(rAux.getFechaPago().isEmpty() ||rAux.getFechaPago().trim().equals("")){
										Calendar DiaSemana = Calendar.getInstance();
										String fechaPago = DiaSemana.get(Calendar.YEAR)+"-"+DiaSemana.get(Calendar.MONTH)+"-"+DiaSemana.get(Calendar.DAY_OF_MONTH);
										rAux.setFechaPago(fechaPago);
										try {
											ControladorReciboInmueble.getControladorReciboInmueble().actualizarReciboInmueble(rAux);
											recibosModel.updateRow(rowSel, rAux);
											recibosTable.setModel(recibosModel);
										} catch (DAOExcepcion e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										ReportJustificantePago report= new ReportJustificantePago();										
										report.muestraJustificantePorIdRecibo(idRecibo);
										/*Repintar tabla*/
										inmModel.cargaInmueblesTodos();
									}else{
										javax.swing.JOptionPane.showMessageDialog(null, "Este recibo ya está pagado");
									}
								}
							}
						});
					}
					{
						enviarCartaButton = new JButton();
						recibosButtonsPanel.add(enviarCartaButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10, 5, 10), 0, 0));
						enviarCartaButton.setText("Enviar Carta");
						enviarCartaButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("enviarCartaButton.actionPerformed, event="+evt);
								//TODO add your code for enviarCartaButton.actionPerformed
								if(recibosTable.getRowCount() > 0){
									ReportCarta report= new ReportCarta();
									int idRecibo = Integer.parseInt(recibosTable.getValueAt(0, 0).toString());
									ReciboInmueble rAux = recibosModel.getReciboPorId(idRecibo);	
									report.crearCartaPropietario(rAux.getInmueble().getPropietario().getIdPropietario());
								}else{
									javax.swing.JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Propietario previamente");
								}								
							}
						});
					}
				}
				{
					recibosScrollPane = new JScrollPane();
					recibosPanel.add(recibosScrollPane, BorderLayout.CENTER);
					recibosScrollPane.setPreferredSize(new java.awt.Dimension(342, 276));
					{
						recibosTable = new JTable(recibosModel);                                                
                        recibosTable.setModel(recibosModel);
                        recibosScrollPane.setViewportView(recibosTable);
                        recibosTable.setFillsViewportHeight(true);                        
					}
				}
			}
			pack();
			this.setSize(710, 369);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
