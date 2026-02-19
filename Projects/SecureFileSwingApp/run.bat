@echo off
setlocal
set SRC=src
set OUT=out
if exist "%OUT%" rmdir /s /q "%OUT%"
mkdir "%OUT%"
for /r "%SRC%" %%f in (*.java) do (
    javac -d "%OUT%" "%%f"
    if errorlevel 1 (
        echo Compile failed: %%f
        pause
        exit /b 1
    )
)
pushd "%OUT%"
java app.Main
popd
