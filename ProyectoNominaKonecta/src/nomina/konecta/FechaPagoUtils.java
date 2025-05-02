package nomina.konecta;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class FechaPagoUtils {
    public static LocalDate calcularProximaFechaPago(LocalDate fechaActual) {
        LocalDate quince = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 15);
        LocalDate treinta = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), fechaActual.getMonth().length(fechaActual.isLeapYear()) == 28 ? 28 : 30);

        LocalDate proximaFecha = fechaActual.isBefore(quince) || fechaActual.isEqual(quince) ? quince : treinta;
        proximaFecha = ajustarAHabilAnterior(proximaFecha);
        return proximaFecha;
    }

    private static LocalDate ajustarAHabilAnterior(LocalDate fecha) {
        List<LocalDate> festivos = FestivoUtils.cargarFestivos("festivos_colombia.json");

        while (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY || festivos.contains(fecha)) {
            fecha = fecha.minusDays(1);
        }
        return fecha;
    }
}