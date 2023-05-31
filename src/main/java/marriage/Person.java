package marriage;

/*
Обидва класи мають властивості:
firstName
lastName
age
partner

Обидва класи мають методи:
конструктор, який включає всі поля
сеттер і геттер на полі age, та інші властивості, де це необхідно
isRetired (повертає true, якщо вік більше пенсійного порогу 60 для жінок та 65 для чоловіків)
registerPartnership (мається на увазі, що дружина приймає прізвище чоловіка)
deregisterPartnership (як вхідний параметр приймає boolean: повернення до попереднього прізвища)
 */
public abstract class Person {

  private String firstName;
  private String lastName;
  private int age;
  private Person partner;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public abstract boolean isRetired();

  public abstract void registerPartnership(Person partner);

  public abstract void deregisterPartnership(boolean setMaidenName);

  public boolean isMarried(){
    return this.partner != null;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return String.format("%s %s, age %d", getFirstName(), getLastName(), getAge());
  }

  public String getPartnerName(){
    return isMarried() ? String.format("is married with %s", partner) : "not married";
  }

  protected Person getPartner(){
    return partner;
  }

  protected void setPartner(Person partner){
    this.partner = partner;
  }

}
