@startuml
class Lanceur{
+nourrir()
+afficher()
-go()
}
class Zoo <<Singleton>> #green{
+nourrir()
+devorer(mangeur:int,mange:int)
+getInfos():List<String>
} 
interface Individu #orange{
+manger()
+manger(autre:Mangeable)
+dormir()
+crier()
}
interface Mangeable #orange{
+prelever():double
}
class Visiteur #orange{
+manger()
+manger(autre:Mangeable)
+dormir()
+crier()
+prelever():double
}
abstract class Animal #orange{
- POIDSMAX:double
- nom: String
- age
- poids
+ <<leaf>> vieillir()
+getInfos():String 
#setPoids(p:double)
+manger(autre:Mangeable)
+ crier()
+courir()
+sauter()
}
note top of Animal 
	sauter, courir,crier: defaut rien (optionnelles)
	manger(Mangeable) : defaut en erreur (optionnelle)
endnote

class Lion <<leaf>> #orange{
+manger()
+manger(autre:Mangeable)
+ crier()
+courir()
+ dormir()
}

class Singe #orange{
+manger()
+ dormir()
+sauter()
+crier()
}
class Gazelle #orange{
- lgCornes:int
+manger()
+getInfos():String
+ dormir()
+courir()
+sauter()
+prelever():double
}

Lanceur ..> Zoo
Zoo *-- "1..* -lesCages" Animal

Animal <|-- Lion
Animal <|-- Singe
Animal <|-- Gazelle
Mangeable <|.. Gazelle
Individu <|.. Animal
Individu <|.. Visiteur 
Mangeable <|.. Visiteur

Zoo -- "0..10 -lesVisiteurs" Visiteur
@enduml 