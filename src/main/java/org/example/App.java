/*
Написати тести на всі методи класів Man та Woman з домашнього завдання до лекції 15.
Покрити тестами всі методи та всі необхідні значення.
Описати два тестові набори: один включає всі тести,
другий включає тільки тести на сеттери та гетери (набори повинні бути описані через XML файли).
 */
package org.example;

import marriage.Man;
import marriage.Woman;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Man man1 = new Man("Robert", "Plant", 64, null);
        System.out.printf("%s, %s\n", man1, man1.getPartnerName());
        Woman woman1 = new Woman("Maureen", "Wilson", 61, man1);
        System.out.printf("%s, %s\n", man1, man1.getPartnerName());
        System.out.printf("%s, %s\n", woman1, woman1.getPartnerName());
        System.out.printf("%s has maiden name %s\n", woman1, woman1.getMaidenName());
        woman1.deregisterPartnership(true);
        System.out.printf("%s, %s\n", man1, man1.getPartnerName());
        System.out.printf("%s, %s\n", woman1, woman1.getPartnerName());
        man1.registerPartnership(man1);
        System.out.printf("%s, %s\n", man1, man1.getPartnerName());
        System.out.printf("%s, %s\n", woman1, woman1.getPartnerName());
        man1.registerPartnership(woman1);
        System.out.printf("%s, %s\n", man1, man1.getPartnerName());
        System.out.printf("%s, %s\n", woman1, woman1.getPartnerName());
        woman1.deregisterPartnership(false);
        System.out.printf("%s, %s\n", man1, man1.getPartnerName());
        System.out.printf("%s, %s\n", woman1, woman1.getPartnerName());
        System.out.printf("%s %s\n", man1, man1.isRetired() ? "is retired" : "is not retired");
        System.out.printf("%s %s\n", woman1, woman1.isRetired() ? "is retired" : "is not retired");
    }
}
