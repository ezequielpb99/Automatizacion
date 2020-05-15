package automatizacion;

import automatizacion.acciones.AbrirAplicacion;
import automatizacion.acciones.EnviarWhatsapp;
import automatizacion.ejecuciones.EjecucionParalela;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        WhatsApp wpp = new WhatsApp("+5491168011234","+14155238886", "Estoy probando una app de wpp, don't worry");
        Tarea enviarWppTask = new Tarea(new EjecucionParalela());
        EnviarWhatsapp enviarWpp = new EnviarWhatsapp(wpp);
        enviarWppTask.agregarAccion(enviarWpp);

        EjecutadorDeTareas ejecutador = new EjecutadorDeTareas();
        ejecutador.agregarTarea(enviarWppTask);

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(ejecutador, 0, 10*1000);

        try {
            Thread.sleep(120000);
        }
        catch (InterruptedException e){

        }
        timer.cancel();
        System.out.println("termino la ejecucion");
    }
}
