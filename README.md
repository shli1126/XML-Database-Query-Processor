# How to run?
### 1. Modify the code
In `src/main/java/impl/XPath/XPathMain.java`, change the string`xpathQuery` into your input `Xpath` query

e.g.
```declarative
String xpathQuery = "doc(\"j_caesar.xml\")//PERSONA";
```

### 2. Compile the project
`mvn clean compile`

### 3. Run the main program
`mvn exec:java`

### 4. See the results
The result file `result.xml` will be generated under the root directory.

