#INPUT  = computation.c
#OUTPUT = libcomputation.so
INPUT  = legacyqe.cpp quadeqn.o
OUTPUT = liblegacyqe.so

JAVA_HOME ?= $(shell readlink -e "$$(dirname "$$(readlink -e "$$(which javac)")")"/..)
CFLAGS  +=  -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/linux" -fPIC
LDFLAGS += -shared 

all: $(OUTPUT)
$(OUTPUT): $(INPUT)
	@$(CC) $(CFLAGS) $(LDFLAGS) $? -o $@

