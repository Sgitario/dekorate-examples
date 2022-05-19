#!/usr/bin/env bash
FOLDER=$1
IMAGE=${2:-app:latest}
CONTAINER_REGISTRY=${3:-localhost:5000}

# Create docker image and tag it in registry
docker build $FOLDER -t $IMAGE
docker tag $IMAGE $CONTAINER_REGISTRY/$IMAGE
docker push $CONTAINER_REGISTRY/$IMAGE
