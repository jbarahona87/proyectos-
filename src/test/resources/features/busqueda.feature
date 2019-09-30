# language: es
# encoding: iso-8859-1
Característica: Busqueda de Trabajo
  Como usuario del sistema en el buscador  
  deseo poder buscar empleo 
  para el cargo Contador

  Esquema del escenario: seleccionar primera oferta con el nombre contador
    Dado que estoy en la pagina de computrabajo
    Cuando ingreso los datos <cargo> y <ciudad>
    Entonces puedo ingresar a la primer oferta 

    Ejemplos: 
      | cargo|ciudad|
      | Cont |Bogotá|
