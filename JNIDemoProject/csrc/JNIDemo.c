#include <jni.h>
#include "JNIDemo.h"

JNIEXPORT jint JNICALL Java_JNIDemo_doubleValue(JNIEnv *env, jobject obj, jint x) {
    return x * 2;
}

