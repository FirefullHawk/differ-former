.DEFAULT_GOAL := run-dist

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install
	
test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions

run-dist:
	@./build/install/app/bin/app -h

run-version:
	@./build/install/app/bin/app -V

run-json:
	@./build/install/app/bin/app ./src/test/resources/defaultJSON/file1.json ./src/test/resources/defaultJSON/file2.json

run-inner-json:
	@./build/install/app/bin/app ./src/test/resources/json/file1.json ./src/test/resources/json/file2.json
	
run-yml:
	@./build/install/app/bin/app ./src/test/resources/yml/file1.yml ./src/test/resources/yml/file2.yml
	
run-plain:
	@./build/install/app/bin/app -f plain ./src/test/resources/json/file1.json ./src/test/resources/json/file2.json
	
run-json-out:
	@./build/install/app/bin/app -f json ./src/test/resources/defaultJSON/file1.json ./src/test/resources/defaultJSON/file2.json
	
build-run: build run

.PHONY: build
