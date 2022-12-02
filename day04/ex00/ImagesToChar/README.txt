
#1. Delete target directory if it created:
    rm -rf target

#1. Create target directory:
    mkdir target

#2. Compile files to the 'target' directory:
    javac src/java/edu/school21/printer/*/*.java -d target

#3. Copy resources and run program:
    java -cp target edu/school21/printer/app/Program . 0 /Users/elena/Downloads/it.bmp
