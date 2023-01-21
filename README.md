# PokemonStore

PokemonStore es una aplicación diseñada para el manejo de inventario y compra de dichos productos disponibles, la cual permite agregar productos nuevos, listar, editar y eliminar dichos productos para su respectiva compra, la cual se ve registrada y validada por la cantidad de productos en el inventario y la compra mínima y máxima de los mismos.

## BACKEND

El desarrollo de la lógica del software se ha realizado en java con la ayuda de la plataforma Spring Boot, para el desarrollo de la aplicación, configurando automáticamente la aplicación según las dependencias, tiene un modelo de arquitectura limpia y cuenta con tres carpetas, la de dominio en la cual se hace un modelado de las entidades y también los respectivos casos de uso, infraestructura donde se encuentra los respositorios y una carpeta de utilidades donde se desarrollas disfrerentes clases como herramientas para el desarrollo del programa y Api.

En la carpeta contoller podemos encontrar las diferentes rutas o endpoints que permiten contactar con el servicio y dar respuesta a la petición realizada por el usuario. Entre ellas podemos encontrar las siguientes:


| Producto EndPoints       | Metodo | Descripcion                     |
| -------------------------| -------|---------------------------------|
| /products/Allproducts    | GET    | Obtiene todos los productos     |
| /products/add            | POST   | Agregar Producto                |
| /products/update/:id     | PUT    | Editar Producto                 |
| /products/byId/:id       | GET    | Obtiene producto por id         |
| /products/delteProduct   | DELETE | Eliminar producto               |

| Registro EndPoints                 | Metodo | Descripcion                                        |
| ---------------------------------- | ------ | -------------------------------------------------- |
| /sold/product/:id                  | POST   | Agregar Producto a la canasta                      |
| /sale/product                      | POST   | Crear Registro de Compra                           |
| /sale/allRegister                  | GET    | Obtener todos los registros                        |

## Documentación con Swagger
http://localhost:8080/swagger-ui/index.html#/
# Coleción Postman
https://red-moon-680989.postman.co/workspace/7730bdbb-745f-4289-bc87-c1ece53bea81/collection/25387800-06fff008-bca8-4ffa-813b-186d21b9640b?action=share&creator=25387800
![Image text](https://github.com/LuisaBAvila/PokemonStoreBackend/blob/main/Captura.PNG)
