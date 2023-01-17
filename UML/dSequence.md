@startuml
actor prg
prg -> z:<<create>>() 
participant lesCages <<collection>>
== init (pas finie) == 
z -> lesCages:<<create>>("toto",23,123.89)
z -> lesLions:<<create>>("titi",23,123.89)
z -> lesLions:<<create>>("tutu",23,123.89)
== manger ==
prg -> z:nourrir()
loop 3 fois
z -> lesLions:manger()
end
loop 3 fois
z -> lesSinges:manger()
end


@enduml 
