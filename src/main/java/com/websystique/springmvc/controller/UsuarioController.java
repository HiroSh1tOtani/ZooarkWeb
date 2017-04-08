package com.websystique.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.controller.base.BaseZooArkController;
import com.websystique.springmvc.utils.ZooArkCommonConstants;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class UsuarioController extends BaseZooArkController {
	
	private static final Logger log = LogManager.getLogger(UsuarioController.class);
	private static final String modulo = "usuario";
	
	@RequestMapping(value = "/Mantenimiento_Usuario", method = RequestMethod.GET)
	public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		setNavigationParams(model, ZooArkCommonConstants.TEMPLATE_MANTENIMIENTO_USUARIO, modulo);
		
		return handleModelAndView(model);
	}
	
}
