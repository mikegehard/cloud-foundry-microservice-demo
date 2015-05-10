#!/usr/bin/env bash
set -e

# First argument is the name of the application to deploy, for example "property-lookup".
# Second argument is the version of the service to deploy, for example 0.0.1-SNAPSHOT.

ltc remove $1
ltc create $1 msgehard/$1:$2