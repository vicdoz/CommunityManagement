package gui;

import negocio._tablas.*;
import negocio.Comunidad;
import negocio.NotaInformativa;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import accesoAdatos._controladores.ControladorNotaInformativa;


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
public class VentanaNotas extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar notasMenuBar;
	private JPanel leftOrRightPanel;
	private JScrollPane factsPendPane;
	private JButton detNotasButton;
	private JButton delNotasButton;
	private JButton editNotasButton;
	private JButton addNotasButton;
	private JPanel notasPanelButtons;
	private JMenuItem genSelNotaReport;
	private JMenuItem genAllNotaReport;
	private JButton all2leftButton;
	private JButton all2rightButton;
	private JButton genNotaButton;
	private JButton right2leftButton;
	private JButton left2rightButton;
	private JScrollPane factsSelPane;
	private JScrollPane notasScrollPane;
	private JPanel factsPanel;
	private JPanel notasPane;
	private JTabbedPane notasTabbedPane;
	private JMenu jMenu1;
	
	private Comunidad cAux;
	
	public JTable notasTable;
	public JTable factsPendTable;
	public JTable factsSelTable;
	public static ModeloTablaNotas notasModel = new ModeloTablaNotas();
	public static ModeloTablaFactura factsPendModel = new ModeloTablaFactura();
	public static ModeloTablaFactura factsSelModel = new ModeloTablaFactura();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaNotas inst = new VentanaNotas();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VentanaNotas() {
		super();
		initGUI();
	}
	public VentanaNotas(Comunidad c) {
		super();
		this.cAux = c;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Gestion Notas");
			{
				notasTabbedPane = new JTabbedPane();
				getContentPane().add(notasTabbedPane, BorderLayout.CENTER);
				{
					notasPane = new JPanel();
					BorderLayout notasPaneLayout = new BorderLayout();
					notasPane.setLayout(notasPaneLayout);
					notasTabbedPane.addTab("Notas", null, notasPane, null);
					{
						notasScrollPane = new JScrollPane();
						notasPane.add(notasScrollPane, BorderLayout.CENTER);
						{					
							notasTable = new JTable(notasModel);
							notasTable.setModel(notasModel);
							notasScrollPane.setViewportView(notasTable);
							notasTable.setFillsViewportHeight(true);
							
						}
					}
					{
						notasPanelButtons = new JPanel();
						GridLayout notasPaneButtonsLayout = new GridLayout(6, 1);
						notasPaneButtonsLayout.setHgap(5);
						notasPaneButtonsLayout.setVgap(20);
						notasPaneButtonsLayout.setColumns(1);
						notasPaneButtonsLayout.setRows(6);
						notasPane.add(notasPanelButtons, BorderLayout.EAST);
						notasPanelButtons.setLayout(notasPaneButtonsLayout);
						{
							addNotasButton = new JButton();
							notasPanelButtons.add(addNotasButton);
							addNotasButton.setText("Nueva");
							addNotasButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("addNotasButton.actionPerformed, event="+evt);
									//TODO add your code for addNotasButton.actionPerformed
								}
							});
						}
						{
							editNotasButton = new JButton();
							notasPanelButtons.add(editNotasButton);
							editNotasButton.setText("Editar");
							editNotasButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("editNotasButton.actionPerformed, event="+evt);
									//TODO add your code for editNotasButton.actionPerformed
								}
							});
						}
						{
							delNotasButton = new JButton();
							notasPanelButtons.add(delNotasButton);
							delNotasButton.setText("Borrar");
							delNotasButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("delNotasButton.actionPerformed, event="+evt);
									//TODO add your code for delNotasButton.actionPerformed
								}
							});
						}
						{
							detNotasButton = new JButton();
							notasPanelButtons.add(detNotasButton);
							detNotasButton.setText("Detalle");
							detNotasButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("detNotasButton.actionPerformed, event="+evt);
									//TODO add your code for detNotasButton.actionPerformed
									if(notasTable.getRowCount()<1||notasTable.getSelectedRow()==-1){
										javax.swing.JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");										
									}else{
										int selRow = notasTable.getSelectedRow();	
										
										NotaInformativa nI = ControladorNotaInformativa.getControladorNotaInformativa().getNotaInformativaPorPos(selRow);
										
										factsSelModel.cargaFacturasComunidadAsignadas(nI);
										factsPendModel.cargaFacturasComunidadPendientes(cAux);										
										notasTabbedPane.setSelectedIndex(1);
									}
								}
							});
						}
					}
				}
				{
					factsPanel = new JPanel();
					GridBagLayout factsPanelLayout = new GridBagLayout();
					factsPanelLayout.rowWeights = new double[] {0.1};
					factsPanelLayout.rowHeights = new int[] {7};
					factsPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0};
					factsPanelLayout.columnWidths = new int[] {280, 40, 280};
					notasTabbedPane.addTab("Facturas", null, factsPanel, null);
					factsPanel.setLayout(factsPanelLayout);
					{
						factsPendPane = new JScrollPane();
						factsPanel.add(factsPendPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						{		
							factsPendModel.cargaFacturasComunidadPendientes(cAux);
							factsPendTable = new JTable(factsPendModel);
							factsPendTable.setModel(factsPendModel);
							factsPendPane.setViewportView(factsPendTable);
							factsPendTable.setFillsViewportHeight(true);
							
						}
					}
					{
						leftOrRightPanel = new JPanel();
						factsPanel.add(leftOrRightPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
						GridBagLayout leftOrRightPanelLayout = new GridBagLayout();
						leftOrRightPanelLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
						leftOrRightPanelLayout.rowHeights = new int[] {20, 7, 7, 20, 7, 20, 7, 20};
						leftOrRightPanelLayout.columnWeights = new double[] {0.1, 0.1, 0.1};
						leftOrRightPanelLayout.columnWidths = new int[] {7, 7, 7};
						leftOrRightPanel.setLayout(leftOrRightPanelLayout);
						leftOrRightPanel.setPreferredSize(new java.awt.Dimension(146, 307));
						{
							left2rightButton = new JButton();
							leftOrRightPanel.add(left2rightButton, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							left2rightButton.setText("->");
							left2rightButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("left2rightButton.actionPerformed, event="+evt);
									//TODO add your code for left2rightButton.actionPerformed
								}
							});
						}
						{
							right2leftButton = new JButton();
							leftOrRightPanel.add(right2leftButton, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							right2leftButton.setText("<-");
							right2leftButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("right2leftButton.actionPerformed, event="+evt);
									//TODO add your code for right2leftButton.actionPerformed
								}
							});
						}
						{
							all2rightButton = new JButton();
							leftOrRightPanel.add(all2rightButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							all2rightButton.setText("->>");
							all2rightButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("all2rightButton.actionPerformed, event="+evt);
									//TODO add your code for all2rightButton.actionPerformed
								}
							});
						}
						{
							all2leftButton = new JButton();
							leftOrRightPanel.add(all2leftButton, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							all2leftButton.setText("<<-");
							all2leftButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("all2leftButton.actionPerformed, event="+evt);
									//TODO add your code for all2leftButton.actionPerformed
								}
							});
						}
						{
							genNotaButton = new JButton();
							leftOrRightPanel.add(genNotaButton, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							genNotaButton.setText("Generar");
							genNotaButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("genNotaButton.actionPerformed, event="+evt);
									//TODO add your code for genNotaButton.actionPerformed
								}
							});
						}
					}
					{
						factsSelPane = new JScrollPane();
						factsPanel.add(factsSelPane, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						factsSelPane.setPreferredSize(new java.awt.Dimension(277, 307));
						{							
							factsSelTable = new JTable(factsSelModel);
							factsSelTable.setModel(factsSelModel);
							factsSelPane.setViewportView(factsSelTable);							
							factsSelTable.setFillsViewportHeight(true);
						}
					}
				}
			}
			{
				notasMenuBar = new JMenuBar();
				setJMenuBar(notasMenuBar);
				{
					jMenu1 = new JMenu();
					notasMenuBar.add(jMenu1);
					jMenu1.setText("Generar Informes");
					{
						genSelNotaReport = new JMenuItem();
						jMenu1.add(genSelNotaReport);
						genSelNotaReport.setText("Nota Seleccionada");
						genSelNotaReport.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("genSelNotaReport.actionPerformed, event="+evt);
								//TODO add your code for genSelNotaReport.actionPerformed
							}
						});
					}
					{
						genAllNotaReport = new JMenuItem();
						jMenu1.add(genAllNotaReport);
						genAllNotaReport.setText("Todas las Notas");
						genAllNotaReport.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("genAllNotaReport.actionPerformed, event="+evt);
								//TODO add your code for genAllNotaReport.actionPerformed
							}
						});
					}
				}
			}
			pack();
			this.setSize(685, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
