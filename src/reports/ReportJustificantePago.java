package reports;

import java.util.HashMap;

import org.hibernate.Session;

import accesoAdatos._ORM.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;

public class ReportJustificantePago {
	
	@SuppressWarnings("unchecked")
	public void muestraTodos() {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);		
		parametros.put("IDRECIBO",1);
		try {
			String fileName= "src/reports/listados/JustificanteDePago.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
	@SuppressWarnings("unchecked")	
	public void muestraJustificantePorIdRecibo(int id) {
		JasperPrint informe = null;

		Session sesion= UtilidadHibernate.getSessionFactory().openSession();
		HashMap parametros = new HashMap();

		parametros.put(JRHibernateQueryExecuterFactory.
				   		          PARAMETER_HIBERNATE_SESSION,sesion);
		parametros.put("IDRECIBO",id);

		try {
			String fileName= "src/reports/listados/JustificanteDePago.jasper";
			System.out.println("Fichero encontrado!");
			 informe= JasperFillManager.fillReport(fileName, parametros);
		   
		}
		catch (JRException e){e.printStackTrace();}

		JasperViewer.viewReport(informe,false);
	}
}
