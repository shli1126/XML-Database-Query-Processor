rm -r data/result/*

mkdir -p classes
# Find all java files in src directory
java_files=$(find src -name "*.java")
javac -cp lib/* -d classes $java_files

for i in {1..10}; do
    java -cp "classes;lib/*" main.Main data/j_caesar.xml data/query/q$i.txt data/result/q$i.xml
done

#java -cp "classes;lib/*" main.Main data/j_caesar.xml data/query/q2.txt data/result/q2.xml
