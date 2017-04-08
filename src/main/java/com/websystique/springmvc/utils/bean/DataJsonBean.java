package com.websystique.springmvc.utils.bean;

import java.io.Serializable;

public class DataJsonBean
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String estado;
    private String msg;
    private Object dataJson;

    public void setRespuesta(final String estado,
                             final String msg,
                             final Object dataJson)
    {
        setEstado(estado);
        setMsg(msg);
        setDataJson(dataJson);
    }

    public void setRespuesta(final String estado,
                             final String msg)
    {
        setEstado(estado);
        setMsg(msg);
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(final String estado)
    {
        if (estado == null) {
            this.estado = "";
        } else {
            this.estado = estado;
        }
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(final String msg)
    {
        if (msg == null) {
            this.msg = "";
        } else {
            this.msg = msg;
        }
    }

    public Object getDataJson()
    {
        return dataJson;
    }

    public void setDataJson(final Object dataJson)
    {
        this.dataJson = dataJson;
    }
}