package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import negocio.Comunidad;
import negocio._tablas.ModeloTablaFacturaDetalle;


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
public class VentanaFacturaDetalle extends javax.swing.JFrame {
	private JPanel facturaDetalle;
	private JScrollPane factDetjScrollPane;
	//private JTable tablaFactDet;
	private JButton delLineasButton;
	private JButton editLineasButton;
	private JButton addLineasButton;
	private JPanel factDetButtons;

	public static JTable tablaFactDet;
	public static ModeloTablaFacturaDetalle modeloFactDet = new ModeloTablaFacturaDetalle();
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaFacturaDetalle inst = new VentanaFacturaDetalle();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VentanaFacturaDetalle() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				facturaDetalle = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				facturaDetalle.setLayout(jPanel1Layout);
				getContentPane().add(facturaDetalle, BorderLayout.CENTER);
				{
					factDetjScrollPane = new JScrollPane();
					facturaDetalle.add(factDetjScrollPane, BorderLayout.CENTER);
					{
									
						tablaFactDet = new JTable(modeloFactDet);
						tablaFactDet.setModel(modeloFactDet);
						factDetjScrollPane.setViewportView(tablaFactDet);						
						tablaFactDet.setFillsViewportHeight(true);
						tablaFactDet.getColumnModel().getColumn(0).setMaxWidth(50);
						//tablaFactDet.getColumnModel().getColumn(1).setMaxWidth(350);
					}
				}
				{
					factDetButtons = new JPanel();
					GridLayout factDetButtonsLayout = new GridLayout(6, 1);
					factDetButtonsLayout.setHgap(5);
					factDetButtonsLayout.setVgap(20);
					factDetButtonsLayout.setColumns(1);
					factDetButtonsLayout.setRows(6);
					factDetButtons.setLayout(factDetButtonsLayout);
					facturaDetalle.add(factDetButtons, BorderLayout.EAST);
					{
						addLineasButton = new JButton();
						factDetButtons.add(addLineasButton);
						addLineasButton.setText("Nueva Línea");
						addLineasButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//TODO
							}
						});
					}
					{
						editLineasButton = new JButton();
						factDetButtons.add(editLineasButton);
						editLineasButton.setText("Edita Línea");
					}
					{
						delLineasButton = new JButton();
						factDetButtons.add(delLineasButton);
						delLineasButton.setText("Borra Línea");
					}
				}
			}
			pack();
			setSize(500, 400);
			this.setTitle("Líneas Factura");
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
