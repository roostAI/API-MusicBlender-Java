Feature: Pages and Navigation API Functionality

Background:
  Given the Spring Boot Application is running at "http://localhost:8080"
  And the PagesController is initialized

Scenario: Access Main Page Successfully
  When I send a GET request to "/pagina" endpoint
  Then the response status code should be 200
  And the ModelAndView should have the following attributes:
    | Attribute | Expected Value     |
    | titulo    | Minha Página       |
    | mensagem  | Bem-vindo à minha página! |
  And the view name should be "minhaPagina"

Scenario: Verify Page Title and Welcome Message
  When I navigate to the "/pagina" endpoint
  Then the response should contain the text "Minha Página"
  And the response should include the welcome message "Bem-vindo à minha página!"

Scenario: Check Page Rendering Consistency
  When I send multiple consecutive GET requests to "/pagina" endpoint
    | Request Number |
    | 1              |
    | 2              |
    | 3              |
    | 4              |
    | 5              |
  Then each response should consistently return:
    | Attribute | Consistent Value    |
    | titulo    | Minha Página        |
    | mensagem  | Bem-vindo à minha página! |

Scenario: Validate Response Content Type
  When I send a GET request to "/pagina" endpoint
  Then the response Content-Type should be "text/html"
  And the response should be a valid HTML document

Scenario: Handling Non-Existent Page Variations
  When I attempt to access variations of the page URL
    | URL Variation     | Expected Status |
    | "/pagina/"        | 200             |
    | "/pagina/extra"   | 404             |
    | "/Pagina"         | 404             |
  Then verify the corresponding response status codes
