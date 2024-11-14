import java.util.ArrayList;
import java.util.Random;

public class Carro implements BMWClaseA {
    //Atributos
    private boolean encendido;
    private int temperaturaInt;
    private int temperaturaExt;
    private int nivelVentilacion;
    private String direccionVentilacion;
    private boolean circulacionInterna;
    private int nivelCalefaccionAsientos;
    private String nivelCalefaccionVolante;
    private boolean calefaccionRapida;
    private boolean desempañador;
    private boolean ionizador;
    private String intensidadIonizador;
    private String calidadDeAire;
    private int ionizadorAutolimpieza;
    private ArrayList<Object> perfil1;
    private ArrayList<Object> perfil2;
    private ArrayList<Object> perfil3;
    private ArrayList<String> historialMantenimienot;
    private String fechaDeMantenimiento;

    //Métodos
    public Carro(){
        this.encendido = false;
        this.temperaturaInt = 20;
        this.temperaturaExt = 26;
        this.nivelVentilacion = 1;
        this.direccionVentilacion = "frontal";
        this.circulacionInterna = false;
        this.nivelCalefaccionAsientos = 1;
        this.nivelCalefaccionVolante = "bajo";
        this.calefaccionRapida = false;
        this.desempañador = false;
        this.ionizador = false;
        this.intensidadIonizador = "bajo";
        Random random = new Random();
        this.calidadDeAire = random.nextBoolean() ? "buena" : "mala";
        this.ionizadorAutolimpieza = 0;
    }

    public void encender(){
        this.encendido = true;
    }

    public void apagar(){
        this.encendido = false;
    }

    public void ajustarTemperatura(int incremento){
        if (encendido) {
            this.temperaturaInt += incremento;
        }
    }

    public void activarModoAutomatico(){
        if (encendido) {
            this.temperaturaInt = this.temperaturaExt;
        } 
    }

    public void ajustarNivelVentilacion(int nivel){
        if (encendido) {
            this.nivelVentilacion = nivel;
        } 
    }

    public void cambiarDireccionFlujo(String direccion){
        if (encendido) {
            this.direccionVentilacion = direccion;
        } 
    }

    public void activarCirculacionInterna(){
        if (encendido) {
            this.circulacionInterna = !this.circulacionInterna;
        } 
    }

    public void ajustarCalefaccionAsientos(int nivel){
        if (encendido) {
            this.nivelCalefaccionAsientos = nivel;
        }
    }

    public void activarCalefaccionVolante(String nivel){
        if (encendido) {
            this.nivelCalefaccionVolante = nivel;
        }
    }

    public void activarCalefaccionRapida() {
        if (encendido) {
            if (this.calefaccionRapida == false) {
                this.calefaccionRapida = true;
                this.nivelCalefaccionAsientos = 3;
                this.nivelCalefaccionVolante = "alto";
            }
            else {
                this.calefaccionRapida = false;
            }
        }
    }

    public void activarDesempañador() {
        if (encendido) {
            this.desempañador = !this.desempañador;
        }
    }

    public void activarIonizador(){
        if (encendido) {
            this.ionizador = !this.ionizador;
        }
    }

    public void autoIonizador(String nivel){
        if (encendido) {
            if (this.ionizador == false) {
                if (this.calidadDeAire == "mala"){
                    this.ionizador = true;
                    this.intensidadIonizador = nivel;
                }
            }
        }
    }

    public void ajustarIonizador(String nivel){
        if (encendido && this.ionizador) {
            this.intensidadIonizador = nivel;
        }
    }

    public String cicloIonizador() {
        if (encendido) {
            if (this.ionizador == false) {
                return "El ionizador está desactivado.";
            }
            else {
                this.nivelVentilacion = 5;
                this.calidadDeAire = "excelente";
                return "Ciclo terminado. Calidad del aire: " + this.calidadDeAire;	
            } 
        }
        return "El carro está apagado.";
    }

    public void autoLimpiezaIonizador() {
        if (encendido) {
            this.ionizadorAutolimpieza += 1;
        }
    }

    public void reduceIonizador() {
        if (encendido) {
            this.intensidadIonizador = "bajo";
        }
    }
}