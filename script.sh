rm -r data/result/*

mkdir -p classes
# Find all java files in src directory
java_files=$(find src -name "*.java")
javac -cp lib/* -d classes $java_files

#for i in {1..6}; do
#    java -cp "classes;lib/*" main.XPathRewriter data/query/query$i.txt data/result/query$i.txt
#done

for i in {1..4}; do
    if [ "$i" -eq 1 ]; then
        XML_FILE="data/j_caesar.xml"
    else
        XML_FILE="data/large-data.xml"
    fi

    java -cp "classes;lib/*" main.XPathRewriter "data/query/query$i.txt" "data/result/query$i.txt"
    java -cp "classes;lib/*" main.Main "$XML_FILE" "data/query/query$i.txt" "data/result/query$i.txt" "data/result/result$i.xml"
done
