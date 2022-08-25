public class Persona {
    // Declaracion de atributos
    private String Nombre, Genero;
    private int id, rut, edad, numero;

    //Constructor
    public Persona(){
        Nombre = "";
        Genero = "";
        id = 0;
        rut = 0;
        edad = 0;
        numero = 0;
    }

    // Getter y Setter
    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public String GetNombre() {
        return Nombre;
    }

    public void SetNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String GetGenero() {
        return Genero;
    }

    public void SetGenero(String Genero) {
        this.Genero = Genero;
    }

    public int GetRut() {
        return rut;
    }

    public void SetRut(int rut) {
        this.rut = rut;
    }

    public int GetEdad() {
        return edad;
    }

    public void SetEdad(int edad) {
        this.edad = edad;
    }

    public int GetNumero() {
        return numero;
    }

    public void SetNumero(int numero) {
        this.numero = numero;
    }

}