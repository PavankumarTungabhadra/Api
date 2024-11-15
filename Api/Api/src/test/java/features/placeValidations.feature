Feature: Validate Place API's
@AddPlace @Regression
Scenario Outline: Verify place is being added successfuly using AddPlaceAPI

Given AddPlaceAPI payload with "<name>" "<language>" "<address>" "<PhoneNumber>" "<Website>" "<Type1>" "<Type2>"
When user calls "AddPlaceAPI" with "Post" https request
Then place should be sucessfully added with statuscode 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id  created maps to "<name>"  using "GetPlaceAPI"


Examples:
|name     |language  |address    |PhoneNumber    |Website                            |Type1   |Type2|
|RebelStar|Kannada_IN|Tungabhadra|(+91)9945646646|pavankumartrggg123@gmail.com|Somosa  |Gobi|
@DeletePlace @Regression
Scenario: verify if Delete Place Functionality is working

Given DeletePlaceAPI payLoad
When user calls "DeletePlaceAPI" with "Post" https request
Then place should be sucessfully added with statuscode 200
And "status" in response body is "OK"