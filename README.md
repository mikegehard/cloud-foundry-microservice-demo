# Microservices in Cloud Foundry Demo

This repository contains a demo of how to run multiple services within Cloud Foundry. It will focus on the technical details instead of how to decompose your domain into microservices.

This demo deploys the applications, packaged as Docker images,
to a [Lattice](http://lattice.cf/docs) instance running locally.

## Applications

* service-discovery - A Spring Boot application that uses a Eureka server from Spring Cloud to handle service discovery

* property-lookup - A Java 8/Spring Boot based service that can look up property data.

* tax-calculator - A Java 8/Spring Boot based service that queries the property-lookup service and calculates property tax based on the property information.


## Building Docker images

The Docker images are built using a Gradle plugin and can be created by running `./gradlew build buildDocker`.
Prerequisites for building Docker images are:

* [Boot2docker](http://boot2docker.io/) installed locally
* A [DockerHub](https://hub.docker.com/) login

Before running the buildDocker command in a terminal window, you must have the 3 boot2docker env variables
set in that window (see `docker up` for details). You also need to be logged in to DockerHub via `docker login`.

## Deploying to Lattice

See the [Lattice walkthrough](http://lattice.cf/docs/getting-started/) for details on how to use Lattice.
You can use the `bin/deploy-to-lattice.sh <DockerHub tag>` script to deploy Docker containers pushed to DockerHub to your
local Lattice installation.

## Service information

You can query the service-discovery service for information about the registered services using curl:

```
curl http://service-discovery.192.168.11.11.xip.io/eureka/apps

```

Please note that it takes ~30 seconds for a new service instance to be registered with the service-discovery
service.