package idatx.mappe2.pasientregister.model;

/**
 * Represents a patient with all values of a patient.
 */
public class Patient {
  private String firstName;
  private String lastName;
  private String generalPractitioner;
  private String socialSecurityNumber;
  private String diagnosis;

  public Patient(
                 String firstName,
                 String lastName,
                 String generalPractitioner,
                 String socialSecurityNumber,
                 String diagnosis) {
    this.setSocialSecurityNumber(socialSecurityNumber);
    this.setDiagnosis(diagnosis);
    this.firstName = firstName;
    this.lastName = lastName;
    this.generalPractitioner = generalPractitioner;
  }

  /**
   * Return social security number of patient.
   * @return social security number.
   */
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  /**
   * Returns first name of patient.
   * @return first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns last name of patient.
   * @return last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns full name of patient.
   * @return full name.
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * Returns diagnosis of patient
   * @return diagnosis.
   */
  public String getDiagnosis() {
    return this.diagnosis;
  }

  /**
   * Returns general practitioner of a patient.
   * @return general practitioner.
   */
  public String getGeneralPractitioner() {
    return this.generalPractitioner;
  }

  /**
   * Set first name of patient.
   * @param firstName first name to set.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set last name of patient.
   * @param lastName last name to set.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set general practitioner of patient
   * @param generalPractitioner General practitioner to set.
   */
  public void setGeneralPractitioner(String generalPractitioner) {
    this.generalPractitioner = generalPractitioner;
  }

  /**
   * Set social security number (as String) of patient.
   * The social security number could have also been an int, but it is specified in the assignment that it
   * is supposed be a String.
   * @param socialSecurityNumber Social security number to set.
   */
  public void setSocialSecurityNumber(String socialSecurityNumber) {
    if (socialSecurityNumber == null || socialSecurityNumber.isEmpty()) {
      throw new IllegalArgumentException("Social security number can not be empty.");
    } else {
      this.socialSecurityNumber = socialSecurityNumber;
    }
  }

  /**
   * Set diagnosis of patient.
   * if the value recieved is null or empty, diagnosis is set to [Undiagnosed].
   * @param diagnosis Diagnosis to set.
   */
  public void setDiagnosis(String diagnosis) {
    if (diagnosis == null || diagnosis.isEmpty()) {
      this.diagnosis = "[Undiagnosed]";
    } else {
      this.diagnosis = diagnosis;
    }
  }

  @Override
  public String toString() {
    return firstName+";"+lastName+";"+generalPractitioner+";"+socialSecurityNumber+";"+diagnosis;
  }
}
