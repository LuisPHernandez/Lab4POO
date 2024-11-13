import java.util.ArrayList;

public class Carro implements BMWClaseA {
    //Atributos
    private boolean encendido;
    private int temperaturaInt;
    private boolean modoAutomatico;
    private int temperaturaExt;
    private int nivelVentilacion;
    private String direccionVentilacion;
    private boolean circulacionInterna;
    private int nivelCalefaccionAsientoConductor;
    private int nivelCalefaccionAsientoPasajero;
    private int nivelCalefafaccionaAsientosTraseros;
    private String nivelCalefaccionVolante;
    private boolean calefaccionRapida;
    private boolean desempañador;
    private String ionizador;
    private String calidadDeAire;
    private boolean purificacionProfunda;
    private int ionizadorAutolimpieza;
    private boolean ionizadorBajoConsumo;
    private ArrayList<Object> perfil1;
    private ArrayList<Object> perfil2;
    private ArrayList<Object> perfil3;
    private ArrayList<String> historialMantenimienot;
    private String fechaDeMantenimiento;

    //Métodos
    public Carro(int temperaturaExt){
        this.encendido = false;
        this.temperaturaInt = 20;
        this.modoAutomatico = false;
        this.temperaturaExt = temperaturaExt;
    }

    public void encender(){
        this.encendido = true;
    }

    public void apagar(){
        this.encendido = false;
    }

    public void ajustarTemperatura(int incremento){
        this.temperaturaInt += incremento;
    }

    public void activarModoAutomatico(){
        this.modoAutomatico = true;
        this.temperaturaInt = this.temperaturaExt;
    }
}