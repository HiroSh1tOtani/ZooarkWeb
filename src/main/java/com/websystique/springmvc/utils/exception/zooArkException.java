package com.websystique.springmvc.utils.exception;

public class zooArkException
    extends Exception
{

    private static final long serialVersionUID = 1L;

    // tipo de error para no llenarse de clases excepcion
    private String tipo;

    // cadena texto que describe la excepcion
    private String mensaje;

    // atributo extra para cualquier otro manejo
    private Object extra;

    public zooArkException(final String mensaje)
    {
        this("default-type-error", mensaje, null);
    }

    public zooArkException(final String tipo,
                                    final String mensaje)
    {
        this("default-type-error", mensaje, null);
    }

    public zooArkException(final String tipo,
                                    final String mensaje,
                                    final Object extra)
    {
        super(mensaje);
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.extra = extra;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(final String tipo)
    {
        this.tipo = tipo;
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public void setMensaje(final String mensaje)
    {
        this.mensaje = mensaje;
    }

    public Object getExtra()
    {
        return extra;
    }

    public void setExtra(final Object extra)
    {
        this.extra = extra;
    }

}
