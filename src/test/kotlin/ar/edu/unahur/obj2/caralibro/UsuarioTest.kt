package ar.edu.unahur.obj2.caralibro

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class UsuarioTest : DescribeSpec({
  describe("Caralibro") {
    val saludoCumpleanios = Texto("Felicidades Pepito, que los cumplas muy feliz")
    val fotoEnCuzco = Foto(768, 1024)

    describe("Una publicación") {
      describe("de tipo foto") {
        it("ocupa ancho * alto * compresion bytes") {
          fotoEnCuzco.espacioQueOcupa().shouldBe(550503)
        }
      }

      describe("de tipo texto") {
        it("ocupa tantos bytes como su longitud") {
          saludoCumpleanios.espacioQueOcupa().shouldBe(45)
        }
      }
    }

    describe("Un usuario") {
      it("puede calcular el espacio que ocupan sus publicaciones") {
        val juana = Usuario()
        juana.agregarPublicacion(fotoEnCuzco)
        juana.agregarPublicacion(saludoCumpleanios)
        juana.espacioDePublicaciones().shouldBe(550548)
      }
    }
  }
  val saludoCumpleanios = Texto("Felicidades Pepito, que los cumplas muy feliz",Publico)
  val fotoEnCuzco = Foto(768, 1024,Publico)
  val sD  = SD
  val p720 = HD720p
  val p1080 = HD1080p
  val videoPlaya = Video(sD,10,Publico)
  val videoBoda = Video(p720,12,Publico)
  val videoTortuga = Video(p1080,100,Publico)

  describe("Una publicación") {
    describe("de tipo foto") {
        lass UsuarioTest : DescribeSpec({

    }

      it("Saber si un usuario puede ver una cierta publicacion."){
        val rodrigo = Usuario()
        val daniel = Usuario()
        val matias = Usuario()
        val leandro = Usuario()
        val cintia = Usuario()
          rodrigo.agregarAmigo(fede)
          rodrigo.esMasAmistosoQue(daniel).shouldBeTrue()

        val fotoDeCoche = Foto(768, 1024, Publico)
        daniel.agregarPublicacion(fotoDeCoche)
        rodrigo.puedeVerPublicacion(fotoDeCoche).shouldBeTrue()
        daniel.puedeVerPublicacion(fotoDeCoche).shouldBeTrue()

        val videoTutorial = Video(HD720p, 30, SoloAmigos)
        daniel.agregarPublicacion(videoTutorial)
        daniel.agregarAmigo(rodrigo)
        rodrigo.puedeVerPublicacion(videoTutorial).shouldBeTrue()
        cintia.puedeVerPublicacion(videoTutorial).shouldBeFalse()
        daniel.puedeVerPublicacion(videoTutorial).shouldBeTrue()

        val fotoDeInstagram = Foto(768,1024, PrivadoConPermitidos)
        daniel.agregarPublicacion(fotoDeInstagram)
        daniel.agregarPermitidos(rodrigo)
        daniel.agregarPermitidos(cintia)
        rodrigo.puedeVerPublicacion(fotoDeInstagram).shouldBeTrue()
        cintia.puedeVerPublicacion(fotoDeInstagram).shouldBeTrue()
        matias.puedeVerPublicacion(fotoDeInstagram).shouldBeFalse()
        daniel.puedeVerPublicacion(fotoDeInstagram).shouldBeTrue()

        val videoDeVacaciones = Video(HD1080p, 15, PublicoConExcluidos)
        daniel.agregarPublicacion(videoDeVacaciones)
        daniel.agregarExcluidos(leandro)
        daniel.agregarExcluidos(cintia)
        rodrigo.puedeVerPublicacion(videoDeVacaciones).shouldBeTrue()
        cintia.puedeVerPublicacion(videoDeVacaciones).shouldBeFalse()
        matias.puedeVerPublicacion(videoDeVacaciones).shouldBeTrue()
        leandro.puedeVerPublicacion(videoDeVacaciones).shouldBeFalse()
        daniel.puedeVerPublicacion(videoDeVacaciones).shouldBeTrue()

        videoLluvia.cambiarPrivacidad(Publico)
        rodrigo.puedeVerPublicacion(videoLluvia).shouldBeTrue()
        cintia.puedeVerPublicacion(videoLluvia).shouldBeTrue()
        matias.puedeVerPublicacion(videoLluvia).shouldBeTrue()
        leandro.puedeVerPublicacion(videoLluvia).shouldBeTrue()
        daniel.puedeVerPublicacion(videoLluvia).shouldBeTrue()

      }

      it("Son mejores amigos."){
          val daniel = Usuario()


          val fernando = Usuario()
          daniel.agregarAmigo(fernando)
          daniel.agregarPermitidos(fernando)
          daniel.esMejorAmigoDe(fernando).shouldBeTrue()

          val cintia = Usuario()
          daniel.agregarAmigo(cintia)
          daniel.esMejorAmigoDe(cintia).shouldBeFalse()

          val rodrigo = Usuario()
          daniel.agregarPermitidos(rodrigo)
          daniel.esMejorAmigoDe(rodrigo).shouldBeFalse()
          daniel.agregarAmigo(rodrigo)
          daniel.esMejorAmigoDe(rodrigo).shouldBeTrue()
          daniel.agregarExcluidos(rodrigo)
          daniel.esMejorAmigoDe(rodrigo).shouldBeFalse()
        }
    }
  }
})
