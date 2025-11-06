@echo off
REM Change directory to your project folder
cd "E:\AAA\Anbin Aravanaippu Arakkattalai BackEnd"

REM Stage all changes
git add .

REM Commit with a message
git commit -m "Auto update"

REM Push to GitHub
git push origin main

REM Pause to see output
pause
