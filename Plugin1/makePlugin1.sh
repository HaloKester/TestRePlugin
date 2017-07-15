#!/usr/bin/env bash
./gradlew assembleDebug
adb push app/build/outputs/apk/app-debug.apk /sdcard/Android/data/com.kester.host/cache/plugin1/plugin1.apk