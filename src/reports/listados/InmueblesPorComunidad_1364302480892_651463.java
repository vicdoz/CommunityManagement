/*
 * Generated by JasperReports - 26/03/13 13:54
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import net.sf.jasperreports.engine.*;
import java.util.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class InmueblesPorComunidad_1364302480892_651463 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_IDCOM = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_HIBERNATE_SESSION = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_HIBERNATE_FILTER_COLLECTION = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_nombre = null;
    private JRFillField field_porcentaje = null;
    private JRFillField field_escalera = null;
    private JRFillField field_idInmueble = null;
    private JRFillField field_idPropietario = null;
    private JRFillField field_puerta = null;
    private JRFillField field_propietario = null;
    private JRFillField field_piso = null;
    private JRFillField field_listaRecibos = null;
    private JRFillField field_comunidad = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_comunidad_COUNT = null;
    private JRFillVariable variable_idInmueble_COUNT = null;
    private JRFillVariable variable_propietario_COUNT = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_IDCOM = (JRFillParameter)pm.get("IDCOM");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_HIBERNATE_SESSION = (JRFillParameter)pm.get("HIBERNATE_SESSION");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_HIBERNATE_FILTER_COLLECTION = (JRFillParameter)pm.get("HIBERNATE_FILTER_COLLECTION");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_nombre = (JRFillField)fm.get("nombre");
        field_porcentaje = (JRFillField)fm.get("porcentaje");
        field_escalera = (JRFillField)fm.get("escalera");
        field_idInmueble = (JRFillField)fm.get("idInmueble");
        field_idPropietario = (JRFillField)fm.get("idPropietario");
        field_puerta = (JRFillField)fm.get("puerta");
        field_propietario = (JRFillField)fm.get("propietario");
        field_piso = (JRFillField)fm.get("piso");
        field_listaRecibos = (JRFillField)fm.get("listaRecibos");
        field_comunidad = (JRFillField)fm.get("comunidad");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_comunidad_COUNT = (JRFillVariable)vm.get("comunidad_COUNT");
        variable_idInmueble_COUNT = (JRFillVariable)vm.get("idInmueble_COUNT");
        variable_propietario_COUNT = (JRFillVariable)vm.get("propietario_COUNT");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(((negocio.Comunidad)field_comunidad.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(""+((java.lang.Integer)parameter_IDCOM.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)field_idInmueble.getValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_idInmueble.getValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(((negocio.Propietario)field_propietario.getValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nombre.getValue())+" ("+((java.lang.Integer)field_idPropietario.getValue())+")");//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)field_escalera.getValue()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(((java.lang.String)field_piso.getValue()));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.lang.String)(((java.lang.String)field_puerta.getValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()) + " of ");//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=26$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(((negocio.Comunidad)field_comunidad.getOldValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(""+((java.lang.Integer)parameter_IDCOM.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)field_idInmueble.getOldValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_idInmueble.getOldValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(((negocio.Propietario)field_propietario.getOldValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nombre.getOldValue())+" ("+((java.lang.Integer)field_idPropietario.getOldValue())+")");//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)field_escalera.getOldValue()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(((java.lang.String)field_piso.getOldValue()));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.lang.String)(((java.lang.String)field_puerta.getOldValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()) + " of ");//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=26$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Object)(((negocio.Comunidad)field_comunidad.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(""+((java.lang.Integer)parameter_IDCOM.getValue()));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)field_idInmueble.getValue()));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_idInmueble.getValue()));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(((negocio.Propietario)field_propietario.getValue()));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nombre.getValue())+" ("+((java.lang.Integer)field_idPropietario.getValue())+")");//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)field_escalera.getValue()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(((java.lang.String)field_piso.getValue()));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.lang.String)(((java.lang.String)field_puerta.getValue()));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()) + " of ");//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.util.Date)(new Date());//$JR_EXPR_ID=26$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
