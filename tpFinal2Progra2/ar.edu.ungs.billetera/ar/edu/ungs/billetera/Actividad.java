package ar.edu.ungs.billetera;

import java.time.LocalDate;

public abstract class Actividad {
    protected LocalDate fecha;
    protected double monto;
    protected String cvuCuentaOrigen;
    protected String dniUsuario;
    protected boolean aprobada;

    public Actividad(double monto, String cvuCuentaOrigen, String dniUsuario, boolean aprobada) {
        this.fecha = Utilitarios.hoy();
        this.monto = monto;
        this.cvuCuentaOrigen = cvuCuentaOrigen;
        this.dniUsuario = dniUsuario;
        this.aprobada = true;
    }

    public double mostrarMonto() {
        return monto;
    }
    
    public boolean fueAprobada() {
        return aprobada;
    }

    @Override
    public abstract String toString();
    
    public String getCVU(){
    	return cvuCuentaOrigen; 	
    };
    
    public String getDNI() {
    	return dniUsuario;
    }

}
