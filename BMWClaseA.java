import java.util.Date;

public interface BMWClaseA {
    /**
     * 
     */
    void encender(); // Solo enciende el sistema de climatización, no necesita devolver nada. X
    /**
     * 
     */
    void apagar(); // Apaga el sistema de climatización, no requiere devolver nada. X
    /**
     * @param incremento
     */
    void ajustarTemperatura(int incremento); // Ajusta la temperatura, no es necesario devolver nada. X
    /**
     * 
     */
    void activarModoAutomatico(); // Ajusta la temperatura a la externa, no devuelve nada. X
    /**
     * @param nivel
     */
    void ajustarNivelVentilacion(int nivel); // Ajusta el nivel de ventilación, no devuelve nada. X
    /**
     * @param direccion
     */
    void cambiarDireccionFlujo(String direccion); // Cambia la dirección del flujo de aire, no devuelve nada. X
    /**
     * 
     */
    void activarCirculacionInterna(); // Activa la circulación interna de aire, no devuelve nada. X
    /**
     * @param nivel
     */
    void ajustarCalefaccionAsientos(int nivel); // Ajusta la calefacción en los asientos, no devuelve nada. X
    /**
     * @param nivel
     */
    void activarCalefaccionVolante(String nivel); // Activa la calefacción del volante, no devuelve nada. X
    /**
     * 
     */
    void activarCalefaccionRapida(); // Activa el modo de calefacción rápida, no devuelve nada. X
    /**
     * 
     */
    void activarDesempañador(); // Activa o desactiva el desempañador, no devuelve nada. X
    /**
     * 
     */
    void activarIonizador(); // Activa el ionizador de aire, no devuelve nada. X
    /**
     * @param nivel
     */
    void autoIonizador(String nivel); // Activa el ionizador automáticamente según el nivel, no devuelve nada. X
    /**
     * @param nivel
     */
    void ajustarIonizador(String nivel); // Ajusta el nivel del ionizador, no devuelve nada. X
    /**
     * @return
     */
    String cicloIonizador(); // Aumenta la ventilación y devuelve la calidad del aire en formato de texto. X
    /**
     * 
     */
    void autoLimpiezaIonizador(); // Activa la limpieza automática del ionizador, no devuelve nada. X
    /**
     * 
     */
    void reduceIonizador(); // Reduce la intensidad del ionizador para ahorrar energía, no devuelve nada. X
    /**
     * @param nombre
     */
    void crearPerfil(String nombre); // Crea un nuevo perfil de climatización, no devuelve nada. X
    /**
     * @param nombre
     */
    void elegirPerfil(String nombre); // Selecciona un perfil al entrar al vehículo, no devuelve nada. X
    /**
     * @return
     */
    boolean mantenimiento(); // Notifica si es necesario un mantenimiento, devuelve un valor booleano. X
    /**
     * @return
     */
    String historialMantenimiento(); // Devuelve un historial de mantenimientos en formato de texto. X
    /**
     * @param fecha
     */
    void programarMantenimiento(Date fecha); // Permite programar una fecha de mantenimiento, no devuelve nada. X
}