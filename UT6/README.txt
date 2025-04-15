Ejercicio 1
El objetivo de la primera parte de la tarea de esta unidad: implementar la clase Biblioteca, que representará una biblioteca de consulta de libros. 
La biblioteca será capaz de almacenar un máximo de 100 libros. El proyecto se llamará PROG06_Tarea.

Al iniciar nuestra aplicación, se mostrará por pantalla un pequeño menú con las siguientes opciones:
  1. Nuevo Libro.
  2. Listar Libros.
  3. Buscar Libro.
  4. Modificar ediciones Libro.
  5. Salir.

El funcionamiento de cada opción será el siguiente:
 1. Nuevo Libro: Se solicitarán al usuario por teclado los datos de un nuevo libro y, si los datos son correctos, se almacenará en la biblioteca. 
    En caso de error en algún dato se volverá a solicitar hasta introducir un valor correcto.
 2. Listar Libros: Mostrará por pantalla un listado de los libros de la biblioteca, mostrando título, autor, ISBN, número de ediciones, fecha de publicación y descripción por cada libro.
 3. Buscar Libro: Se solicitará al usuario un ISBN (de 13 caracteres) por teclado (no será necesario validarla) y se buscará en la biblioteca un libro cuyo ISBN coincida con el introducido por teclado. 
    Si existe se mostrarán su título, autor, ISNB, número de ediciones, fecha de publicación y descripción por pantalla y en caso contrario el mensaje "No existe libro con el ISBN introducido".
 4. Modificar ediciones Libro: Se solicitará al usuario por teclado un ISBN y un número de ediciones. Si el libro con ese ISBN existe, se actualizará su número de ediciones al valor introducido. 
    Si no existe, se mostrará un mensaje por pantalla.
 5. Salir: la aplicación finalizará.

Después de la ejecución de cada opción, se mostrará de nuevo el menú.

Para la implementación TEN EN CUENTA:
· Puedes reutilizar la clase Libro que ya tienes implementada en la unidad anterior.
· Para añadir un nuevo libro se deberá validar:
  - Mediante expresiones regulares que: 
    · El DNI del bibliotecario es correcto (tan solo el formato), es decir, tiene 8 dígitos y 1 letra (según norma Anexo I unidad 5). ¡¡ Este dato no se guarda, sólo se valida para poder continuar!
    · El ISBN del libro es correcto (tan solo el formato), es decir, tiene doce caracteres (según norma Anexo II unidad 5) y el carácter 13, de control, sigue la norma.
  - Sin expresiones regulares (utilizando métodos de la clase String):
    · Que el nombre del libro contenga al menos un nombre y su longitud no exceda de 40 caracteres.
  - Habrá que comprobar que no existe en la biblioteca un libro con el ISBN introducido. En caso afirmativo, se mostrará un mensaje por pantalla y mostrará el menú.
· Debes implementar la clase Principal que se encargue de:
  - Instanciar un objeto Biblioteca.
  - Pintar el menú y solicitar datos por teclado al usuario.
  - Realizar las validaciones de datos de entrada.
  - Mostrar datos por pantalla.
· Debes evitar el uso de la clase Libro desde la clase Principal. Solo se debe utilizar la clase Biblioteca.
· Debes implementar la clase Biblioteca para aportar la funcionalidad que se especifica. Esta clase deberá contener la estructura de datos necesaria para almacenar los libros, 
  con un tamaño máximo de 100. Por otro lado, ten en cuenta que para saber el número de libro existente en la citada estructura, deberás utilizar un atributo de tipo entero. 
  Este atributo te permitirá conocer la posición de inserción de un nuevo libro o hasta qué posición debes recorrer la estructura. Sus métodos serán:
  - Constructor o constructores.
  - buscaLibro: Recibe como parámetro un ISBN, buscar el libro en la Biblioteca y devuelve una cadena con los datos del libro o null si el libro buscado no existe.
  - insertarLibro: Recibe todos los datos de un libro y trata de insertarlo en la Biblioteca. Devuelve 0 si se hizo con éxito, -1 si la Biblioteca esta vacio y -2 si el ISBN ya existe.
  - listaLibros: Lista por pantalla los datos de todos los libros de la Biblioteca.
  - actualizaEdiciones: Recibe por parámetro un ISBN y un número de ediciones, busca el libro con la cuyo ISBN coincida y actualiza sus ediciones. Devuelve true si se hizo con éxito y false en caso contrario.
· Utiliza los paquetes que consideres oportuno para organizar las clases.
· Ten en cuenta que los métodos de la clase Biblioteca no deben mostrar datos  por pantalla, a excepción del método que liste los libros.
  Estos métodos deben devolver un valor indicando si la operación se realizó correctamente o no.

MEJORA
Aunque no es obligatorio, se valorará la implementación de la opción Eliminar libro, que, solicitado un ISBN, elimine de la biblioteca el libro cuyo ISBN coincida.

