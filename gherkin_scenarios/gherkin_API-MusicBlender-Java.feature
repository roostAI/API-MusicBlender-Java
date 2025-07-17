Feature: Testing UserAccountController API

Scenario: Verify retrieval of a user by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '1'
  When I send a GET request to '/findUser?id=1'
  Then the response status should be '200'
  And the response body should contain the user credentials for ID '1'

Scenario: Verify retrieval of a non-existent user by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '999'
  When I send a GET request to '/findUser?id=999'
  Then the response status should be '404'
  And the response body should contain the error message 'User not found'

Scenario: Verify deletion of a user by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '1'
  When I send a DELETE request to '/delete?id=1'
  Then the response status should be '200'
  And the response body should contain the message 'Conta Deletada'

Scenario: Verify deletion of a non-existent user by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '999'
  When I send a DELETE request to '/delete?id=999'
  Then the response status should be '404'
  And the response body should contain the error message 'User not found'

Scenario: Verify updating user credentials by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '1'
  And the request payload with 'email' as 'new@example.com', 'password' as 'newpassword123', and 'username' as 'newusername'
  When I send a POST request to '/update?id=1&email=new@example.com&password=newpassword123&username=newusername' with payload
  Then the response status should be '200'
  And the response body should contain the message 'Usuário Salvo'

Scenario: Verify updating credentials for a non-existent user by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '999'
  And the request payload with 'email' as 'new@example.com', 'password' as 'newpassword123', and 'username' as 'newusername'
  When I send a POST request to '/update?id=999&email=new@example.com&password=newpassword123&username=newusername' with payload
  Then the response status should be '404'
  And the response body should contain the error message 'User não encontrado'

Scenario: Verify creating additional info for a user by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '1'
  And the request payload with 'photoURL' as 'http://example.com/photo.jpg', 'favoritesMusics' as 'Rock, Pop', 'gender' as 'Male', 'phone' as '1234567890', 'instaURL' as 'http://instagram.com/example', 'twitterURL' as 'http://twitter.com/example', and 'favoritesThings' as 'Music, Arts'
  When I send a POST request to '/createInfo/1?photoURL=http://example.com/photo.jpg&favoritesMusics=Rock, Pop&gender=Male&phone=1234567890&instaURL=http://instagram.com/example&twitterURL=http://twitter.com/example&favoritesThings=Music, Arts' with payload
  Then the response status should be '200'
  And the response body should contain the message 'ATUALIZADO'

Scenario: Verify creating additional info for a non-existent user by ID
  Given the API base URL 'http://localhost:8080'
  And the user ID is '999'
  And the request payload with 'photoURL' as 'http://example.com/photo.jpg', 'favoritesMusics' as 'Rock, Pop', 'gender' as 'Male', 'phone' as '1234567890', 'instaURL' as 'http://instagram.com/example', 'twitterURL' as 'http://twitter.com/example', and 'favoritesThings' as 'Music, Arts'
  When I send a POST request to '/createInfo/999?photoURL=http://example.com/photo.jpg&favoritesMusics=Rock, Pop&gender=Male&phone=1234567890&instaURL=http://instagram.com/example&twitterURL=http://twitter.com/example&favoritesThings=Music, Arts' with payload
  Then the response status should be '404'
  And the response body should contain the error message 'User not found'
