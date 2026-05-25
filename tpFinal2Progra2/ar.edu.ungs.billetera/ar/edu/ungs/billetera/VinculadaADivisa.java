package ar.edu.ungs.billetera;

public class VinculadaADivisa extends Inversion {

    private String divisa;
    private double interes;

    public VinculadaADivisa(String id, String fecha, double monto, String cuentaOrigen, String dniUsuario, int plazo, String divisa, double interes, boolean aprobada) {

        super(monto, cuentaOrigen, dniUsuario, plazo, "Vinculada a Divisa", aprobada);

        this.divisa = divisa;
        this.interes = interes;
        this.preCancelable = true;
    }

    @Override
    public void sumarGanancia() {

        double cotizacion = Utilitarios.consultarCotizacion(divisa);

        gananciasGeneradas += monto * cotizacion * interes;
    }
    
    
    public void precancelar() {

        if (!preCancelable) {

            throw new RuntimeException(
                    "No es precancelable");
        }
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}


}
