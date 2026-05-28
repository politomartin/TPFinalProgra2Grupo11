package ar.edu.ungs.billetera;

public abstract class Inversion extends Actividad {

    protected String id;
	protected int plazo;
    protected String tipoDeInversion;
    protected boolean preCancelable;
    protected double gananciasGeneradas;

    

    public Inversion(double monto, 
    				String cuentaOrigen, 
    				String dniUsuario, 
    				int plazo, 
    				String tipoDeInversion, 
    				boolean aprobada) {
    	

        super(monto, cuentaOrigen, dniUsuario, aprobada);
        this.plazo = plazo;
        this.tipoDeInversion = tipoDeInversion;
        this.id = id;
    }

    public abstract void sumarGanancia();

    public double getGananciasGeneradas() {
        return gananciasGeneradas;
    }
    
    public String getIdInversion() {
        return id;
    }
    
    public boolean esPreCancelable() {
        return preCancelable;
    }
    
}