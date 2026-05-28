package ar.edu.ungs.billetera;

public class Transferencia extends Actividad {

	private String dniDestino;
    private String cvuCuentaDestino;

    public Transferencia(double monto, String cvuCuentaOrigen, String dniUsuario, String cvuCuentaDestino, String dniDestino, boolean aprobada) {

        super(monto, cvuCuentaOrigen, dniUsuario, aprobada);

        this.cvuCuentaDestino = cvuCuentaDestino;
        this.dniDestino = dniDestino;
    }

    public void transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {

        cuentaOrigen.extraer(monto);
        cuentaDestino.depositar(monto);
    }
    
    public String getCvuCuentaDestino() {
    	return cvuCuentaDestino;
    }
    public String getDniDestino() {
    	return dniDestino;
    }
    

	@Override
	public String toString() {

	    String estado;

	    if (aprobada) {
	        estado = "Aprobado";
	    } else {
	        estado = "Rechazado";
	    }
	    return "fecha: " + fecha+ "\norigen: "+ dniUsuario+ " ("+ cvuCuentaOrigen+ ")"+ 
	    "\ndestino: "+ dniDestino+ " ("+ cvuCuentaDestino+ ")" + 
	    "\nmonto: "+ monto+ 
	    "\n"+ estado;
	}
}
