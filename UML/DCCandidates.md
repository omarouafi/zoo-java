@startuml

class Zoo{
}
note right of Zoo 
	contient et est responsable de tous les animaux
endnote

class Lion 
note right of Lion 
	possède un état (nom, age, poids)
	est toujours dans le zoo.
endnote

class Singe
note right of Singe 
	possède un état (nom, age, poids)
	est toujours dans le zoo.
endnote
class Gazelle
note right of Gazelle 
	possède un état (nom, age, poids)
	est toujours dans le zoo.
endnote
class Cage
note right of Cage 
	possède un état (nom, age, poids)
	est toujours dans le zoo.
endnote
@enduml 