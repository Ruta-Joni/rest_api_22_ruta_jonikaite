package clickUpApi.stepdefinitions;

import clickUpApi.domain.Folder;
import clickUpApi.domain.List;
import clickUpApi.helpers.TestCaseContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;

import static clickUpApi.clients.ClickUpClient.*;
import static clickUpApi.helpers.TestCaseContext.getBoard;
import static clickUpApi.helpers.TestCaseContext.getList;


public class ClickUpSteps {
    @Given ("The test space exists and contains the correct information")
    public void getSpaceAndCheckInfo(){
        Response resp = getSpaceInfo();
    }
    @When ("I create the folder with title {string}")
    public void createFolderAndCheckInfo(String name){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        Response resp = createFolder(obj);
        Folder defaultFolder=resp.as(Folder.class);
        Assertions.assertThat(defaultFolder.getName())
                .as("We assert that name is correct").
                isEqualTo(name);
        TestCaseContext.setFolder(defaultFolder);
    }
    @When ("I add a list with title {string} to the folder")
    public void createNewList(String name){
    Folder defaultFolder = getBoard();
    String folderId=defaultFolder.getId();
    JSONObject obj = new JSONObject();
    obj.put("name", name);
    obj.put("content", "Test information");
        Response resp = createList(obj, folderId);
    List defaultList= resp.as(List.class);
    TestCaseContext.setList(defaultList);
    }

    @Then ("I check that the list name is {string}")
    public void checkListInfo(String name){
        List defaultList=getList();
        Assertions.assertThat(defaultList.getName())
                .as("We assert that list name is correct").
                isEqualTo(name);
    }
    @Then  ("I add a task with title {string} to the list")
    public void createTask(String name){

    }
    @Then ("I check that the task name is {string}")
    public void checkTaskInfo(String name){

    }
}





