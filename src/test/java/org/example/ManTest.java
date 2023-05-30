/*
Написати тести на всі методи класів Man та Woman з домашнього завдання до лекції 15.
Покрити тестами всі методи та всі необхідні значення.
Описати два тестові набори: один включає всі тести,
другий включає тільки тести на сеттери та гетери (набори повинні бути описані через XML файли).
 */

package org.example;

import marriage.Man;
import marriage.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManTest {

  private Man man;
  private Woman woman;

  @BeforeClass(groups = {"setter_test", "getter_test"})
  public void setup(){
    man = new Man("Robert", "Plant", 64, null);
    woman = new Woman("Maureen", "Wilson", 61, null);
  }

  @Test(groups = "getter_test")
  public void getFirstNameTest(){
    Assert.assertEquals(man.getFirstName(), "Robert");
  }

  @Test(groups = "getter_test")
  public void getLastNameTest(){
    Assert.assertEquals(man.getLastName(), "Plant");
  }

  @Test(groups = "getter_test")
  public void getAgeTest(){
    Assert.assertEquals(man.getAge(), 64);
  }

  @Test(dependsOnMethods = {"getFirstNameTest"},
        groups = "setter_test")
  public void setFirstNameTest(){
    man.setFirstName("John");
    Assert.assertEquals(man.getFirstName(), "John");
  }

  @Test(dependsOnMethods = {"getLastNameTest"},
        groups = "setter_test")
  public void setLastNameTest(){
    man.setLastName("Bonham");
    Assert.assertEquals(man.getLastName(), "Bonham");
  }

  @Test(dependsOnMethods = {"getAgeTest"},
        groups = "setter_test")
  public void setAgeTest(){
    man.setAge(32);
    Assert.assertEquals(man.getAge(), 32);
  }

  @Test
  public void isRetiredTest(){
    Assert.assertFalse(man.isRetired());
  }

  @Test
  public void registerPartnershipTest(){
    man.registerPartnership(woman);
    Assert.assertTrue(man.isMarried());
    Assert.assertTrue(man.getPartnerName().contains(woman.toString()));
  }

  @Test(dependsOnMethods = {"registerPartnershipTest"})
  public void deregisterPartnershipTest(){
    man.deregisterPartnership(false);
    Assert.assertFalse(man.isMarried());
    Assert.assertEquals(man.getPartnerName(), "not married");
  }

}
