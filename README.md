<p align="center">
  <a href="//architect.io" target="blank"><img src="https://www.architect.io/logo.svg" width="320" alt="Architect Logo" /></a>
</p>

# Java Spring Boot Microservices Example

This repository contains an example microservice project built in Java and using
the Spring framework. The project itself serves a simple web application that acts
as a log book for guest visitors – allowing visitors to log their name into the
application to show up on the list of previous visitors.

## Running the application

This application depends on a MySQL database to keep track of visitors. In order to
streamline the spin up of the database alongside our microservice, we've created an
[Architect Component](https://www.architect.io/docs/getting-started/core-concepts#components)
that encapsulates both the database and our project. 

### Prerequisites 

* [Architect CLI](https://github.com/architect-team/architect-cli)

### Run locally

```sh
# Link the component to our local registry
$ architect link .

# Deploy the component
$ architect deploy --local davidthor/java-spring-example:latest -i app:app
```

#### Hot reloading

The project is automatically configured to hot reload when it detects changes to the compiled
code, but Spring requires a separate process to watch raw source code and re-compile. Run the
following in another session to enable hot-reloading:

```sh
$ cd ./src/
$ ./gradlew build --continuous
```

Any time you make changes to the source code, you'll first see this window pickup the changes and re-compile
before quickly seeing the original architect deploy process respond to the newly compiled code and restart the
server.

### Cloud deployment

Architect Component's can be easily deployed to remote cloud environments with their continuous delivery platform.
Simply register the component, register a target environment, and deploy the former to the latter:

```sh
# Login to your account
$ architect login

# Register the component
$ architect register . --tag latest

# Register an environment
$ architect platforms:create my-platform

# Register an environment
$ architect environments:create my-environment --platform my-platform

# Deploy to the environment
$ architect deploy davidthor/java-spring-example:latest -e my-environment -i app:app
```