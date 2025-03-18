
### Generate Antlr files using `.g4` file
```
java -jar lib/antlr-4.13.2-complete.jar -Dlanguage=Java -listener -visitor -o src/main/antlr src/main/antlr/XPath.g4
```

### Compile the program
```
javac -cp "lib/antlr-4.13.2-complete.jar" -d out src/main/*.java src/main/antlr/*.java
```

### Run the program (example)
```
java -cp "lib/*;out" main.Main j_caesar.xml test\xpath\q1.txt test\xpath\q1.xml
```