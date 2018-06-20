test:
	./gradlew clean test

report:
	./gradlew allureReport
	./gradlew allureServe