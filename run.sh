#!/bin/bash

function getdir(){
    export TIMEFORMAT=$'real=%R user=%U sys=%S'
    for file in `ls $1`
    do
        sufix="${file##*.}"
        realfile=$1"/"$file
        case $sufix in
            js)
                echo "JavaScript----------------------------------"
                time node $realfile
                ;;
            java)
                echo "Java----------------------------------------"
                (cd $1;javac $file;time java "${file%.*}")
                ;;
            cs)
                echo "C#------------------------------------------"
                (cd $1;mcs $file;time mono "${file%.*}.exe")
                ;;
            c)
                ;;
            cpp)
                ;;
            kt)
                echo "Kotlin--------------------------------------"
                kotlinc-native $realfile -o ${realfile%.*}
                time "${realfile%.*}.kexe"
                ;;
            php)
                echo "PHP-----------------------------------------"
                time php $realfile
                ;;
            txt)
                echo ""
                echo "----------------Test Case-------------------"
                cat $realfile
                ;;
        esac
    done
}

getdir $1
