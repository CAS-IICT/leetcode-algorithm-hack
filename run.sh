#!/bin/bash

function getdir(){
    echo ""
    export TIMEFORMAT=$'real=%R user=%U sys=%S'

    # get cases
    while read line
    do
        cases=$line" "$cases
    done < $1"/TestCase.txt"

    for file in `ls $1`
    do
        sufix="${file##*.}"
        realfile=$1"/"$file

        case $sufix in
            js)
                echo "JavaScript----------------------------------"
                time node $realfile $cases
                ;;
            java)
                echo "Java----------------------------------------"
                (cd $1;javac $file;time java "${file%.*}")
                ;;
            cs)
                echo "C#------------------------------------------"
                (cd $1;mcs $file;(time mono ${file%.*}.exe $cases))
                ;;
            c)
                ;;
            cpp)
                ;;
            php)
                echo "PHP-----------------------------------------"
                time php $realfile $cases
                ;;
            kt) #速度很慢
                echo "Kotlin--------------------------------------"
                kotlinc-native $realfile -o ${realfile%.*}
                (time ./${realfile%.*}.kexe $cases)
                ;;
            txt)
                echo ""
                echo "----------------Test Case-------------------"
                cat $realfile
                echo "--------------------------------------------"
                ;;
        esac
        echo ""
    done
}

getdir $1
