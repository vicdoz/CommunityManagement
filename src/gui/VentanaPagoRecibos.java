package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
public class VentanaPagoRecibos extends javax.swing.JFrame {

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
        private JButton mostrarFactsPropButton;
        private JButton mostrarFactsInmButton;
        private JButton mostrarInmPropButton;
        private JScrollPane recibosScrollPane;
        private JScrollPane inmScrollPane;
        private JScrollPane propScrollPane;
        
        public JTable recibosTable;
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
                        this.setResizable(false);
                        this.setTitle("Gestion Pagos");
                        {
                                pagoRecibosPanel = new JPanel();
                                GridBagLayout pagoRecibosPanelLayout = new GridBagLayout();
                                getContentPane().add(pagoRecibosPanel, BorderLayout.CENTER);
                                pagoRecibosPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.1, 0.0, 0.0, 0.0};
                                pagoRecibosPanelLayout.rowHeights = new int[] {5, 36, 7, 7, 103, 36, 8};
                                pagoRecibosPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0};
                                pagoRecibosPanelLayout.columnWidths = new int[] {250, 250, 250};
                                pagoRecibosPanel.setLayout(pagoRecibosPanelLayout);
                                pagoRecibosPanel.setPreferredSize(new java.awt.Dimension(780, 398));
                                {
                                        mostrarInmPropButton = new JButton();
                                        pagoRecibosPanel.add(mostrarInmPropButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 0, 10), 0, 0));
                                        mostrarInmPropButton.setText("Inmuebles de Propietario");
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
                                        propScrollPane = new JScrollPane();
                                        pagoRecibosPanel.add(propScrollPane, new GridBagConstraints(0, 2, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 10, 10), 0, 0));
                                        propScrollPane.setSize(250, 227);
                                        {
                                                propTable = new JTable(propModel);
                                                propTable.setModel(propModel);                                                                                          
                                                propScrollPane.setViewportView(propTable);
                                                propTable.setFillsViewportHeight(true);
                                                propTable.setSize(250, 200);    
                                                propTable.removeColumn(propTable.getColumnModel().getColumn(9));        propTable.removeColumn(propTable.getColumnModel().getColumn(8));
                                                propTable.removeColumn(propTable.getColumnModel().getColumn(7));        propTable.removeColumn(propTable.getColumnModel().getColumn(6));
                                                propTable.removeColumn(propTable.getColumnModel().getColumn(5));        propTable.removeColumn(propTable.getColumnModel().getColumn(4));
                                                propTable.removeColumn(propTable.getColumnModel().getColumn(3));        propTable.removeColumn(propTable.getColumnModel().getColumn(1));
                                                propTable.getColumnModel().getColumn(0).setMaxWidth(40);
                                                
                                        }
                                }
                                {
                                        mostrarFactsPropButton = new JButton();
                                        pagoRecibosPanel.add(mostrarFactsPropButton, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 0, 10), 0, 0));
                                        mostrarFactsPropButton.setText("Facturas Propietario");
                                        mostrarFactsPropButton.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent evt) {
                                                        System.out.println("mostrarFactsPropButton.actionPerformed, event="+evt);
                                                        //TODO add your code for mostrarFactsPropButton.actionPerformed
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
                                        mostrarTodosInmuebles = new JButton();
                                        pagoRecibosPanel.add(mostrarTodosInmuebles, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 0, 10), 0, 0));
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
                                        inmScrollPane = new JScrollPane();
                                        pagoRecibosPanel.add(inmScrollPane, new GridBagConstraints(1, 2, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 10, 10), 0, 0));
                                        inmScrollPane.setSize(250, 227);
                                        {
                                                inmTable = new JTable(inmModel);
                                                inmTable.setModel(inmModel);
                                                inmScrollPane.setViewportView(inmTable);
                                                inmTable.setFillsViewportHeight(true);
                                                inmTable.setSize(250, 200);
                                        }
                                }
                                {
                                        mostrarFactsInmButton = new JButton();
                                        pagoRecibosPanel.add(mostrarFactsInmButton, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 0, 10), 0, 0));
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
                                        recibosScrollPane = new JScrollPane();
                                        pagoRecibosPanel.add(recibosScrollPane, new GridBagConstraints(2, 2, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 10, 10), 0, 0));
                                        recibosScrollPane.setSize(250, 227);
                                        {                                                                                               
                                                recibosTable = new JTable(recibosModel);                                                
                                                recibosTable.setModel(recibosModel);
                                                recibosScrollPane.setViewportView(recibosTable);
                                                recibosTable.setFillsViewportHeight(true);
                                                recibosTable.setSize(250, 200);
                                        }
                                }
                                {
                                        pagarFacturaButton = new JButton();
                                        pagoRecibosPanel.add(pagarFacturaButton, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 0, 10), 0, 0));
                                        pagarFacturaButton.setText("Pagar Factura ");
                                        pagarFacturaButton.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent evt) {
                                                        System.out.println("pagarFacturaButton.actionPerformed, event="+evt);
                                                        //TODO add your code for pagarFacturaButton.actionPerformed
                                                }
                                        });
                                }
                        }
                        pack();
                        this.setSize(786, 411);
                } catch (Exception e) {
                    //add your error handling code here
                        e.printStackTrace();
                }
        }

}