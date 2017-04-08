package com.websystique.springmvc.utils;


public class ZooArkCommonConstants {  

	public final static String MSG_LOGIN_INCORRECTO = "Usuario o password incorrecto";
	
	public final static String TEMPLATE_PRINCIPAL = "welcome";
	
	public final static String CARPETA_PAGINAS = "pages";
	
	/*
	 * TEMPLATES
	 */
	public final static String TEMPLATE_LOGIN = "login";
	public final static String TEMPLATE_403 = "403";
	public final static String TEMPLATE_MANTENIMIENTO_USUARIO = "mantenimiento-usuario";
	public final static String TEMPLATE_MANTENIMIENTO_MASCOTA = "mantenimiento-mascota";
	public final static String TEMPLATE_MANTENIMIENTO_CLIENTE = "mantenimiento-cliente";
	public final static String TEMPLATE_MANTENIMIENTO_EMPRESA = "mantenimiento-empresa";
	public final static String TEMPLATE_MANTENIMIENTO_PRODUCTO = "mantenimiento-producto";
	public final static String TEMPLATE_MANTENIMIENTO_SERVICIO = "mantenimiento-servicio";
	public final static String TEMPLATE_LANDINGPAGE = "landingpage";
	
	public final static String TEMPLATE_GENERAR_CALENDARIO_CITA = "generar-calendario-cita";
	public final static String TEMPLATE_GUARDAR_USUARIO = "guardar-usuario";
	public final static String TEMPLATE_GUARDAR_MASCOTA = "guardar-mascota";
	public final static String TEMPLATE_GUARDAR_CLIENTE = "guardar-cliente";
	public final static String TEMPLATE_GUARDAR_EMPRESA = "guardar-empresa";
	public final static String TEMPLATE_GUARDAR_CITA = "guardar-cita";
	public final static String TEMPLATE_GUARDAR_PRODUCTO = "guardar-producto";
	public final static String TEMPLATE_GUARDAR_SERVICIO = "guardar-servicio";
	
	public final static String TEMPLATE_GENERAL= "template-general";
	
	/*
	 * CATEGORIAS TABLA GENERAL
	 */
	public final static String CATEGORIA_TIPO_DOCUMENTO = "TIPO_DOCUMENTO";
	public final static String CATEGORIA_TIPO_ROL = "TIPO_ROL";
	public final static String GENERO_MASCOTA = "GENERO_MASCOTA";
	public final static String TIPO_EMPLEADO = "TIPO_EMPLEADO";
	public final static String ESPECIALIDAD = "ESPECIALIDAD";
	public final static String CATEGORIA_PRODUCTO = "CATEGORIA_PRODUCTO";
	
	public static class GRILLA{
		public static final String DRAW = "draw";			
		public static final String START = "start";			
		public static final String LENGTH = "length";			
		public static final String FIRST = "first";	
		public static final String LAST = "last";		
		public static final String COLUMN_P = "order[0][column]";
		public static final String DIR_P = "order[0][dir]";
	}
	
	public static class TABLA_GENERAL{
		public static final String VETERINARIO = "TIEM02";
	}
	
	//Mensajes de validación
	public static final String MSG_CAMPO_REQUERIDO = "Este campo es requerido.";
	public static final String MSG_CORREO_NO_VALIDO = "Correo no válido.";
	public static final String MSG_FECHA_NO_VALIDO = "Fecha no válido.";
	public static final String MSG_NUMERO_NO_VALIDO = "Número no válido.";
	public static final String MSG_DIGITO_NO_VALIDO = "Dígitos no válido.";
	public static final String MSG_TARJETA_CREDITO_NO_VALIDO = "Tarjeta de credito no valido.";
	public static final String MSG_MISMO_DATO_ANTERIOR = "Ingresar mismo dato anterior.";
	public static final String MSG_USUARIO_EXISTE = "Usuario ya Existe.";
	public static final String MSG_RUC_EXISTE = "RUC ya Existe.";
	public static final String MSG_NUMERO_DOCUMENTO_EXISTE = "Numero de Documento ya Existe.";
	public static final String MSG_SOLO_ALFANUMERICOS = "Solo valores Alfanumericos.";
	public static final String MSG_HORA_NO_VALIDO = "Hora no válido.";
	public static final String MSG_FECHA_MAYOR_ACTUAL = "Fecha debe ser mayor al actual.";
	public static final String MSG_HORA_MAYOR_ACTUAL = "Hora debe ser mayor al actual.";
	public static final String MSG_FECHA_HORA_ASIGNADA = "Fecha y Hora Asignada.";
	public static final String MSG_FECHA_MAYOR_DESDE = "Fecha debe ser mayor a Fecha desde.";
	
	/**
	 * Field ACTIVO.
	 */
	public static final String ACTIVO = "1";
	/**
	 * Field NO ACTIVO.
	 */
	public static final String INACTIVO = "0";
	public static final String PORCENTAJE = "%";
	
	public static final String CERO = "0";
}