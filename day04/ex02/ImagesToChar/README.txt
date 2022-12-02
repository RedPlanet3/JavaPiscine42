#!/bin/sh
# delete target and lib directories
rm -rf target
rm -rf lib

# make a new target directory
mkdir target
mkdir lib

# install jcommander
#touch lib/jcommander-1.82.jar
curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
# install JCDP
#touch lib/JCDP-4.0.2.jar
curl -o lib/JCDP-4.0.2.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar


# copy resources
cp -R src/resources target

#set target directory for class files
javac -d target -sourcepath src/java -cp lib/JCDP-4.0.2.jar:lib/jcommander-1.82.jar:. src/java/edu/school21/printer/*/*.java

#copy class-file from jar-libs
jar -xf lib/jcommander-1.82.jar
jar -xf lib/JCDP-4.0.2.jar
rm -rf META-INF
mv com target

# arhivation and runing
jar cmf src/manifest.txt target/printer.jar -C target/ .
java -jar target/printer.jar --white=RED --black=GREEN
java -jar target/printer.jar --white=BLUE --black=YELLOW