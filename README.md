# netcrakerdemo

# WEB
Para usar la app, en la página https://netcrakerdemo.herokuapp.com/  
- Introducir el Agremment en JSON en el textarea con el placeholder "Ingres your Agreement..."

INPUT:

{
		"signedBy":"John Snow",
		"products":[
			{
				"name":"laptop",
				"price":"700",
				"products":[]
			},
			{	
				"name":"pc",
				"price":"400",
				"products":[]
			}
		]
	
}

- Presionar el botón Process (Existe una validacion para que no se envien objetos vacios)

- Sa salida mostrarrá la ruta en la que se creo el archivo en el servidor con los objetos creados

- Para obtener los objetos creados, basta con ingresar la ruta obtenida en el paso anterior en el recuadro de "Ingres your path" (también hay una validación contra objetos vacios)

- la salida se mostrará en el recuadro debajo 

OUTPUT:

Agreement 23-February-2020.txt

# CONSOLA

Para consumir la api desde la consola, los endpoints son:

-POST:  https://netcrakerdemo.herokuapp.com/v1/store

Ejemplo del cuerpo:

{
		"signedBy":"John Snow",
		"products":[
			{
				"name":"laptop",
				"price":"700",
				"products":[]
			},
			{	
				"name":"pc",
				"price":"400",
				"products":[]
			}
		]
	
}

- GET:   https://netcrakerdemo.herokuapp.com/v1/products/{path}

Ejemplo de ruta

https://netcrakerdemo.herokuapp.com/v1/products/Agreement 23-February-2020.txt

