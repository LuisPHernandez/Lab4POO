import java.util.Date;

public interface BMWClaseA {
    void encender(); // Solo enciende el sistema de climatización, no necesita devolver nada.
    void apagar(); // Apaga el sistema de climatización, no requiere devolver nada.
    void ajustarTemperatura(int incremento); // Ajusta la temperatura, no es necesario devolver nada.
    void activarModoAutomatico(); // Ajusta la temperatura a la externa, no devuelve nada.
    void ajustarNivelVentilacion(int nivel); // Ajusta el nivel de ventilación, no devuelve nada.
    void cambiarDireccionFlujo(String direccion); // Cambia la dirección del flujo de aire, no devuelve nada.
    void activarCirculacionInterna(); // Activa la circulación interna de aire, no devuelve nada.
    void ajustarCalefaccionAsientos(int nivel); // Ajusta la calefacción en los asientos, no devuelve nada.
    void activarCalefaccionVolante(String nivel); // Activa la calefacción del volante, no devuelve nada.
    void activarCalefaccionRapida(); // Activa el modo de calefacción rápida, no devuelve nada.
    void activarDesempañador(); // Activa o desactiva el desempañador, no devuelve nada.
    void activarIonizador(); // Activa el ionizador de aire, no devuelve nada.
    void autoIonizador(String nivel); // Activa el ionizador automáticamente según el nivel, no devuelve nada.
    void ajustarIonizador(String nivel); // Ajusta el nivel del ionizador, no devuelve nada.
    void crearPerfil(String nombre); // Crea un nuevo perfil de climatización, no devuelve nada.
    String cicloIonizador(); // Aumenta la ventilación y devuelve la calidad del aire en formato de texto.
    void autoLimpiezaIonizador(); // Activa la limpieza automática del ionizador, no devuelve nada.
    void reduceIonizador(); // Reduce la intensidad del ionizador para ahorrar energía, no devuelve nada.
    void crearPerfil(); // Configura perfiles personalizados de climatización, no devuelve nada.
    void editarPerfil(); // Permite editar los perfiles, no devuelve nada.
    void elegirPerfil(); // Selecciona un perfil al entrar al vehículo, no devuelve nada.
    boolean mantenimiento(); // Notifica si es necesario un mantenimiento, puede devolver un valor booleano.
    String historialMantenimiento(); // Devuelve un historial de mantenimientos en formato de texto.
    void programarMantenimiento(Date fecha); // Permite programar una fecha de mantenimiento, no devuelve nada.
}