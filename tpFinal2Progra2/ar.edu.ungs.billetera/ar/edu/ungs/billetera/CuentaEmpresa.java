package ar.edu.ungs.billetera;

public class CuentaEmpresa extends Cuenta {
	
	 private String cuitEmpresa;
	 private boolean autorizado;

	    public CuentaEmpresa(double saldoTotal, String dniUsuario, boolean autorizado, String cuitEmpresa, String alias) {

	        super(saldoTotal, dniUsuario, alias);

	        this.autorizado = true;
	        this.cuitEmpresa = cuitEmpresa;
	    }

	@Override
	public boolean puedeTransferir(double monto) {
		if(estaAutorizado()) {
			return saldoDisponible >= monto;
		}
		return false;
	}

	@Override
	public boolean puedeInvertir(double monto) {
		if(estaAutorizado()) {
			return saldoDisponible >= monto;
		}
		return false;
	}
	 public boolean estaAutorizado() {
	        return autorizado;
	    }
	 
	 public String getCuitEmpresa() {
		 return cuitEmpresa;
	 }

	 @Override
	 protected String getTipoCuenta() {
		// TODO Auto-generated method stub
		return "Corporativa";
	 }

}
