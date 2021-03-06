***
### JARE
###### Just Another Rules Engine
[![Maven Central](https://img.shields.io/maven-central/v/com.github.parisk85/JARE.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.parisk85%22%20AND%20a:%22JARE%22)
[![javadoc](https://javadoc.io/badge2/com.github.parisk85/JARE/javadoc.svg)](https://javadoc.io/doc/com.github.parisk85/JARE)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
***

#### What is JARE?

JARE is just another rules engine! It is minimalistic library to provide a rules engine (JAREngine) to software clients. Clients are able to run individual rules or multiple rules using JAREngine.

#### Examples

##### 1. Using simple rules:

Provide the class to the given method and feed the rule when you run it:

```java
Rule rule = RuleBuilder.given(String.class)
        .then(s -> System.out.println("Hello " + s));

rule.run("JARE");
```

With a when clause:

```java
Rule rule = RuleBuilder.given(String.class)
    .when(s -> "JARE".equals(s))
    .then(s -> System.out.println("Hello " + s));
    
rule.run("JARE");
```

We can also run in the same statement:

```java
StringBuilder test = new StringBuilder();

RuleBuilder.given(StringBuilder.class)
    .when(s -> s.toString().isEmpty())
    .then(s -> s.append("Hello JARE"))
    .run(test);

System.out.println(test);
```

Let's throw an exception:

```java
RuleBuilder.given(Boolean.class)
    .when(Boolean::booleanValue)
    .thenThrow(RuntimeException::new)
    .run(true);
```

##### 2. Using JAREngine

You can chain multiple rules and fire the engine:

```java
JAREngine.feed("JARE")
    .addRule(r -> r.when(String::isEmpty).then(s -> System.out.println("Oh no!")))
    .addRule(r -> r.when(s -> !s.isEmpty()).then(s -> System.out.println("Hello " + s)))
    .fire();
```

You can also feed the engine with multiple inputs using a List or variable arguments:

```java
JAREngine.feed("JARE", "", "me")
    .addRule(r -> r.when(String::isEmpty).then(s -> System.out.println("Oh no!")))
    .addRule(r -> r.when(s -> !s.isEmpty()).then(s -> System.out.println("Hello " + s)))
    .fire();
```

Thank you for using JARE!
***