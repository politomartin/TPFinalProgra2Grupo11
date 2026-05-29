package ar.edu.ungs.billetera;

class FondoLiquidezEmpresarial extends Inversion {
	
	private double inversionFLE;

    public FondoLiquidezEmpresarial(double monto, String cuentaOrigen, String dniUsuario, int plazo, boolean aprobada) {

        super(monto, cuentaOrigen, dniUsuario, plazo, "FLE ", aprobada);
        this.inversionFLE = 0.08;
    }

    
    @Override
    public double sumarGanancia() {

        double cotizacion = Utilitarios.consultarCotizacion("FLE");

        gananciasGeneradas += monto * cotizacion * inversionFLE;
        
        return gananciasGeneradas;
    }

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "FLE";
	}


	@Override
	public double getMonto() {
		return monto;
	}
}

