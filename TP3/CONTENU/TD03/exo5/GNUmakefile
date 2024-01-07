PRECEDENT = ../../REPOSITORY.point/REPOSITORY

COPIES = \
	Point.java	\
	ExemplePoint1.java	\
	ExemplePoint2.java	\

DEDUITS = \
	ExemplePoint1.out	\
	ExemplePoint2.out	\

FILTRE_CMD = xcfiltre	\
	-TRANSPARENT	\
	-META_INTERFACE	\
	-META_CLASSE_ABSTRAITE	\
	+METHODES_CLASSE_ABSTRAITE	\
	-SOUS_TYPE	\
	+EXPLICATION_NL	\
	-INTERFACE	\
	-FABRIQUE	\
	-USE_ATTRIBUTS	\
	+AVEC_CARTESIEN -AVEC_POLAIRE -MIXTE       \
	-ATTRIBUTS_PUBLICS	\
	+ACCESSEURS_CARTESIENS +ACCESSEURS_POLAIRES 

all:: generes


include ${HOME}/usr/make/generes.make
include ${HOME}/usr/make/java.make
