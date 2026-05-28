package ar.edu.ungs.billetera;

public class RentaFija extends Inversion {

    private double interes;

    public RentaFija(double monto, String cuentaOrigen, String dniUsuario, int plazo, double interes, boolean aprobada) {

        super(monto, cuentaOrigen, dniUsuario, plazo, "Renta Fija", aprobada);

        this.interes = interes;
        this.preCancelable = true;
    }

    @Override
    public void sumarGanancia() {
        gananciasGeneradas += monto * interes;
    }

    public void precancelar() {

        if (!preCancelable) {
            throw new RuntimeException(
                    "No es precancelable");
        }
    }

	@Override
	protected String getDescripcion() {
		// TODO Auto-generated method stub
		return "Renta Fija";
	}


}
