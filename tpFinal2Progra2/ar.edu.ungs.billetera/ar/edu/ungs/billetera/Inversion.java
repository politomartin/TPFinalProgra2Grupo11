package ar.edu.ungs.billetera;

public abstract class Inversion extends Actividad {

    protected int id;
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
    }

    public double calcularMontoADevolver() {
        throw new RuntimeException("Esta inversión no es precancelable");
    }

    public abstract double sumarGanancia();

    public double getGananciasGeneradas() {
        return gananciasGeneradas;
    }
    
    public int getIdInversion() {
        return id;
    }
    
    public abstract double getMonto();
    
    public boolean esPreCancelable() {
        return preCancelable;
    }
    
    @Override
    public String toString() {

        String estado;

        if (aprobada) {
            estado = "Aprobado";

        } else {
            estado = "Rechazado";
        }

        return "fecha: " + fecha+ "\norigen: "+ dniUsuario+ " ("+ cvuCuentaOrigen+ ")"
                + "\ndesc: "+ getDescripcion()
                + "\nmonto: "+ monto 
                + "\nplazo: "+ plazo
                + "\n"+ estado;
    }

	protected abstract String getDescripcion();

    
}