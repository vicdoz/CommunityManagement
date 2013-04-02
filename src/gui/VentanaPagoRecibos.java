package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


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
public class VentanaPagoRecibos extends javax.swing.JFrame {
	private JPanel pagoRecibosPanel;
	private JButton pagarFacturaButton;
	private JButton mostrarFactsInmButton;
	private JButton mostrarInmPropButton;
	private JTable recibosTable;
	private JTable inmTable;
	private JTable propTable;
	private JScrollPane recibosScrollPane;
	private JScrollPane inmScrollPane;
	private JScrollPane propScrollPane;

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
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setTitle("Gestion Pagos");
			{
				pagoRecibosPanel = new JPanel();
				GridBagLayout pagoRecibosPanelLayout = new GridBagLayout();
				getContentPane().add(pagoRecibosPanel, BorderLayout.CENTER);
				pagoRecibosPanelLayout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1};
				pagoRecibosPanelLayout.rowHeights = new int[] {36, 7, 7, 7};
				pagoRecibosPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0};
				pagoRecibosPanelLayout.columnWidths = new int[] {250, 250, 250};
				pagoRecibosPanel.setLayout(pagoRecibosPanelLayout);
				pagoRecibosPanel.setPreferredSize(new java.awt.Dimension(684, 319));
				{
					mostrarInmPropButton = new JButton();
					pagoRecibosPanel.add(mostrarInmPropButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
					mostrarInmPropButton.setText("Inmuebles de Propietario");
				}
				{
					propScrollPane = new JScrollPane();
					pagoRecibosPanel.add(propScrollPane, new GridBagConstraints(0, 1, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 10, 10), 0, 0));
					propScrollPane.setSize(250, 227);
					{
						TableModel propTableModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });
						propTable = new JTable();
						propScrollPane.setViewportView(propTable);
						propTable.setModel(propTableModel);
						propTable.setFillsViewportHeight(true);
						propTable.setSize(250, 200);
					}
				}
				{
					mostrarFactsInmButton = new JButton();
					pagoRecibosPanel.add(mostrarFactsInmButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					mostrarFactsInmButton.setText("Facturas de Inmueble");
				}
				{
					inmScrollPane = new JScrollPane();
					pagoRecibosPanel.add(inmScrollPane, new GridBagConstraints(1, 1, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 10, 10), 0, 0));
					inmScrollPane.setSize(250, 227);
					{
						TableModel inmTableModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });
						inmTable = new JTable();
						inmScrollPane.setViewportView(inmTable);
						inmTable.setModel(inmTableModel);
						inmTable.setFillsViewportHeight(true);
						inmTable.setSize(250, 200);
					}
				}
				{
					pagarFacturaButton = new JButton();
					pagoRecibosPanel.add(pagarFacturaButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					pagarFacturaButton.setText("Pagar Factura");
				}
				{
					recibosScrollPane = new JScrollPane();
					pagoRecibosPanel.add(recibosScrollPane, new GridBagConstraints(2, 1, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 10, 10), 0, 0));
					recibosScrollPane.setSize(250, 227);
					{
						TableModel recibosTableModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });
						recibosTable = new JTable();
						recibosScrollPane.setViewportView(recibosTable);
						recibosTable.setModel(recibosTableModel);
						recibosTable.setFillsViewportHeight(true);
						recibosTable.setSize(250, 200);
					}
				}
			}
			pack();
			this.setSize(766, 346);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
