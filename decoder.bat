@echo off
chcp 65001 2>nul >nul
set /p code=enter string: 
java "-Dfile.encoding=UTF8" -jar coder.jar -d .\key "%code%"
pause