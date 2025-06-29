Task C:

1. In MainScreenControllerr.java, line 46:
- Added theModel attribute pageName with value "Ascended Computer Parts"

2. In MainScreenControllerr.java, line 47:
- Added theModel attribute companyName with value "Ascended Computer Parts"

3. In MainScreenControllerr.java, line 48:
- Added theModel attribute partsHeading with value "PC Components"

4. In MainScreenControllerr.java, line 49:
- Added theModel attribute productsHeading with value "Computers"

5. In the mainscreen.html template, line 14:
- Added th:text attribute to <title> tag for pageName

6. In the mainscreen.html template, line 19:
- Added th:text attribute to <h1> tag for companyName

7. In the mainscreen.html template, line 21:
- Added th:text attribute to <h2> tag for partsHeading

8. In the mainscreen.html template, line 53:
- Added th:text attribute to <h2> tag for productsHeading

Task D:
1. Created About.html page, and added th:href attributes to both mainscreen.html and About.html to move back and forth
between said pages. In About.html, included information about the company.

Task E:
1. Changed the name of the products from "Computers" to "Computers and Kits" to reflect the company offering
Computer part kits as well.
2. Added a sample inventory for both Components and Computers and Kits

Task F:
1. Removed the demo products from the MainScreenControllerr.java file, and used the buttons on the webpage to
add the products for the testing of the Buy Now button.
2. Added the Buy Now button, and set functionality to decrement inventory when product is bought, and save the
difference after the fact.
3. Verified the success and failure messages work.

Task G:
1. Added additional fields in the inhouse and outsourced forms for minimum and maximum desired inventory values.
2. Database file renamed.
3. Inhouse and outsourced parts will now only be created if they are within the min and max desired inventory values.

Task G v2:
1. Reworked the code to take you to a page that tells you the inventory should be between the specified minimum and maximum numbers.

Task H:
1. Added display messages that pop up over the inventory fields of both parts and products.
   - If adding parts to a product, an error message with red text will display if the inventory for the product is above the available parts.
   - If either adding parts with inventories above or below the maximum or minimum numbers, red text will appear above the inventory field.

Task I:
1. In the PartTest class, added tests for going below the minimum value, and going above the maximum value.

Task J:
1. Removed the ProductPriceValidator as well as its html to get rid of the price checker, as deals for buying products opposed to single components may be desired.

