package by.church4u.database.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile
{

    private String itsSurname;
    private String itsName;
    private String itsPatronymic;
    private Date itsDateOfBirth;
    private String itsAddress;
    private String itsPhone;
    private String itsIndex;
    private Date itsBaptizedOnDate;
    private boolean itsBaptismOfTheHolySpirit;
    private String itsSpecialty;
    private boolean itsFromAnotherChurch;
    private String itsTheNameOfAnotherChurch;
    private Date itsArrivalDate;
    private boolean itsWidow;
    private boolean itsDivorced;
    private boolean itsDisabilityGroup;

    public Profile()
    {

    }

    public Profile(final String aSurname, final String aName, final String aPatronymic, final Date aDateOfBirth,
            final String anAddress, final String aPhone, final String anIndex, final Date aBaptizedOnDate,
            final boolean aBaptismOfTheHolySpirit, final String aSpecialty, final boolean aFromAnotherChurch,
            final String aTheNameOfAnotherChurch, final Date anArrivalDate, final boolean aWidow,
            final boolean aDivorced, final boolean aDisabilityGroup)
    {
        this.itsSurname = aSurname;
        this.itsName = aName;
        this.itsPatronymic = aPatronymic;
        this.itsDateOfBirth = aDateOfBirth;
        this.itsAddress = anAddress;
        this.itsPhone = aPhone;
        this.itsIndex = anIndex;
        this.itsBaptizedOnDate = aBaptizedOnDate;
        this.itsBaptismOfTheHolySpirit = aBaptismOfTheHolySpirit;
        this.itsSpecialty = aSpecialty;
        this.itsFromAnotherChurch = aFromAnotherChurch;
        this.itsTheNameOfAnotherChurch = aTheNameOfAnotherChurch;
        this.itsArrivalDate = anArrivalDate;
        this.itsWidow = aWidow;
        this.itsDivorced = aDivorced;
        this.itsDisabilityGroup = aDisabilityGroup;
    }

    public String getSurname()
    {
        return itsSurname;
    }

    public String getName() {
        return itsName;
    }

    public Date getDateOfBirth() {
        return itsDateOfBirth;
    }

    public String getAddress() {
        return itsAddress;
    }

    public String getPhone() {
        return itsPhone;
    }

    public String getIndex() {
        return itsIndex;
    }

    public Date getBaptizedOnDate() {
        return itsBaptizedOnDate;
    }

    public boolean getBaptismOfTheHolySpirit() {
        return itsBaptismOfTheHolySpirit;
    }

    public String getSpecialty() {
        return itsSpecialty;
    }

    public boolean getFromAnotherChurch() {
        return itsFromAnotherChurch;
    }

    public String getTheNameOfAnotherChurch() {
        return itsTheNameOfAnotherChurch;
    }

    public Date getArrivalDate() {
        return itsArrivalDate;
    }

    public boolean getWidow() {
        return itsWidow;
    }

    public boolean getDivorced() {
        return itsDivorced;
    }

    public boolean getDisabilityGroup() {
        return itsDisabilityGroup;
    }

    public String getPatronymic() {
        return itsPatronymic;
    }
}