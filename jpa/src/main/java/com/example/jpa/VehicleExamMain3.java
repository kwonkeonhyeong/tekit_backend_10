package com.example.jpa;

import jakarta.persistence.EntityManager;
import java.util.List;

public class VehicleExamMain3 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        Car3 car3 = new Car3();
        car3.setManufacturer("Toyota");
        car3.setSeatCount(5);
        em.persist(car3);

        Car3 car4 = new Car3();
        car4.setManufacturer("hyundai");
        car4.setSeatCount(4);
        em.persist(car4);

        Truck3 truck3 = new Truck3();
        truck3.setManufacturer("Volvo");
        truck3.setPayloadCapacity(15.5);
        em.persist(truck3);


        Truck3 truck4 = new Truck3();
        truck4.setManufacturer("Scania");
        truck4.setPayloadCapacity(20.0);
        em.persist(truck4);


        // 데이터 조회
        List<Vehicle3> vehicles = em.createQuery("SELECT v FROM Vehicle3 v", Vehicle3.class).getResultList();

        for (Vehicle3 vehicle : vehicles) {
            if (vehicle instanceof Car3) {
                Car3 car = (Car3) vehicle;
                System.out.println("Car: " + car.getManufacturer() + ", Seats: " + car.getSeatCount());
            } else if (vehicle instanceof Truck3) {
                Truck3 truck = (Truck3) vehicle;
                System.out.println("Truck: " + truck.getManufacturer() + ", Payload Capacity: " + truck.getPayloadCapacity());
            }
        }

        em.getTransaction().commit();
        em.close();
    }
}
