# Chuck Norris Facts

Chuck Norris Facts is a demo project to demonstrate my knowledge of Java 8, Spring Boot, REST, Maven, etc.
It is a RESTful Spring Boot application that returns Chuck Norris "facts", i.e. random Chuck Norris jokes.
It provides several REST endpoints, including /fact, /count, and /citation.  I started the project with start.spring.io
and customized from there.

## Requirements

Chuck Norris Facts requires Java 8.  I believe it can be built from source with the Maven wrapper already included, requiring no installation of Maven on your system.

## Installation

Chuck Norris Facts is a standalone application that can be run with Java 8 once downloaded.  It can be downloaded here,
```bash
https://github.com/johatfie/ChuckNorrisFacts/archive/master.zip
```
or with this command:


```bash
git clone https://github.com/johatfie/ChuckNorrisFacts.git
```


## Usage

To build from source use
```bash
./mvnw clean package
```
from the project root directory.  I have included a compiled jar file in this repo, if you don't wish to build it yourself.

Compilation yields a runnable jar file that can be run as follows:

```bash
java -jar target/facts-0.0.1-SNAPSHOT.jar
```

It is a completely self-contained Spring Boot application, requiring no other software.

Once running direct your browser to [localhost:8080/fact](http://localhost:8080/fact)
to get a random Chuck Norris joke in json format, e.g.
```json
{"fact":"Chuck Norris runs on batteries. Specifically, Die Hards."}
```

Also available are [localhost:8080/count](http://localhost:8080/count)
which shows that there are 572 facts available, and
[localhost:8080/citation](http://localhost:8080/citation)
which yields

```txt
Credit for all these Chuck Norris facts goes to
http://www.killcure.com/2009/10/06/the-ultimate-list-of-chuck-norris-jokes/
from which I blatently copied the whole list. My thanks to Varun for posting it.
```
giving attribution to the source of these jokes.


## License
[BSD-3-Clause](https://choosealicense.com/licenses/bsd-3-clause/)
