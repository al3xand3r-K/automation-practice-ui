test:
	./gradlew clean test

report:
	allure generate target/allure-results
	allure report open