cd C:\Users\Neha\PSCodingChallenges\date-time-calculator
set localpath = %mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout%
cd localpath
dir
