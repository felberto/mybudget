VERSION     := $(shell cat ${TRAVIS_BUILD_DIR}/backend/target/classes/build.properties | awk -F= '/build.version/ {print $$2}')
DOCKER_REPO := mybudget
NAME        := ${DOCKER_USERNAME}/${DOCKER_REPO}
IMG_TAG     := ${NAME}:${VERSION}-${TRAVIS_BUILD_NUMBER}
RELEASE_TAG := ${VERSION}-${TRAVIS_BUILD_NUMBER}

prepare:
	cp ${TRAVIS_BUILD_DIR}/backend/target/backend-211.0000.jar ./

build:
	docker build -t ${IMG_TAG} .
	docker tag ${IMG_TAG} ${RELEASE_TAG}
	git config --global user.email "travis@travis-ci.org"
	git config --global user.name "Travis CI"
	git tag ${RELEASE_TAG} -a -m "Tagging version ${RELEASE_TAG}"
	git push origin ${TRAVIS_BRANCH} --tags

push:
	docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD} && docker push ${IMG_TAG}