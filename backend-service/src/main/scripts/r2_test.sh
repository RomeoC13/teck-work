#M2_REPOS="/c/Users/pc/.m2/repository"
PROJECT_PATH="${M2_REPO}/edu/episen/si/ing1/pds/backend-service/1.0-SNAPSHOT"
JAR_FILE="backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar"
CLASS_PATH=${PROJECT_PATH}/${JAR_FILE}
MAIN_CLASS="edu.episen.si.ing1.pds.backend.server.BackendService"
java -cp ${CLASS_PATH} ${MAIN_CLASS} $*