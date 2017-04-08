package com.websystique.springmvc.controller.base;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcfr.utiles.files.JFUtil;
import com.jcfr.utiles.listas.JLUtil;
import com.jcfr.utiles.string.JSUtil;
import com.websystique.springmvc.utils.ZooArkCommonConstants;
import com.websystique.springmvc.utils.bean.DataJsonBean;
import com.websystique.springmvc.utils.exception.zooArkException;

public class BaseZooArkController extends MultiActionController {
	
	protected static final JSUtil JS = JSUtil.JSUtil;
	protected static final JFUtil JF = JFUtil.JFUtil;
	protected static final JLUtil JL = JLUtil.JLUtil;
	
	protected void setNavigationParams(Map<String, Object> model, String pagina, String plantilla) {
		setNavigationParams(model, pagina, plantilla, true);
	}
	
	protected void setNavigationParamsGrilla(Map<String, Object> model, String pagina, String plantilla) {
		setNavigationParams(model, pagina, plantilla, false);
	}
	
	public ModelAndView cargarPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return handleCargar(request, false);
	}
	
	protected void setNavigationParams(Map<String, Object> model, String pagina, String modulo, boolean useTemplateAsView) {

		String _view = null;
		String _page = StringUtils.trimToEmpty(pagina);
		String _module = StringUtils.trimToEmpty(modulo);

		if (useTemplateAsView) {
			_view = ZooArkCommonConstants.TEMPLATE_PRINCIPAL;
		} else {
			if (StringUtils.isNotBlank(_module)) {
				_view = ZooArkCommonConstants.CARPETA_PAGINAS + "/" + _module + "/" + _page;
			} else {
				_view = ZooArkCommonConstants.CARPETA_PAGINAS + "/" + _page;
			}
		}

		// setear atributos de navegacion, vista es la siguiente vista
		if (StringUtils.isNotBlank(_page)) model.put("_page", _page);
		if (StringUtils.isNotBlank(_module)) model.put("_module", _module);
		model.put("_template", ZooArkCommonConstants.CARPETA_PAGINAS);
		if (StringUtils.isNotBlank(_view)) model.put("_view", _view);

	}
	
	protected ModelAndView handleModelAndView(Map<String, Object> model) {
		String _nextView = MapUtils.getString(model, "_view");

		return new ModelAndView(_nextView, model);
	}
	
	protected ModelAndView handleJSONResponse(final DataJsonBean dataJsonBean, final HttpServletResponse response)
	throws Exception
	{
		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		// String dataJsonString = new Gson().toJson(dataJsonBean);
		final String dataJsonString = new ObjectMapper().writeValueAsString(dataJsonBean);
		
		final PrintWriter writer = response.getWriter();
		
		if (writer != null) {
		writer.write(dataJsonString);
		// writer.close();
		}
		
		return null;
	}
	
	private ModelAndView handleCargar(HttpServletRequest request, boolean useTemplateAsView) throws Exception {

		// INFO: solo busca los atributos en el request y armar el _nextView
		String _page = StringUtils.trimToEmpty(request.getParameter("_page"));
		String _module = StringUtils.trimToEmpty(request.getParameter("_module"));

		HashMap<String, Object> model = new HashMap<String, Object>();

		// usar page
		setNavigationParams(model, _page, _module, useTemplateAsView);

		return handleModelAndView(model);
	}
	
	protected void configurarDatatable(HttpServletRequest request,
			Map<String, Object> params) {

		// DATOS DEL DATATABLES
		String start = StringUtils.trimToNull(request
				.getParameter(ZooArkCommonConstants.GRILLA.START));
		String length = StringUtils.trimToNull(request
				.getParameter(ZooArkCommonConstants.GRILLA.LENGTH));

		Long lStart = null == start ? 0L : JS.toLong(start);
		Long lLength = null == length ? 0L : JS.toLong(length);

		String draw = StringUtils.trimToEmpty(request
				.getParameter(ZooArkCommonConstants.GRILLA.DRAW));

		Long lFirst = lStart + 1;
		Long lLast = lStart + lLength;

		params.put(ZooArkCommonConstants.GRILLA.FIRST, lFirst);
		params.put(ZooArkCommonConstants.GRILLA.LAST, lLast);
		params.put(ZooArkCommonConstants.GRILLA.DRAW, draw == null ? "" : draw);
	}
	
	protected ModelAndView handleJSONResponse(List<?> dataJsonBean,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		// String dataJsonString = new Gson().toJson(dataJsonBean);

		PrintWriter writer = response.getWriter();
		if (writer != null) {
			writer.write("{" + JSONObject.toString("data", dataJsonBean) + "}");
			// writer.close();
		}
		return null;
	}
	
	protected ModelAndView handleJSONResponse(List<?> dataJsonBean,
			HttpServletResponse response, Object draw, Long total)
			throws Exception {

		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		// String dataJsonString = new Gson().toJson(dataJsonBean);		
		
		PrintWriter writer = response.getWriter();
		if (writer != null) {
			writer.write("{" + JSONObject.toString("data", dataJsonBean) + " , \"draw\":"+ draw.toString() +", \"recordsFiltered\":"+ total +", \"recordsTotal\":"+ total +" }");			
			writer.close();
		}
		return null;
	}
	
	protected String handleJSONError(final DataJsonBean dataJsonBean,
            final Exception sos)
	{
	
		final String msgError = handleMsgError(sos);
		
		// caso de error normal
		dataJsonBean.setRespuesta("error", msgError, null);
		
		if (sos instanceof zooArkException) {
			final zooArkException cast = (zooArkException) sos;
		
			// ver si es error por validacion
			if (JS._equiv(cast.getTipo(), "errorValidacion")) {
				dataJsonBean.setRespuesta("errorValidacion", msgError, cast.getExtra());
			}
		}
		
		return msgError;
	}
	
	// revisar
    protected String handleMsgError(final Exception sos) {

        // FIXME: aqui agregar incluir manejo de la exception personalizada
        // CategorizacionException

        // seteando el mensaje de error
        String msgError = ""
                        + ((sos == null || sos instanceof NullPointerException) ? "Null Pointer Exception" : sos
                                        .getMessage());
        if (sos != null && sos.getCause() != null) {
            msgError = msgError + ", CAUSA: " + sos.getCause().getMessage();
        }

        return msgError;
    }
    
    protected Map<String, Object> ingresoCampo(String estado, String msg, Object result) {
    	Map<String, Object> campo = new HashMap<String, Object>();
    	campo.put("estado", estado);
    	campo.put("msg", msg);
    	campo.put("dataJson", result);
    	return campo;
    }
    
    /*protected Empleado getEmpleadoSessio(HttpServletRequest request) throws Exception{
    	if(WebUtils.getSessionAttribute(request, "empleado")!=null){
    		return ((Empleado) WebUtils.getSessionAttribute(request, "empleado"));
    	}else{
    		Empleado empleado =  zooArkService.SelectEmpleadoByUsername(request.getUserPrincipal().getName());
			WebUtils.setSessionAttribute(request, "empleado", empleado);
			return empleado;
    	}
    }*/
	
}
