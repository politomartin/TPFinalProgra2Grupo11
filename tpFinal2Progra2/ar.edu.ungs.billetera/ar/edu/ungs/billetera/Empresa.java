package ar.edu.ungs.billetera;

import java.util.HashSet;
import java.util.Set;

public class Empresa {

    private String cuit;
    private String nombre;
    private String telefono;
    private String email;
    private String nombreContacto;    
    private Set <String> usuariosAutorizados;


    public Empresa(String cuit,
                   String nombre,
                   String telefono,
                   String email,
                   String nombreContacto) {

        this.cuit = cuit;
        this.nombre= nombre;
        this.telefono = telefono;
        this.email = email;
        this.nombreContacto = nombreContacto;
        this.usuariosAutorizados = new HashSet<>();


    }
    
    public void agregarPersonaAutorizada(String DNIAutorizado) {
    	usuariosAutorizados.add(DNIAutorizado);
    }

    public boolean estaAutorizado(String dniUsuario) {
        return usuariosAutorizados.contains(dniUsuario);
    }

    public String getCuit() {
        return cuit;
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

    public String getNombreContacto() {
        return nombreContacto;
    }
}