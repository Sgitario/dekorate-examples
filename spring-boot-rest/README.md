# REST HTTP Spring Boot Example

https://appdev.openshift.io/docs/spring-boot-runtime.html#mission-http-api-spring-boot

## Table of Contents

* [REST HTTP Spring Boot Example](#rest-http-spring-boot-example)
    * [Deploying application on OpenShift using Dekorate](#deploying-application-on-openshift-using-dekorate)
    * [Running Tests on OpenShift using Dekorate](#running-tests-on-openshift-using-dekorate)
    * [Running Tests on Kubernetes with External Registry](#running-tests-on-kubernetes-with-external-registry)

## Deploying application on OpenShift using Dekorate

```
mvn clean verify -Popenshift -Ddekorate.deploy=true
```

## Running Tests on OpenShift using Dekorate

```
mvn clean verify -Popenshift,openshift-it
```

## Running Tests on Kubernetes with External Registry

```
mvn clean verify -Pkubernetes,kubernetes-it -Ddekorate.docker.registry=<url to your registry, example: quay.io> -Ddekorate.push=true
```