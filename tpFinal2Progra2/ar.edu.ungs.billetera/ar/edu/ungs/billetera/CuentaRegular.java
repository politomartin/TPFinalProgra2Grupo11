package ar.edu.ungs.billetera;

public class CuentaRegular extends Cuenta {

    public CuentaRegular(double saldoTotal, String dniUsuario, String alias) {
        super(saldoTotal, dniUsuario, alias);
    }

    @Override
    public boolean puedeTransferir(double monto) {
        return saldoDisponible >= monto;
    }

    @Override
    public boolean puedeInvertir(double monto) {
        return monto <= saldoDisponible * 0.5;
    }

	@Override
	protected String getTipoCuenta() {
		// TODO Auto-generated method stub
		return "Regular";
	}
}
