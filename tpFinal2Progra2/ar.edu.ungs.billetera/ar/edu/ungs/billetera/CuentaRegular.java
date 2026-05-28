package ar.edu.ungs.billetera;

public class CuentaRegular extends Cuenta {
	
	
	 private double limiteSaldo = 5000000;

    public CuentaRegular(String dniUsuario, String alias) {
        super(0, dniUsuario, alias);
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
    public void depositar(double monto) {
    	 if (saldoDisponible + monto > limiteSaldo) {

             throw new IllegalStateException("La cuenta regular supera el limite permitido");
         }

         saldoDisponible += monto;
    }

	@Override
	protected String getTipoCuenta() {
		// TODO Auto-generated method stub
		return "Regular";
	}
}
