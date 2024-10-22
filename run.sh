cd Fuzzer
./mvnw clean package
cd ..

cd SimpleParser
./mvnw clean package
cd ..

java -jar Fuzzer/target/Fuzzer-v1-jar-with-dependencies.jar && java -jar SimpleParser/target/SimpleParser-v1-jar-with-dependencies.jar

