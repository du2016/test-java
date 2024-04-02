build:
	@mvn clean package -Dmaven.test.skip=true

run:
	@mvn -pl demo spring-boot:run

default:run