
    #1. Create directory:
rm -rf target
mkdir target

    #2. Compile files to the 'target' directory:
javac src/java/edu/school21/printer/*/*.java -d ./target

    #3. Copy resources:
cp -R src/resources target/.

    #4. Create jar:
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .
    #chmod u+x /target/images-to-chars-printer.jar

    #5. Run program:
java -jar target/images-to-chars-printer.jar . O