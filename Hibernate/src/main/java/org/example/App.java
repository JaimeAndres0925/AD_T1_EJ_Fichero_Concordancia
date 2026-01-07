package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nba");
        EntityManager em = emf.createEntityManager();
        /*
        Query q = em.createQuery("SELECT j.nombre, j.nombreEquipo.nombre FROM Jugadore j LIMIT 10");
        List<Object[]> jugadores =  q.getResultList();
        for (Object[] o: jugadores) {
            System.out.println(o[0] + " "+ o[1]);
        }
         */
        System.out.println("Hola bro, dame el id del partido");
        String id = sc.nextLine();
        Query q = em.createQuery("SELECT COUNT (p.equipoLocal.nombre) FROM Partido p WHERE (p.puntosLocal - p.puntosVisitante > 0) group by p.temporada ");

        List<Object[]> objects =  q.getResultList();
        for (Object[] o: objects) {
            System.out.println(o[0]);
        }
    }
}
