package ar.edu.ungs.billetera;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

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
		
		empresa.agregarPersonaAutorizada(dniAutorizado);
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
		if (depositoInicial < 500000) {
			throw new IllegalArgumentException("El depósito inicial debe ser de al menos $500.000");
		}

		 Usuario usuario = usuarios.get(dniUsuario);
		 Cuenta cuenta = new CuentaPremium(depositoInicial, dniUsuario, alias);
		 usuario.agregarCuenta(cuenta); 
		 aliasCvu.put(alias, cuenta.getCvu());

		return cuenta.getCvu();
	}

	@Override
	public String crearCuentaCorporativa(String dniUsuario, String alias, String cuitEmpresa) {

		
		Empresa empresa = empresas.get(cuitEmpresa);

	    if (empresa == null) {
	        throw new IllegalArgumentException("La empresa no existe");
	    }

	    if (!empresa.estaAutorizado(dniUsuario)) {
	        throw new IllegalArgumentException("El usuario no está autorizado para operar con esta empresa");
	    }

			Usuario usuario = usuarios.get(dniUsuario);
			
			Cuenta cuenta = new CuentaEmpresa(0, dniUsuario, true, cuitEmpresa, alias);
			
			usuario.agregarCuenta(cuenta);
			
			aliasCvu.put(alias, cuenta.getCvu());

			return cuenta.getCvu();
			
			
	}

	@Override
	public List<String> obtenerCuentas(String dniUsuario) {
		Usuario usuario = usuarios.get(dniUsuario);

    	List<String> resultado = new ArrayList<>();

		for (Cuenta cuenta : usuario.getCuentas()) {
			resultado.add(cuenta.toString());
		}

    	return resultado;
	}

	public double obtenerSaldoDisponible(String cvu) {
		return devolverCuentaConCVU(cvu).saldoDisponible;
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
		if (!aliasCvu.containsKey(alias)) {
			throw new IllegalArgumentException("El alias no existe, ingrese un alias existente");
		    }

		    return aliasCvu.get(alias);
	}

	@Override
	public List<String> consultarHistorialGlobal() {
		
		   ArrayList<String> lista = new ArrayList<>();

	       for (Actividad actividad : actividades.values() ) {
	        	lista.add(actividad.toString());
	        }
	        return lista;

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
		
        HashMap<String, Integer> contadorMovimientos = new HashMap<>();
        
        for (Actividad actividad : actividades.values()) {
            String cvu = actividad.getCVU();
            contadorMovimientos.put(cvu,contadorMovimientos.getOrDefault(cvu, 0) + 1);
        };

        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(contadorMovimientos.entrySet());

        listaOrdenada.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<String> topCuentas = new ArrayList<>();

        for (int i = 0; i < cantidadTop && i < listaOrdenada.size(); i++) {

            topCuentas.add(listaOrdenada.get(i).getKey().toString());
        }

        return topCuentas;
    };
	
	private Cuenta devolverCuentaConCVU(String cvu) {		
		for(Usuario user: usuarios.values()) {
			for(Cuenta cuenta: user.getCuentas()) {
				if(cuenta.getCvu().equals(cvu)) {
					return cuenta;
				}
			}
		}
		throw new IllegalArgumentException("Este CVU no existe");
	}

}
