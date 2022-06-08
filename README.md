# Alticci sequence

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