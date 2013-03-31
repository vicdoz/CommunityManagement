package reports;

import java.util.HashMap;

import org.hibernate.Session;

import accesoAdatos._ORM.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;

public class ReportInmuebles {
	
	@SuppressWarnings("unchecked")
	public void muestraTodos() {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);		

		try {
			String fileName= "src/reports/listados/Inmuebles.jasper";
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
			String fileName= "src/reports/listados/InmueblesDeComunidad.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
	@SuppressWarnings("unchecked")
	public void muestraPorPropietario(int id) {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);
		parametros.put("IDPROP",id);

		try {
			String fileName= "src/reports/listados/InmueblesDePropietario.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
	
}
