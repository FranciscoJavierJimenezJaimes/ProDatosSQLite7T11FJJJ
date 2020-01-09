package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.DatosGS;

import java.sql.Blob;

public class DatosGS {
    int id;
    String nombre;
    int edad;
    String correo;
    String curp;
    byte Imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public byte getImagen() {
        return Imagen;
    }

    public void setImagen(byte imagen) {
        Imagen = imagen;
    }
}


