package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import negocio.Inmueble;
import negocio.Propietario;
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
public class VentanaPagoRecibosAUX extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pagoRecibosPanel;
	private JButton pagarFacturaButton;
	private JButton mostrarTodosInmuebles;
	private JButton mostrarRecibosPropButton;
	private JButton mostrarFactsInmButton;
	private JButton mostrarInmPropButton;
	private JScrollPane recibosScrollPane;
	private JScrollPane inmScrollPane;
	private JScrollPane propScrollPane;
	
	public JTable recibosTable;
	private JPanel inmPanel;
	private JPanel propPanel;
	private JTabbedPane propInmTabbedPane;
	private JPanel propButtonPanel;
	private JPanel recibosPanel;
	public JTable inmTable;
	public JTable propTable;
	
	public static ModeloTablaPropietario propModel = new ModeloTablaPropietario();
	public static ModeloTablaInmueble inmModel = new ModeloTablaInmueble();
	public static ModeloTablaRecibo recibosModel = new ModeloTablaRecibo();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaPagoRecibosAUX inst = new VentanaPagoRecibosAUX();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VentanaPagoRecibosAUX() {
		super();
		inmModel.cargaInmueblesTodos();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Gestion Pagos");
			{
				pagoRecibosPanel = new JPanel();
				getContentPane().add(pagoRecibosPanel, BorderLayout.CENTER);
				GridLayout pagoRecibosPanelLayout = new GridLayout(1, 3);
				pagoRecibosPanelLayout.setHgap(5);
				pagoRecibosPanelLayout.setVgap(5);
				pagoRecibosPanelLayout.setColumns(3);
				pagoRecibosPanel.setLayout(pagoRecibosPanelLayout);
				pagoRecibosPanel.setPreferredSize(new java.awt.Dimension(927, 490));
				{
					propInmTabbedPane = new JTabbedPane();
					pagoRecibosPanel.add(propInmTabbedPane);
					propInmTabbedPane.setPreferredSize(new java.awt.Dimension(306, 655));
					{
						propPanel = new JPanel();
						propInmTabbedPane.addTab("Propietarios", null, propPanel, null);
						propPanel.setPreferredSize(new java.awt.Dimension(457, 460));
						{
							mostrarInmPropButton = new JButton();
							propPanel.add(mostrarInmPropButton);
							mostrarInmPropButton.setText("Inmuebles del Propietario");
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
									}
								}
							});
						}
						{
							mostrarRecibosPropButton = new JButton();
							propPanel.add(mostrarRecibosPropButton);
							mostrarRecibosPropButton.setText("Recibos Propietario");
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
						{
							propScrollPane = new JScrollPane();
							propPanel.add(propScrollPane);
							propScrollPane.setSize(250, 227);
							{
								propTable = new JTable(propModel);
								propTable.setModel(propModel);												
								propScrollPane.setViewportView(propTable);
								propTable.setFillsViewportHeight(true);
								propTable.setSize(250, 200);	
								propTable.removeColumn(propTable.getColumnModel().getColumn(9));	propTable.removeColumn(propTable.getColumnModel().getColumn(8));
								propTable.removeColumn(propTable.getColumnModel().getColumn(7));	propTable.removeColumn(propTable.getColumnModel().getColumn(6));
								propTable.removeColumn(propTable.getColumnModel().getColumn(5));	propTable.removeColumn(propTable.getColumnModel().getColumn(4));
								propTable.removeColumn(propTable.getColumnModel().getColumn(3));	propTable.removeColumn(propTable.getColumnModel().getColumn(1));
								propTable.getColumnModel().getColumn(0).setMaxWidth(40);
								propTable.setPreferredSize(new java.awt.Dimension(351, 235));

							}
						}
						{
							propButtonPanel = new JPanel();
							BorderLayout propButtonPanelLayout = new BorderLayout();
							propButtonPanel.setLayout(propButtonPanelLayout);
							propPanel.add(propButtonPanel);
						}
					}
					{
						inmPanel = new JPanel();
						propInmTabbedPane.addTab("Inmuebles", null, inmPanel, null);
						{
							mostrarTodosInmuebles = new JButton();
							inmPanel.add(mostrarTodosInmuebles);
							mostrarTodosInmuebles.setText("Todos los Inmuebles");
							mostrarTodosInmuebles.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("mostrarTodosInmuebles.actionPerformed, event="+evt);
									//TODO add your code for mostrarTodosInmuebles.actionPerformed
									inmModel.cargaInmueblesTodos();
									inmTable.setModel(inmModel);
								}
							});
						}
						{
							mostrarFactsInmButton = new JButton();
							inmPanel.add(mostrarFactsInmButton);
							mostrarFactsInmButton.setText("Facturas de Inmueble");
							mostrarFactsInmButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("mostrarFactsInmButton.actionPerformed, event="+evt);
									//TODO add your code for mostrarFactsInmButton.actionPerformed
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
						{
							inmScrollPane = new JScrollPane();
							inmPanel.add(inmScrollPane);
							inmScrollPane.setSize(250, 227);
							{
								inmTable = new JTable(inmModel);
								inmScrollPane.setViewportView(inmTable);
								inmTable.setModel(inmModel);
								inmTable.setFillsViewportHeight(true);
								inmTable.setSize(250, 200);
							}
						}
					}
				}
				{
					recibosPanel = new JPanel();
					pagoRecibosPanel.add(recibosPanel);
					recibosPanel.setPreferredSize(new java.awt.Dimension(644, 188));
					{
						pagarFacturaButton = new JButton();
						recibosPanel.add(pagarFacturaButton);
						pagarFacturaButton.setText("Pagar Recibos");
						pagarFacturaButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("pagarFacturaButton.actionPerformed, event="+evt);
								//TODO add your code for pagarFacturaButton.actionPerformed
							}
						});
					}
					{
						recibosScrollPane = new JScrollPane();
						recibosPanel.add(recibosScrollPane);
						recibosScrollPane.setSize(200, 227);
						{												
							recibosTable = new JTable(recibosModel);						
							recibosTable.setModel(recibosModel);
							recibosScrollPane.setViewportView(recibosTable);
							recibosTable.setFillsViewportHeight(true);
							recibosTable.setSize(200, 200);
						}
					}
				}
			}
			pack();
			this.setSize(979, 369);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
