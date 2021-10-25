Feature: Demonstrating the data table feature for cucumber

  Cucumber provide ability to organize repeating steps with different data
  using the data table feature and automatically convert the table into
  few known data types supported by cucumber

  Scenario: Petting zoo
    Given I have a "horse"
    And I have a "dog"
    And I have a "turtle"
    And I have a "zebra"
    When I call their names
    Then They come to me.


  Scenario: Petting zoo with table
    Given I have the following animals
#  if you want it to nicely align, control + alt + l
      | horse  |
      | dog    |
      | turtle |
      | zebra  |
    When I call their names with below names
      | kira    |
      | Doro    |
      | Tito    |
      | Zemfira |

    Then They come to me with below noise
      | horse  | Nai  |
      | dog    | Woof |
      | turtle | Hiss |
      | zebra  | Bro  |