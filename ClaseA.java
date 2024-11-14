import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class ClaseA implements BMWClaseA {
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
    private int numeroPerfiles;
    private ArrayList<String> perfil1;
    private ArrayList<String> perfil2;
    private ArrayList<String> perfil3;
    private ArrayList<String> historialMantenimiento;
    private String fechaDeMantenimiento;

    //Métodos
    public ClaseA(){
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
        this.numeroPerfiles = 0;
        this.perfil1 = new ArrayList<String>();
        this.perfil2 = new ArrayList<String>();
        this.perfil3 = new ArrayList<String>();
        this.historialMantenimiento = new ArrayList<String>();
        this.fechaDeMantenimiento = "";
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

    public void crearPerfil(String nombre) {
        if (encendido){
            ArrayList<String> perfil = new ArrayList<>();

            perfil.add(nombre);
            perfil.add(String.valueOf(this.temperaturaInt));
            perfil.add(String.valueOf(this.nivelVentilacion));
            perfil.add(this.direccionVentilacion);
            perfil.add(String.valueOf(this.circulacionInterna));
            perfil.add(String.valueOf(this.nivelCalefaccionAsientos));
            perfil.add(this.nivelCalefaccionVolante);
            perfil.add(String.valueOf(this.calefaccionRapida));
            perfil.add(String.valueOf(this.desempañador));
            perfil.add(String.valueOf(this.ionizador));
            perfil.add(this.intensidadIonizador);
    
            if (numeroPerfiles == 0) {
                perfil1 = perfil;
            } else if (numeroPerfiles == 1) {
                perfil2 = perfil;
            } else if (numeroPerfiles == 2) {
                perfil3 = perfil;
            }
            numeroPerfiles ++;
        }   
    }

    public void elegirPerfil(String nombre) {
        if (encendido) {
            ArrayList<String> perfil = null;

            if (perfil1 != null && perfil1.get(0).equals(nombre)) {
                perfil = perfil1;
            } else if (perfil2 != null && perfil2.get(0).equals(nombre)) {
                perfil = perfil2;
            } else if (perfil3 != null && perfil3.get(0).equals(nombre)) {
                perfil = perfil3;
            }

            if (perfil != null) {
                this.temperaturaInt = Integer.parseInt(perfil.get(1));
                this.nivelVentilacion = Integer.parseInt(perfil.get(2));
                this.direccionVentilacion = perfil.get(3);
                this.circulacionInterna = Boolean.parseBoolean(perfil.get(4));
                this.nivelCalefaccionAsientos = Integer.parseInt(perfil.get(5));
                this.nivelCalefaccionVolante = perfil.get(6);
                this.calefaccionRapida = Boolean.parseBoolean(perfil.get(7));
                this.desempañador = Boolean.parseBoolean(perfil.get(8));
                this.ionizador = Boolean.parseBoolean(perfil.get(9));
                this.intensidadIonizador = perfil.get(10);
            }
        } 
    }

    public boolean mantenimiento() {
        Random random = new Random();
        boolean mantenimiento = random.nextBoolean();
        Date fechaActual = new Date();
        String fechaString = fechaActual.toString();
        this.historialMantenimiento.add(fechaString);
        return mantenimiento;
    }

    public String historialMantenimiento() {
        return String.join(", ", historialMantenimiento);
    }

    public void programarMantenimiento(Date fecha) {
        this.fechaDeMantenimiento = fecha.toString();
    }
}