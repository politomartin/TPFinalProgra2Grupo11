package ar.edu.ungs.billetera;

import java.time.temporal.ChronoUnit;

public class VinculadaADivisa extends Inversion {

    private String divisa;
    private double intereses = 0.03;
    private double cotizacion;

    public VinculadaADivisa(double monto, String cuentaOrigen, String dniUsuario, int plazo, String divisa, double interes, boolean aprobada) {

        super(monto, cuentaOrigen, dniUsuario, plazo, "Vinculada a Divisa", aprobada);

        this.divisa = divisa;
        this.preCancelable = true;
    }
    

    public void cotizacionAlMomentoDeInvertir() {
        cotizacion = Utilitarios.consultarCotizacion(divisa);
    }
    

    @Override
    public double sumarGanancia() {
    	
    	double cantidadDivisas = monto / cotizacion;
        long diasTranscurridos =ChronoUnit.DAYS.between( fecha, Utilitarios.hoy());
        double cotizacionActual = Utilitarios.consultarCotizacion(divisa);
        
        gananciasGeneradas += ((cantidadDivisas * (intereses / 365) * diasTranscurridos)+
        		(cantidadDivisas/2)) * cotizacionActual;
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
		return "Vinculada a Divisa";
	}

	@Override
	public double getMonto() {
		return monto;
	}



}
