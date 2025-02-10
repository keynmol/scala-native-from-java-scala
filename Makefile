SHARED_EXT := $(shell [ "$$(uname)" = "Darwin" ] && echo "dylib" || echo "so")

jextract:
	jextract --output java-side/ --target-package myscalalib_bindings interface.h

bindgen:
	sn-bindgen --header interface.h --package myscalalib --export --flavour scala-native05 --scala --out scala-native-side/interface.scala

scala-lib:
	cd scala-native-side && scala-cli package . -f -o ../scala-lib.$(SHARED_EXT)

run: scala-lib
	cd java-side && scala-cli run . -- ../scala-lib.$(SHARED_EXT)

