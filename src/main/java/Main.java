import model.Address;
import model.Company;

public class Main
{

    public static void main (String[] args)
    {
        var main = new Main();
        var model = main.GetCompany();

        //parse

        System.out.println("Hello world!");
    }

    private Main()
    {
        //ignore
    }

    public Company GetCompany()
    {
        var companyAddress = new Address();
        companyAddress.setCity("Utrecht");
        companyAddress.setPostalCode("1234aa");
        companyAddress.setStreet("Street");
        companyAddress.setStreetNumber(21);

        var company = new Company();
        company.setAddress(companyAddress);
        company.setName("Company name");
        company.setVatNumber("02349385");
        company.setIban("INGB03NL0001234435");
        company.setBic("ING");

        return company;
    }

    private void


}
