package marriage;

public class Man extends Person{

  public Man(String firstName, String lastName, int age, Person partner) {
    super(firstName, lastName, age);
    if (partner != null) {
      registerPartnership(partner);
    }
  }

  @Override
  public boolean isRetired() {
    return getAge() >= 65;
  }

  @Override
  public void registerPartnership(Person partner) {
    if (!isMarried() && partner != null && partner instanceof Woman && !partner.isMarried()) {
      this.setPartner(partner);
      partner.setPartner(this);
      partner.setLastName(getLastName());
      System.out.printf("%s and %s get married\n", getFirstName(), partner.getFirstName());
    } else {
      System.out.printf("%s and %s cannot get married\n", getFirstName(), partner.getFirstName());
    }
  }

  @Override
  public void deregisterPartnership(boolean setMaidenName) {
    if (getPartner() != null) {
      System.out.printf("%s and %s are getting divorced\n", getFirstName(), getPartner().getFirstName());
      if (setMaidenName) {
        getPartner().setLastName(((Woman)getPartner()).getMaidenName() );
      }
      getPartner().setPartner(null);
      this.setPartner(null);
    }
  }
}
