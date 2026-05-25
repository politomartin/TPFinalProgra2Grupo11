package ar.edu.ungs.billetera;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billetera implements IBilletera {
	
	private Map<String, Usuario> usuarios;
	 private HashMap<Integer, Actividad> actividades;
	
	public Billetera() {
		usuarios = new HashMap<>();
		actividades= new HashMap<>();
	}
	
	
	

	public HashMap<Integer, Actividad> getActividades() {
		return actividades;
	}


	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}


	@Override
	public void registrarEmpresa(String cuit, String nombreFantasia, String telefono, String email,
			String nombreContacto) {
		

	}

	@Override
	public void agregarPersonaAutorizada(String cuitEmpresa, String dniAutorizado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registrarUsuario(String dni, String nombre, String telefono, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public String crearCuentaRegular(String dniUsuario, String alias) {
		// TODO Auto-generated method stub
		return null;
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
