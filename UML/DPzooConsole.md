@startuml
 package org{
	package formation{
		package zoo{
			package modele{
			 	class Individu
				class Animal
				class Lion
				class Singe
				class Gazelle
				class Visiteur
			}
			package vue{
			class Lanceur
			}
			package controleur{
			class Zoo
			}
		}
	}
}
Lanceur ..> Zoo 
Zoo *-- Animal
Zoo *-- Visiteur


@enduml 