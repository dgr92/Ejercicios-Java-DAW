Desarrollar una aplicación Java denominado PROG05_Tarea que permita gestionar un libro. 
Mediante un menú que aparecerá en pantalla se podrán realizar determinas operaciones:

1. Nuevo Libro.
2. Ver Título.
3. Ver Autor.
4. Ver ISBN.
5. Mostrar número de ediciones.
6. Actualizar número de ediciones.
7. Mostrar Fecha de Publicación.
8. Mostrar Descripción.
9. Mostrar Antigüedad.
10. Salir.


La funcionalidad será la siguiente:

- Al iniciar la aplicación se mostrará el menú propuesto.
- Dependiendo de la opción seleccionada por el usuario:
    · Añadir libro: Se creará un nuevo Libro, si los datos introducidos por el usuario son correctos. El libro incluirá título, autor, ISBN, número de páginas, 
      año de publicación y una descripción no muy extensa. Todos los datos serán solicitados por teclado y se harán las siguientes comprobaciones:
        > El número de ediciones debe ser mayor que 0.
        > El ISBN debe tener exactamente 13 caracteres.
        > El año de publicación no puede ser superior al año actual.
        > Si no se cumple algunas de las condiciones se deberá mostrar el correspondiente mensaje de error. En ese caso habrá se mostrará de nuevo el menú principal.
    · Ver Título: Mostrará el título del libro por pantalla.
    · Ver Autor: Mostrará el autor del libro por pantalla.
    · Ver ISBN: Mostrará el ISBN del libro por pantalla.
    · Ver número de edición: Mostrará por pantalla el número de ediciones del libro.
    · Actualizar número de edición: Permitirá actualizar el número de edición del libro. Sólo se podrán aumentar. (Si el libro ha tenido muchas ventas y ha salido una nueva edición)
    · Mostrar Fecha de Publicación: Mostrará la fecha de publicación del libro por pantalla.
    · Mostrar Descripción: Mostrará una descripción del libro, incluyendo título, autor, ISBN y el número de páginas.
    · Años de Antigüedad: Mostrará por pantalla el número de años que tiene el libro. Desde el año que se editó hasta el año actual.
    · Salir: El programa finalizará.


El proyecto de Netbeans constará de dos paquetes, donde se crearán las clases oportunas:

- PROG05_Ejerc1: que contendrá la clase Libro y la clase Principal.
- PROG05_Ejerc1_util: contendrá una clase  con un métodos estáticos para realizar validaciones.


La clase Libro dispondrá de los siguientes métodos:

- Constructor o constructores.
- Métodos get y set para acceder a sus propiedades.
- Método get_Antiguedad(): Retorna un entero con el número de años desde que el libro fue publicado.


TEN EN CUENTA

  · En  la clase Principal implementarás toda la lógica del programa.
  · La clase Libro no debe hacer validaciones de datos. Los datos se validan en la clase Principal y si son correcto, se instancia el objeto Libro.
  · Debes incluir una excepción para la validación del ISBN. Es decir, cuando no sea válido, se lanzará una excepción que se gestionará en la clase Principal, 
    desde donde se mostrará el correspondiente mensaje de error.
  · La aplicación solo trabajará con un libro, por lo tanto, solo utilizará una referencia a un objeto de tipo Libro en la clase Principal. Si existe un libro y 
    el usuario selecciona Nuevo Libro en el menú, se perderá la información del vehículo existente y se guardará la del nuevo.
  · No será necesario realizar comprobaciones de tipo en los datos solicitados por teclado.
  · No se podrán mostrar datos de un libro si aún no se ha creado: en ese caso habrá que mostrar un mensaje por pantalla.

Piensa en los modificadores de acceso que debes utilizar tanto en atributos y métodos de la clase.
Además del programa deberás escribir también un informe con todas las consideraciones oportunas que se necesiten para entender cómo has realizado la tarea.


IMPORTANTE

  · En la cabecera de las clases añade documentación indicando autor y descripción de la clase.
  · En la cabecera de cada método añade documentación indicando la funcionalidad que implementa y el valor que devuelve.
  · El código fuente Java de esta clase debería incluir comentarios en cada atributo (o en cada conjunto de atributos) y método (o en cada conjunto de métodos del mismo tipo) indicando su utilidad.


MEJORA

  · Una mejora consistiría en, cuando un dato solicitado no es correcto, mostrar un mensaje y volver a solicitarlo hasta que se introduzca correctamente.




