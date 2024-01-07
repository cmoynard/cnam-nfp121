PRECEDENT = ../../REPOSITORY.point/REPOSITORY

COPIES = \
	ExemplePoint1.java	\
	ExemplePoint2.java	\
	Point.java	\

DEDUITS = \
	ExemplePoint1.javac	\
	ExemplePoint2.javac	\

FILTRE_CMD = xcfiltre	\
	-TRANSPARENT	\
	-META_INTERFACE	\
	-META_CLASSE_ABSTRAITE	\
	+METHODES_CLASSE_ABSTRAITE	\
	-SOUS_TYPE	\
	+EXPLICATION_NL	\
	-INTERFACE	\
	-CLASSE_ABSTRAITE	\
	-FABRIQUE	\
	-AVEC_CARTESIEN +AVEC_POLAIRE -MIXTE       \
	-ATTRIBUTS_PUBLICS	\
	+USE_ATTRIBUTS	\
	+ACCESSEURS_CARTESIENS +ACCESSEURS_POLAIRES

all:: generes

include ${HOME}/usr/make/generes.make
include ${HOME}/usr/make/java.make
