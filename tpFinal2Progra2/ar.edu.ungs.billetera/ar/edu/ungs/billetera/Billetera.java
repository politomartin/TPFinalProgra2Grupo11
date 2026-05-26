package ar.edu.ungs.billetera;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billetera implements IBilletera {
	
	private HashMap<String, Usuario> usuarios;
	private HashMap<Integer, Actividad> actividades;
	private HashMap<String, Empresa> empresas;
	private HashMap<String, String> aliasCvu;
	
	public Billetera() {
		usuarios = new HashMap<>();
		actividades= new HashMap<>();
		empresas = new HashMap<>();
		aliasCvu = new HashMap<>();
	}
	
	
	

	public HashMap<Integer, Actividad> getActividades() {
		return actividades;
	}




	@Override
	public void registrarEmpresa(String cuit, String nombreFantasia, String telefono, String email,
			String nombreContacto) {
		Empresa empresa = new Empresa(cuit, nombreFantasia, telefono, email, nombreContacto);
		
		empresas.put(cuit, empresa);
		

	}

	@Override
	public void agregarPersonaAutorizada(String cuitEmpresa, String dniAutorizado) {
		Empresa empresa = empresas.get(cuitEmpresa);
		

	}

	@Override
	public void registrarUsuario(String dni, String nombre, String telefono, String email) {
		Usuario usuario = new Usuario(dni, nombre, telefono, email);
		usuarios.put(dni, usuario);
	}

	@Override
	public String crearCuentaRegular(String dniUsuario, String alias) {
		Usuario usuario = usuarios.get(dniUsuario);
		
		Cuenta cuenta = new CuentaRegular(dniUsuario, alias);
		
		usuario.agregarCuenta(cuenta);
		
		aliasCvu.put(alias, cuenta.getCvu());

		return cuenta.getCvu();
		
	}

	@Override
	public String crearCuentaPremium(String dniUsuario, String alias, double depositoInicial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String crearCuentaCorporativa(String dniUsuario, String alias, String cuitEmpresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> obtenerCuentas(String dniUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double obtenerSaldoDisponible(String cvu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void realizarTransferencia(String cvuOrigen, String cvuDestino, double monto) {
		// TODO Auto-generated method stub

	}

	@Override
	public int realizarInversionRentaFija(String dni, String cvu, double monto, int plazoDias) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int realizarInversionDivisa(String dni, String cvu, double monto, int plazoDias, String divisa,
			double tasa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int realizarInversionLiquidez(String dni, String cvu, double monto, int plazoDias) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void precancelarInversion(String dni, String cvu, int idInversion) {
		// TODO Auto-generated method stub

	}

	@Override
	public String consultarCvu(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> consultarHistorialGlobal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> consultarHistorialCuenta(String cvu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> consultarHistorialUsuario(String dniUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double obtenerTotalInvertido(String dniUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> cuentasConMayorVolumen(int cantidadTop) {
		// TODO Auto-generated method stub
		return null;
	}

}
