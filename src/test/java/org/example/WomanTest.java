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

public class WomanTest {

  private Man man;
  private Woman woman;

  @BeforeClass(groups = {"setter_test", "getter_test"})
  public void setup(){
    man = new Man("Robert", "Plant", 64, null);
    woman = new Woman("Maureen", "Wilson", 61, null);
  }

  @Test(groups = "getter_test")
  public void getFirstNameTest(){
    Assert.assertEquals(woman.getFirstName(), "Maureen");
  }

  @Test(groups = "getter_test")
  public void getLastNameTest(){
    Assert.assertEquals(woman.getLastName(), "Wilson");
  }

  @Test(groups = "getter_test")
  public void getAgeTest(){
    Assert.assertEquals(woman.getAge(), 61);
  }

  @Test(dependsOnMethods = {"getFirstNameTest"},
        groups = "setter_test")
  public void setFirstNameTest(){
    woman.setFirstName("Patti");
    Assert.assertEquals(woman.getFirstName(), "Patti");
  }

  @Test(dependsOnMethods = {"getLastNameTest"},
        groups = "setter_test")
  public void setLastNameTest(){
    woman.setLastName("Griffin");
    Assert.assertEquals(woman.getLastName(), "Griffin");
  }

  @Test(dependsOnMethods = {"getAgeTest"},
        groups = "setter_test")
  public void setAgeTest(){
    woman.setAge(60);
    Assert.assertEquals(woman.getAge(), 60);
  }

  @Test
  public void isRetiredTest(){
    Assert.assertTrue(woman.isRetired());
  }

  @Test
  public void registerPartnershipTest(){
    woman.registerPartnership(man);
    Assert.assertTrue(woman.isMarried());
    Assert.assertTrue(woman.getPartnerName().contains(man.toString()));
  }

  @Test(dependsOnMethods = {"registerPartnershipTest"})
  public void deregisterPartnershipTest(){
    woman.deregisterPartnership(true);
    Assert.assertFalse(woman.isMarried());
    Assert.assertEquals(woman.getPartnerName(), "not married");
    Assert.assertEquals(woman.getLastName(), woman.getMaidenName());
  }

}
