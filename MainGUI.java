import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainGUI {
    private static boolean sistemaEncendido = false;
    private static boolean desempañadorActivo = false; 
    private static boolean ionizadorActivo = false;

    public static void main(String[] args) {
        // Crear una instancia de ClaseA usando la interfaz BMWClaseA
        BMWClaseA carro = new ClaseA();

        // Crear la ventana principal
        JFrame frame = new JFrame("Simulador de Climatización BMW");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLayout(new GridLayout(0, 1));

        // Crear un área de texto para mostrar mensajes de éxito
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Botones para cada método
        JButton encenderBtn = new JButton("Encender");
        encenderBtn.addActionListener(e -> {
            carro.encender();
            sistemaEncendido = true;
            outputArea.append("Sistema encendido\n");
        });

        JButton apagarBtn = new JButton("Apagar");
        apagarBtn.addActionListener(e -> {
            carro.apagar();
            sistemaEncendido = false;
            outputArea.append("Sistema apagado\n");
        });

        JButton ajustarTempBtn = new JButton("Ajustar Temperatura");
        ajustarTempBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String input = JOptionPane.showInputDialog("Ingrese el incremento de temperatura:");
                try {
                    int incremento = Integer.parseInt(input);
                    carro.ajustarTemperatura(incremento);
                    outputArea.append("Temperatura ajustada en " + incremento + " grados\n");
                } catch (NumberFormatException ex) {
                    outputArea.append("Entrada no válida\n");
                }
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton modoAutoBtn = new JButton("Modo Automático");
        modoAutoBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                carro.activarModoAutomatico();
                outputArea.append("Modo automático activado, temperatura ajustada a temperatura externa\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton ventilacionBtn = new JButton("Ajustar Nivel Ventilación");
        ventilacionBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String input = JOptionPane.showInputDialog("Ingrese el nivel de ventilación (1 a 5):");
                try {
                    int nivel = Integer.parseInt(input);
                    if (nivel < 1 || nivel > 5) throw new NumberFormatException();
                    carro.ajustarNivelVentilacion(nivel);
                    outputArea.append("Nivel de ventilación ajustado a " + nivel + "\n");
                } catch (NumberFormatException ex) {
                    outputArea.append("Nivel inválido. Debe estar entre 1 y 5.\n");
                }
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton direccionBtn = new JButton("Cambiar Dirección Flujo");
        direccionBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String direccion = JOptionPane.showInputDialog("Ingrese dirección del flujo (parabrisas, frontal, pies):");
                carro.cambiarDireccionFlujo(direccion);
                outputArea.append("Dirección del flujo cambiada a " + direccion + "\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton circulacionBtn = new JButton("Activar Circulación Interna");
        circulacionBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                carro.activarCirculacionInterna();
                outputArea.append("Circulación interna activada\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton calefaccionAsientosBtn = new JButton("Ajustar Calefacción Asientos");
        calefaccionAsientosBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String input = JOptionPane.showInputDialog("Ingrese el nivel de calefacción para los asientos (1 a 3):");
                try {
                    int nivel = Integer.parseInt(input);
                    if (nivel < 1 || nivel > 3) throw new NumberFormatException();
                    carro.ajustarCalefaccionAsientos(nivel);
                    outputArea.append("Calefacción en asientos ajustada a nivel " + nivel + "\n");
                } catch (NumberFormatException ex) {
                    outputArea.append("Nivel inválido. Debe estar entre 1 y 3.\n");
                }
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton calefaccionVolanteBtn = new JButton("Activar Calefacción Volante");
        calefaccionVolanteBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String nivel = JOptionPane.showInputDialog("Ingrese nivel de calefacción del volante (bajo o alto):");
                carro.activarCalefaccionVolante(nivel);
                outputArea.append("Calefacción del volante ajustada a " + nivel + "\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton calefaccionRapidaBtn = new JButton("Activar Calefacción Rápida");
        calefaccionRapidaBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                carro.activarCalefaccionRapida();
                outputArea.append("Calefacción rápida activada\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton desempañadorBtn = new JButton("Activar/Desactivar Desempañador");
        desempañadorBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                desempañadorActivo = !desempañadorActivo;
                carro.activarDesempañador();
                outputArea.append(desempañadorActivo ? "Desempañador activado\n" : "Desempañador desactivado\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton ionizadorBtn = new JButton("Activar/Desactivar Ionizador");
        ionizadorBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                ionizadorActivo = !ionizadorActivo;
                carro.activarIonizador();
                outputArea.append(ionizadorActivo ? "Ionizador activado\n" : "Ionizador desactivado\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton autoIonizadorBtn = new JButton("Modo Automático del Ionizador");
        autoIonizadorBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String nivel = JOptionPane.showInputDialog("Ingrese el nivel del ionizador (bajo, medio, alto):");
                carro.autoIonizador(nivel);
                outputArea.append("Modo automático del ionizador activado, el ionizador se prenderá en nivel " + nivel + "\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton ajustarIonizadorBtn = new JButton("Ajustar Nivel Ionizador");
        ajustarIonizadorBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String nivel = JOptionPane.showInputDialog("Ingrese el nivel del ionizador (bajo, medio, alto):");
                carro.ajustarIonizador(nivel);
                outputArea.append("Nivel de ionizador ajustado a " + nivel + "\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton cicloIonizadorBtn = new JButton("Purificación profunda");
        cicloIonizadorBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String mensaje = carro.cicloIonizador();
                outputArea.append(mensaje + "\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton ionizadorAutoLimpiezaBtn = new JButton("Auto Limpieza Ionizador");
        ionizadorAutoLimpiezaBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                carro.autoLimpiezaIonizador();
                outputArea.append("Ionizador limpiado automáticamente\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton modoBajoConsumoBtn = new JButton("Modo de Bajo Consumo");
        modoBajoConsumoBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                carro.reduceIonizador();
                outputArea.append("Intensidad del ionizador reducida a nivel bajo\n");
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
            
        });

        JButton crearPerfilBtn = new JButton("Crear Perfil");
        crearPerfilBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String nombrePerfil = JOptionPane.showInputDialog("Ingrese el nombre del nuevo perfil:");
                if (nombrePerfil != null && !nombrePerfil.trim().isEmpty()) {
                    carro.crearPerfil(nombrePerfil.trim());
                    outputArea.append("Perfil " + nombrePerfil + " creado exitosamente\n");
                } 
                else {
                    outputArea.append("Nombre de perfil no válido\n");
                }
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton elegirPerfilBtn = new JButton("Elegir Perfil");
        elegirPerfilBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String nombrePerfil = JOptionPane.showInputDialog("Ingrese el nombre del perfil a seleccionar:");
                if (nombrePerfil != null && !nombrePerfil.trim().isEmpty()) {
                    try {
                        carro.elegirPerfil(nombrePerfil.trim());
                        outputArea.append("Perfil " + nombrePerfil + " seleccionado\n");
                    } catch (Exception ex) {
                        outputArea.append("El perfil " + nombrePerfil + " no existe\n");
                    }
                } else {
                    outputArea.append("Nombre de perfil no válido\n");
                }
            }
            else{
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton mantenimientoBtn = new JButton("Realizar Mantenimiento");
        mantenimientoBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                boolean necesario = carro.mantenimiento();
                outputArea.append(necesario ? "Mantenimiento realizado, fecha guardada en historial\n" : "No es necesario el mantenimiento\n");
            }
           else {
                outputArea.append("El sistema está apagado\n");
           }
        });

        JButton historialMantenimientoBtn = new JButton("Historial de Mantenimiento");
        historialMantenimientoBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String historial = carro.historialMantenimiento();
                if (historial != null && !historial.trim().isEmpty()) {
                    outputArea.append("Historial de mantenimiento:\n" + historial + "\n");
                } else {
                    outputArea.append("No hay historial de mantenimiento disponible\n");
                }
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        JButton programarMantenimientoBtn = new JButton("Programar Mantenimiento");
        programarMantenimientoBtn.addActionListener(e -> {
            if (sistemaEncendido) {
                String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de mantenimiento (dd/mm/yyyy):");
                try {
                    Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
                    carro.programarMantenimiento(fecha);
                    outputArea.append("Mantenimiento programado para " + fechaStr + "\n");
                } catch (ParseException ex) {
                    outputArea.append("Fecha inválida\n");
                }
            }
            else {
                outputArea.append("El sistema está apagado\n");
            }
        });

        // Agregar botones y área de texto a la ventana
        frame.add(encenderBtn);
        frame.add(apagarBtn);
        frame.add(ajustarTempBtn);
        frame.add(modoAutoBtn);
        frame.add(ventilacionBtn);
        frame.add(direccionBtn);
        frame.add(circulacionBtn);
        frame.add(calefaccionAsientosBtn);
        frame.add(calefaccionVolanteBtn);
        frame.add(calefaccionRapidaBtn);
        frame.add(desempañadorBtn);
        frame.add(ionizadorBtn);
        frame.add(autoIonizadorBtn);
        frame.add(ajustarIonizadorBtn);
        frame.add(cicloIonizadorBtn);
        frame.add(ionizadorAutoLimpiezaBtn);
        frame.add(modoBajoConsumoBtn);
        frame.add(crearPerfilBtn);
        frame.add(elegirPerfilBtn);
        frame.add(mantenimientoBtn);
        frame.add(historialMantenimientoBtn);
        frame.add(programarMantenimientoBtn);
        frame.add(scrollPane);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}