import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fedex.vetapi.Vet;
import com.fedex.vetapi.VetClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VetApiTest<apiUrl> {

    static String apiUrl;
    private String vetId;


    @BeforeAll
    static void getApiUrl() {
        apiUrl = System.getProperty("apiUrl");
    }

/*

    public void get_Create_Delete () throws InvalidResponseException{
        //FETCH DETAILS OF VET USING METHOD: GET
        getVetInfo();
        //CREATE DETAILS FOR VET USING METHOD: POST
        createVetInfo();
        //DELETING DETAILS OF VET USING METHOD: DELETE
        deleteVetInfo();
    }
*/
   @Test
   @Order(1)
    public void getVetInfo() throws InvalidResponseException {
        VetClient client = new VetClient(apiUrl, "/api/vets");
        Vet[] vets = client.getVet();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(vets[1].getFirstName()).isEqualTo("Helen");
        softly.assertThat(vets[1].getLastName()).isEqualTo("Leary");

        softly.assertAll();
    }



 @Test
 @Order(2)
    public void createVetInfo() throws InvalidResponseException, IOException {
     Properties prop=new Properties();

     FileInputStream fis =new FileInputStream("D:\\Petclinic_RestAssured\\src\\main\\java\\rest\\api\\vet\\data.properties");

     prop.load(fis);
        VetClient client = new VetClient(apiUrl, "/api/vets/");
        Vet createdVet = client.createVet(Vet.builder().firstName(prop.getProperty("FirstName")).lastName(prop.getProperty("LastName")).build());

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(createdVet.getFirstName()).isEqualTo(prop.getProperty("Firstname"));
        softly.assertThat(createdVet.getLastName()).isEqualTo(prop.getProperty("LastName"));

        vetId=createdVet.getId();
    }


@Test
@Order(3)
public void deleteVetInfo() throws InvalidResponseException{

        VetClient client = new VetClient(apiUrl,"/api/vets");

    Vet newvet = client.createVet(Vet.builder().firstName("prishika").lastName("peter").build());
    String id = newvet.getId();

    VetClient client1= new VetClient(apiUrl,"/api/vets/" + vetId);
    ApiResponse<Vet[]> deleteVet =client.deleteVet();


    SoftAssertions softly= new SoftAssertions();
        softly.assertThat(deleteVet.getHttpStatusCode()).isEqualTo(204);

        softly.assertAll();


    }





}