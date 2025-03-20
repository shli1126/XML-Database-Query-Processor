java -jar lib/antlr-4.13.2-complete.jar -Dlanguage=Java -listener -visitor -o src/main/antlr src/main/antlr/XPath.g4

rm -r data/result/*

rm -r classes

mkdir -p classes
# Find all java files in src directory
java_files=$(find src -name "*.java")
javac -cp lib/* -d classes $java_files

#for i in {1..6}; do
#    java -cp "classes;lib/*" main.XPathRewriter data/query/query$i.txt data/result/query$i.txt
#done

#java -cp "classes;lib/*" main.XQueryTest "data/j_caesar.xml" "data/query/testquery1.txt" "data/result/testresult1.xml"
java -cp "classes;lib/*" main.XQueryTest "data/large-data.xml" "data/query/testquery2.txt" "data/result/testresult2.xml"