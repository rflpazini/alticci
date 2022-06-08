# Alticci sequence
[![Build](https://github.com/rflpazini/alticci/actions/workflows/gradle.yml/badge.svg)](https://github.com/rflpazini/alticci/actions/workflows/gradle.yml)


A project to calculate a sequence using the following logic

```
n=0 => a(0) = 0
n=1 => a(1) = 1
n=2 => a(2) = 1
n>2 => a(n) = a(n-3) + a(n-2)
```

## Project 

### What we are using
* Micronaut
* Java 17

### Running

```shell
$ ./gradlew run
```

#### Docker
We provided a simple running that uses docker. 

```ssh
$ docker build -t alticci . && docker run -dp 8080:8080 alticci
```

### Swagger

After run the application, you can navigate to our swagger and make some tests on our API 🤓
```
http://localhost:8080/swagger/views/swagger-ui/#/calculate/get
```
