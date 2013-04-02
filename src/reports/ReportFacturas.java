package reports;

import java.util.HashMap;

import org.hibernate.Session;

import accesoAdatos._ORM.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;

public class ReportFacturas {
	
	@SuppressWarnings("unchecked")
	public void muestraTodos() {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);		

		try {
			String fileName= "src/reports/listados/Facturas.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
	@SuppressWarnings("unchecked")	
	public void muestraPorComunidad(int id) {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);
		parametros.put("IDCOM",id);

		try {
			String fileName= "src/reports/listados/FacturasDeComunidad.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
	
	@SuppressWarnings("unchecked")	
	public void muestraDetalle(int id) {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);
		parametros.put("IDFAC",id);

		try {
			String fileName= "src/reports/listados/FacturaDetalle.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}	
}
