package ar.edu.ungs.billetera;

public class CuentaPremium extends Cuenta {

    public CuentaPremium(double saldoTotal, String dniUsuario, String alias) {
        super(saldoTotal, dniUsuario, alias);
    }

    @Override
    public boolean puedeTransferir(double monto) {
        return saldoDisponible >= monto;
    }

    @Override
    public boolean puedeInvertir(double monto) {
        return saldoDisponible >= monto;
    }

	@Override
	protected String getTipoCuenta() {
		// TODO Auto-generated method stub
		return "Premium";
	}
}


