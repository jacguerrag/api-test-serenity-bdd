package petstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.Matchers;
import static net.serenitybdd.rest.SerenityRest.*;

public class PetApiActions extends UIInteractions {

    @Given("Firulais esta disponible en la tienda de mascota")
    public Long givenFirulaisEstaDisponibleEnTiendaMascotas() {
        Pet mascota = new Pet( "Disponible", "Firulais");
        Long newId = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .body(mascota,ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Pet.class, ObjectMapperType.GSON).getId();

        return newId;
    }

    @When("Yo solicito una mascota usando el ID de Firulais: {0}")
    public void whenYoSolicitoUnaMascotaConID(Long id) {
        when().get("/"+id);
    }

    @Then("Obtengo a firulais como resultado")
    public void thenYoVeoAFirulaisComoResultado() {
        then().body("name", Matchers.equalTo("Firulais"));
    }
}
