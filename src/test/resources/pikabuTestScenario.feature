Feature: we open pikabu.ru, we need to enter some info in TAG field, and find by tag name, sort by BEST. And copy first most-voted comment to txt file.


  Scenario: open pikabu and copy to clipboard comment
    Given pikabu homepage
    When we hover over button
    And adding "Самолет" as search word
    Then opens tag search page
    When we choose sort by "HOT"
    #there is HOT and FRESH
    Then first post should have rating more than 10000
#    When we click on first post
#    Then this post page opens
#    And we copy first most voted comment to clipboard.