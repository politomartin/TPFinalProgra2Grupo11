package ar.edu.ungs.billetera;



public class Empresa {

    private String cuit;

    private String nombre;

    private String telefono;

    private String email;

    private String nombreContacto;


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