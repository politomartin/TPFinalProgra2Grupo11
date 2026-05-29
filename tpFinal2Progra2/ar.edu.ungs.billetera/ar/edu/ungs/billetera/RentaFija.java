package ar.edu.ungs.billetera;

import java.time.temporal.ChronoUnit;

public class RentaFija extends Inversion {

    private static final double TASA = 0.20;
    private double interes;

    public RentaFija(double monto, String cuentaOrigen, String dniUsuario, int plazo, boolean aprobada) {

        super(monto, cuentaOrigen, dniUsuario, plazo, "Renta Fija", aprobada);

        this.interes = TASA;
        this.preCancelable = true;
    }
    


    @Override
    public double sumarGanancia() {
        long diasTranscurridos =ChronoUnit.DAYS.between( fecha, Utilitarios.hoy());
        gananciasGeneradas += (monto * (interes / 365) * diasTranscurridos)/2;
        return gananciasGeneradas;
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

	@Override
	public double getMonto() {
		return monto;
	}


}
