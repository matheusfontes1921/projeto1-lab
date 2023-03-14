package Universidade;

import java.time.LocalDate;

public class Semestre {
    private static Boolean isEtapaMatricula = true;
    private static Boolean started = false;

    LocalDate matriculaFim;
    LocalDate inicioSemestre;

    Integer id = 0;

    public static boolean terminarEtapaMatricula() {
        isEtapaMatricula = false;
        return false;
    }

    public static Boolean getIsEtapaMatricula() {
        return isEtapaMatricula;
    }

    public static Boolean comecarSemestre() {
        started = true;
        return true;
    }

    public static Boolean getStarted() {
        return started;
    }
}
