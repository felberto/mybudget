ARTEFACT    := $(shell cat target/classes/build.properties | awk -F= '/build.artifactId/ {print $$2}')
VERSION     := $(shell cat target/classes/build.properties | awk -F= '/build.version/ {print $$2}')
GIT         := $(shell cat target/classes/build.properties | awk -F= '/build.git.commit/ {print $$2}')
DOCKER_REPO := mybudget
NAME        := ${DOCKER_USERNAME}/${DOCKER_REPO}
IMG_TAG     := ${NAME}:${VERSION}-${TRAVIS_BUILD_NUMBER}-${GIT}
RELEASE_TAG := ${VERSION}-${TRAVIS_BUILD_NUMBER}

prepare:
	cp ${$TRAVIS_BUILD_DIR}/backend-211.0000.jar ./

build:
	docker build -t ${IMG_TAG} .
	docker tag ${IMG_TAG} ${RELEASE_TAG}
	git tag ${RELEASE_TAG} -a -m "Tagging version ${RELEASE_TAG}"
	git push --tags

push:
	docker login -u "$DOCKER_USERNAME" -p "$DOCKER_PASSWORD" && docker push ${IMG_TAG}