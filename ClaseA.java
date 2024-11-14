import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class ClaseA implements BMWClaseA {
    //Atributos
    /**
     *
     */
    private boolean encendido;
    /**
     *
     */
    private int temperaturaInt;
    /**
     *
     */
    private int temperaturaExt;
    /**
     *
     */
    private int nivelVentilacion;
    /**
     *
     */
    private String direccionVentilacion;
    /**
     *
     */
    private boolean circulacionInterna;
    /**
     *
     */
    private int nivelCalefaccionAsientos;
    /**
     *
     */
    private String nivelCalefaccionVolante;
    /**
     *
     */
    private boolean calefaccionRapida;
    /**
     *
     */
    private boolean desempañador;
    /**
     *
     */
    private boolean ionizador;
    /**
     *
     */
    private String intensidadIonizador;
    /**
     *
     */
    private String calidadDeAire;
    /**
     *
     */
    private int ionizadorAutolimpieza;
    /**
     *
     */
    private int numeroPerfiles;
    /**
     *
     */
    private ArrayList<String> perfil1;
    /**
     *
     */
    private ArrayList<String> perfil2;
    /**
     *
     */
    private ArrayList<String> perfil3;
    /**
     *
     */
    private ArrayList<String> historialMantenimiento;
    /**
     *
     */
    private String fechaDeMantenimiento;

    //Métodos
    /**
     * 
     */
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

    //Cambia el estado del sistema a encendid0
    public void encender(){
        this.encendido = true;
    }

    //Cambia el estado del sistema a apagado
    public void apagar(){
        this.encendido = false;
    }

    //Ajusta la temperatura interior del vehículo por el incremento que el usuario ingrese
    public void ajustarTemperatura(int incremento){
        if (encendido) {
            this.temperaturaInt += incremento;
        }
    }

    //Activa el modo de operación automático del vehículo, que establece la temperatura interior al nivel de la externa
    public void activarModoAutomatico(){
        if (encendido) {
            this.temperaturaInt = this.temperaturaExt;
        } 
    }

    //Ajusta el nivel de ventilación del vehículo por el nivel que el usuario ingrese
    public void ajustarNivelVentilacion(int nivel){
        if (encendido) {
            this.nivelVentilacion = nivel;
        } 
    }

    //Cambia la dirección del flujo de aire del vehículo por la dirección que el usuario ingrese
    public void cambiarDireccionFlujo(String direccion){
        if (encendido) {
            this.direccionVentilacion = direccion;
        } 
    }

    //Activa circulación del aire solo adentro del vehículo
    public void activarCirculacionInterna(){
        if (encendido) {
            this.circulacionInterna = !this.circulacionInterna;
        } 
    }

    //Ajusta el nivel de calefacción del asiento por el nivel que el usuario ingrese
    public void ajustarCalefaccionAsientos(int nivel){
        if (encendido) {
            this.nivelCalefaccionAsientos = nivel;
        }
    }

    //Activa la calefacción del volante con el nivel que el usuario ingrese
    public void activarCalefaccionVolante(String nivel){
        if (encendido) {
            this.nivelCalefaccionVolante = nivel;
        }
    }

    //Activa la calefacción rápida del vehículo, que aumenta el nivel de calefacción del asiento y del volante
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

    //Activa y desactiva el desempañador
    public void activarDesempañador() {
        if (encendido) {
            this.desempañador = !this.desempañador;
        }
    }

    //Activa y desactiva el ionizador
    public void activarIonizador(){
        if (encendido) {
            this.ionizador = !this.ionizador;
        }
    }

    //Activa el ionizador automáticamente  si la calidad del aire es mala según el nivel que el usuario ingrese
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

    //Ajusta la intensidad del ionizador por el nivel que el usuario ingrese
    public void ajustarIonizador(String nivel){
        if (encendido && this.ionizador) {
            this.intensidadIonizador = nivel;
        }
    }

    //Activa el ciclo de purificación profunda del ionizador
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

    //Activa la autolimpieza del ionizador
    public void autoLimpiezaIonizador() {
        if (encendido) {
            this.ionizadorAutolimpieza += 1;
        }
    }

    //Pone el ionizador en intensidad baja para guardar energía
    public void reduceIonizador() {
        if (encendido) {
            this.intensidadIonizador = "bajo";
        }
    }

    //Crea un perfil con los valores actuales
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

    //Permite elegir un perfil con valores almacenados
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

    //Determina si es necesario un mantenimiento, si lo es lo realiza
    public boolean mantenimiento() {
        Random random = new Random();
        boolean mantenimiento = random.nextBoolean();
        if (mantenimiento = true) {
            Date fechaActual = new Date();
            String fechaString = fechaActual.toString();
            this.historialMantenimiento.add(fechaString);
        }
        return mantenimiento;
    }

    //Muestra el historial de mantenimientos realizados
    public String historialMantenimiento() {
        return String.join(", ", historialMantenimiento);
    }

    //Programa una fecha de mantenimiento para el sistema
    public void programarMantenimiento(Date fecha) {
        this.fechaDeMantenimiento = fecha.toString();
    }
}