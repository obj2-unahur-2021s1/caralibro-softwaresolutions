package ar.edu.unahur.obj2.caralibro

import kotlin.math.ceil

abstract class Publicacion(var privacidad: Privacidad) {
  var cantidadDeMeGusta = 0
  val personasQueDieronMeGusta = mutableListOf<Usuario>()

  lateinit var creadorDePublicacion : Usuario

  abstract fun espacioQueOcupa(): Int

  fun recibeUnMegusta(usuario: Usuario) {
      personasQueDieronMeGusta.add(usuario)
    }

  fun puedeSerVistaPor(usuario: Usuario) = privacidad.permiteVerA(usuario,this)

  fun cambiarPrivacidad(privacidadNueva: Privacidad){
    privacidad = privacidadNueva
  }
}

abstract class Foto(val alto: Int, val ancho: Int, privacidad: Privacidad) : Publicacion(privacidad) {
  var factorDeCompresion = 0.7
}

abstract class Texto(val contenido: String, privacidad: Privacidad) : Publicacion(privacidad) {
  override fun espacioQueOcupa() = contenido.length
}

abstract class Video(var calidad: Calidad, val duracion: Int, privacidad: Privacidad) : Publicacion(privacidad) {
  override fun espacioQueOcupa(): Int = calidad.espacioQueOcupa(duracion)
  }

