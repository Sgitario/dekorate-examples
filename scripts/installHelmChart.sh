#!/usr/bin/env bash
CHART_NAME=$1
CHART_LOCATION=$2
IMAGE=$3
CONTAINER_REGISTRY=${4:-localhost:5000}
K8S_NAMESPACE=${5:-helm}

source scripts/waitFor.sh
oc project $K8S_NAMESPACE

CONFIG_ROOT=$(echo $CHART_NAME | sed -r 's/(^|-)(\w)/\U\2/g' | sed 's/.*/\l&/')
helm install $CHART_NAME $CHART_LOCATION --set $CONFIG_ROOT.image=$CONTAINER_REGISTRY/$IMAGE -n $K8S_NAMESPACE
if [[ $(waitFor $CHART_NAME "app.kubernetes.io/name") -eq 1 ]] ; then
  echo "Application failed to deploy. Aborting"
  exit 1
fi
