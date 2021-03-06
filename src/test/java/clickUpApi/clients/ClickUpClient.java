package clickUpApi.clients;
import clickUpApi.helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static clickUpApi.constants.ProjectConstants.API_KEY;
import static clickUpApi.constants.ProjectConstants.SPACE_ID;

public class ClickUpClient {

    public static Response getSpaceInfo(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .get("https://api.clickup.com/api/v2/space/"+SPACE_ID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createFolder(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/"+SPACE_ID+"/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createList(JSONObject obj, String folder){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/"+folder+"/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createTask(JSONObject obj, String list){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/"+list+"/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteTask(String task){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/task/"+task)
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }
    public static Response deleteFolder(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/"+ TestCaseContext.getFolder().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
