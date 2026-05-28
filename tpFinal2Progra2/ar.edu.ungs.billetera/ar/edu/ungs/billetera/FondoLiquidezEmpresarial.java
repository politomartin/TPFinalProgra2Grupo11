package ar.edu.ungs.billetera;

class FondoLiquidezEmpresarial extends Inversion {
	
	private double inversionFLE;

    public FondoLiquidezEmpresarial(String id, String fecha, double monto, String cuentaOrigen, String dniUsuario, int plazo, boolean aprobada) {

        super(monto, cuentaOrigen, dniUsuario, plazo, "FLE ", aprobada);
        this.inversionFLE = 0.8;
    }

    
    @Override
    public void sumarGanancia() {

        double cotizacion =
                Utilitarios.consultarCotizacion("FLE");

        gananciasGeneradas +=
                monto * cotizacion * inversionFLE;
    }

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "FLE";
	}
}

