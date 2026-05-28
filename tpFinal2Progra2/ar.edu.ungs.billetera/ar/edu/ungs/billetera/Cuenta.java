package ar.edu.ungs.billetera;

public abstract class Cuenta {

    protected String cvu;
    protected String alias;
    protected double saldoDisponible;
    protected double saldoTotal;
    protected String dniUsuario;

    public Cuenta(double saldoTotal, String dniUsuario, String alias) {
        this.saldoTotal = saldoTotal;
        this.saldoDisponible = saldoTotal;
        this.dniUsuario = dniUsuario;
        this.alias = alias;
        this.cvu = Utilitarios.generarSiguienteCvu();
    }

    public void depositar(double monto) {
        saldoDisponible += monto;
        saldoTotal += monto;
    }

    public void extraer(double monto) {

        if (saldoDisponible >= monto) {
            saldoDisponible -= monto;
            saldoTotal -= monto;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void invertir(double monto, Cuenta cuentaOrigen, String dniUsuario, int plazo, String tipoDeInversion) {

        if (puedeInvertir(monto)) {
            extraer(monto);
            System.out.println("Inversión realizada");
        } else {
            System.out.println("No puede invertir");
        }
    }

    public boolean transferirDinero(double monto, Cuenta cuentaOrigen, String dniUsuario, Cuenta cuentaDestino) {

        if (puedeTransferir(monto)) {

            cuentaOrigen.extraer(monto);
            cuentaDestino.depositar(monto);
            
            System.out.println("Transferencia realizada");
            return true;
        } else {
        	System.out.println("No puede transferir");
            return false;
        }
    }

    public abstract boolean puedeTransferir(double monto);

    public abstract boolean puedeInvertir(double monto);

    public double mostrarSaldo() {
        return saldoDisponible;
    }

    public String devolverDNIUsuario() {
        return dniUsuario;
    }

    public String getCvu() {
        return cvu;
    }
    
    @Override
    public String toString() {
        return getTipoCuenta() + ": " +
               alias + " (" + cvu + ")";
    }

	protected abstract String getTipoCuenta();
}

