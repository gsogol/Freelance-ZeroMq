## Why?

Using `http` for internal services may not be the most efficient way to communicate. There are many protocols like thrift, zeromq and others that make communication over `tcp` much faster.

This is a sample that shows the throughput of a single-threaded server.

## Features

* uses a [freelance pattern](http://zguide.zeromq.org/php:chapter4#Brokerless-Reliability-Freelance-Pattern)
* uses ZeroMq 3.2.4 with java bindings
* uses Java 7


## Installation

* get zeromq. no really, it may help.
* then build it:

```bash
$ brew install pkg-config
$ brew install automake
$ brew install autoconf
$ ./autogen.sh
$ ./configure
$ make
$ make install
```

* set the VM arguments to `-Djava.library.path=/usr/local/lib'

## Usage

Just run the jUnit test. Very elaborate, I know.

**Note**: the built `zmq.jar` is already referenced in the lib.

## Issues

Welcome any feedback



