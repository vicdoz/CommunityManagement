package reports;

import java.util.HashMap;

import org.hibernate.Session;

import accesoAdatos._ORM.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;

public class ReportRecibo {
	
	@SuppressWarnings("unchecked")	
	public void muestraPorIdNota(int id) {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);
		parametros.put("IDNOTA",id);

		try {
			String fileName= "src/reports/listados/NuevoRecibo.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
	@SuppressWarnings("unchecked")	
	public void muestraPorPropietario() { //Muestra todos los propietarios adeudados
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);	
		try {
			String fileName= "src/reports/listados/ReciboPropietario.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
}
