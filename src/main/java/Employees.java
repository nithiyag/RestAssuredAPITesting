public class Employees {

    public Response getEmployees(String args) {
        RequestSpecification httpRequest=RestAssured.given();

        //specify response object
        Response response=httpRequest.request(Method.GET,"/45");
        return response
    }

}
