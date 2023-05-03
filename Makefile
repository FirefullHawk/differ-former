.DEFAULT_GOAL := build-run

clean:
	make -C app clean

build:
	make -C app build

install:
	make -C app install

run-dist:
	make -C run-dist

run:
	make -C app run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

run-json:
	make -C app run-json
	
run-plain:
	make -C app run-plain
	
run-inner-json:
	make -C app run-inner-json
	
run-json-out:
	make -C app run-json-out


build-run: build run

.PHONY: build
