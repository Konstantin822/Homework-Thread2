package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ThreadSafeList<Integer> list = new ThreadSafeList<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("Add: " + i);
            }
        });
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer integer = list.remove(4);
        System.out.println(list);
        System.out.println(integer + " has been removed");
        System.out.println("List get: " + list.get(3));
        System.out.println("List get: " + list.get(7));
        System.out.println("List get: " + list.get(5));
        System.out.println();


        PetrolStation station = new PetrolStation(1000, 3);

        Thread thread2 = new Thread(() -> {
            try {
                station.doRefuel(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                station.doRefuel(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                station.doRefuel(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
