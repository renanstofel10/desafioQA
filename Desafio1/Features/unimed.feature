Feature: Unimed medical consultation
  As a user I wish to perform medical consultations
  on the unimed website

Background: Access detailed medical research
  Given user access the Unimed website
  When i click the medical tab menu
  Then the doctors consultation page is displayed
  When i click detailed search
  Then site displays the search filter by states

@Test1
Scenario Outline: To consult doctors of the state of the RJ
  When i fill in the <state> and <city> field
  Then site displays the preferred Unimed options
  When i select the <unit>
  And i click on continue
  Then page updates the care network
  When i click the search button
  Then site displays the results found

Examples:
|       state        |         city       |      unit      |
|  "Rio de Janeiro"  |  "Rio de Janeiro"  |  "UNIMED RIO"  |

@Test2
Scenario Outline: Validate non-display of São Paulo state in search result
  When i fill in the <state> and <city> field
  Then site displays the preferred Unimed options
  When i select the <unit>
  And i click on continue
  Then page updates the care network
  When i click the search button
  Then site displays the results found
  And check the absence of the state of <missing_state> in the query result
    
Examples:
|       state        |         city       |      unit      | missing_state |
|  "Rio de Janeiro"  |  "Rio de Janeiro"  |  "UNIMED RIO"  |  "São Paulo"  |
