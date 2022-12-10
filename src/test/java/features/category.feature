Feature: Category

  @category
  Scenario Outline: As a user, I should able to navigate to each category page successfully

    When I click on "<category_name>" link
    Then User should able to navigate to related "<category_link>" page
    Examples:
      | category_name     | category_link     |
      | Computers         | computers         |
      | Electronics       | electronics       |
      | Apparel           | apparel           |
      | Digital downloads | digital-downloads |
      | Books             | books             |
      | Jewelry           | jewelry           |
      | Gift Cards        | gift-cards        |
