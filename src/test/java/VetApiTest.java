import api.Vet.Vet;
import api.Vet.VetClient;
import api.common.exception.InvalidResponseException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VetApiTest<apiUrl> {

    static String apiUrl;

    @BeforeAll
    static void getApiUrl() {
        apiUrl = System.getProperty("apiUrl");
    }

    @Test
    public void getVetInfo() throws InvalidResponseException {
        VetClient client = new VetClient(apiUrl);
        Vet[] vets = client.getVet();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(vets[1].getFirstName()).isEqualTo("Helen");
        softly.assertThat(vets[1].getLastName()).isEqualTo("Leary");

        softly.assertAll();
    }



    @Test
    public void createVet_addingName() throws InvalidResponseException {
        VetClient client = new VetClient(apiUrl);
        Vet createdVet = client.createVet(Vet.builder().firstName("prishika").lastName("peter").build());
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(createdVet.getFirstName()).isEqualTo("prishika");
        softly.assertThat(createdVet.getLastName()).isEqualTo("peter");
        //softly.assertThat(createdVet.getId()).isNotNull();
        softly.assertAll();
    }
/*
    @Test
    public void deleteVet() throws InvalidResponseException{
        VetClient delClient = new VetClient(apiUrl);
  Vet deleteVet = delClient.deleteVet();
        SoftAssertions softly= new SoftAssertions();
        softly.assertThat(deleteVet.getFirstName()).isEqualTo("abc");
        softly.assertThat(deleteVet.getLastName()).isEqualTo("jjj");
        softly.assertAll();

    }


 */
}
