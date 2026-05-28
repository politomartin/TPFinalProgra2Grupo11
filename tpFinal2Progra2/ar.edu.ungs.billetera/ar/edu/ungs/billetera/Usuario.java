package ar.edu.ungs.billetera;


import java.util.ArrayList;
import java.util.List;

class Usuario {

    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    private List<Cuenta> cuentas;
    private double totalInvertido;

    public Usuario(String dni, String nombre, String telefono, String email) {

        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.cuentas = new ArrayList<>();
    }

    public void crearCuentaRegular(double saldoTotal,  String alias) {

        Cuenta cuenta = new CuentaRegular(dni, alias );
        cuentas.add(cuenta);
    }
    
    public void crearCuentaPremium(double saldoTotal, String dni, String alias) {
    	Cuenta cuenta = new CuentaPremium(saldoTotal, dni, alias);
    	cuentas.add(cuenta);
    }
    
    

    public void crearCuentaEmpresa(boolean autorizado,String cuitEmpresa, String alias) {

        Cuenta cuenta = new CuentaEmpresa(0, dni, autorizado, cuitEmpresa, alias);
        cuentas.add(cuenta);
    }
    
    public void agregarCuenta(
            Cuenta cuenta) {

        cuentas.add(cuenta);
    }

    public String getDni() {
        return dni;
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public String getTelefono() {
    	return telefono;
    }

	public String getEmail() {
		return email;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public double getTotalInvertido() {
		return totalInvertido;
	}
	  public void sumarInvertido( double monto) {
	        totalInvertido += monto;
	    }
	
}

