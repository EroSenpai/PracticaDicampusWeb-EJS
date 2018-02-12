# PracticaDicampusWeb-EJS
App Web correspondiente al modulo 5 del curso: Desarrollo con J2EE

Detalles por si algo casca muy fuerte:

1- Si al arrancar la app no carga el index, es porque no se importan los archivos de dentro del WEB_CONTENT

  ClickDerecho en el proyexto -> BuildPath/Configure BuildPath -> Deployment Assembly
  La ruta de Webcontent puede estar definida como WebContent/WebContent -> Cambiarla a \WebContent
2- Al agregar el META-INF/context.xml (POOL DE CONEXIONES) debemos agregar el .jar del mysql en la carpeta lib del tomcat
