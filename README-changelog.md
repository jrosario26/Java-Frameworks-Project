------Task C:

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
- **NEW: Changed the name in the HTML title tag to "Ascended Computer Parts"**

6. In the mainscreen.html template, line 18:
- Added th:text attribute to <h1> tag for companyName
- **NEW: Changed HTML h1 tag text to "Ascended Computer Parts"**

7. In the mainscreen.html template, line 21:
- Added th:text attribute to <h2> tag for partsHeading
- **NEW: Changed HTML h2 tag text to "PC Components"**

8. In the mainscreen.html template, line 53:
- Added th:text attribute to <h2> tag for productsHeading
- **NEW: Now line 57, changed h2 tag text to "Computers and Kits"**

-------Task D:
1. Created About.html page, and added th:href attributes to both mainscreen.html and About.html to move back and forth
between said pages. In About.html, included information about the company.

In MainScreenControllerr.java:
- Line 13: imported RequestMapping
- Line 25: Added @RequestMapping("/") for the main page
- Starting line 62 - 65: Added @GetMapping for the newly created About page

In About.html:
- New page: everything created here is for the new page.

In mainscreen.html:
- Line 19: added a tag with href to new About page

-------Task E:
1. Changed the name of the products from "Computers" to "Computers and Kits" to reflect the company offering
Computer part kits as well.
2. Added a sample inventory for both Components and Computers and Kits

In MainScreenControllerr.java:
- Line 15: imported the java.util.Arrays
- Line 51: Removed addAttribute for "Computers"
- Line 52: Added addAttribute for "Computers and Kits"
- Starting line 61 - 77: Added a test for inserting products into the list using Thymeleaf (optional)

In Part.java:
- Removed the abstract from the Part class (this caused a bug later on, and was corrected later in task G)

-------Task F:
1. Removed the demo products from the MainScreenControllerr.java file, and used the buttons on the webpage to
add the products for the testing of the Buy Now button.
2. Added the Buy Now button, and set functionality to decrement inventory when product is bought, and save the
difference after the fact.
3. Verified the success and failure messages work.

In MainScreenControllerr.java:
- Starting line 14 - 16: Important RequestParam, ResponseBody, and RedirectAttributes
- Starting line 70 - 74: Commented out the Product Thymeleaf additions after confirming test for previous commit, and started using adding product through web interface
- Starting 79 - 80: Commented these lines out as they were no longer needed; these lines went with the Thymelead Product additions
- Starting line 85 - 96: Added the @GetMapping for the Buy Now button, and also the ResponseBody for the success/failure checking for said button

In ProductService.java:
- Added the buy method for the interface

In ProductServiceImpl.java:
- Starting line 58 - 67: Constructed the method for the buy functionality, and specified the decrement process in the inventory once a product is bought.
As well, code written to handle the exception in the event the stock is out.

In mainscreen.html:
- Starting line 83 - 87: Added the a tag for the Buy Now button, and copied over the class it belongs to for the CSS handling
- Starting line 96 - 113: Added script for purchase handling for the products, with a popup confirming whether you want to buy or not

-------Task G:
1. Added additional fields in the inhouse and outsourced forms for minimum and maximum desired inventory values.
2. Database file renamed.
3. Inhouse and outsourced parts will now only be created if they are within the min and max desired inventory values.

In AddInhousePartController.java:
- Starting line 46 - 49: Added if statement to handle inventory threshold checking for below minimum and above maximum user input
  - else statement included to handle if the inventory meets requirements

In AddOutsourcedPartController.java:
- Starting line 47 - 49: Added the if statement to the outsourced part controller as well so that it works for outsourced parts too

In AddPartController.java:
- Added conditional logic to verify whether there are enough parts in the outsourced part inventory, and to either proceed or return to the main screen

In MainScreenControllerr.java:
- Starting line 64 - 68: Commented out lines that create parts via Thymeleaf; these test parts are no longer needed, and all parts and products
will be created using the web interface
- Starting line 76 - 78: Commented out the list that's created for the test parts, as they're no longer needed
- Starting line 79 - 80: Commented out the list that's created for the test products, as they're no longer needed

In Part.java:
- Line 23: Added back the abstract for the class to fix an issue with creating parts through the web interface
- Starting line 32 - 33: Added variables for minInv and maxInv, reflecting minimum and maximum inventory respectively
  (Not sure why I put the public part in line 32)
- Starting line 56 - 84: Created constructors and getters/setters for the new variables using the Generate ability in IntelliJ
- Starting line 114 - 117: I think these were duplicates created for some reason. I think these were deleted in a later commit

In application.properties:
- Line 6: Changed the name of the database file to D287-project-db

In InhousePartForm.html:
- Starting line 25 - 26: Added fields for minimum and maximum inventory

In OutsourcedPartForm.html:
- Starting line 25 - 26: Added fields for minimum and maximum inventory

In mainscreen.html:
- Starting line 48 - 49: Added td tags for the minimum and maximum inventory, with default placeholder values if unspecified during part creation

-------Task G v2:
1. Reworked the code to take you to a page that tells you the inventory should be between the specified minimum and maximum numbers.

In AddInhousePartController.java:
- Line 47: Changed the return statement to direct the user to a new page if inventory is below minimum or above maximum

In inhouseBelowOrAbove.html:
- NEW PAGE: Page created for error redirecting when inventory is below set minimum or above set maximum

In mainscreen.html:
- Line 49: Added error checking for whether or not inventory is below set minimum inventory (set up for a future implementation, see task H)
- Line 51: Added error checking for whether or not inventory is above set maximum inventory (set up for a future implementation, see task H)

-------Task H:
1. Added display messages that pop up over the inventory fields of both parts and products.

In AddInhousePartController.java:
- Starting line 42 - 45: Conditional written for checking inhouse parts to complete the setup for line 49 in mainscreen.html
- Starting line 51 - 55: Reworked the else statement to prevent errors with how it was structured last time, ensuring it works with new error checking code
- Starting line 58 - 59: See previous bullet point

In AddProductController.java:
- Starting line 81 - 96: Added code to check whether or not inventory for associated parts for created product will be reduced beyond
its minimum set value

In ProductServiceImpl.java:
- Line 62: Generic readability cleanup on written code

In InhousePartForm.html:
- Line 21: Added p tag for error text that will appear above the inventory field: Text is red for readability
- Previous line 49 and 51: Removed these error fields from above the minimum and maximum inventory fields: Error on my part,
now properly displays the error above the inventory where it should have been to begin with

In productForm.html:
- Line 21: Added p tag error text above the inventory field: Text appears red for readability

-------Task I:
1. In the PartTest class, added tests for going below the minimum value, and going above the maximum value.

In PartTest.java:
- Starting line 104 - 140: Added tests for parts with inventory below minimum and above maximum set values

---------A duplicate Task I commit was made, but it was supposed to be Task J: The details for the Task J commit (duplicate Task I) will be outlined below

-------Task J (duplicate Task I):
1. Removed the ProductPriceValidator as well as its html to get rid of the price checker, as deals for buying products opposed to single components may be desired.

- The ValidProductPrice.java and the PriceProductValidator.java files were removed for cleanup: These were also removed to 
allow for pricing discounts for buying preassembled products vs buying parts for build-your-own setups
  - This also removed the import for ValidProductPrice and the @ValidProductPrice lines in Product.java (lines 4 and 20 respectively)


