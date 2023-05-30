package marriage;

public class Woman extends Person{

  private final String maidenName;

  public Woman(String firstName, String lastName, int age, Person partner) {
    super(firstName, lastName, age);
    maidenName = lastName;
    if (partner != null) {
      registerPartnership(partner);
    }
  }

  public String getMaidenName() {
    return maidenName;
  }

  @Override
  public boolean isRetired() {
    return getAge() >= 60;
  }

  @Override
  public void registerPartnership(Person partner) {
    if (!isMarried() && partner != null && partner instanceof Man && !partner.isMarried()) {
      this.setPartner(partner);
      setLastName(partner.getLastName());
      partner.setPartner(this);
      System.out.printf("%s and %s get married\n", getFirstName(), partner.getFirstName());
    } else {
      System.out.printf("%s and %s cannot get married\n", getFirstName(), partner.getFirstName());
    }
  }

  @Override
  public void deregisterPartnership(boolean setMaidenName) {
    if (getPartner() != null) {
      System.out.printf("%s and %s are getting divorced\n", getFirstName(), getPartner().getFirstName());
      getPartner().setPartner(null);
      this.setPartner(null);
      if (setMaidenName) setLastName(maidenName);
    }
  }
}
